package finalProject.controlador;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import finalProject.basedatos.Conexion;
import finalProject.excepxiones.ExcepcionesPersonalizadas;
import finalProject.modelo.Banco;
import finalProject.modelo.Cliente;
import finalProject.modelo.Cuenta;
import finalProject.modelo.Transaccion;
import finalProject.modelo.Usuario;
import finalProject.persistencia.BancoRepoImpl;
import finalProject.persistencia.ClienteRepoImpl;
import finalProject.persistencia.CuentaRepoImpl;
import finalProject.persistencia.TransaccionRepoImpl;
import finalProject.persistencia.UsuarioRepoImpl;
import finalProject.reportes.ReporteClienteCuenta;
import finalProject.reportes.ToCsv;

public class ControladorPrincipal {

	public static void iniciarSesion(Scanner sc, Connection conn) throws ExcepcionesPersonalizadas {

		boolean confirmacionUser = true;
		boolean confirmacionPass = true;
		boolean confirmacion = true;
		String usuario = "";
		String contrasena = "";
		Map<String, Usuario> userEnable = new HashMap<>();

		do {
			System.out.println("INGRESO AL SISTEMA BANCARIO\n");

			while (confirmacionUser) {
				System.out.print("Usuario: ");
				usuario = sc.nextLine().trim();
				if (usuario != "") {
					confirmacionUser = false;
				}
			}

			while (confirmacionPass) {
				System.out.print("contrasena: ");
				contrasena = sc.nextLine().trim();
				if (contrasena != "") {
					confirmacionPass = false;
				}
			}

			if (usuario != "" && contrasena != "") {
				userEnable = UsuarioRepoImpl.iniciarSesion(usuario, contrasena);
			} else {
				System.out.println("Error de inicio de sesión");
			}

			if (!userEnable.isEmpty()) {
				confirmacion = false;

				String nameUser = userEnable.get("USER").getNombre_usuario();
				char rolUser = userEnable.get("USER").getRol();

				if (rolUser == 'U') {

					ClienteRepoImpl clrimpl = new ClienteRepoImpl();

					Cliente cli = clrimpl.obtenerByUser(conn, nameUser);
					//System.out.println("cli-> " + cli);
					if (cli != null) {

						String nombre = cli.getNombre();
						String apellidos = cli.getApellidos();
						System.out.println("\n----------- HOLA " + nombre.toUpperCase() + " " + apellidos.toUpperCase()
								+ " -----------");

						imprimirCuentasClientes(cli);

						mostrarMenuUsuario(sc, cli);

					}

				} else if (rolUser == 'A') {
					BancoRepoImpl brimpl = new BancoRepoImpl();
					Banco banco = brimpl.obtenerBancoUser(conn, nameUser);
					
					System.out.println("hola bancp"+banco);
					if (banco != null) {

						String nombre = banco.getNombre();
						System.out.println("\n----------- HOLA " + nombre.toUpperCase() + " -----------");
						
						mostrarMenuAdministrador(sc, banco);

					}
				} else {
					throw new ExcepcionesPersonalizadas("Error faltal en el sistema");
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

	public static void imprimirCuentasClientes(Cliente cli) {
		CuentaRepoImpl cimpl = new CuentaRepoImpl();
		Connection conn = Conexion.getConexion();
		System.out.println("Cuentas:");
		List<Cuenta> cuenta = cimpl.obtener(conn, cli.getCedula());
		Map<String, String> mapaCuentas = cuenta.stream()
				.collect(Collectors.toMap(e -> e.getNumero_cuenta() + "\t", e -> "\t" + e.getSaldo() + " USD"));
		mapaCuentas.entrySet().stream().forEach(s -> System.out.println(s));
		System.out.println();
	}

	public static void index() throws ExcepcionesPersonalizadas {
		Scanner sc = new Scanner(System.in);

		System.out.println("----------- BANCO NOVATEC -----------\n" + "------------- BIENVENIDO ------------\n");
		mostrarMenuPrincipal(sc);
	}

	public static void mostrarMenuPrincipal(Scanner sc) throws ExcepcionesPersonalizadas {
		Connection conn = Conexion.getConexion();
		boolean correct = true;
		while (correct) {
			System.out.println("MENÚ PRINCIPAL\n para seleccionar una opción solo vasta con escribir su numero");
			System.out.println("1 -> Ingresar a mi cuenta");
			System.out.println("2 -> Crear una cuenta");
			System.out.println("3 -> Salir del sistema");
			System.out.print("Op: ");
			String opcion = sc.nextLine();

			switch (opcion) {
			case "1":
				iniciarSesion(sc, conn);
				correct = false;
				break;
			case "2":
				crearCuentaUsuario(sc);
				break;
			case "3":
				System.out.println("Finalizando el sistema bancario...\n");
				System.exit(0);
				correct = false;
				break;

			default:
				System.out.println("Opcion erronea\n");
			}

		}

	}

	public static void mostrarMenuAdministrador(Scanner sc, Banco bc) {
		Connection conn = Conexion.getConexion();
		CuentaRepoImpl crimpl = new CuentaRepoImpl();
		ToCsv tcsv = new ToCsv();
		@SuppressWarnings("unused")
		String numeroCuenta = "";
		String cedula ="";
		boolean correct = true;
		while (correct) {
			System.out
					.println("---------------------->\n para seleccionar una opción solo vasta con escribir su numero");
			System.out.println("CUENTAS -------->");
			System.out.println("1 -> informe cuentas por usuario (Crear csv)");
			System.out.println("2 -> informe cliente - cuentas (Crear csv)");
			System.out.println("CLIENTE -------->");
			System.out.println("3 -> Ingresar cliente");
			System.out.println("4 -> Cerrar sesión");
			System.out.println("5 -> informe transacciones (Crear csv)");
			System.out.print("Op: ");
			String opcion = sc.nextLine();

			switch (opcion) {

			case "1":
				while (cedula == "") {
					System.out.print("Ingrese el numero de cedula del cliente: ");
					cedula = sc.nextLine().trim();
				}
				List<Cuenta> listCuenta = crimpl.obtener(conn, cedula);
				
				
				tcsv.toCsv(listCuenta);
				System.out.println("Reporte creado");
				
				break;
			case "2":
				List<ReporteClienteCuenta> cuntasTotal = crimpl.obtenerAll(conn);
				
				tcsv.toCsv(cuntasTotal);
				System.out.println("Reporte creado");
				break;
			case "3":
				crearCuentaAdministrador(sc, bc);
				break;

			case "4":
				try {
					System.out.println("Cerrando sesión...");
					index();
				} catch (ExcepcionesPersonalizadas e) {
					System.out.println(e.getMessage());
				}
				break;
			case "5":
				TransaccionRepoImpl tr = new TransaccionRepoImpl();
				List<Transaccion> lstr = tr.obtener(conn);
				tcsv.toCsv(lstr);
				System.out.println("Reporte de transacciones generado");
				break;
			default:
				System.out.println("Opcion erronea\n");
			}
		}
	}

	public static void crearCuentaUsuario(Scanner sc) {
		Connection conn = Conexion.getConexion();
		BancoRepoImpl ban = new BancoRepoImpl();
		UsuarioRepoImpl USER = new UsuarioRepoImpl();
		ClienteRepoImpl CLIENT = new ClienteRepoImpl();

		Cliente newCliente = new Cliente();
		Usuario newUsuario = new Usuario();
		System.out.println("----- CREAR CUENTA USUARIO -----");
		System.out.print("Nombre: ");
		String nombre = sc.nextLine().trim();
		System.out.print("Apellidos: ");
		String apellidos = sc.nextLine().trim();
		System.out.print("Numero de cedula: ");
		String cedula = sc.nextLine().trim();
		System.out.print("Fecha nacimiento (yyyy/MM/dd): ");
		LocalDate fecha_nacimiento = LocalDate.parse(sc.nextLine().trim(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		System.out.print("Sexo (M -> Masculino, F -> Femenino): ");
		char sexo = sc.nextLine().trim().charAt(0);
		System.out.print("Nombre usuario: ");
		String username = sc.nextLine().trim();
		System.out.print("Correo: ");
		String correo = sc.nextLine().trim();
		System.out.print("contrasena: ");
		String contrasena = sc.nextLine().trim();
		char rol = 'U';
		System.out.println("\nEntidad Financiera (ingresar el nit correspondiente a su banco): ");
		listarBancos(conn);
		String banco = sc.nextLine().trim();

		if (nombre == "" || apellidos == "" || cedula == "" || fecha_nacimiento == null || sexo == '\0'
				|| username == "" || correo == "" || contrasena == "" || banco == "") {
			System.out.println("Todos los campos consultados son requeridos por el proceso, ingreselos nuevamente...");
			crearCuentaUsuario(sc);
		} else {
			newUsuario.setNombre_usuario(username);
			newUsuario.setContrasena(contrasena);
			newUsuario.setCorreo(correo);
			newUsuario.setRol(rol);

			newCliente.setCedula(cedula);
			newCliente.setNombre(nombre);
			newCliente.setApellidos(apellidos);
			newCliente.setFecha_nacimiento(Date.valueOf(fecha_nacimiento));
			newCliente.setSexo(sexo);
			newCliente.setBanco(ban.obtenerBanco(conn, banco));
			newCliente.setNombre_usuario(newUsuario);

			boolean confUser = USER.agregar(conn, newUsuario);
			if (confUser) {
				boolean confClie = CLIENT.agregar(conn, newCliente);
				if (confClie) {
					System.out.println("Datos almacenados correctamente");
				}
			}

		}

	}

	public static void crearCuentaAdministrador(Scanner sc, Banco b) {
		Connection conn = Conexion.getConexion();
		@SuppressWarnings("unused")
		BancoRepoImpl ban = new BancoRepoImpl();
		UsuarioRepoImpl USER = new UsuarioRepoImpl();
		ClienteRepoImpl CLIENT = new ClienteRepoImpl();

		Cliente newCliente = new Cliente();
		Usuario newUsuario = new Usuario();
		System.out.println("----- CREAR CUENTA USUARIO -----");
		System.out.print("Nombre: ");
		String nombre = sc.nextLine().trim();
		System.out.print("Apellidos: ");
		String apellidos = sc.nextLine().trim();
		System.out.print("Numero de cedula: ");
		String cedula = sc.nextLine().trim();
		System.out.print("Fecha nacimiento (yyyy/MM/dd): ");
		LocalDate fecha_nacimiento = LocalDate.parse(sc.nextLine().trim(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		System.out.print("Sexo (M -> Masculino, F -> Femenino): ");
		char sexo = sc.nextLine().trim().charAt(0);
		System.out.print("Nombre usuario: ");
		String username = sc.nextLine().trim();
		System.out.print("Correo: ");
		String correo = sc.nextLine().trim();
		System.out.print("contrasena: ");
		String contrasena = sc.nextLine().trim();
		char rol = 'U';
		

		if (nombre == "" || apellidos == "" || cedula == "" || fecha_nacimiento == null || sexo == '\0'
				|| username == "" || correo == "" || contrasena == "" || rol == '\0') {
			System.out.println("Todos los campos consultados son requeridos por el proceso, ingreselos nuevamente...");
			crearCuentaUsuario(sc);
		} else {
			newUsuario.setNombre_usuario(username);
			newUsuario.setContrasena(contrasena);
			newUsuario.setCorreo(correo);
			newUsuario.setRol(rol);

			newCliente.setCedula(cedula);
			newCliente.setNombre(nombre);
			newCliente.setApellidos(apellidos);
			newCliente.setFecha_nacimiento(Date.valueOf(fecha_nacimiento));
			newCliente.setSexo(sexo);
			newCliente.setBanco(b);
			newCliente.setNombre_usuario(newUsuario);

			boolean confUser = USER.agregar(conn, newUsuario);
			if (confUser) {
				boolean confClie = CLIENT.agregar(conn, newCliente);
				if (confClie) {
					System.out.println("Datos almacenados correctamente");
				}
			}

		}

	}

	
	public static void listarBancos(Connection con) {
		BancoRepoImpl brimpl = new BancoRepoImpl();
		Map<String, String> banc = brimpl.obtenerBancoAll(con).stream()
				.collect(Collectors.toMap(e -> e.getNit() + "\t", e -> "\t" + e.getNombre()));
		banc.entrySet().stream().forEach(x -> System.out.println(x));
		System.out.println();
	}

	public static void mostrarMenuUsuario(Scanner sc, Cliente cli) {
		Connection conn = Conexion.getConexion();
		CuentaRepoImpl crimpl = new CuentaRepoImpl();
		String numeroCuenta = "";
		boolean correct = true;
		while (correct) {
			System.out
					.println("---------------------->\n para seleccionar una opción solo vasta con escribir su numero");
			System.out.println("CUENTAS -------->");
			System.out.println("1 -> Abrir cuenta");
			System.out.println("2 -> Consultar cuenta");
			System.out.println("TRANSACCIONES");
			System.out.println("3 -> Retirar dinero");
			System.out.println("4 -> Ingresar dinero");
			System.out.println("5 -> Cerrar sesión");
			System.out.print("Op: ");
			String opcion = sc.nextLine();

			String nCuenta = "";
			Cuenta cuent = null;
			switch (opcion) {

			case "1":
				numeroCuenta = CuentaRepoImpl.generarNumeroCuenta();
				if (!CuentaRepoImpl.existeCuenta(conn, numeroCuenta)) {
					Cuenta cuenta = new Cuenta(numeroCuenta, 100D, 'A', cli);

					boolean d = crimpl.agregar(conn, cuenta);

					if (d) {
						System.out.println("Cuenta numero | " + cuenta.getNumero_cuenta()
								+ " | creada, ahora puede retirar e ingresar dinero");
						System.out.println("su saldo es de: " + cuenta.getSaldo() + " USD");
						System.out.println("Por defecto las cuentas se cargan con 100USD\n");
					} else {
						System.out.println("Error al agregar la cuenta, intentelo nuevamente\n");
					}

				}
				imprimirCuentasClientes(cli);
				break;
			case "2":

				while (nCuenta == "") {
					System.out.print("Ingrese el numero de cuenta a consultar: ");
					nCuenta = sc.nextLine().trim();
				}

				cuent = crimpl.obtenerCuenta(conn, nCuenta);

				if (cuent != null) {
					boolean perteneceClienteCuenta = nCuenta.equals(cuent.getNumero_cuenta());
					if (perteneceClienteCuenta) {
						System.out.print("Cuenta numero | " + cuent.getNumero_cuenta() + " |");
						System.out.println("su saldo es de: " + cuent.getSaldo() + " USD");
						System.out.println("Sus ultimos movimientos fueron................");
						TransaccionRepoImpl trimp = new TransaccionRepoImpl();
						trimp.obtenerTransaccion(conn, nCuenta).stream().forEach(x-> System.out.println(x));
						
						imprimirCuentasClientes(cli);
					} else {
						System.out.println("Cuenta numero | " + cuent.getNumero_cuenta()
								+ " | no se encuentra asociada a su usuario");
						imprimirCuentasClientes(cli);
					}

				} else {
					System.out.println("verifique el numero de la cuenta e intentelo nuevamente\n");
					imprimirCuentasClientes(cli);
				}
				break;
			case "3":

				while (nCuenta == "") {
					System.out.print("Ingrese el numero de cuenta: ");
					nCuenta = sc.nextLine().trim();
				}

				cuent = crimpl.obtenerCuenta(conn, nCuenta);

				if (cuent != null) {
					boolean perteneceClienteCuenta = nCuenta.equals(cuent.getNumero_cuenta());
					if (perteneceClienteCuenta) {
						double monto = 0D;
						while (monto <= 0D) {
							System.out.print("Ingrese el monto a debitar: ");
							monto = Double.valueOf(sc.nextLine().trim());
						}
						boolean debito = TransaccionRepoImpl
								.verificarCriterioTransaccionRetiro(cuent.getNumero_cuenta(), monto);
						if (debito) {
							System.out.println("Transaccion aprobada");
							imprimirCuentasClientes(cli);
						}
					}

				} else {
					System.out.println("verifique el numero de la cuenta e intentelo nuevamente\n");
					imprimirCuentasClientes(cli);
				}

				break;
			case "4":

				while (nCuenta == "") {
					System.out.print("Ingrese el numero de cuenta: ");
					nCuenta = sc.nextLine().trim();
				}

				cuent = crimpl.obtenerCuenta(conn, nCuenta);

				if (cuent != null) {
					boolean perteneceClienteCuenta = nCuenta.equals(cuent.getNumero_cuenta());
					if (perteneceClienteCuenta) {
						double monto = 0D;
						while (monto <= 0D) {
							System.out.print("Ingrese el monto a ingresar: ");
							monto = Double.valueOf(sc.nextLine().trim());
						}
						boolean debito = TransaccionRepoImpl.ingresarDineroCuenta(cuent.getNumero_cuenta(), monto);
						if (debito) {
							System.out.println("Transaccion aprobada");
							imprimirCuentasClientes(cli);
						}
					}

				} else {
					System.out.println("verifique el numero de la cuenta e intentelo nuevamente\n");
					imprimirCuentasClientes(cli);
				}
				break;

			case "5":
				try {
					System.out.println("Cerrando sesión...");
					index();
				} catch (ExcepcionesPersonalizadas e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Opcion erronea\n");
			}

		}
	}

}
