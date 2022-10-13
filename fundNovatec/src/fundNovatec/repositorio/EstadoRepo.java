package fundNovatec.repositorio;

import java.util.List;

import fundNovatec.dto.EstadoDTO;

public interface EstadoRepo {

	public boolean agregar(EstadoDTO estado);
	
	public EstadoDTO buscarPorDescripcion(String desc);
	
	public EstadoDTO buscarPorId(Integer id);
	
	public List<EstadoDTO> listarTodo();
	
	public List<EstadoDTO> listarPorCateg(char caracter);
	
	public boolean eliminar(int id);
	
	public boolean actualizar(int id, EstadoDTO est);
	
	
	
}
