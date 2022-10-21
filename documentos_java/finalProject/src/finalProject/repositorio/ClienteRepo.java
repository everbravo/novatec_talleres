package finalProject.repositorio;

import java.sql.Connection;
import java.util.List;

import finalProject.excepxiones.ExcepcionesPersonalizadas;
import finalProject.modelo.Cliente;

public interface ClienteRepo {

	public boolean agregar(Connection con, Cliente cliente);
	
	public List<Cliente> obtener(Connection con);
	
	public boolean actualizar(Connection con, Cliente cliente, String ident)  throws ExcepcionesPersonalizadas;
	
	public Cliente obtenerCliente(Connection con, String cedula);
	
	public boolean eliminar(Connection con, String cedula);
	
	public Cliente obtenerByUser(Connection con, String nombre_user);
		
	
	
}
