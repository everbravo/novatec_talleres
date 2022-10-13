package fundNovatec.dto;

public class RolUsuarioDTO {

	public RolUsuarioDTO() {}
	
	private Integer idRol;
    
    private String descripcion;
    
    public RolUsuarioDTO(Integer idRol) {
        this.idRol = idRol;
    }

    public RolUsuarioDTO(Integer idRol, String descripcion) {
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

}
