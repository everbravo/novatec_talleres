package fundNovatec.dto;

public class MonedaDTO {

	public MonedaDTO() {
		
	}
	
	private String codigoIso;
    
    private double tasaConversionCop;
    
    private String descripcion;
    
    public MonedaDTO(String codigoIso) {
        this.codigoIso = codigoIso;
    }

    public MonedaDTO(String codigoIso, double tasaConversionCop, String descripcion) {
        this.codigoIso = codigoIso;
        this.tasaConversionCop = tasaConversionCop;
        this.descripcion = descripcion;
    }

    public String getCodigoIso() {
        return codigoIso.toUpperCase();
    }

    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso.toUpperCase();
    }

    public double getTasaConversionCop() {
        return tasaConversionCop;
    }

    public void setTasaConversionCop(double tasaConversionCop) {
        this.tasaConversionCop = tasaConversionCop;
    }

    public String getDescripcion() {
        return descripcion.toUpperCase();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toUpperCase();
    }
    

}
