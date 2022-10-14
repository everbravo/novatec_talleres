package fundNovatec.repositorio;

import java.util.List;

import fundNovatec.dto.CampanaDTO;

public interface CampanaRepo {

	public boolean agregar(CampanaDTO campana);
	
	public boolean eliminar(String id, int idEstado);
	
	public boolean actualizar(String id, CampanaDTO campana);
	
	public CampanaDTO buscarPorId(String id);
	
	public List<CampanaDTO> listarTodo();
	
	public List<CampanaDTO> listarPorEstado(int estado);
	
}
