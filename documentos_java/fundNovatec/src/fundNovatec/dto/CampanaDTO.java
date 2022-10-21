package fundNovatec.dto;

public class CampanaDTO {

	public CampanaDTO() {
	}

	private String idCampana;

	private String nombreCampana;

	private String objetivoCampana;
	
	private String fundacion_nit;
	
	private Integer estado_id;

	public CampanaDTO(String idCampana) {
		this.idCampana = idCampana;
	}

	public CampanaDTO(String nombreCampana, String objetivoCampana, String fundacion_nit, Integer estado_id) {
		this.nombreCampana = nombreCampana;
		this.objetivoCampana = objetivoCampana;
		this.fundacion_nit = fundacion_nit;
		this.estado_id = estado_id;
	}

	public String getIdCampana() {
		return idCampana;
	}

	public void setIdCampana(String idCampana) {
		this.idCampana = idCampana;
	}

	public String getNombreCampana() {
		return nombreCampana;
	}

	public void setNombreCampana(String nombreCampana) {
		this.nombreCampana = nombreCampana;
	}

	public String getObjetivoCampana() {
		return objetivoCampana;
	}

	public void setObjetivoCampana(String objetivoCampana) {
		this.objetivoCampana = objetivoCampana;
	}

	public String getFundacion_nit() {
		return fundacion_nit;
	}

	public void setFundacion_nit(String fundacion_nit) {
		this.fundacion_nit = fundacion_nit;
	}

	public Integer getEstado_id() {
		return estado_id;
	}

	public void setEstado_id(Integer estado_id) {
		this.estado_id = estado_id;
	}
	
}
