package fundNovatec.repositorio;

import java.util.List;

import fundNovatec.dto.PersonaDTO;
import fundNovatec.reporte.PersonaDonadorPtllDTO;

public interface PersonaRepo {

	public boolean agregar(PersonaDTO persona);
	
	public boolean inactivar(String identificacion, int idEst);
	
	public boolean activar(String identificacion, int idEst);
	
	public boolean actulizar(String identificacion, PersonaDTO persona);
	
	public PersonaDTO obtenerPorIdentificacion(String identificacion);
	
	public List<PersonaDonadorPtllDTO> generarReporteDonacion(String fecha);

	
}
