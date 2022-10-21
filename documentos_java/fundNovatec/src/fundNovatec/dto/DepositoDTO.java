package fundNovatec.dto;


public class DepositoDTO {

	public DepositoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private String codigoDeposito;
    
    private double saldo;
    
    private Integer estadoId;
    
    private String monedaCod;
   
    private String personaId;

	public DepositoDTO(String codigoDeposito, double saldo, Integer estadoId, String monedaCod, String personaId) {
		super();
		this.codigoDeposito = codigoDeposito;
		this.saldo = saldo;
		this.estadoId = estadoId;
		this.monedaCod = monedaCod;
		this.personaId = personaId;
	}

	public String getCodigoDeposito() {
		return codigoDeposito;
	}

	public void setCodigoDeposito(String codigoDeposito) {
		this.codigoDeposito = codigoDeposito;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

	public String getMonedaCod() {
		return monedaCod;
	}

	public void setMonedaCod(String monedaCod) {
		this.monedaCod = monedaCod;
	}

	public String getPersonaId() {
		return personaId;
	}

	public void setPersonaId(String personaId) {
		this.personaId = personaId;
	}

    
    
}
