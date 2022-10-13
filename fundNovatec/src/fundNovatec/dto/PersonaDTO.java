package fundNovatec.dto;

import java.sql.Date;

public class PersonaDTO {

	public PersonaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private String identificacion;

	private String nombre;

	private String apellidos;

	private Date nacimiento;
	
	private Integer sexo_id;
	
	private Integer rol_usuario;
	
	private Integer id_estado;
	
	private String fn_nit;

	public PersonaDTO(String identificacion) {
		this.identificacion = identificacion;
	}

	public PersonaDTO(String nombre, String apellidos, Date nacimiento, Integer sexo_id, Integer rol_usuario,
			String fn_nit) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nacimiento = nacimiento;
		this.sexo_id = sexo_id;
		this.rol_usuario = rol_usuario;
		this.fn_nit = fn_nit;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public Integer getSexo_id() {
		return sexo_id;
	}

	public void setSexo_id(Integer sexo_id) {
		this.sexo_id = sexo_id;
	}

	public Integer getRol_usuario() {
		return rol_usuario;
	}

	public void setRol_usuario(Integer rol_usuario) {
		this.rol_usuario = rol_usuario;
	}

	public String getFn_nit() {
		return fn_nit;
	}

	public void setFn_nit(String fn_nit) {
		this.fn_nit = fn_nit;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}
	
	

}
