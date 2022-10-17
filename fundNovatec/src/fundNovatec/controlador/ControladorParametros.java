package fundNovatec.controlador;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import fundNovatec.dto.EstadoDTO;
import fundNovatec.dto.FundacionDTO;
import fundNovatec.dto.MonedaDTO;
import fundNovatec.dto.PersonaDTO;
import fundNovatec.dto.RolUsuarioDTO;
import fundNovatec.dto.SexoDTO;
import fundNovatec.persistencia.CampanaRepoImpl;
import fundNovatec.persistencia.EstadoRepoImpl;
import fundNovatec.persistencia.FundacionRepoImpl;
import fundNovatec.persistencia.MonedaRepoImpl;
import fundNovatec.persistencia.RolUsuarioRepoImpl;
import fundNovatec.persistencia.SexoRepoImpl;
import fundNovatec.persistencia.UsuarioRepoImpl;

public class ControladorParametros {

	private final static Scanner SC = new Scanner(System.in); 
	private final static RolUsuarioRepoImpl ROL = new RolUsuarioRepoImpl();
	private final static SexoRepoImpl SEX = new SexoRepoImpl();
	private final static FundacionRepoImpl FUN = new FundacionRepoImpl();
	private final static EstadoRepoImpl EST = new EstadoRepoImpl();
	private final static UsuarioRepoImpl USR = new UsuarioRepoImpl();
	private final static MonedaRepoImpl MON = new MonedaRepoImpl();
	private final static CampanaRepoImpl CAMP = new CampanaRepoImpl();
	
	public ControladorParametros() {
	}
	
	public static void registrarRol() {
		System.out.println("Ingrese el Rol: ");
		String nombre = SC.nextLine().trim();
		
		RolUsuarioDTO r = new RolUsuarioDTO();
		r.setDescripcion(nombre);
		
		if(nombre =="" ) {
			System.out.println("Es necesario que ingrese un rol de usuario\n desea repetir el proceso? 1 -> Si, 2 -> No");
			String res = SC.nextLine();
			switch (res) {
				case "1":
					registrarRol();
					break;
				default:
					break;
				
			}
		}else {
			boolean agregar = ROL.agregar(r);
			if(agregar) {
				System.out.println("Se agregó el rol "+r.getDescripcion());
			}else {
				System.out.println("Ocurrio un error inesperado");
			}
		}
	}
	
	public static void registrarSexo() {
		System.out.println("Ingrese el Sexo: ");
		String nombre = SC.nextLine().trim();
		
		SexoDTO r = new SexoDTO();
		r.setDescripcion(nombre);
		
		if(nombre =="" ) {
			System.out.println("Es necesario que ingrese un sexo\n desea repetir el proceso? 1 -> Si, 2 -> No");
			String res = SC.nextLine();
			switch (res) {
				case "1":
					registrarSexo();
					break;
				default:
					break;
				
			}
		}else {
			boolean agregar = SEX.agregar(r);
			if(agregar) {
				System.out.println("Se agregó el sexo "+r.getDescripcion());
			}else {
				System.out.println("Ocurrio un error inesperado");
			}
		}
	}
	
	public static String generarNumeroDeposito() {
		
		String parte1 = String.valueOf((int)(100000 * Math.random()));
		if(parte1.length() == 5) {
			return parte1;
		}else {
			return generarNumeroDeposito();
		}
	}
	
	public static String generarCodigoCamp() {

		Random random = new Random();
	    String cod = "";
	    for (int i = 0; i < 5; i++){
	        cod += (char) (random.nextInt(94)+33);
	    }
	    
	    if (cod.length() == 5) {
	    	return cod;
	    }else {
	    	return generarCodigoCamp();
	    }
		
	}
	
	public static void registrarFundacion() {
		System.out.println("Ingrese el nit: ");
		String nit = SC.nextLine().trim();
		
		System.out.println("Ingrese el nombre de la entidad: ");
		String nombre = SC.nextLine().trim();
		
		System.out.println("Ingrese la razon social: ");
		String razon_social = SC.nextLine().trim();
		
		System.out.println("Ingrese la moneda local: ");
		String moneda_iso = SC.nextLine().trim();
		
		FundacionDTO r = new FundacionDTO();
		r.setNit(nit);
		r.setNombre(nombre);
		r.setRazonSocial(razon_social);
		r.setMonedaIso(moneda_iso);
		
		if(nombre =="" || nit == "" || razon_social == "" || moneda_iso == "") {
			System.out.println("Es necesario que ingrese los datos solicitados\n desea repetir el proceso? 1 -> Si, 2 -> No");
			String res = SC.nextLine();
			switch (res) {
				case "1":
					registrarFundacion();
					break;
				default:
					break;
				
			}
		}else {
			boolean agregar = FUN.agregar(r);
			if(agregar) {
				System.out.println("Se agregó la entidad "+r.getNombre());
			}else {
				System.out.println("Ocurrio un error inesperado");
			}
		}
	}
	
	public static void registrarEstado() {
		System.out.println("Ingrese el Estado: ");
		String nombre = SC.nextLine().trim();
		
		System.out.println("Ingrese un caracter identificador: ");
		char caracter = SC.nextLine().trim().charAt(0);
		
		EstadoDTO r = new EstadoDTO();
		r.setDescripcion(nombre);
		r.setCategoria(caracter);
		
		if(nombre =="" || caracter == '\0' ) {
			System.out.println("No deben quedar campos vacios...\n desea repetir el proceso? 1 -> Si, 2 -> No");
			String res = SC.nextLine();
			switch (res) {
				case "1":
					registrarEstado();
					break;
				default:
					break;
				
			}
		}else {
			boolean agregar = EST.agregar(r);
			if(agregar) {
				System.out.println("Se agregó el estado "+r.getDescripcion());
			}else {
				System.out.println("Ocurrio un error inesperado");
			}
		}
	}
	
	public static void registrarMoneda () {
		System.out.println("Ingrese el nombre de la moneda: ");
		String nombre = SC.nextLine().trim();
		
		System.out.println("Ingrese el codigo iso: ");
		String iso = SC.nextLine().trim().toUpperCase();
		
		System.out.println("Ingrese el valor equivalente en COP: ");
		Double valor = Double.valueOf( SC.nextLine().trim());
		
		MonedaDTO r = new MonedaDTO();
		r.setDescripcion(nombre);
		r.setCodigoIso(iso);
		r.setTasaConversionCop(valor);
		
		if(nombre =="" || iso == "" || valor.isNaN()) {
			System.out.println("Es necesario que ingrese todos los valores requeridos\n desea repetir el proceso? 1 -> Si, 2 -> No");
			String res = SC.nextLine();
			switch (res) {
				case "1":
					registrarMoneda();
					break;
				default:
					break;
				
			}
		}else {
			boolean agregar = MON.agregar(r);
			if(agregar) {
				System.out.println("Se agregó la moneda "+r.getDescripcion());
			}else {
				System.out.println("Ocurrio un error inesperado");
			}
		}
	}
	
	
	public static void iniciarSesion() {
		boolean confirmacionUser = true;
		boolean confirmacionPass = true;
		boolean confirmacion = true;
		String usuario = "";
		String contrasena = "";
		Map<String, PersonaDTO> userEnable = new HashMap<>();

		do {
			System.out.println("INGRESO AL SISTEMA");

			while (confirmacionUser) {
				System.out.print("Usuario: ");
				usuario = SC.nextLine().trim();
				if (usuario != "") {
					confirmacionUser = false;
				}
			}

			while (confirmacionPass) {
				System.out.print("contrasena: ");
				contrasena = SC.nextLine().trim();
				if (contrasena != "") {
					confirmacionPass = false;
				}
			}

			if (usuario != "" && contrasena != "") {
				userEnable = USR.iniciarSesion(usuario, contrasena);
			} else {
				System.out.println("Error de inicio de sesión");
			}

			if (!userEnable.isEmpty()) {
				confirmacion = false;

				String nameUser = userEnable.get("USER").getNombre().toUpperCase();
				int idRolUser = userEnable.get("USER").getRol_usuario();
				
				RolUsuarioDTO rol = ROL.buscarPorId(idRolUser);
				String rolUser = rol.getDescripcion().toUpperCase();

				if (rolUser.equalsIgnoreCase("DONANTE")) {

						String apellidos = userEnable.get("USER").getApellidos().toUpperCase();
						System.out.println("\n----------- HOLA " + nameUser + " " + apellidos
								+ " -----------");
						
						boolean inactivo = verificarEstadoInactivo(userEnable.get("USER").getId_estado());
						
						if(inactivo) {
							ControladorDonador.accionesDeposito(userEnable.get("USER").getIdentificacion());
						}else {
							boolean conf = true;
							do {
								System.out.println("Menú Donante\n"
										+ "1 -> Opciones de deposito\n"
										+ "2 -> Opciones de campaña\n"
										+ "3 -> Solicitar reporte donación\n"
										+ "4 -> Reversar dinero de mis fondos\n"
										+ "5 -> Cerrar Sesión");
								System.out.print("Ingrese el numero de la opcion deseada: ");
								String op = SC.nextLine().trim();
								if(op == "") {
									System.out.println("Ingrese una opcion...");
								}else {
									
									switch (op) {
									case "1":
										ControladorDonador.accionesDeposito(userEnable.get("USER").getIdentificacion());
										break;
									case "2":
										ControladorDonador.accionesCampaña(userEnable.get("USER").getIdentificacion());;
										break;
									case "3":
										ControladorDonador.emitirDocumentoDonante(userEnable.get("USER").getIdentificacion());
										break;
									case "4":
										ControladorDonador.reversarFondos(userEnable.get("USER").getIdentificacion());
										conf = false;
										System.out.println("Cerrando sesión, bye...");
										break;
									case "5":
										System.out.println("Cerrando sesión, bye...");
										conf = false;
										break;
									default:
										System.out.println("Opcion erronea...");
										break;
									}
									
								}
							}while(conf);
						}

				} else if (rolUser.equalsIgnoreCase("ADMINISTRADOR")) {
					String apellidos = userEnable.get("USER").getApellidos().toUpperCase();
					System.out.println("\n----------- HOLA " + nameUser + " " + apellidos
							+ " -----------");
					
						boolean conf = true;
						//ControladorParametros.registrarSexo();
						//ControladorParametros.registrarEstado();
						//ControladorParametros.registrarRol();
						//ControladorParametros.registrarMoneda();
						//ControladorParametros.registrarFundacion();
						//ControladorAdministrador.registrarCampana("87432567-2");
						//ControladorAdministrador.reporteCampana("@@Qw)");
						do {
							System.out.println("\nCAMPAÑAS REGISTRADAS\n");
						CAMP.listarTodo().stream().forEach(x -> System.out.println("CODIGO: "+x.getIdCampana()+" NOMBRE: "+x.getNombreCampana()));
						System.out.println("**************************************");
									
							
							System.out.println("Menú Administrador\n"
									+ "******* PARAMETRIZACIÓN GENERAL ********"
									+ "1 -> Registrar Sexo\n"
									+ "2 -> Registrar Estado\n"
									+ "3 -> Registrar Rol\n"
									+ "4 -> Registrar Monedas\n"
									+ "5 -> Registrar Fundación\n"
									+ "******* CAMPAÑAS *********\n"
									+ "6 -> Registrar Campaña\n"
									+ "7 -> Generar Reporte de Campaña\n"
									+ "0 -> Cerrar Sesión");
							System.out.print("Ingrese el numero de la opcion deseada: ");
							String op = SC.nextLine().trim();
							if(op == "") {
								System.out.println("Ingrese una opcion...");
							}else {
								
								switch (op) {
								case "1":
									ControladorParametros.registrarSexo();
									break;
								case "2":
									ControladorParametros.registrarEstado();
									break;
								case "3":
									ControladorParametros.registrarRol();
									break;
								case "4":
									ControladorParametros.registrarMoneda();
									break;
								case "5":
									ControladorParametros.registrarFundacion();
									break;
								case "6":
									ControladorAdministrador.registrarCampana(userEnable.get("USER").getFn_nit());
									break;
								case "7":
									System.out.print("Ingrese el codigo de la campaña: ");
									String opt = SC.nextLine().trim();
									if(opt != "") {
										ControladorAdministrador.reporteCampana(opt);
									}else {
										System.out.println("Ingrese una opcion valida...");
									}
									
									break;
								case "0":
									System.out.println("Cerrando sesión, bye...");
									conf = false;
									break;
								default:
									System.out.println("Opcion erronea...");
									break;
								}
								
							}
						}while(conf);
					}
				

			} else {
				confirmacionUser = true;
				confirmacionPass = true;
				System.out.println("Usuario o contrasena incorrectos\n");
			}

			System.out.print("\033[H\033[2J");
			System.out.flush();

		} while (confirmacion);
	}
	
	public static boolean verificarEstadoInactivo(int id) {
		
		EstadoDTO estado = EST.buscarPorId(id);
		if(estado != null) {
			
			if(estado.getDescripcion().equalsIgnoreCase("INACTIVO")) {
				System.out.println("De forma temporal su cuenta esta en estado |INACTIVA|\\n Para activar su cuenta debe cargar un monto minimo de $1,000,000COP en fondos");
				return true;
			}	
		}
		return false;
	}
	
	

}
