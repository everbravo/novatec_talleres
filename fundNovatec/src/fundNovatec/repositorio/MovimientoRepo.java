package fundNovatec.repositorio;

import java.util.List;

import fundNovatec.dto.MovimientoDTO;

public interface MovimientoRepo {

	public boolean agregar(MovimientoDTO movi);
	
	public boolean cambiarEstado(int id, MovimientoDTO movi);
	
	public List<MovimientoDTO> listarPorDeposito();
	
	public List<MovimientoDTO> listarPorCampaña();
	
	public List<MovimientoDTO> listarPorEstado();
	
	public List<MovimientoDTO> listarTodo();
	
}
