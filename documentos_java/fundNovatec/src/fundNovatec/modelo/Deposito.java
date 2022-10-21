package fundNovatec.modelo;

import java.util.List;

public class Deposito {

	public Deposito() {
		// TODO Auto-generated constructor stub
	}
	
	private String codigoDeposito;
    
    private double saldo;
    
    private List<Movimiento> movimientoList;
    
    private Estado estadoId;
    
    private Moneda monedaCod;
   
    private Persona personaId;

    public Deposito(String codigoDeposito) {
        this.codigoDeposito = codigoDeposito;
    }

    public Deposito(String codigoDeposito, double saldo) {
        this.codigoDeposito = codigoDeposito;
        this.saldo = saldo;
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

    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public Moneda getMonedaCod() {
        return monedaCod;
    }

    public void setMonedaCod(Moneda monedaCod) {
        this.monedaCod = monedaCod;
    }

    public Persona getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Persona personaId) {
        this.personaId = personaId;
    }

}
