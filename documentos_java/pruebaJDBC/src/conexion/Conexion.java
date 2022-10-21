package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private final String DBURL = "jdbc:mysql://localhost:3306/pruebasjava";
	
	private final String USERNAME = "root";
	
	private final String PASSWORD = "ever123";
	
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private static Connection conn = null;
	
	private Conexion () {
		
		try {
			
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
			
			if (conn != null) {
				System.out.println("Conectado a BD");
			}else {
				System.out.println("Conexión a BD erronea");
			}
			
		}catch (SQLException | ClassNotFoundException e){
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	public static Connection getConexion() {
		if (conn == null) {
			new Conexion();
		}
		return conn;
	}
	
	public static void closeConexion() {
		try {
			conn.close();
			System.out.println("Conexión cerrada");
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexión: "+e.getMessage());
		}
	}

}
