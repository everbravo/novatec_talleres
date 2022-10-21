package fundNovatec.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fundNovatec.conexion.Conexion;
import fundNovatec.dto.MonedaDTO;
import fundNovatec.repositorio.MonedaRepo;

public class MonedaRepoImpl implements MonedaRepo{
	
	private final static Connection CONN = Conexion.getConexion();
	private static PreparedStatement psmt;

	public MonedaRepoImpl() {
	}

	@Override
	public boolean agregar(MonedaDTO moneda) {
		final String INSERT = "insert into moneda (codigo_iso, tasa_conversion_cop, descripcion) values (?, ?, ?)";
		
		try {
			
			psmt = CONN.prepareStatement(INSERT);
			psmt.setString(1, moneda.getCodigoIso());
			psmt.setDouble(2, moneda.getTasaConversionCop());
			psmt.setString(3, moneda.getDescripcion());
			
			int rowsAfected = psmt.executeUpdate();
			
			if (rowsAfected > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Moneda:agregar:Error -> "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean eliminar(String cod) {
		MonedaDTO moneda = buscarPorId(cod);
		final String DELETE = "delete from moneda where codigo_iso = ?";
		
		if(moneda != null) {
			
			try {
				
				psmt = CONN.prepareStatement(DELETE);
				psmt.setString(1, moneda.getCodigoIso());
				
				int affectedRows = psmt.executeUpdate();
				if(affectedRows > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Moneda:eliminar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public boolean actualizar(String cod, MonedaDTO moned) {
		MonedaDTO moneda = buscarPorId(cod);
		final String UPDATE = "update moneda set tasa_conversion_cop = ?, descripcion = ? where codigo_iso = ?";
		
		if(moneda != null) {
			
			try {
				
				psmt = CONN.prepareStatement(UPDATE);
				psmt.setDouble(1, moned.getTasaConversionCop());
				psmt.setString(2, moned.getDescripcion());
				psmt.setString(3, moneda.getCodigoIso());
				
				int rowsAffected = psmt.executeUpdate();
				if(rowsAffected > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Moneda:actualizar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public List<MonedaDTO> listarTodo() {
		final String SELECT = "select * from moneda";
		List<MonedaDTO> monedas = new ArrayList<>();
		
		try {
			
			Statement stm = CONN.createStatement();
			ResultSet rs = stm.executeQuery(SELECT);
			
			while(rs.next()) {
				
				MonedaDTO moneda = new MonedaDTO();
				moneda.setCodigoIso(rs.getString("codigo_iso"));
				moneda.setTasaConversionCop(rs.getDouble("tasa_conversion_cop"));
				moneda.setDescripcion(rs.getString("descripcion"));
				
				monedas.add(moneda);
				
			}
			
			return monedas;
			
		} catch (SQLException e) {
			System.out.println("Moneda:seleccionarTodo:Error -> "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public MonedaDTO buscarPorId(String cod) {
		final String FIND = "select * from moneda where codigo_iso = ?";
		
		try {
			
			psmt = CONN.prepareStatement(FIND);
			psmt.setString(1, cod);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				
				MonedaDTO moneda = new MonedaDTO();
				moneda.setCodigoIso(rs.getString("codigo_iso"));
				moneda.setTasaConversionCop(rs.getDouble("tasa_conversion_cop"));
				moneda.setDescripcion(rs.getString("descripcion"));
				
				return moneda;
			}
			
		} catch (SQLException e) {
			System.out.println("Moneda:buscarId:Error -> "+e.getMessage());
		}
		
		return null;
	}
	
	public boolean agregarCampMon(String camp, String mon) {
		final String INSERT = "insert into campana_moneda (campana_id, moneda_iso) values (?, ?)";
		
		try {
			
			psmt = CONN.prepareStatement(INSERT);
			psmt.setString(1, camp);
			psmt.setString(2, mon);
			
			int rowsAfected = psmt.executeUpdate();
			
			if (rowsAfected > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("CampanaMoneda:agregar:Error -> "+e.getMessage());
		}
		
		return false;
	}
	

}
