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
	
	public List<String> listarCampMon(String id) {
		final String SELECT = "select * from campana_moneda where campana_id = ?";
		List<String> monedas = new ArrayList<>();
		
		try {
			
			psmt = CONN.prepareStatement(SELECT);
			psmt.setString(1, id);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				monedas.add(rs.getString("moneda_iso"));
				
			}
			
			return monedas;
			
		} catch (SQLException e) {
			System.out.println("CampanaMoned:listarId:Error -> "+e.getMessage());
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
	
	public boolean inscVerCantDonantes(String campana) {
		String QUERY_CANTDONADORES = "select count(pc.persona_id) as cant_inscrita, par.cant_donadores as cant_permit from parametros_campana par "
				+ "join campana c on par.campana_id = id_campana "
				+ "join persona_campana pc on c.id_campana = pc.campana_id where c.id_campana = ?";
		try {
			
			psmt = CONN.prepareStatement(QUERY_CANTDONADORES);
			psmt.setString(1, campana);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				int cantNow = rs.getInt("cant_inscrita");
				int cantPermit = rs.getInt("cant_permit");
				if(cantPermit == 0) {
					return true;
				}
				int cantBefore = (cantNow + 1);
				return cantPermit >= cantBefore;
			}
			
		} catch (SQLException e) {
			System.out.println("Campana:verificarPlazasDisponiblesInscripcion:Error -> "+e.getMessage());
		}
		
		return false;
	}
	
	public int cnatTotalDonantesCamp(String campana) {
		String QUERY_CANTDONADORES = "select count(persona_id) as cant_inscrita from persona_campana "
				+ "where campana_id = ?";
		try {
			
			psmt = CONN.prepareStatement(QUERY_CANTDONADORES);
			psmt.setString(1, campana);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				int cantNow = rs.getInt("cant_inscrita");
				
				return cantNow;
			}
			
		} catch (SQLException e) {
			System.out.println("Campana:cnatTotalDonantesCamp:Error -> "+e.getMessage());
		}
		
		return 0;
	}
	
	public int cnatTotalDonacionesCamp(String campana) {
		String QUERY_CANTDONADORES = "select count(deposito_cod) as cant_dona from movimiento "
				+ "where campana_id = ?";
		try {
			
			psmt = CONN.prepareStatement(QUERY_CANTDONADORES);
			psmt.setString(1, campana);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				int cantNow = rs.getInt("cant_dona");
				
				return cantNow;
			}
			
		} catch (SQLException e) {
			System.out.println("Campana:cnatTotalDonacionesCamp:Error -> "+e.getMessage());
		}
		
		return 0;
	}
	
	public double montMaxDonadoCamp(String campana) {
		String QUERY_CANTDONADORES = "select max(valor) as max_value from movimiento "
				+ "where campana_id = ?";
		try {
			
			psmt = CONN.prepareStatement(QUERY_CANTDONADORES);
			psmt.setString(1, campana);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				double cantNow = rs.getInt("max_value");
				
				return cantNow;
			}
			
		} catch (SQLException e) {
			System.out.println("Campana:montMaxDonadoCamp:Error -> "+e.getMessage());
		}
		
		return 0D;
	}
	
	public boolean inscVerCantDonacionesRealizadas(String campana) {
		String QUERY_CANTDONACIONES = "select count(m.campana_id) as cant_donaciones, par.cant_donaciones_permit as cant_donac_permit from parametros_campana par "
				+ "join campana c on par.campana_id = id_campana "
				+ "join movimiento m on c.id_campana = m.campana_id where c.id_campana = ?";
		try {
			
			psmt = CONN.prepareStatement(QUERY_CANTDONACIONES);
			psmt.setString(1, campana);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				int cantNow = rs.getInt("cant_donaciones");
				int cantPermit = rs.getInt("cant_donac_permit");
				if(cantPermit == 0) return true;
				int cantBefore = (cantNow + 1);
				
				return cantPermit >= cantBefore;
			}
			
		} catch (SQLException e) {
			System.out.println("Campana:verificarDonacionesDisponibles:Error -> "+e.getMessage());
		}
		
		return false;
	}
	
	public boolean inscVerCantMaximaDonador(String campana, Double cant) {
		String QUERY_MAXDONADOR = "select sum(m.valor) as cant_donacion_per, par.cant_max_donador as cant_max_permit_donador from parametros_campana par "
				+ "join campana c on par.campana_id = id_campana "
				+ "join movimiento m on c.id_campana = m.campana_id where c.id_campana = ?";
		try {
			
			psmt = CONN.prepareStatement(QUERY_MAXDONADOR);
			psmt.setString(1, campana);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				Double cantNow = rs.getDouble("cant_donacion_per");
				Double cantPermit = rs.getDouble("cant_max_permit_donador");
				if (cantPermit == 0D) return true;
				Double cantBefore = (cantNow + cant);
				System.out.println("ss "+cantPermit);
				return cantPermit >= cantBefore;
			}
			
		} catch (SQLException e) {
			System.out.println("Campana:verificarCantidadMaximaDonador:Error -> "+e.getMessage());
		}
		
		return false;
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
