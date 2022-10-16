package fundNovatec.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fundNovatec.conexion.Conexion;
import fundNovatec.dto.DepositoDTO;
import fundNovatec.dto.MonedaDTO;
import fundNovatec.repositorio.DepositoRepo;

public class DepositoRepoImpl implements DepositoRepo {

	private final static Connection CONN = Conexion.getConexion();
	private static PreparedStatement psmt;
	
	public DepositoRepoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean agregar(DepositoDTO dep) {
		final String INSERT = "insert into deposito (codigo_deposito, saldo, persona_id, estado_id, moneda_cod) values (?, ?, ?, ?, ?)";
		
		try {
			
			psmt = CONN.prepareStatement(INSERT);
			psmt.setString(1, dep.getCodigoDeposito());
			psmt.setDouble(2, dep.getSaldo());
			psmt.setString(3, dep.getPersonaId());
			psmt.setInt(4, dep.getEstadoId());
			psmt.setString(5, dep.getMonedaCod());
			
			int rowsAfected = psmt.executeUpdate();
			
			if (rowsAfected > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Deposito:agregar:Error -> "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean eliminar(String dep) {
		DepositoDTO deposito = buscarPorId(dep);
		int estado = EstadoRepoImpl.getCodInactivo();
		final String UPDATE = "update deposito set estado_id = ? where codigo_deposito = ?";
		
		if(deposito != null) {
			
			try {
				
				psmt = CONN.prepareStatement(UPDATE);
				psmt.setInt(1, estado);
				psmt.setString(2, deposito.getCodigoDeposito());
				
				int rowsAffected = psmt.executeUpdate();
				if(rowsAffected > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Deposito:elimianar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public boolean actualizar(String dep, DepositoDTO d) {
		DepositoDTO depio = buscarPorId(dep);
		final String UPDATE = "update deposito set saldo = ?, moneda_cod = ? where codigo_deposito = ?";
		
		if(depio != null) {
			
			MonedaRepoImpl mn = new MonedaRepoImpl();
			MonedaDTO m = mn.buscarPorId(d.getMonedaCod());
			
			try {
				
				psmt = CONN.prepareStatement(UPDATE);
				psmt.setDouble(1, d.getSaldo());
				psmt.setString(2, m.getCodigoIso());
				psmt.setString(3, depio.getCodigoDeposito());
				
				int rowsAffected = psmt.executeUpdate();
				if(rowsAffected > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Deposito:actualizar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public DepositoDTO buscarPorId(String dep) {
		final String FIND = "select * from deposito where codigo_deposito = ?";
		
		try {
			
			psmt = CONN.prepareStatement(FIND);
			psmt.setString(1, dep);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				
				DepositoDTO dposito = new DepositoDTO();
				dposito.setCodigoDeposito(rs.getString("codigo_deposito"));
				dposito.setEstadoId(rs.getInt("estado_id"));
				dposito.setMonedaCod(rs.getString("moneda_cod"));
				dposito.setPersonaId(rs.getString("persona_id"));
				dposito.setSaldo(rs.getDouble("saldo"));
				
				return dposito;
			}
			
		} catch (SQLException e) {
			System.out.println("Deposito:obtenerporId:Error -> "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<DepositoDTO> listarPorPersona(String id) {
		final String SELECT = "select * from deposito where persona_id = ? and estado_id = ?";
		List<DepositoDTO> depositos = new ArrayList<>();
		int codAct = EstadoRepoImpl.getCodActivo();
		
		try {
			
			psmt = CONN.prepareStatement(SELECT);
			psmt.setString(1, id);
			psmt.setInt(2, codAct);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				DepositoDTO dposito = new DepositoDTO();
				dposito.setCodigoDeposito(rs.getString("codigo_deposito"));
				dposito.setEstadoId(rs.getInt("estado_id"));
				dposito.setMonedaCod(rs.getString("moneda_cod"));
				dposito.setPersonaId(rs.getString("persona_id"));
				dposito.setSaldo(rs.getDouble("saldo"));
				
				depositos.add(dposito);
				
			}
			
			return depositos;
			
		} catch (SQLException e) {
			System.out.println("Deposito:listarPersona:Error -> "+e.getMessage());
		}
		
		return null;
	}
	
	public List<DepositoDTO> listarPorPersonaCampana(String id, List<String> monedaCamp) {
		final String SELECT = "select * from deposito where persona_id = ? and estado_id = ?";
		List<DepositoDTO> depositos = new ArrayList<>();
		int codAct = EstadoRepoImpl.getCodActivo();
		
		try {
			
			psmt = CONN.prepareStatement(SELECT);
			psmt.setString(1, id);
			psmt.setInt(2, codAct);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				DepositoDTO dposito = new DepositoDTO();
				dposito.setCodigoDeposito(rs.getString("codigo_deposito"));
				dposito.setEstadoId(rs.getInt("estado_id"));
				dposito.setMonedaCod(rs.getString("moneda_cod"));
				dposito.setPersonaId(rs.getString("persona_id"));
				dposito.setSaldo(rs.getDouble("saldo"));
				
				depositos.add(dposito);
				
			}
			
			return depositos;
			
		} catch (SQLException e) {
			System.out.println("Deposito:listarPersona:Error -> "+e.getMessage());
		}
		
		return null;
	}

}
