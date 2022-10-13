package fundNovatec.modelo;

import java.util.List;

public class Moneda {

	public Moneda() {
		// TODO Auto-generated constructor stub
	}
	
	private String codigoIso;
    
    private double tasaConversionCop;
    
    private String descripcion;
    
    private List<Campana> campanaList;
    
    private List<Deposito> depositoList;

    public Moneda(String codigoIso) {
        this.codigoIso = codigoIso;
    }

    public Moneda(String codigoIso, double tasaConversionCop, String descripcion) {
        this.codigoIso = codigoIso;
        this.tasaConversionCop = tasaConversionCop;
        this.descripcion = descripcion;
    }

    public String getCodigoIso() {
        return codigoIso;
    }

    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso;
    }

    public double getTasaConversionCop() {
        return tasaConversionCop;
    }

    public void setTasaConversionCop(double tasaConversionCop) {
        this.tasaConversionCop = tasaConversionCop;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Campana> getCampanaList() {
        return campanaList;
    }

    public void setCampanaList(List<Campana> campanaList) {
        this.campanaList = campanaList;
    }

    public List<Deposito> getDepositoList() {
        return depositoList;
    }

    public void setDepositoList(List<Deposito> depositoList) {
        this.depositoList = depositoList;
    }

}
