package finalProject;


import finalProject.controlador.ControladorPrincipal;
import finalProject.excepxiones.ExcepcionesPersonalizadas;

public class Main {

	public static void main(String[] args) {
		
		try {
			ControladorPrincipal.index();
		} catch (ExcepcionesPersonalizadas e) {
			System.out.println(e.getMessage());
			
		}
		

	}

}
