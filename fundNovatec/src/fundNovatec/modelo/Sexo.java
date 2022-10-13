package fundNovatec.modelo;

import java.util.List;

public class Sexo {

	public Sexo() {
		// TODO Auto-generated constructor stub
	}

	private Integer idsexo;
	   
    private String descripcion;
   
    private List<Persona> personaList;

    public Sexo(Integer idsexo) {
        this.idsexo = idsexo;
    }

    public Sexo(Integer idsexo, String descripcion) {
        this.idsexo = idsexo;
        this.descripcion = descripcion;
    }

    public Integer getIdsexo() {
        return idsexo;
    }

    public void setIdsexo(Integer idsexo) {
        this.idsexo = idsexo;
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
