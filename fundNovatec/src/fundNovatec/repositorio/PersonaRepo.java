package fundNovatec.repositorio;

import fundNovatec.dto.PersonaDTO;

public interface PersonaRepo {

	public boolean agregar(PersonaDTO persona);
	
	public boolean inactivar(String identificacion);
	
	public boolean actulizar(String identificacion, PersonaDTO persona);
	
	public boolean obtenerPorIdentificacion(String identificacion);

	
}
