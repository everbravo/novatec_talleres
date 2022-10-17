package fundNovatec.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static Connection conn = null;
	
	private final String DBURL = "jdbc:mysql://localhost:3306/fproject2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private final String USERNAME = "root";
	
	private final String PASSWORD = "ever123";
	
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	
	public Conexion() {
		
		try {
			
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
			
			if (conn != null) {
				//System.out.println("Conectado a BD");
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
	

	
	
}
