package fundNovatec.modelo;

import java.util.List;

public class Fundacion {

	public Fundacion() {
		// TODO Auto-generated constructor stub
	}
	
private String nit;
    
    private String nombre;
    
    private String razonSocial;
    
    private String monedaIso;
   
    private List<Campana> campanaList;
    
    private List<Persona> personaList;

    public Fundacion(String nit) {
        this.nit = nit;
    }

    public Fundacion(String nit, String nombre, String monedaIso) {
        this.nit = nit;
        this.nombre = nombre;
        this.monedaIso = monedaIso;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getMonedaIso() {
        return monedaIso;
    }

    public void setMonedaIso(String monedaIso) {
        this.monedaIso = monedaIso;
    }

    public List<Campana> getCampanaList() {
        return campanaList;
    }

    public void setCampanaList(List<Campana> campanaList) {
        this.campanaList = campanaList;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

}
