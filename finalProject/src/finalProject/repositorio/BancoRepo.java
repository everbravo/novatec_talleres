package finalProject.repositorio;

import java.sql.Connection;

import finalProject.excepxiones.ExcepcionesPersonalizadas;
import finalProject.modelo.Banco;
//import finalProject.modelo.Cliente;

public interface BancoRepo {
	
	public boolean agregar(Connection conn, Banco banco);
	
	public boolean actualizar(Connection conn, String banco, Banco bc) throws ExcepcionesPersonalizadas;
	
	public Banco obtenerBanco(Connection conn, String nit);
	
	public boolean eliminar(Connection conn, String nit);
	
	//public boolean agregarCliente(Cliente cliente);
	
}
