package fundNovatec.modelo;

import java.sql.Date;

public class Cronograma {

	public Cronograma() {
		// TODO Auto-generated constructor stub
	}
	
	private Date fechaCodificacion;
    
    private Date fechaFin;
    
    private Date fechaInicio;
   
    private String campanaId;
    
    private Campana campana;

    public Cronograma(String campanaId) {
        this.campanaId = campanaId;
    }

    public Cronograma(String campanaId, Date fechaFin, Date fechaInicio) {
        this.campanaId = campanaId;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaCodificacion() {
        return fechaCodificacion;
    }

    public void setFechaCodificacion(Date fechaCodificacion) {
        this.fechaCodificacion = fechaCodificacion;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
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
