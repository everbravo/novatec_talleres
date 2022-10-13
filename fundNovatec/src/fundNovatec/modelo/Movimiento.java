package fundNovatec.modelo;

public class Movimiento {

	public Movimiento() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer idMovimiento;
    
    private double valor;
    
    private Campana campanaId;
  
    private Deposito depositoCod;
    
    private Estado estadoId;


    public Movimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Movimiento(Integer idMovimiento, double valor) {
        this.idMovimiento = idMovimiento;
        this.valor = valor;
    }

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Campana getCampanaId() {
        return campanaId;
    }

    public void setCampanaId(Campana campanaId) {
        this.campanaId = campanaId;
    }

    public Deposito getDepositoCod() {
        return depositoCod;
    }

    public void setDepositoCod(Deposito depositoCod) {
        this.depositoCod = depositoCod;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

}
