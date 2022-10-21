package fundNovatec.dto;

public class FundacionDTO {

	public FundacionDTO() {
	}
	
	private String nit;
    
    private String nombre;
    
    private String razonSocial;
    
    private String monedaIso;
    
    public FundacionDTO(String nit) {
        this.nit = nit;
    }

    public FundacionDTO(String nit, String nombre, String monedaIso) {
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

}
