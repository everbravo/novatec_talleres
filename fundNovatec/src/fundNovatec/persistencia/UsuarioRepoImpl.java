package fundNovatec.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fundNovatec.conexion.Conexion;
import fundNovatec.dto.UsuarioDTO;
import fundNovatec.repositorio.UsuarioRepo;

public class UsuarioRepoImpl implements UsuarioRepo{
	
	private final static Connection CONN = Conexion.getConexion();
	private static PreparedStatement psmt;

	public UsuarioRepoImpl() {
	}

	@Override
	public boolean agregar(UsuarioDTO info) {
		final String INSERT = "insert into usuario (nameuser, password) values (?, ?)";
		
		try {
			
			psmt = CONN.prepareStatement(INSERT);
			psmt.setString(1, info.getNameuser());
			psmt.setString(2, info.getPassword());
			
			int rowsAfected = psmt.executeUpdate();
			
			if (rowsAfected > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Usuario:agregar:Error -> "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean actualizar(String id, UsuarioDTO info) {
		UsuarioDTO usuario = obtenerPorIdentificacion(id);
		final String UPDATE = "update usuario set nameuser = ?, password = ? where persona_id = ?";
		
		if(usuario != null) {
			
			try {
				
				psmt = CONN.prepareStatement(UPDATE);
				psmt.setString(1, info.getNameuser());
				psmt.setString(2, info.getPassword());
				psmt.setString(3, usuario.getPersonaId());
				
				int rowsAffected = psmt.executeUpdate();
				if(rowsAffected > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Usuario:actualizar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public UsuarioDTO obtenerPorIdentificacion(String id) {
		final String FIND = "select * from usuario where persona_id = ?";
		
		try {
			
			psmt = CONN.prepareStatement(FIND);
			psmt.setString(1, id);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				
				UsuarioDTO usuario = new UsuarioDTO();
				usuario.setNameuser(rs.getString("nameuser"));
				usuario.setPassword(rs.getString("password"));
				usuario.setPersonaId(rs.getString("persona_id"));
				
				return usuario;
			}
			
		} catch (SQLException e) {
			System.out.println("Usuario:obtenerporId:Error -> "+e.getMessage());
		}
		
		return null;
	}
	
	

}
