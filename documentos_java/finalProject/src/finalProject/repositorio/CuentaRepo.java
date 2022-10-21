package finalProject.repositorio;

import java.sql.Connection;
import java.util.List;

import finalProject.excepxiones.ExcepcionesPersonalizadas;
import finalProject.modelo.Cuenta;

public interface CuentaRepo {

	public boolean agregar(Connection conn, Cuenta cuenta);
	
	public List<Cuenta> obtener(Connection conn, String cedula);
	
	public boolean actualizar(Connection conn, Cuenta cuenta, String numero) throws ExcepcionesPersonalizadas;
	
	public Cuenta obtenerCuenta(Connection conn, String numero);
	
	public boolean eliminar(Connection conn, String cuenta);
	
	
	
}
