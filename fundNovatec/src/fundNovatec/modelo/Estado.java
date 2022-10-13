package fundNovatec.modelo;

import java.util.List;

public class Estado {

	public Estado() {
		// TODO Auto-generated constructor stub
	}

	private Integer idEstado;
    
    private String descripcion;
    
    private Character categoria;
    
    private List<Campana> campanaList;
    
    private List<Movimiento> movimientoList;
    
    private List<Deposito> depositoList;
    
    private List<Persona> personaList;

    public Estado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Estado(Integer idEstado, String descripcion) {
        this.idEstado = idEstado;
        this.descripcion = descripcion;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getCategoria() {
        return categoria;
    }

    public void setCategoria(Character categoria) {
        this.categoria = categoria;
    }

    public List<Campana> getCampanaList() {
        return campanaList;
    }

    public void setCampanaList(List<Campana> campanaList) {
        this.campanaList = campanaList;
    }

    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }

    public List<Deposito> getDepositoList() {
        return depositoList;
    }

    public void setDepositoList(List<Deposito> depositoList) {
        this.depositoList = depositoList;
    }

	public List<Persona> getPersonaList() {
		return personaList;
	}

	public void setPersonaList(List<Persona> personaList) {
		this.personaList = personaList;
	}
    
    
	
}
