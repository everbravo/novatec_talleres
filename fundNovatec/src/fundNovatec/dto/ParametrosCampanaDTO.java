package fundNovatec.dto;

public class ParametrosCampanaDTO {

	public ParametrosCampanaDTO() {
	}

	private Integer cantDonadores;
    
    private Integer cantDonacionesPermit;
    
    private Double cantMaxDonador;
    
    private String campanaId;
    
    private Double cantMin;
    
    private float porcentaje;
    
    public ParametrosCampanaDTO(String campanaId) {
        this.campanaId = campanaId;
    }

    public ParametrosCampanaDTO(Integer cantDonadores, Integer cantDonacionesPermit, Double cantMaxDonador,
			Double cantMin, float porcentaje) {
		super();
		this.cantDonadores = cantDonadores;
		this.cantDonacionesPermit = cantDonacionesPermit;
		this.cantMaxDonador = cantMaxDonador;
		this.cantMin = cantMin;
		this.porcentaje = porcentaje;
	}

	public Integer getCantDonadores() {
		return cantDonadores;
	}

	public void setCantDonadores(Integer cantDonadores) {
		this.cantDonadores = cantDonadores;
	}

	public Integer getCantDonacionesPermit() {
		return cantDonacionesPermit;
	}

	public void setCantDonacionesPermit(Integer cantDonacionesPermit) {
		this.cantDonacionesPermit = cantDonacionesPermit;
	}

	public Double getCantMaxDonador() {
		return cantMaxDonador;
	}

	public void setCantMaxDonador(Double cantMaxDonador) {
		this.cantMaxDonador = cantMaxDonador;
	}

	public String getCampanaId() {
		return campanaId;
	}

	public void setCampanaId(String campanaId) {
		this.campanaId = campanaId;
	}

	public Double getCantMin() {
		return cantMin;
	}

	public void setCantMin(Double cantMin) {
		this.cantMin = cantMin;
	}

	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}

    
}
