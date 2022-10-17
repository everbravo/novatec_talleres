package fundNovatec.controlador;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.stream.DoubleStream;

import fundNovatec.dto.CampanaDTO;
import fundNovatec.dto.CronogramaDTO;
import fundNovatec.dto.MonedaDTO;
import fundNovatec.dto.ParametrosCampanaDTO;
import fundNovatec.persistencia.CampanaRepoImpl;
import fundNovatec.persistencia.CronogramaRepoImpl;
import fundNovatec.persistencia.DepositoRepoImpl;
import fundNovatec.persistencia.EstadoRepoImpl;
import fundNovatec.persistencia.MonedaRepoImpl;
import fundNovatec.persistencia.MovimientoRepoImpl;
import fundNovatec.persistencia.ParametrosCampanaRepoImpl;
import fundNovatec.persistencia.PersonaRepoImpl;
import fundNovatec.persistencia.UsuarioRepoImpl;

@SuppressWarnings("unused")
public class ControladorAdministrador {

	public ControladorAdministrador() {
	}
	
	private final static Scanner SC = new Scanner(System.in); 
	private final static PersonaRepoImpl PER = new PersonaRepoImpl();
	private final static UsuarioRepoImpl USER = new UsuarioRepoImpl();
	private final static MonedaRepoImpl MON = new MonedaRepoImpl();
	private final static EstadoRepoImpl EST = new EstadoRepoImpl();
	private final static DepositoRepoImpl DEP = new DepositoRepoImpl();
	private final static MovimientoRepoImpl MOV = new MovimientoRepoImpl();
	private final static CampanaRepoImpl CAMP = new CampanaRepoImpl();
	private final static CronogramaRepoImpl CRON = new CronogramaRepoImpl();
	private final static ParametrosCampanaRepoImpl PARAM = new ParametrosCampanaRepoImpl();
	
	public static void registrarCampana(String fundId) {
		LocalDate fechaIni = null;
		LocalDate fechaFin = null;
		
		System.out.println("INGRESO DE CAMPAÑA");
		String idcampana = ControladorParametros.generarCodigoCamp();
		
		System.out.println("Ingrese el nombre de la campaña: ");
		String nombre = SC.nextLine().trim();
		
		System.out.println("Ingrese el objetivo de la campaña");
		String obj = SC.nextLine().trim();
		
		Integer esatdo_id = EstadoRepoImpl.getCodActivo();
		
		System.out.println("PARAMETROS INICIALES");
		System.out.println("Ingrese la cantidad maxima de donadores par esta campaña: ");
		String tempG = SC.nextLine().trim();
		Integer cantDon = null;
		if (tempG != "") {
			cantDon = Integer.parseInt(tempG);
		}
		
		
		System.out.println("Ingrese la cantidad maxima de donaciones permitidas para esta campaña: ");
		String temp1 = SC.nextLine().trim();
		Integer cantDonaciones = null;
		if (temp1 != "") {
			cantDonaciones = Integer.parseInt(temp1);
		}
		
		System.out.println("Ingrese la cantidad maximo de dinero aportado por donadores a esta campaña: ");
		String temp2 = SC.nextLine().trim();
		Double cantMaxDona = null;
		if (temp2 != "") {
			cantMaxDona = Double.valueOf(temp2);
		}
	
		System.out.println("Ingrese el minimo de dinero estimado a recaudo: ");
		String temp3 = SC.nextLine().trim();
		Double montoMinimo = null;
		if (temp3 != "") {
			montoMinimo = Double.valueOf(temp3);
		}
		
		System.out.println("Ingrese el porcentaje inicial para gastos administrativos: ");
		String temp4 = SC.nextLine().trim();
		Float porcentaje = null;
		if (temp4 != "") {
			porcentaje = Float.parseFloat(temp4);
		}
		
		System.out.println("CRONOGRAMA");
		System.out.println("Ingrese la fecha programada de inicio (yyyy/MM/dd): ");
		String f1 = SC.nextLine().trim();
		if(ControladorDonador.validarFecha(f1)) {
			fechaIni = LocalDate.parse(f1, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		}
		
		System.out.println("Ingrese la fecha programada de fin (yyyy/MM/dd): ");
		String f2 = SC.nextLine().trim();
		if(ControladorDonador.validarFecha(f2)) {
			fechaFin = LocalDate.parse(f2, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		}
		
		CampanaDTO camp = new CampanaDTO();
		camp.setIdCampana(idcampana);
		camp.setNombreCampana(nombre);
		camp.setObjetivoCampana(obj);
		camp.setFundacion_nit(fundId);
		camp.setEstado_id(esatdo_id);
		
		
		if(idcampana == "" || nombre == "" || obj == "" || cantDon == null 
				|| cantDonaciones == null || cantMaxDona == null || fechaFin == null || fechaIni == null) {
			System.out.println("Todos los campos consultados son requeridos por el proceso, ingreselos nuevamente...");
		}else {
			ParametrosCampanaDTO param = new ParametrosCampanaDTO();
			param.setCampanaId(camp.getIdCampana());
			param.setCantDonadores(cantDon);
			param.setCantDonacionesPermit(cantDonaciones);
			param.setCantMaxDonador(cantMaxDona);
			param.setCantMin(montoMinimo);
			param.setPorcentaje(porcentaje);
			
			CronogramaDTO crono = new CronogramaDTO();
			crono.setCampanaId(camp.getIdCampana());
			crono.setFechaFin(Date.valueOf(fechaFin));
			crono.setFechaInicio(Date.valueOf(fechaIni));
			
			boolean registro = CAMP.agregar(camp);
			if(registro) {
				boolean cr = CRON.agregar(crono);
				boolean pr = PARAM.agregar(param);
				if(cr && pr) {
					System.out.println("Campaña agregada...");
					
					boolean mond = true;
					do {
						asociarMonedas(idcampana);
						
						System.out.println("Ingrese el valor | SI | Desea seguir agregando mas monedas,\n tenga en cuenta que no podra hacerlo despues de creada las campañas");
						if(!SC.nextLine().trim().equalsIgnoreCase("SI")) mond = false;
					}while(mond);
					
				}
			}else {
				System.out.println("Ocurrio un error al agregar los datos iniciales de la campaña");
			}
		}
		
		
	}
	
	public static void reporteCampana(String idCamp) {
		CampanaDTO campana = CAMP.buscarPorId(idCamp);
		if(campana != null) {
			ParametrosCampanaDTO params = PARAM.obtenerPorCampana(campana.getIdCampana());
			CronogramaDTO cronog = CRON.obtenerPorCampana(campana.getIdCampana());
			//info de la campaña
			System.out.println("\n\nINFORMACION GENERAL DE CAMPAÑA COD |"+idCamp+"|");
			System.out.println("Nombre: "+campana.getNombreCampana()+"\n"
					+ "Objetivo: "+campana.getObjetivoCampana()+"\n"
							+ "Estado: "+EST.buscarPorId(campana.getEstado_id()).getDescripcion()+"\t"
									+ "Fecha Inicio: "+cronog.getFechaInicio()+" - Fecha Fin: "+cronog.getFechaFin()+"\n"
											+ "Cantidad donantes permitidos: "+params.getCantDonadores()+" - Cantidad donantes inscritos: "+CAMP.cnatTotalDonantesCamp(campana.getIdCampana())+"\n"
													+ "Cantidad donaciones permitidas: "+params.getCantDonacionesPermit()+" - Cantidad donaciones realizadas: "+CAMP.cnatTotalDonacionesCamp(campana.getIdCampana())+"\n"
															+ "Monto maximo x donador: "+params.getCantMaxDonador()+" - Monto maximo donado (usuario): "+ CAMP.montMaxDonadoCamp(campana.getIdCampana())+"\n"
																	+ "Monedas Permitidas: "+CAMP.listarCampMon(campana.getIdCampana())+"\n");
			
			
			Double total = Math.round((params.getCantMin() * params.getPorcentaje()) * 100.0)/100.0;
			Double totalRecaudado = MOV.listarPorCampana(campana.getIdCampana()).stream().flatMapToDouble(x -> DoubleStream.of(x.getValor())).sum();
			float porcentajeAjust =calcularPorcentajeAdmin(params.getCantMin(), totalRecaudado, params.getPorcentaje());
			System.out.println("--------------------ESTIMADO PRE-CAMPAÑA -------------------");
			System.out.println("El porcentaje administrativo inical del campaña fue: "+params.getPorcentaje()+"% o ["+Math.round(params.getPorcentaje()*100 * 100.0)/100.0+"%]");
			System.out.println("El monto minimo estimado de recaudo fue: $ "+params.getCantMin()+" COP");
			System.out.println("El gasto ADMINISTRATIVO estimado para la campaña fue: $ "+total+" COP\n");
			System.out.println("--------------------CALCULADO POST-CAMPAÑA -------------------");
			calcularGastosAdmin(totalRecaudado, Math.round(porcentajeAjust * 100.0f)/100.0f);
			
		}else {
			System.out.println("Error al encontrar la campaña");
		}
	}
	
	public static float calcularPorcentajeAdmin(Double canEst, Double cantObt, float porcIni) {
		if(cantObt >= canEst) {
			return porcIni;
		}else {
			return (float) ((float) (cantObt * porcIni) / canEst);
		}
	}
	
	public static void calcularGastosAdmin(Double recaudo, float porcentaje) {
		Double total = Math.round((recaudo * porcentaje) * 100.0)/100.0;
		System.out.println("El total de dinero recaudado durante la campaña fue de: $ "+recaudo+" COP");
		System.out.println("El porcentaje administrativo (variacional) aplicado es: "+porcentaje+"% o ["+porcentaje*100+"%]");
		System.out.println("El gasto ADMINISTRATIVO recaudado para la campaña es de: $ "+total+" COP\n\n");
	}
	
	public static void asociarMonedas(String camp) {
		System.out.println("Monedas registradas en el sistema (Codigo ISO -> Nombre)");
		MON.listarTodo().stream().forEach(z -> System.out.println(z.getCodigoIso()+" -> "+z.getDescripcion()));	

			System.out.println("Ingrese el codigo ISO de la moneda: ");
			String mon = SC.nextLine().trim();
			
			if(mon!="") {
				MonedaDTO find = MON.buscarPorId(mon);
				if(find != null) {
					boolean resp = MON.agregarCampMon(camp, mon);
					if(resp) {
						System.out.println("se creó la relacion con la moneda");
					}else {
						System.out.println("Error interno al relacionar la moneda");
					}
				}else {
					System.out.println("no se encontró la moneda");
				}
			}
		
	}

}
