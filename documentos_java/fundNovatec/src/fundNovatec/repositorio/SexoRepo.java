package fundNovatec.repositorio;

import java.util.List;

import fundNovatec.dto.SexoDTO;

public interface SexoRepo {
	
	public boolean agregar(SexoDTO sexo);
	
	public boolean actulizar(int id, SexoDTO sexo);
	
	public boolean eliminar(int id);
	
	public List<SexoDTO> listarTodo();
	
	public SexoDTO buscarPorId(int id);
	
}
