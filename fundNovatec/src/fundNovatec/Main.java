package fundNovatec;

import java.util.Scanner;

import fundNovatec.controlador.ControladorAdministrador;
import fundNovatec.controlador.ControladorDonador;
import fundNovatec.controlador.ControladorParametros;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		//ControladorParametros.registrarSexo();
		//ControladorParametros.registrarEstado();
		//ControladorParametros.registrarRol();
		//ControladorParametros.registrarMoneda();
		//ControladorParametros.registrarFundacion();
		//ControladorDonador.registrarDonador(); listo
		//ControladorParametros.iniciarSesion(); listo
		//ControladorDonador.accionesDeposito("21343534");
		//ControladorAdministrador.registrarCampana("87432567-2");
		//ControladorDonador.accionesCampaña("21343534"); listo
		//ControladorAdministrador.reporteCampana("@@Qw)");
		//ControladorDonador.emitirDocumentoDonante("21343534");
		//ControladorDonador.reversarFondos("21343534");
		Scanner sc = new Scanner(System.in);
		boolean repetir = true;
		
		while(repetir) {
			System.out.println("******************************************************");
			System.out.println("FUND-NOVATEC");
			System.out.println("Menú Principal\n"
					+ "1 -> Registrarse\n"
					+ "2 -> Iniciar Sesión\n"
					+ "3 -> Finalizar Aplicativo");
			System.out.println("******************************************************");
			
			System.out.println("Ingrese el numero de la opcion a la qu desea acceder...");
			String opcion = sc.nextLine().trim();
			if(opcion=="") {
				System.out.println("Por favor ingrese una opcion");
			}else {
				switch (opcion) {
				case "1":
					ControladorDonador.registrarDonador();
					break;
				case "2":
					ControladorParametros.iniciarSesion();
					break;
				case "3":
					repetir=false;
					System.exit(0);
					break;

				default:
					System.out.println("Ingrese una opcion valida");
					break;
				}
			}
			
		}
		
	}

}
