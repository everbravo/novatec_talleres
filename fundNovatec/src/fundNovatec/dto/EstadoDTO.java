package fundNovatec.dto;

public class EstadoDTO {

	public EstadoDTO() {
		
	}
	
	private Integer idEstado;
    
    private String descripcion;
    
    private Character categoria;
    
    public EstadoDTO(Integer idEstado) {
		this.idEstado = idEstado;
	}

    public EstadoDTO(Integer idEstado, String descripcion) {
    	this.descripcion = descripcion;
    }

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Character getCategoria() {
		return categoria;
	}

	public void setCategoria(Character categoria) {
		this.categoria = categoria;
	}
    
    

}
