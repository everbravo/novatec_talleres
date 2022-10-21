package fundNovatec.repositorio;

import fundNovatec.dto.CronogramaDTO;

public interface CronogramaRepo {
	
	public boolean agregar(CronogramaDTO crono);
	
	public boolean actualizar(String campana, CronogramaDTO crono);
	
	public CronogramaDTO obtenerPorCampana(String campana);
}
