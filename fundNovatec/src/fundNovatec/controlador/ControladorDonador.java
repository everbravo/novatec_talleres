package fundNovatec.controlador;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import fundNovatec.dto.DepositoDTO;
import fundNovatec.dto.PersonaDTO;
import fundNovatec.dto.UsuarioDTO;
import fundNovatec.operaciones.OperacionesPersonalizadas;
import fundNovatec.persistencia.DepositoRepoImpl;
import fundNovatec.persistencia.EstadoRepoImpl;
import fundNovatec.persistencia.MonedaRepoImpl;
import fundNovatec.persistencia.PersonaRepoImpl;
import fundNovatec.persistencia.UsuarioRepoImpl;

public class ControladorDonador {

	private final static Scanner SC = new Scanner(System.in); 
	private final static PersonaRepoImpl PER = new PersonaRepoImpl();
	private final static UsuarioRepoImpl USER = new UsuarioRepoImpl();
	private final static MonedaRepoImpl MON = new MonedaRepoImpl();
	private final static EstadoRepoImpl EST = new EstadoRepoImpl();
	private final static DepositoRepoImpl DEP = new DepositoRepoImpl();
	
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
		int id_sexo = Integer.parseInt(SC.nextLine().trim());
		
		int rol = OperacionesPersonalizadas.getRolUsuario();
		
		System.out.println("Ingrese el codigo de su fundación: ");
		OperacionesPersonalizadas.desplegarFundaciones();
		String id_fund = SC.nextLine().trim();
		
		System.out.println("Ingrese su nombre de usuario: ");
		String nameuser = SC.nextLine().trim();
		
		System.out.println("Ingrese su contraseña: ");
		String password = SC.nextLine().trim();
		
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
		
		if(identificacion == "" || nombre == "" || apellidos == "" || fecha_nacimiento == null 
				|| id_sexo == -1 || rol == -1 || id_fund == "" || nameuser == "" || password == "") {
			System.out.println("Todos los campos consultados son requeridos por el proceso, ingreselos nuevamente...");
			registrarDonador();
		}else {
			
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
	
	
	public static void accionesDeposito(String perId) {
		
		String opciones = "MENÚ DEPOSITOS\n"
				+ "1 -> Crear Deposito\n"
				+ "2 -> Eliminar Deposito\n"
				+ "3 -> Editar Deposito\n"
				+ "4 -> Solicitar Activación de Cuenta\n"
				+ "0 -> Salir";
		
		boolean confirma = true;
		do {
			
			System.out.println(opciones);
			String op = SC.nextLine().trim();
			
			switch (op) {
			case "1":
				crearDeposito(perId);
				break;
			case "2":
				
				break;
			case "3":
	
				break;
			case "4":
				
				break;
			case "0":
	
				break;

			default:
				System.out.println("Opción Erronea");
				break;
			}
			
		} while (confirma);
	}
	
	
	public static void crearDeposito(String perId) {
		
		System.out.println("Ingrese el codigo ISO de la moneda: ");
		MON.listarTodo().stream().forEach(x->System.out.println(x.getCodigoIso()+" -> "+x.getDescripcion()));
		String iso = SC.nextLine().trim();
		
		System.out.println("Ingrese la cantidad que desea cargar: ");
		Double cant = Double.valueOf(SC.nextLine().trim());
		
		String codiDep = ControladorParametros.generarNumeroDeposito();
		
		int estadoId = EstadoRepoImpl.getCodActivo();
		
		DepositoDTO dpos = new DepositoDTO();
		dpos.setCodigoDeposito(codiDep);
		dpos.setEstadoId(estadoId);
		dpos.setMonedaCod(iso);
		dpos.setPersonaId(perId);
		dpos.setSaldo(cant);
		
		boolean confirma = DEP.agregar(dpos);
		
		if(confirma) {
			
		}
	}
	
	
	private static boolean validarFecha(String fecha) {
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
