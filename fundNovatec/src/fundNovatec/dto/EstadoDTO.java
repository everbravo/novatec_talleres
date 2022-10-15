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
		return descripcion.toUpperCase();
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion.toUpperCase();
	}

	public Character getCategoria() {
		return Character.toUpperCase(categoria);
	}

	public void setCategoria(Character categoria) {
		this.categoria = Character.toUpperCase(categoria);
	}
    
    

}
