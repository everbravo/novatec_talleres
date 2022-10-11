package finalProject.modelo;

public class Banco {

	private String nit;
	
	private String nombre;
	
	private Usuario usuario;

	public Banco() {
		
	}
	
	public Banco(String nit, String nombre, Usuario usuario) {
		super();
		this.nit = nit;
		this.nombre = nombre;
		this.usuario = usuario;
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

	public Usuario getNombre_usuario() {
		return usuario;
	}

	public void setNombre_usuario(Usuario nombre_usuario) {
		this.usuario = nombre_usuario;
	}

	@Override
	public String toString() {
		return "Banco [nit=" + nit + ", nombre=" + nombre + ", usuario=" + usuario + "]";
	}
	
	
}
