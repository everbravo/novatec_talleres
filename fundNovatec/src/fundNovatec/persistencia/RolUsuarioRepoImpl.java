package fundNovatec.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fundNovatec.conexion.Conexion;
import fundNovatec.dto.RolUsuarioDTO;
import fundNovatec.repositorio.RolUsuarioRepo;

public class RolUsuarioRepoImpl implements RolUsuarioRepo{
	
	private final static Connection CONN = Conexion.getConexion();
	private static PreparedStatement psmt;

	public RolUsuarioRepoImpl() {
		
	}

	@Override
	public boolean agregar(RolUsuarioDTO rol) {
		
		final String INSERT = "insert into rol_usuario (descripcion) values (?)";
		
		try {
			
			psmt = CONN.prepareStatement(INSERT);
			psmt.setString(1, rol.getDescripcion());
			
			int rowsAfected = psmt.executeUpdate();
			
			if (rowsAfected > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("RolUsuario:agregar:Error -> "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean eliminar(int id) {

		RolUsuarioDTO rolUsuario = buscarPorId(id);
		final String DELETE = "delete from rol_usuario where id_rol = ?";
		
		if(rolUsuario != null) {
			
			try {
				
				psmt = CONN.prepareStatement(DELETE);
				psmt.setInt(1, rolUsuario.getIdRol());
				
				int affectedRows = psmt.executeUpdate();
				if(affectedRows > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Sexo:eliminar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public boolean actualizar(int id, RolUsuarioDTO rol) {

		RolUsuarioDTO rolUsuario = buscarPorId(id);
		final String UPDATE = "update rol_usuario set descripcion = ? where id_rol = ?";
		
		if(rolUsuario != null) {
			
			try {
				
				psmt = CONN.prepareStatement(UPDATE);
				psmt.setString(1, rol.getDescripcion());
				psmt.setInt(2, rolUsuario.getIdRol());
				
				int rowsAffected = psmt.executeUpdate();
				if(rowsAffected > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("RolUsuario:actualizar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public List<RolUsuarioDTO> listarTodo() {
		final String SELECT = "select * from rol_usuario";
		List<RolUsuarioDTO> rolUsuario = new ArrayList<>();
		
		try {
			
			Statement stm = CONN.createStatement();
			ResultSet rs = stm.executeQuery(SELECT);
			
			while(rs.next()) {
				
				RolUsuarioDTO uRol = new RolUsuarioDTO();
				uRol.setIdRol(rs.getInt("idsexo"));
				uRol.setDescripcion(rs.getString("descripcion"));
				
				rolUsuario.add(uRol);
				
			}
			
			return rolUsuario;
			
		} catch (SQLException e) {
			System.out.println("RolUsuario:seleccionarTodo:Error -> "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public RolUsuarioDTO buscarPorId(int id) {
		
		final String FIND = "select * from rol_usuario where id_rol = ?";
		
		try {
			
			psmt = CONN.prepareStatement(FIND);
			psmt.setInt(1, id);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				
				RolUsuarioDTO rolUsuario = new RolUsuarioDTO();
				rolUsuario.setIdRol(rs.getInt("id_rol"));
				rolUsuario.setDescripcion(rs.getString("descripcion"));
				
				return rolUsuario;
			}
			
		} catch (SQLException e) {
			System.out.println("RolUsuario:buscarId:Error -> "+e.getMessage());
		}
		
		return null;
	}
	
	
	public int rolUsuarioReg() {
		
		String comodin = "%DONANTE%";
		final String FIND = "select id_rol from rol_usuario where descripcion like ?";
		
		try {
			
			psmt = CONN.prepareStatement(FIND);
			psmt.setString(1, comodin);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				return rs.getInt("id_rol");
			}
			
		} catch (SQLException e) {
			System.out.println("RolUsuario:obtenerCodigoDonante:Error -> "+e.getMessage());
		}
		
		return -1;
	}
	

}
