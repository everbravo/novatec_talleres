package fundNovatec.modelo;

public class ParametrosCampana {

	public ParametrosCampana() {
		// TODO Auto-generated constructor stub
	}
	
private int cantDonadores;
    
    private int cantDonacionesPermit;
    
    private double cantMaxDonador;
    
    private String campanaId;
    
    private Campana campana;

    public ParametrosCampana(String campanaId) {
        this.campanaId = campanaId;
    }

    public ParametrosCampana(String campanaId, int cantDonadores, int cantDonacionesPermit, double cantMaxDonador) {
        this.campanaId = campanaId;
        this.cantDonadores = cantDonadores;
        this.cantDonacionesPermit = cantDonacionesPermit;
        this.cantMaxDonador = cantMaxDonador;
    }

    public int getCantDonadores() {
        return cantDonadores;
    }

    public void setCantDonadores(int cantDonadores) {
        this.cantDonadores = cantDonadores;
    }

    public int getCantDonacionesPermit() {
        return cantDonacionesPermit;
    }

    public void setCantDonacionesPermit(int cantDonacionesPermit) {
        this.cantDonacionesPermit = cantDonacionesPermit;
    }

    public double getCantMaxDonador() {
        return cantMaxDonador;
    }

    public void setCantMaxDonador(double cantMaxDonador) {
        this.cantMaxDonador = cantMaxDonador;
    }

    public String getCampanaId() {
        return campanaId;
    }

    public void setCampanaId(String campanaId) {
        this.campanaId = campanaId;
    }

    public Campana getCampana() {
        return campana;
    }

    public void setCampana(Campana campana) {
        this.campana = campana;
    }

}
