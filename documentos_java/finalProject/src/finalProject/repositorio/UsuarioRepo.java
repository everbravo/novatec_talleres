package finalProject.repositorio;


import java.sql.Connection;

import finalProject.excepxiones.ExcepcionesPersonalizadas;
import finalProject.modelo.Usuario;

public interface UsuarioRepo {

public boolean agregar(Connection conn, Usuario user);
	
	public boolean actualizar(Connection conn, String user, Usuario er) throws ExcepcionesPersonalizadas;
	
	public Usuario obtenerUsuario(Connection conn, String username);
	
	public boolean eliminar(Connection conn, String username);
	
}
