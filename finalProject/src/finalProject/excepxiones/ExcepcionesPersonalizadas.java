package finalProject.excepxiones;

import java.sql.SQLException;

public class ExcepcionesPersonalizadas extends Exception{

	private static final long serialVersionUID = 1L;

	public ExcepcionesPersonalizadas() {
		super();
	}
	
	public ExcepcionesPersonalizadas(String mensaje) {
		super(String.format("Error: %s", mensaje));
	}
	
	public ExcepcionesPersonalizadas(Throwable causa) {
		super(String.format("Causa del error: %s", causa));
	}
	
	public ExcepcionesPersonalizadas(SQLException sql) {
		super(String.format("SQL Error: %s", sql));
	}
	
	public ExcepcionesPersonalizadas(String mensaje, Throwable causa) {
		super(String.format("Error: %s Causa del error: %s", mensaje, causa));
	}

}
