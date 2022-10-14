package fundNovatec.reporte;

import java.sql.Date;
import java.time.LocalDateTime;

public class PersonaDonadorPtllDTO {

	public PersonaDonadorPtllDTO() {
		
	}
	
	private String nombre;
	
	private String apellidos;
	
	private Date fecha_donacion;
	
	private Double valor;
	
	private String nombre_campana;
	
	private String codigo_campana;
	
	private LocalDateTime fecha_emision;

	public PersonaDonadorPtllDTO(String nombre, String apellidos, Date fecha_donacion, Double valor,
			String nombre_campana, String codigo_campana, LocalDateTime fecha_emision) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_donacion = fecha_donacion;
		this.valor = valor;
		this.nombre_campana = nombre_campana;
		this.codigo_campana = codigo_campana;
		this.fecha_emision = fecha_emision;
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

	public Date getFecha_donacion() {
		return fecha_donacion;
	}

	public void setFecha_donacion(Date fecha_donacion) {
		this.fecha_donacion = fecha_donacion;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getNombre_campana() {
		return nombre_campana;
	}

	public void setNombre_campana(String nombre_campana) {
		this.nombre_campana = nombre_campana;
	}

	public String getCodigo_campana() {
		return codigo_campana;
	}

	public void setCodigo_campana(String codigo_campana) {
		this.codigo_campana = codigo_campana;
	}

	public LocalDateTime getFecha_emision() {
		return fecha_emision;
	}

	public void setFecha_emision(LocalDateTime fecha_emision) {
		this.fecha_emision = fecha_emision;
	}
	
	

}
