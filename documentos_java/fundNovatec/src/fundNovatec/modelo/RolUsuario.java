package fundNovatec.modelo;

import java.util.List;

public class RolUsuario {

	public RolUsuario() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer idRol;
    
    private String descripcion;
   
    private List<Persona> personaList;

    public RolUsuario(Integer idRol) {
        this.idRol = idRol;
    }

    public RolUsuario(Integer idRol, String descripcion) {
        this.idRol = idRol;
        this.descripcion = descripcion;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }
    

}
