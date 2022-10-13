package fundNovatec.dto;

public class ParametrosCampanaDTO {

	public ParametrosCampanaDTO() {
	}

	private Integer cantDonadores;
    
    private Integer cantDonacionesPermit;
    
    private Double cantMaxDonador;
    
    private String campanaId;
    
    public ParametrosCampanaDTO(String campanaId) {
        this.campanaId = campanaId;
    }

    public ParametrosCampanaDTO(String campanaId, int cantDonadores, int cantDonacionesPermit, double cantMaxDonador) {
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
    
    
	
}
