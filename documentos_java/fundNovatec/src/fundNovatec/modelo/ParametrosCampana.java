package fundNovatec.modelo;

public class ParametrosCampana {

	public ParametrosCampana() {
		// TODO Auto-generated constructor stub
	}
	
	private int cantDonadores;
    
    private int cantDonacionesPermit;
    
    private double cantMaxDonador;
    
    private float porcentaje;
    
    private Double cantMin;
    
    private String campanaId;
    
    private Campana campana;

    public ParametrosCampana(String campanaId) {
        this.campanaId = campanaId;
    }

    public ParametrosCampana(String campanaId, int cantDonadores, int cantDonacionesPermit, double cantMaxDonador, float porcentaje, Double cantMin) {
        this.campanaId = campanaId;
        this.cantDonadores = cantDonadores;
        this.cantDonacionesPermit = cantDonacionesPermit;
        this.cantMaxDonador = cantMaxDonador;
        this.cantMin = cantMin;
        this.porcentaje = porcentaje;
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

	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Double getCantMin() {
		return cantMin;
	}

	public void setCantMin(Double cantMin) {
		this.cantMin = cantMin;
	}
    
    

}
