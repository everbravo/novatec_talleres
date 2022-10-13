package fundNovatec.modelo;

import java.util.List;

public class Campana {

	public Campana() {
		// TODO Auto-generated constructor stub
	}

	private String idCampana;

	private String nombreCampana;

	private String objetivoCampana;

	private List<Moneda> monedaList;

	private List<Persona> personaList;

	private Estado estadoId;

	private Fundacion fundacionNit;

	private Cronograma cronograma;

	private List<Movimiento> movimientoList;

	private ParametrosCampana parametrosCampana;

	public Campana(String idCampana) {
		this.idCampana = idCampana;
	}

	public Campana(String idCampana, String nombreCampana) {
		this.idCampana = idCampana;
		this.nombreCampana = nombreCampana;
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

	public List<Moneda> getMonedaList() {
		return monedaList;
	}

	public void setMonedaList(List<Moneda> monedaList) {
		this.monedaList = monedaList;
	}

	public List<Persona> getPersonaList() {
		return personaList;
	}

	public void setPersonaList(List<Persona> personaList) {
		this.personaList = personaList;
	}

	public Estado getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Estado estadoId) {
		this.estadoId = estadoId;
	}

	public Fundacion getFundacionNit() {
		return fundacionNit;
	}

	public void setFundacionNit(Fundacion fundacionNit) {
		this.fundacionNit = fundacionNit;
	}

	public Cronograma getCronograma() {
		return cronograma;
	}

	public void setCronograma(Cronograma cronograma) {
		this.cronograma = cronograma;
	}

	public List<Movimiento> getMovimientoList() {
		return movimientoList;
	}

	public void setMovimientoList(List<Movimiento> movimientoList) {
		this.movimientoList = movimientoList;
	}

	public ParametrosCampana getParametrosCampana() {
		return parametrosCampana;
	}

	public void setParametrosCampana(ParametrosCampana parametrosCampana) {
		this.parametrosCampana = parametrosCampana;
	}

}
