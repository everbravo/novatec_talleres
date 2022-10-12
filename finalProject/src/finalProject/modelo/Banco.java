/**
 * La clase <b>Banco</b> es una representacion directa de la tabla almacenada en base de datos
 * @author ever.bravo
 * 
 */
package finalProject.modelo;

public class Banco {

	/*...*/
	private String nit;
	
	private String nombre;
	
	private Usuario usuario;

	/**
	 * Constructor vacio nos permite crear instancias de esta clase
	 * @param null
	 */
	public Banco() {
		
	}
	
	/**
	 * Constructor con argumentos nos permite crear objetos y cargar los datos requeridos de la clase en cuestion
	 * @param nit
	 * el nit del banco
	 * @param nombre
	 * el nombre del banco
	 * @param usuario
	 * el objeto de tipo usuario
	 */
	public Banco(String nit, String nombre, Usuario usuario) {
		super();
		this.nit = nit;
		this.nombre = nombre;
		this.usuario = usuario;
	}

	/**
	 * @return el codigo de identificación de la empresa
	 */
	public String getNit() {
		return nit;
	}

	/**
	 * @param nit
	 * una cadena de caracteres con el codigo de identificación de una empresa
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}

	/**
	 * @return una cadena de caracteres con el nombre del banco
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 * una cadena de caracteres con el nombre de la empresa
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return un objeto del tipo usuario
	 */
	public Usuario getNombre_usuario() {
		return usuario;
	}

	/**
	 * @param nombre_usuario
	 * un objeto del tipo usuario
	 */
	public void setNombre_usuario(Usuario nombre_usuario) {
		this.usuario = nombre_usuario;
	}

	@Override
	public String toString() {
		return "Banco [nit=" + nit + ", nombre=" + nombre + ", usuario=" + usuario + "]";
	}
	
	
}
