package fundNovatec.repositorio;

import java.util.List;

import fundNovatec.dto.DepositoDTO;

public interface DepositoRepo {

	public boolean agregar(DepositoDTO dep);
	
	public boolean eliminar(String dep);
	
	public boolean actualizar(String dep, DepositoDTO d);
	
	public DepositoDTO buscarPorId(String dep);
	
	public List<DepositoDTO> listarPorPersona(String id);
	
}
