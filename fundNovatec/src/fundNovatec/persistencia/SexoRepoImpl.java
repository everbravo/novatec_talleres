package fundNovatec.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fundNovatec.conexion.Conexion;
import fundNovatec.dto.SexoDTO;
import fundNovatec.repositorio.SexoRepo;

public class SexoRepoImpl implements SexoRepo{

	public SexoRepoImpl() {
		
	}
	
	private final static Connection CONN = Conexion.getConexion();
	private static PreparedStatement psmt;

	@Override
	public boolean agregar(SexoDTO sexo) {

		final String INSERT = "insert into sexo (descripcion) values (?)";
		
		try {
			
			psmt = CONN.prepareStatement(INSERT);
			psmt.setString(1, sexo.getDescripcion());
			
			int rowsAfected = psmt.executeUpdate();
			
			if (rowsAfected > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Sexo:agregar:Error -> "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean actulizar(int id, SexoDTO sexo) {

		SexoDTO oldSexo = buscarPorId(id);
		final String UPDATE = "update sexo set descripcion = ? where idsexo = ?";
		
		if(oldSexo != null) {
			
			try {
				
				psmt = CONN.prepareStatement(UPDATE);
				psmt.setString(1, sexo.getDescripcion());
				psmt.setInt(2, oldSexo.getIdsexo());
				
				int rowsAffected = psmt.executeUpdate();
				if(rowsAffected > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Sexo:actualizar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public boolean eliminar(int id) {

		SexoDTO sexo = buscarPorId(id);
		final String DELETE = "delete from sexo where idsexo = ?";
		
		if(sexo != null) {
			
			try {
				
				psmt = CONN.prepareStatement(DELETE);
				psmt.setInt(1, sexo.getIdsexo());
				
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
	public List<SexoDTO> listarTodo() {

		final String SELECT = "select * from sexo";
		List<SexoDTO> sexos = new ArrayList<>();
		
		try {
			
			Statement stm = CONN.createStatement();
			ResultSet rs = stm.executeQuery(SELECT);
			
			while(rs.next()) {
				
				SexoDTO sexo = new SexoDTO();
				sexo.setIdsexo(rs.getInt("idsexo"));
				sexo.setDescripcion(rs.getString("descripcion"));
				
				sexos.add(sexo);
				
			}
			
			return sexos;
			
		} catch (SQLException e) {
			System.out.println("Sexo:seleccionarTodo:Error -> "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public SexoDTO buscarPorId(int id) {
		
		final String FIND = "select * from sexo where idsexo = ?";
		
		try {
			
			psmt = CONN.prepareStatement(FIND);
			psmt.setInt(1, id);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				
				SexoDTO sexo = new SexoDTO();
				sexo.setIdsexo(rs.getInt("idsexo"));
				sexo.setDescripcion(rs.getString("descripcion"));
				
				return sexo;
			}
			
		} catch (SQLException e) {
			System.out.println("Sexo:buscarId:Error -> "+e.getMessage());
		}
		
		return null;
	}
	
	

}
