package fundNovatec.dto;

import java.sql.Date;

public class MovimientoDTO {

	public MovimientoDTO() {
		// TODO Auto-generated constructor stub
	}

	private int estado_id;
	
	private Integer idMovimiento;
    
    private Double valor;
    
    private String campanaId;
    
    private String deposito_cod;
    
    private Date fechaMov;

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

	public Date getFechaMov() {
		return fechaMov;
	}

	public int getEstado_id() {
		return estado_id;
	}

	public void setEstado_id(int estado_id) {
		this.estado_id = estado_id;
	}

	public void setFechaMov(Date fechaMov) {
		this.fechaMov = fechaMov;
	}
    
    
    
}
