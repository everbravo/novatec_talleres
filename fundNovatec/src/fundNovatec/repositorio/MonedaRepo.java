package fundNovatec.repositorio;

import java.util.List;

import fundNovatec.dto.MonedaDTO;

public interface MonedaRepo {

	public boolean agregar(MonedaDTO moneda);
	
	public boolean eliminar(String cod);
	
	public boolean actualizar(String cod, MonedaDTO moned);
	
	public List<MonedaDTO> listarTodo();
	
	public MonedaDTO buscarPorId(String cod);
	
}
