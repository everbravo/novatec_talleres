package fundNovatec.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fundNovatec.conexion.Conexion;
import fundNovatec.dto.FundacionDTO;
import fundNovatec.repositorio.FundacionRepo;

public class FundacionRepoImpl implements FundacionRepo{

	public FundacionRepoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private final static Connection CONN = Conexion.getConexion();
	private static PreparedStatement psmt;

	@Override
	public boolean agregar(FundacionDTO fundacion) {
		
		final String INSERT = "insert into fundacion (nit, nombre, razon_social, moneda_iso) values (?, ?, ?, ?)";
		
		try {
			
			psmt = CONN.prepareStatement(INSERT);
			psmt.setString(1, fundacion.getNit());
			psmt.setString(2, fundacion.getNombre());
			psmt.setString(3, fundacion.getRazonSocial());
			psmt.setString(4, fundacion.getMonedaIso());
			
			int rowsAfected = psmt.executeUpdate();
			
			if (rowsAfected > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Fundacion:Agregar:Error -> "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean eliminar(String nit) {
		
		FundacionDTO fundacion = buscarPorNit(nit);
		final String DELETE = "delete from fundacion where nit = ?";
		
		if(fundacion != null) {
			
			try {
				
				psmt = CONN.prepareStatement(DELETE);
				psmt.setString(1, fundacion.getNit());
				
				int affectedRows = psmt.executeUpdate();
				if(affectedRows > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Fundacion:eliminar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public boolean actualizar(String nit, FundacionDTO fundacion) {

		FundacionDTO oldFundacion = buscarPorNit(nit);
		final String UPDATE = "update fundacion set nombre = ?, razon_sacial = ?, moneda_iso = ? where nit = ?";
		
		if(oldFundacion != null) {
			
			try {
				
				psmt = CONN.prepareStatement(UPDATE);
				psmt.setString(1, fundacion.getNombre());
				psmt.setString(2, fundacion.getRazonSocial());
				psmt.setString(3, fundacion.getMonedaIso());
				psmt.setString(4, oldFundacion.getNit());
				
				int rowsAffected = psmt.executeUpdate();
				if(rowsAffected > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Fundacion:actualizar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public List<FundacionDTO> listarTodo() {
		
		final String SELECT = "select * from fundacion";
		List<FundacionDTO> fundaciones = new ArrayList<>();
		
		try {
			
			Statement stm = CONN.createStatement();
			ResultSet rs = stm.executeQuery(SELECT);
			
			while(rs.next()) {
				
				FundacionDTO fundacion = new FundacionDTO();
				fundacion.setNit(rs.getString("nit"));
				fundacion.setNombre(rs.getString("nombre"));
				fundacion.setRazonSocial(rs.getString("razon_social"));
				fundacion.setMonedaIso(rs.getString("moneda_iso"));
				
				fundaciones.add(fundacion);
				
			}
			
			return fundaciones;
			
		} catch (SQLException e) {
			System.out.println("Fundacion:seleccionarTodo:Error -> "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public FundacionDTO buscarPorNit(String nit) {
		
		final String FIND = "select * from fundacion where nit = ?";
		
		try {
			
			psmt = CONN.prepareStatement(FIND);
			psmt.setString(1, nit);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				
				FundacionDTO fundacion = new FundacionDTO();
				fundacion.setNit(rs.getString("nit"));
				fundacion.setNombre(rs.getString("nombre"));
				fundacion.setRazonSocial(rs.getString("razon_social"));
				fundacion.setMonedaIso(rs.getString("moneda_iso"));
				
				return fundacion;
			}
			
		} catch (SQLException e) {
			System.out.println("Fundacion:buscarNit:Error -> "+e.getMessage());
		}
		
		return null;
	}

}
