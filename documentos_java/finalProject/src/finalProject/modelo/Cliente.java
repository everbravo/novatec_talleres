package finalProject.modelo;

import java.sql.Date;

public class Cliente {
	
	private String cedula;
	
	private String nombre;
	
	private String apellidos;
	
	private Date fecha_nacimiento;
	
	// M -> Masculino, F -> Femenino
	private char sexo;
	
	private Banco banco;
	
	private Usuario nombre_usuario;

	public Cliente() {
		super();
	}

	public Cliente(String cedula, String nombre, String apellidos, Date fecha_nacimiento, char sexo, Banco banco,
			Usuario nombre_usuario) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.sexo = sexo;
		this.banco = banco;
		this.nombre_usuario = nombre_usuario;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Usuario getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(Usuario nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	@Override
	public String toString() {
		return cedula;
	}	
	
	
}
