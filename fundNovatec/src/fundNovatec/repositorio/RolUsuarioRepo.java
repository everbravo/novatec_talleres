package fundNovatec.repositorio;

import java.util.List;

import fundNovatec.dto.RolUsuarioDTO;

public interface RolUsuarioRepo {
	
	public boolean agregar(RolUsuarioDTO rol);
	
	public boolean eliminar(int id);
	
	public boolean actualizar(int id, RolUsuarioDTO rol);
	
	public List<RolUsuarioDTO> listarTodo();
	
	public RolUsuarioDTO buscarPorId(int id);
	
}
