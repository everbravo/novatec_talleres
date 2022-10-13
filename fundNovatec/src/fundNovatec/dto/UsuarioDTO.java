package fundNovatec.dto;

public class UsuarioDTO {

	public UsuarioDTO() {
	}
	
	private int nameuser;

	private String password;

	private String personaId;
	
	public UsuarioDTO(String personaId) {
		this.personaId = personaId;
	}

	public UsuarioDTO(String personaId, int nameuser, String password) {
		this.personaId = personaId;
		this.nameuser = nameuser;
		this.password = password;
	}

	public int getNameuser() {
		return nameuser;
	}

	public void setNameuser(int nameuser) {
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

}
