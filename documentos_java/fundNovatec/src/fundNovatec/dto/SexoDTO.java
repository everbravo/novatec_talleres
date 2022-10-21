package fundNovatec.dto;

public class SexoDTO {

	public SexoDTO() {
		
	}
	
	private Integer idsexo;
	   
    private String descripcion;
    
    public SexoDTO(Integer idsexo) {
        this.idsexo = idsexo;
    }

    public SexoDTO(Integer idsexo, String descripcion) {
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
        return descripcion.toUpperCase();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toUpperCase();
    }

}
