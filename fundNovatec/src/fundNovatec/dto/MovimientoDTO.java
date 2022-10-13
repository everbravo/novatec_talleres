package fundNovatec.dto;

public class MovimientoDTO {

	public MovimientoDTO() {
		// TODO Auto-generated constructor stub
	}

	private Integer idMovimiento;
    
    private Double valor;
    
    private String campanaId;
    
    private String deposito_cod;

	public MovimientoDTO(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public MovimientoDTO(Double valor, String campanaId, String deposito_cod) {
		super();
		this.valor = valor;
		this.campanaId = campanaId;
		this.deposito_cod = deposito_cod;
	}

	public Integer getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCampanaId() {
		return campanaId;
	}

	public void setCampanaId(String campanaId) {
		this.campanaId = campanaId;
	}

	public String getDeposito_cod() {
		return deposito_cod;
	}

	public void setDeposito_cod(String deposito_cod) {
		this.deposito_cod = deposito_cod;
	}
    
    
    
}
