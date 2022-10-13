package fundNovatec.repositorio;

import fundNovatec.dto.ParametrosCampanaDTO;

public interface ParametroCampanaRepo {
	
	public boolean agregar(ParametrosCampanaDTO param);
	
	public boolean actualizar(String campana, ParametrosCampanaDTO param);
	
	public ParametrosCampanaDTO obtenerPorCampana(String campana);
	
}
