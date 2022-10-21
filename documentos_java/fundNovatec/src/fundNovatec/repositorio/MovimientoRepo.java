package fundNovatec.repositorio;

import java.util.List;

import fundNovatec.dto.MovimientoDTO;

public interface MovimientoRepo {

	public boolean agregar(MovimientoDTO movi);
	
	public List<MovimientoDTO> listarPorDeposito(String deeposito);
	
	public List<MovimientoDTO> listarPorCampana(String campana);
	
	public List<MovimientoDTO> listarPorEstado(int estado);
	
	public List<MovimientoDTO> listarTodo();
	
	public MovimientoDTO obtenerPorId(int id);
	
}
