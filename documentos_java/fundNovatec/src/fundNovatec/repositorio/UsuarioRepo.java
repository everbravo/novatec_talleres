package fundNovatec.repositorio;

import fundNovatec.dto.UsuarioDTO;

public interface UsuarioRepo {

	public boolean agregar(UsuarioDTO info);
	
	public boolean actualizar(String id, UsuarioDTO info);
	
	public UsuarioDTO obtenerPorIdentificacion(String id);
	
}
