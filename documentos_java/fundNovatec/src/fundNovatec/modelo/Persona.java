package fundNovatec.modelo;

import java.sql.Date;
import java.util.List;

public class Persona {

	public Persona() {

	}

	private String identificacion;

	private String nombre;

	private String apellidos;

	private Date nacimiento;

	private List<Campana> campanaList;

	private Fundacion fnNit;

	private RolUsuario rolUsuario;

	private Sexo sexoId;
	
	private Estado estadoId;

	private List<Deposito> depositoList;

	private Usuario usuario;

	public Persona(String identificacion) {
		this.identificacion = identificacion;
	}

	public Persona(String identificacion, String nombre, String apellidos, Date nacimiento) {
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nacimiento = nacimiento;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public List<Campana> getCampanaList() {
		return campanaList;
	}

	public void setCampanaList(List<Campana> campanaList) {
		this.campanaList = campanaList;
	}

	public Fundacion getFnNit() {
		return fnNit;
	}

	public void setFnNit(Fundacion fnNit) {
		this.fnNit = fnNit;
	}

	public RolUsuario getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(RolUsuario rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public Sexo getSexoId() {
		return sexoId;
	}

	public void setSexoId(Sexo sexoId) {
		this.sexoId = sexoId;
	}

	public List<Deposito> getDepositoList() {
		return depositoList;
	}

	public void setDepositoList(List<Deposito> depositoList) {
		this.depositoList = depositoList;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Estado getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Estado estadoId) {
		this.estadoId = estadoId;
	}
	
	

}
