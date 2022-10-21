package fundNovatec.modelo;

public class Usuario {

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	private String nameuser;

	private String password;

	private String personaId;

	private Persona persona;

	public Usuario(String personaId) {
		this.personaId = personaId;
	}

	public Usuario(String personaId, String nameuser, String password) {
		this.personaId = personaId;
		this.nameuser = nameuser;
		this.password = password;
	}

	public String getNameuser() {
		return nameuser;
	}

	public void setNameuser(String nameuser) {
		this.nameuser = nameuser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPersonaId() {
		return personaId;
	}

	public void setPersonaId(String personaId) {
		this.personaId = personaId;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	

}
