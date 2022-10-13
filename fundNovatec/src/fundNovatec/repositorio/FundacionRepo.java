package fundNovatec.repositorio;

import java.util.List;

import fundNovatec.dto.FundacionDTO;

public interface FundacionRepo {

	public boolean agregar(FundacionDTO fundacion);
	
	public boolean eliminar(String nit);
	
	public boolean actualizar(String nit, FundacionDTO fundacion);
	
	public List<FundacionDTO> listarTodo();
	
	public FundacionDTO buscarPorNit(String nit);
	
}
