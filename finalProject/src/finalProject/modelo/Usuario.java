package finalProject.modelo;

import java.sql.Date;

public class Usuario {
	
	private String nombre_usuario;
	
	private String correo;
	
	private String contraseña;
	
	private Date hora_creacion;
	
	// S -> admin, U -> user
	private char rol;

	public Usuario() {
		super();
	}

	public Usuario(String nombre_usuario, String correo, String contraseña,char rol) {
		super();
		this.nombre_usuario = nombre_usuario;
		this.correo = correo;
		this.contraseña = contraseña;
		this.rol = rol;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getCorreo() {
		return correo;
	}
	
	public void setHora_creacion(Date hora_creacion) {
		this.hora_creacion = hora_creacion;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Date getHora_creacion() {
		return hora_creacion;
	}

	public char getRol() {
		return rol;
	}

	public void setRol(char rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [nombre_usuario=" + nombre_usuario + ", correo=" + correo + ", contraseña=" + contraseña
				+ ", hora_creacion=" + hora_creacion + ", rol=" + rol + "]";
	}
	
	
}
