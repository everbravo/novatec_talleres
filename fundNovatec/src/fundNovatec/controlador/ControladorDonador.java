package fundNovatec.controlador;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.DoubleStream;

import fundNovatec.dto.CampanaDTO;
import fundNovatec.dto.DepositoDTO;
import fundNovatec.dto.MonedaDTO;
import fundNovatec.dto.MovimientoDTO;
import fundNovatec.dto.PersonaDTO;
import fundNovatec.dto.UsuarioDTO;
import fundNovatec.operaciones.OperacionesPersonalizadas;
import fundNovatec.persistencia.CampanaRepoImpl;
import fundNovatec.persistencia.DepositoRepoImpl;
import fundNovatec.persistencia.EstadoRepoImpl;
import fundNovatec.persistencia.MonedaRepoImpl;
import fundNovatec.persistencia.MovimientoRepoImpl;
import fundNovatec.persistencia.PersonaRepoImpl;
import fundNovatec.persistencia.UsuarioRepoImpl;
import fundNovatec.reporte.PersonaDonadorPtllDTO;
import fundNovatec.reporte.ToCsv;

@SuppressWarnings("unused")
public class ControladorDonador {

	private final static Scanner SC = new Scanner(System.in); 
	private final static PersonaRepoImpl PER = new PersonaRepoImpl();
	private final static UsuarioRepoImpl USER = new UsuarioRepoImpl();
	private final static MonedaRepoImpl MON = new MonedaRepoImpl();
	private final static DepositoRepoImpl DEP = new DepositoRepoImpl();
	private final static MovimientoRepoImpl MOV = new MovimientoRepoImpl();
	private final static CampanaRepoImpl CAMP = new CampanaRepoImpl();
	
	
	public ControladorDonador() {
	}
	
	public static void registrarDonador() {
		LocalDate fecha_nacimiento = null;
		
		System.out.println("Ingrese su nombre: ");
		String nombre = SC.nextLine().trim();
		
		System.out.println("Ingrese sus apellidos: ");
		String apellidos = SC.nextLine().trim();
		
		System.out.println("Ingrese su numero de identificación: ");
		String identificacion = SC.nextLine().trim();
		
		System.out.print("Ingrese su Fecha de nacimiento (yyyy/MM/dd): ");
		String temp = SC.nextLine().trim();
		if(validarFecha(temp)) {
			fecha_nacimiento = LocalDate.parse(temp, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		}
		
		System.out.println("Ingrese el codigo correspondiente a su sexo: ");
		OperacionesPersonalizadas.desplegarSexos();
		String tempV = SC.nextLine().trim();
		int id_sexo = (tempV.isEmpty())? 0 :Integer.parseInt(tempV);
		
		int rol = OperacionesPersonalizadas.getRolUsuario();
		
		System.out.println("Ingrese el codigo de su fundación: ");
		OperacionesPersonalizadas.desplegarFundaciones();
		String id_fund = SC.nextLine().trim();
		
		System.out.println("Ingrese su nombre de usuario: ");
		String nameuser = SC.nextLine().trim();
		
		System.out.println("Ingrese su contraseña: ");
		String password = SC.nextLine().trim();
		
		
		if(identificacion == "" || nombre == "" || apellidos == "" || fecha_nacimiento == null 
				|| id_sexo == -1 || rol == -1 || id_fund == "" || nameuser == "" || password == "") {
			System.out.println("Todos los campos consultados son requeridos por el proceso, ingreselos nuevamente...\n\n");
		}else {
			
			PersonaDTO p = new PersonaDTO();
			p.setIdentificacion(identificacion);
			p.setNombre(nombre);
			p.setApellidos(apellidos);
			p.setNacimiento(Date.valueOf(fecha_nacimiento));
			p.setSexo_id(id_sexo);
			p.setRol_usuario(rol);
			p.setFn_nit(id_fund);
			
			UsuarioDTO u = new UsuarioDTO();
			u.setNameuser(nameuser);
			u.setPassword(password);
			u.setPersonaId(p.getIdentificacion());
			
			boolean registro = PER.agregar(p);
			boolean userok = USER.agregar(u);
			if(registro && userok) {
				boolean  exito = PER.inactivar(p.getIdentificacion(), EstadoRepoImpl.getCodInactivo());
				if(exito) {
					System.out.println("Usted se ha registrado como donante.");
					
				}
			}else {
				System.out.println("Error en el proceso de registro.");
			}
			
		}
		
		
	}
	
	public static boolean verificarEstadoDonante(String id) {
		
		PersonaDTO per = PER.obtenerPorIdentificacion(id);
		if(per != null) {
			int estado = per.getId_estado();
			int codInac = EstadoRepoImpl.getCodInactivo();
			if(estado == codInac) {
				return false;
			}
			
		}else {
			System.out.println("Error inesperado en el sistema");
		}
		
		return true;
	}
	
	public static void accionesCampaña(String id) {
		
		String opciones = "MENÚ CAMPAÑAS\n"
				+ "1 -> Unirse a campaña\n"
				+ "2 -> Donar a campaña\n"
				+ "0 -> Salir";
		
		boolean confirma = true;
		do {
			listarCampanasInscrito(id);
			System.out.println(opciones);
			System.out.println("Ingrese una opcion: ");
			String op = SC.nextLine().trim();
			
			switch (op) {
			case "1":
				listarCampanasActivas();
				ingresarACampana(id);
				break;
			case "2":
				donarACampana(id);
				break;
			case "0":
				confirma = false;
				break;
			default:
				System.out.println("Opción Erronea");
				break;
			}
		}while(confirma);
	}
	
	
	public static void ingresarACampana(String id) {
			
				System.out.println("Ingrese el codigo de la campaña: ");
				String mon = SC.nextLine().trim();
				
				if(mon!="") {
					
					boolean repuest = CAMP.inscVerCantDonantes(mon);
					if(repuest) {
						CampanaDTO find = CAMP.buscarPorId(mon);
						if(find != null) {
							boolean resp = CAMP.agregarCampDon(mon, id);
							if(resp) {
								System.out.println("Se acaba de inscribir en la campaña");
							}else {
								System.out.println("Error interno al inscribir en la campaña");
							}
						}else {
							System.out.println("no se encontró la moneda");
						}
					}else {
						System.out.println("Cupos maximos de campaña fueron alcanzados...");
					}
					
				}
			
	}

	
	public static void donarACampana(String id) {
		listarCampanasInscrito(id);
		System.out.println("Ingrese el codigo de la campaña*: ");
		String camp = SC.nextLine().trim();
		obtenerMonedasCampanaPermit(camp, id);
		System.out.println("Ingrese el codigo del fondo a debitar*: ");
		String fond = SC.nextLine().trim();
		
		boolean vrf1 = CAMP.inscVerCantDonacionesRealizadas(camp);
		if(vrf1) {
			if(camp!="" && fond !="") {
				CampanaDTO find = CAMP.buscarPorId(camp);
				if(find.getEstado_id() == EstadoRepoImpl.getCodInactivo()) {
					System.out.println("La campaña se encuentra inhabilitada...");
					accionesCampaña(id);
				}
				DepositoDTO dep = DEP.buscarPorId(fond);
				if(find != null && dep != null) {
					
					System.out.println("Ingrese la cantidad que desea donar*: ");
					Double cant = Double.valueOf(SC.nextLine().trim());
					
					boolean vrf2 = CAMP.inscVerCantMaximaDonador(camp, cant);
					if(vrf2) {
						if (!cant.isNaN()) {
							boolean sobregiro = verificarSobregiro(dep.getSaldo(), cant);	
							if(sobregiro == false) {
								Double saldoNow = dep.getSaldo()-cant;
								dep.setSaldo(saldoNow);
								boolean exitoDep = DEP.actualizar(dep.getCodigoDeposito(), dep);
								if(saldoNow == 0D) {
									DEP.eliminar(fond);
								}
								if(exitoDep) {
									MovimientoDTO mov = new MovimientoDTO();
									mov.setCampanaId(find.getIdCampana());
									mov.setDeposito_cod(dep.getCodigoDeposito());
									mov.setValor(cant);
									mov.setEstado_id(EstadoRepoImpl.getCodEst("DONACION"));
									boolean exitoMov = MOV.agregar(mov);
									if(exitoMov) {
										System.out.println("Donación realizada, Gracias por confiar en nosotros...");
									}
								}
							}else {
								System.out.println("Esta cuenta no tiene los fondos suficientes para realizar la transacción");
							}
						}
					}else {
						System.out.println("Se alcanzó el monto maximo establecido de donacion por usuario");
					}
					}
			}else {
				System.out.println("Ingrese los campos requeridos");
			}
		}else {
			System.out.println("Se alcanzo el maximo de donaciones para esta campaña");
			//establecer en inactiva la campaña
			CAMP.eliminar(camp, EstadoRepoImpl.getCodInactivo());
		}
		
		
	
	}
	
	public static boolean verificarSobregiro(Double valorCuent, Double valorDeb ) {
		return (valorCuent >= ((valorDeb < 0)?-valorDeb:valorDeb)) ? false : true;
	}
	
	public static void listarCampanasActivas() {
		System.out.println("CAMPAÑAS ACTIVAS");
		System.out.println("----------------------------------------------");
		CAMP.listarTodoActivo().stream().forEach(z -> System.out.println("| "+z.getIdCampana()+" | -> "+z.getNombreCampana()));
		System.out.println("----------------------------------------------");
	}
	
	public static void listarCampanasInscrito(String id) {
		System.out.println("CAMPAÑAS EN PARTICIPACIÓN");
		System.out.println("----------------------------------------------");
		CAMP.listarTodoInscrito(id).stream().forEach(z -> System.out.println("| "+z.getIdCampana()+" | -> "+z.getNombreCampana()));
		System.out.println("----------------------------------------------");
	}
	
	
	public static void accionesDeposito(String perId) {

		String opciones = "MENÚ DEPOSITOS\n"
				+ "1 -> Crear Deposito\n"
				+ "2 -> Eliminar fondo\n"
				/*+ "3 -> Editar Deposito\n"*/
				+ "3 -> Solicitar Activación de Cuenta\n"
				+ "4 -> Solicitar Informe de donaciones (Solo para usuarios con antiguedad)"
				+ "0 -> Salir";
		
		
		boolean confirma = true;
		do {
			
			System.out.println("CUENTAS");
			imprimirFondo(perId);
			System.out.println("----------------------------------------------");
			System.out.println("Saldo total en fondos: $"+saldoAcomulado(perId)+"COP");
			System.out.println("----------------------------------------------");
			
			System.out.println(opciones);
			String op = SC.nextLine().trim();
			
			switch (op) {
			case "1":
				crearDeposito(perId);
				break;
			case "2":
				eliminarFonfo();
				break;
			case "3":
				solicitarActivacion(perId);
				break;
			case "4":
				emitirDocumentoDonante(perId);
				break;
			case "0":
				confirma = false;
				break;

			default:
				System.out.println("Opción Erronea");
				break;
			}
			
		} while (confirma);
	}
	
	public static void solicitarActivacion(String usuario) {
		boolean isActive = verificarEstadoDonante(usuario);
		if(isActive) {
			System.out.println("Esta opcion esta deshabilitada para su cuenta, debido a que su usuario ya se ha activado con anterioridad...");
		}else {
			Double saldo = saldoAcomulado(usuario);
			System.out.println("El saldo actual es de: "+saldo);
			if(saldo >= 1000000) {
				boolean activo = PER.activar(usuario, EstadoRepoImpl.getCodActivo());
				if(activo) {
					System.out.println("Su usuario acaba de ser activado, ahora puede iniciar sesión e inscribirse a campañas");
				}
			}else {
				System.out.println("Ops... esat opcion aun no esta disponible para tí.");
				System.out.println("Señor donante, recuerde que por politicas internas se requiere tener el valor inicial de $1,000,000COP\n"
						+ " para activar su cuenta, por tanto si usted actualmente no posee esa cantidad lo invitamos a ingresar fondos.");
			}
		}
		
	}
	
	public static Double saldoAcomulado(String cuent) {
		return DEP.listarPorPersona(cuent).stream().flatMapToDouble(a->DoubleStream.of(convertirACop(a.getSaldo(), a.getMonedaCod()))).sum();
	}
	
	
	public static void editarFondo() {
		System.out.println("Ingrese el numero del fondo a editar: ");
		String cuent = SC.nextLine().trim();
		
		DepositoDTO deposito = DEP.buscarPorId(cuent);
		if(deposito != null) {
			System.out.println("Ingrese el saldo a editar");
		}else {
			System.out.println("El numero de posito ingresado no existe");
		}
	}
	
	public static void eliminarFonfo() {
		System.out.println("Ingrese el numero de fondo a eliminar: ");
		String cuent = SC.nextLine().trim();
		
		DepositoDTO deposito = DEP.buscarPorId(cuent);
		if(deposito != null) {
			boolean conf = DEP.eliminar(cuent);
			if(conf) {
				System.out.println("Fondo Elimiando...");
			}
		}else {
			System.out.println("El numero de posito ingresado no existe");
		}
	}
	
	public static void imprimirFondo(String perId) {
		DEP.listarPorPersona(perId).stream().forEach(x->System.out.println(x.getCodigoDeposito()+" -- saldo de --> "+x.getSaldo()+x.getMonedaCod()+" -- a COP -->"+convertirACop(x.getSaldo(), x.getMonedaCod())));
	}
	
	public static void obtenerMonedasCampanaPermit(String camp, String idper) {
		List<String> monedas = CAMP.listarCampMon(camp);
		System.out.println("Cuentas permitidas por tipo de moneda");
		DEP.listarPorPersona(idper).stream().filter(x-> monedas.contains(x.getMonedaCod())).forEach(z->System.out.println(z.getCodigoDeposito()+" -- saldo de --> "+z.getSaldo()+z.getMonedaCod()+" -- a COP -->"+convertirACop(z.getSaldo(), z.getMonedaCod())));
	}
	
	public static Double convertirACop(Double valor, String moneda) {
		Double result = 0D;
		
		MonedaDTO moned =  MON.buscarPorId(moneda);
		if(moned != null) {
			Double valorMon = moned.getTasaConversionCop();
			result = valor * valorMon;
		}
		
		return result;
	}
	
	
	public static void emitirDocumentoDonante(String id) {
		List<PersonaDonadorPtllDTO> persona = PER.generarReporteDonacion(id);
		ToCsv generarCsv = new ToCsv();
		generarCsv.toCsv(persona);
	}
	
	public static void reversarFondos(String idPersona) {
		PersonaDTO per = PER.obtenerPorIdentificacion(idPersona);
		if(per != null) {
			boolean perInact = false;
			List<DepositoDTO> depositos = DEP.listarPorPersona(per.getIdentificacion());
			if(!depositos.isEmpty()) {
				for(DepositoDTO dep : depositos) {
					Map<String, Double> calculos = calculosReversarF(dep.getCodigoDeposito());
					Double valorRetenido = calculos.get("RET");
					Double valorRetornado = calculos.get("REV");
					
					Double saldoOld = dep.getSaldo();
					dep.setSaldo(0D);
					
					boolean act = DEP.actualizar(dep.getCodigoDeposito(), dep);
					boolean act2 = DEP.eliminar(dep.getCodigoDeposito());
					if(act && act2) {
						perInact = PER.inactivar(per.getIdentificacion(), EstadoRepoImpl.getCodInactivo());
						
						MovimientoDTO movRev = new MovimientoDTO();
						movRev.setDeposito_cod(dep.getCodigoDeposito());
						movRev.setValor(valorRetornado);
						movRev.setEstado_id(EstadoRepoImpl.getCodEst("RETORNO"));
						
						MovimientoDTO movRet = new MovimientoDTO();
						movRet.setDeposito_cod(dep.getCodigoDeposito());
						movRet.setValor(valorRetenido);
						movRet.setEstado_id(EstadoRepoImpl.getCodEst("RETENCION"));
						
						boolean exitoMovRv = MOV.agregar(movRev);
						boolean exitoMovRt = MOV.agregar(movRet);
						if(exitoMovRv && exitoMovRt) {
							System.out.println("Retorno de dinero para la cuenta: "+dep.getCodigoDeposito() +" por concepto de: "+valorRetornado+dep.getMonedaCod()+" - Aprobado");
							System.out.println("Retencion de dinero para la cuenta: "+dep.getCodigoDeposito() +" por concepto de: "+valorRetenido+dep.getMonedaCod()+" - Aprobado");
						}
					}
					
				}
				if(perInact) {
					System.out.println("Debido a que su cuenta no posee fondos su usuario queda temporalmente INACTIVO");
				}
			}
		}
	}
	
	public static Map<String, Double> calculosReversarF(String idDeposito) {
		
		Map<String, Double> reverso = new HashMap<>();
		DepositoDTO deposi = DEP.buscarPorId(idDeposito);
		MonedaDTO moneda = MON.buscarPorId(deposi.getMonedaCod());
		Double saldoActual = deposi.getSaldo();
		List<MovimientoDTO> movCuent = MOV.listarPorDeposito(deposi.getCodigoDeposito());
		if(movCuent.isEmpty()) {
			reverso.put("REV", saldoActual);
			reverso.put("RET", 0D);
		}else {
			Double dineroDonado = (movCuent.stream().flatMapToDouble(x -> DoubleStream.of(x.getValor())).sum()) / moneda.getTasaConversionCop();
			
			Double porcentajeDes = (saldoActual /dineroDonado);
			
			Double reten = Math.round((porcentajeDes * saldoActual)*100)/100D;
			Double rDon = Math.round((saldoActual - reten)*100)/100D;
			
			reverso.put("REV", rDon);
			reverso.put("RET", reten);
		}
		
		
		return reverso;
	}
	
	
	public static void crearDeposito(String perId) {
		String codiDep = "";
		System.out.println("Ingrese el codigo ISO de la moneda: ");
		MON.listarTodo().stream().forEach(x->System.out.println(x.getCodigoIso()+" -> "+x.getDescripcion()));
		String iso = SC.nextLine().trim();
		
		System.out.println("Ingrese la cantidad que desea cargar: ");
		Double cant = Double.valueOf(SC.nextLine().trim());
		
		codiDep = ControladorParametros.generarNumeroDeposito();
		
		if(DEP.buscarPorId(codiDep) != null) {
			codiDep = ControladorParametros.generarNumeroDeposito();
		}else {
			int estadoId = EstadoRepoImpl.getCodActivo();
			
			DepositoDTO dpos = new DepositoDTO();
			dpos.setCodigoDeposito(codiDep);
			dpos.setEstadoId(estadoId);
			dpos.setMonedaCod(iso);
			dpos.setPersonaId(perId);
			dpos.setSaldo(cant);
			
			int codEstTr = EstadoRepoImpl.getCodEst("INGRESO");
			MovimientoDTO movimie = new MovimientoDTO();
			movimie.setValor(dpos.getSaldo());
			movimie.setEstado_id(codEstTr);
			movimie.setDeposito_cod(dpos.getCodigoDeposito());
			
			boolean confirma = DEP.agregar(dpos);
			if(confirma) {
				boolean conf = MOV.agregar(movimie);
				if(conf) {
					System.out.println("Se creó el deposito");
				}
			}
		}
		
	}
	
	
	public static boolean validarFecha(String fecha) {
		if (fecha.isBlank()) {
			System.out.println("No se puede procesar un valor vacio");
		}else {
			String[] partesFecha = fecha.split("/");
			if (partesFecha.length == 3) {
				if (!validarAnio(partesFecha[0])) {
					System.out.println("El año ingresado no es correcto");
				}else if (!validarMes(partesFecha[1])) {
					System.out.println("El mes ingresado no es correcto");
				}else if (!validarDia(partesFecha[2])) {
					System.out.println("El dia ingresado no es correcto");
				}else {
					return true;
				}

			}
			else {
				System.out.println("Error: El formato es incorrecto");
				}
			
		}
		return false;
	}
	
	private static boolean validarDia(String dia) {
		if (dia.length() != 2)
			return false;
		else { 
			try {
				int dd = Integer.parseInt(dia);
				return (dd > 0 && dd < 31);
			}
			catch(NumberFormatException e) {
				return false; 
			}
		}
	}
 
	private static boolean validarMes(String mes) {
		if (mes.length() != 2)
			return false;
		else {
			try {
				int mm = Integer.parseInt(mes);
				return (mm > 0 && mm < 13);
			}catch(NumberFormatException e) {
				return false;
			}
		}
 
	}
 
	private static boolean validarAnio(String anio) {
		if (anio.length() != 4)
			return false;
		else {
			try {
				int aaaa = Integer.parseInt(anio);
				return (aaaa != 0);
			} catch(NumberFormatException e) {
				return false;
			}
		}
	}

}
