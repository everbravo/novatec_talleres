package finalProject.modelo;

public class Cuenta {

	private String numero_cuenta;
	
	private Double saldo;
	
	private char estado_cuenta;
	
	private Cliente cedula;

	public Cuenta() {
		super();
	}

	public Cuenta(String numero_cuenta, Double saldo, char estado_cuenta, Cliente cedula) {
		super();
		this.numero_cuenta = numero_cuenta;
		this.saldo = saldo;
		this.estado_cuenta = estado_cuenta;
		this.cedula = cedula;
	}

	public String getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(String numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public char getEstado_cuenta() {
		return estado_cuenta;
	}

	public void setEstado_cuenta(char estado_cuenta) {
		this.estado_cuenta = estado_cuenta;
	}

	public Cliente getCedula() {
		return cedula;
	}

	public void setCedula(Cliente cedula) {
		this.cedula = cedula;
	}

	@Override
	public String toString() {
		return numero_cuenta ;
	}
	
	
	
	
}
