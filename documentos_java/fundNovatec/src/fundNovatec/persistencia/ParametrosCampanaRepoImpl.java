package fundNovatec.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fundNovatec.conexion.Conexion;
import fundNovatec.dto.ParametrosCampanaDTO;
import fundNovatec.repositorio.ParametroCampanaRepo;

public class ParametrosCampanaRepoImpl implements ParametroCampanaRepo{
	
	private final static Connection CONN = Conexion.getConexion();
	private static PreparedStatement psmt;

	public ParametrosCampanaRepoImpl() {
	}

	@Override
	public boolean agregar(ParametrosCampanaDTO param) {
		final String INSERT = "insert into parametros_campana (cant_donadores, cant_donaciones_permit, cant_max_donador, campana_id, cantMin, pocentaje_adm) values (?, ?, ?, ?, ?, ?)";
		
		try {
			
			psmt = CONN.prepareStatement(INSERT);
			psmt.setInt(1, param.getCantDonadores());
			psmt.setInt(2, param.getCantDonacionesPermit());
			psmt.setDouble(3, param.getCantMaxDonador());
			psmt.setString(4, param.getCampanaId());
			psmt.setDouble(5, param.getCantMin());
			psmt.setFloat(6, param.getPorcentaje());
			
			int rowsAfected = psmt.executeUpdate();
			
			if (rowsAfected > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("ParametrosC:agregar:Error -> "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean actualizar(String campana, ParametrosCampanaDTO param) {
		ParametrosCampanaDTO parametros = obtenerPorCampana(campana);
		final String UPDATE = "update parametros_campana set cant_donadores = ?, cant_donaciones_permit = ?, cant_max_donador = ?, cantMin = ?, pocentaje_adm = ? where campana_id = ?";
		
		if(parametros != null) {
			
			try {
				
				psmt = CONN.prepareStatement(UPDATE);
				psmt.setInt(1, param.getCantDonadores());
				psmt.setInt(2, param.getCantDonacionesPermit());
				psmt.setDouble(3, param.getCantMaxDonador());
				psmt.setDouble(4, param.getCantMin());
				psmt.setFloat(5, param.getPorcentaje());
				psmt.setString(6, parametros.getCampanaId());
				
				int rowsAffected = psmt.executeUpdate();
				if(rowsAffected > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("ParametrosC:actualizar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public ParametrosCampanaDTO obtenerPorCampana(String campana) {
		final String FIND = "select * from parametros_campana where campana_id = ?";
		
		try {
			
			psmt = CONN.prepareStatement(FIND);
			psmt.setString(1, campana);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				
				ParametrosCampanaDTO parametros = new ParametrosCampanaDTO();
				parametros.setCampanaId(rs.getString("campana_id"));
				parametros.setCantDonacionesPermit(rs.getInt("cant_donaciones_permit"));
				parametros.setCantDonadores(rs.getInt("cant_donadores"));
				parametros.setCantMaxDonador(rs.getDouble("cant_max_donador"));
				parametros.setCantMin(rs.getDouble("cantMin"));
				parametros.setPorcentaje(rs.getFloat("pocentaje_adm"));
				
				return parametros;
			}
			
		} catch (SQLException e) {
			System.out.println("ParametrosC:obtenerporCampana:Error -> "+e.getMessage());
		}
		
		return null;
	}

}
