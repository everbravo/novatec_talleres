package fundNovatec.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fundNovatec.conexion.Conexion;
import fundNovatec.dto.CampanaDTO;
import fundNovatec.repositorio.CampanaRepo;

public class CampanaRepoImpl implements CampanaRepo{
	
	private final static Connection CONN = Conexion.getConexion();
	private static PreparedStatement psmt;

	public CampanaRepoImpl() {
	}

	@Override
	public boolean agregar(CampanaDTO campana) {
		final String INSERT = "insert into campana (id_campana, nombre_campana, objetivo_campana, fundacion_nit, estado_id) values (?, ?, ?, ?, ?)";
		
		try {
			
			psmt = CONN.prepareStatement(INSERT);
			psmt.setString(1, campana.getIdCampana());
			psmt.setString(2, campana.getNombreCampana());
			psmt.setString(3, campana.getObjetivoCampana());
			psmt.setString(4, campana.getFundacion_nit());
			psmt.setInt(5, campana.getEstado_id());
			
			int rowsAfected = psmt.executeUpdate();
			
			if (rowsAfected > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Campana:agregar:Error -> "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean eliminar(String id, int idEstado) {
		CampanaDTO campana = buscarPorId(id);
		final String UPDATE = "update campana set estado_id = ? where id_campana = ?";
		
		if(campana != null) {
			
			try {
				
				psmt = CONN.prepareStatement(UPDATE);
				psmt.setInt(1, idEstado);
				psmt.setString(2, campana.getIdCampana());
				
				int rowsAffected = psmt.executeUpdate();
				if(rowsAffected > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Campana:elimianar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public boolean actualizar(String id, CampanaDTO campana) {
		CampanaDTO camp = buscarPorId(id);
		final String UPDATE = "update campana set nombre_campana = ?, objetivo_campana = ? where id_campana = ?";
		
		if(camp != null) {
			
			try {
				
				psmt = CONN.prepareStatement(UPDATE);
				psmt.setString(1, campana.getNombreCampana());
				psmt.setString(2, campana.getObjetivoCampana());
				psmt.setString(3, campana.getIdCampana());
				
				int rowsAffected = psmt.executeUpdate();
				if(rowsAffected > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Campana:actualizar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public List<CampanaDTO> listarTodo() {
		final String SELECT = "select * from campana";
		List<CampanaDTO> campana = new ArrayList<>();
		
		try {
			
			Statement stm = CONN.createStatement();
			ResultSet rs = stm.executeQuery(SELECT);
			
			while(rs.next()) {
				
				CampanaDTO camp = new CampanaDTO();
				camp.setEstado_id(rs.getInt("estado_id"));
				camp.setFundacion_nit(rs.getString("fundacion_nit"));
				camp.setIdCampana(rs.getString("id_campana"));
				camp.setNombreCampana(rs.getString("nombre_campana"));
				camp.setObjetivoCampana(rs.getString("objetivo_campana"));
				
				campana.add(camp);
				
			}
			
			return campana;
			
		} catch (SQLException e) {
			System.out.println("Campana:seleccionarTodo:Error -> "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<CampanaDTO> listarPorEstado(int estado) {
		final String SELECT = "select * from campana where estado_id = ?";
		List<CampanaDTO> campanas = new ArrayList<>();
		
		try {
			
			psmt = CONN.prepareStatement(SELECT);
			psmt.setInt(1, estado);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				CampanaDTO camp = new CampanaDTO();
				camp.setEstado_id(rs.getInt("estado_id"));
				camp.setFundacion_nit(rs.getString("fundacion_nit"));
				camp.setIdCampana(rs.getString("id_campana"));
				camp.setNombreCampana(rs.getString("nombre_campana"));
				camp.setObjetivoCampana(rs.getString("objetivo_campana"));
				
				campanas.add(camp);
				
			}
			
			return campanas;
			
		} catch (SQLException e) {
			System.out.println("Campana:listarEstados:Error -> "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public CampanaDTO buscarPorId(String id) {
		final String FIND = "select * from campana where id_campana = ?";
		
		try {
			
			psmt = CONN.prepareStatement(FIND);
			psmt.setString(1, id);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				
				CampanaDTO camp = new CampanaDTO();
				camp.setEstado_id(rs.getInt("estado_id"));
				camp.setFundacion_nit(rs.getString("fundacion_nit"));
				camp.setIdCampana(rs.getString("id_campana"));
				camp.setNombreCampana(rs.getString("nombre_campana"));
				camp.setObjetivoCampana(rs.getString("objetivo_campana"));
				
				return camp;
			}
			
		} catch (SQLException e) {
			System.out.println("Campana:buscarId:Error -> "+e.getMessage());
		}
		
		return null;
	}
	
	public List<CampanaDTO> listarTodoActivo() {
		final String SELECT = "select * from campana where estado_id = ?";
		List<CampanaDTO> campana = new ArrayList<>();
		int idAct = EstadoRepoImpl.getCodActivo();
		
		try {
			
			psmt = CONN.prepareStatement(SELECT);
			psmt.setInt(1, idAct);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				CampanaDTO camp = new CampanaDTO();
				camp.setEstado_id(rs.getInt("estado_id"));
				camp.setFundacion_nit(rs.getString("fundacion_nit"));
				camp.setIdCampana(rs.getString("id_campana"));
				camp.setNombreCampana(rs.getString("nombre_campana"));
				camp.setObjetivoCampana(rs.getString("objetivo_campana"));
				
				campana.add(camp);
				
			}
			
			return campana;
			
		} catch (SQLException e) {
			System.out.println("Campana:seleccionarTodoActivo:Error -> "+e.getMessage());
		}
		
		return null;
	}
	
	public List<CampanaDTO> listarTodoInscrito(String idPersona) {
		final String SELECT = "select * from campana c join persona_campana pc on pc.campana_id = c.id_campana join persona p on pc.persona_id = p.identificacion where p.identificacion = ?";
		List<CampanaDTO> campana = new ArrayList<>();
		
		try {
			
			psmt = CONN.prepareStatement(SELECT);
			psmt.setString(1, idPersona);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				CampanaDTO camp = new CampanaDTO();
				camp.setEstado_id(rs.getInt("estado_id"));
				camp.setFundacion_nit(rs.getString("fundacion_nit"));
				camp.setIdCampana(rs.getString("id_campana"));
				camp.setNombreCampana(rs.getString("nombre_campana"));
				camp.setObjetivoCampana(rs.getString("objetivo_campana"));
				
				campana.add(camp);
				
			}
			
			return campana;
			
		} catch (SQLException e) {
			System.out.println("Campana:seleccionarTodoPersonaCamp:Error -> "+e.getMessage());
		}
		
		return null;
	}
	
	public boolean agregarCampDon(String camp, String ident) {
		final String INSERT = "insert into persona_campana (campana_id, persona_id) values (?, ?)";
		
		try {
			
			psmt = CONN.prepareStatement(INSERT);
			psmt.setString(1, camp);
			psmt.setString(2, ident);
			
			int rowsAfected = psmt.executeUpdate();
			
			if (rowsAfected > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("CampanaPersona:agregar:Error -> "+e.getMessage());
		}
		
		return false;
	}

}
