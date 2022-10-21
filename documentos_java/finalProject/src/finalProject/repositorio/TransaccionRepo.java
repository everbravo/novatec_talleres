package finalProject.repositorio;

import java.sql.Connection;
import java.util.List;

//import finalProject.excepxiones.ExcepcionesPersonalizadas;
import finalProject.modelo.Transaccion;

public interface TransaccionRepo {

	public boolean agregar(Connection conn, Transaccion transac);
	
	public List<Transaccion> obtener(Connection conn);
	
	//public boolean actualizar(Connection conn, Transaccion transc, int id) throws ExcepcionesPersonalizadas;
	
	public List<Transaccion> obtenerTransaccion(Connection conn, String cuenta);
	
	public boolean eliminar(Connection conn, int id);
	
}
