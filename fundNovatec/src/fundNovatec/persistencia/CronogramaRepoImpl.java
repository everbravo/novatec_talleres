package fundNovatec.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fundNovatec.conexion.Conexion;
import fundNovatec.dto.CronogramaDTO;
import fundNovatec.repositorio.CronogramaRepo;

public class CronogramaRepoImpl implements CronogramaRepo{

	private final static Connection CONN = Conexion.getConexion();
	private static PreparedStatement psmt;
	
	public CronogramaRepoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean agregar(CronogramaDTO crono) {
		final String INSERT = "insert into cronograma (fecha_fin, fecha_inicio, campana_id) values (?, ?, ?)";
		
		try {
			
			psmt = CONN.prepareStatement(INSERT);
			psmt.setDate(1, crono.getFechaFin());
			psmt.setDate(2, crono.getFechaInicio());
			psmt.setString(3, crono.getCampanaId());
			
			int rowsAfected = psmt.executeUpdate();
			
			if (rowsAfected > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Cronograma:agregar:Error -> "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean actualizar(String campana, CronogramaDTO crono) {
		CronogramaDTO cronograma = obtenerPorCampana(campana);
		final String UPDATE = "update cronograma set fecha_fin = ?, fecha_inicio = ? where campana_id = ?";
		
		if(cronograma != null) {
			
			try {
				
				psmt = CONN.prepareStatement(UPDATE);
				psmt.setDate(1, crono.getFechaFin());
				psmt.setDate(2, crono.getFechaInicio());
				psmt.setString(3, cronograma.getCampanaId());
				
				int rowsAffected = psmt.executeUpdate();
				if(rowsAffected > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Cronograma:actualizar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public CronogramaDTO obtenerPorCampana(String campana) {
		final String FIND = "select * from campana where campana_id = ?";
		
		try {
			
			psmt = CONN.prepareStatement(FIND);
			psmt.setString(1, campana);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				
				CronogramaDTO crono = new CronogramaDTO();
				crono.setCampanaId(rs.getString("campana_id"));
				crono.setFechaFin(rs.getDate("fecha_fin"));
				crono.setFechaInicio(rs.getDate("fecha_inicio"));
				
				return crono;
			}
			
		} catch (SQLException e) {
			System.out.println("Campana:obtenerporCampana:Error -> "+e.getMessage());
		}
		
		return null;
	}

}
