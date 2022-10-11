package finalProject.modelo;

import java.sql.Date;

public class Transaccion {
	
	private Integer transaccion;
	
	private Date fecha_transaccion;
	
	private char estado_transaccion;
	
	private String desc_transaccion;
	
	private Cuenta numero_cuenta;
	
	private Double monto;

	public Transaccion(char estado_transaccion, String desc_transaccion,
			Cuenta numero_cuenta, Double monto) {
		super();
		this.estado_transaccion = estado_transaccion;
		this.desc_transaccion = desc_transaccion;
		this.numero_cuenta = numero_cuenta;
		this.monto=monto;
	}

	public Transaccion() {
		super();
	}
	
	
	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public void setTransaccion(Integer transaccion) {
		this.transaccion = transaccion;
	}

	public Integer getTransaccion() {
		return transaccion;
	}

	public Date getFecha_transaccion() {
		return fecha_transaccion;
	}

	public void setFecha_transaccion(Date fecha_transaccion) {
		this.fecha_transaccion = fecha_transaccion;
	}

	public char getEstado_transaccion() {
		return estado_transaccion;
	}

	public void setEstado_transaccion(char estado_transaccion) {
		this.estado_transaccion = estado_transaccion;
	}

	public String getDesc_transaccion() {
		return desc_transaccion;
	}

	public void setDesc_transaccion(String desc_transaccion) {
		this.desc_transaccion = desc_transaccion;
	}

	public Cuenta getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(Cuenta numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}

	@Override
	public String toString() {
		return "Transaccion=" + transaccion + ", fecha_transaccion=" + fecha_transaccion
				+ ", estado_transaccion=" + estado_transaccion + ", desc_transaccion=" + desc_transaccion
				+ ", numero_cuenta=" + numero_cuenta + ", monto=" + monto ;
	}
	
	
	
}
