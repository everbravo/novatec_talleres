package fundNovatec.repositorio;

import fundNovatec.dto.PersonaDTO;

public interface PersonaRepo {

	public boolean agregar(PersonaDTO persona);
	
	public boolean inactivar(String identificacion, int idEst);
	
	public boolean activar(String identificacion, int idEst);
	
	public boolean actulizar(String identificacion, PersonaDTO persona);
	
	public PersonaDTO obtenerPorIdentificacion(String identificacion);

	
}
