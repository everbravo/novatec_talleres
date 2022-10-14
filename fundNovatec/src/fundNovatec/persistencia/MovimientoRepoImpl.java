package fundNovatec.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fundNovatec.conexion.Conexion;
import fundNovatec.dto.MovimientoDTO;
import fundNovatec.repositorio.MovimientoRepo;

public class MovimientoRepoImpl implements MovimientoRepo{

	private final static Connection CONN = Conexion.getConexion();
	private static PreparedStatement psmt;
	
	public MovimientoRepoImpl() {
	}

	@Override
	public boolean agregar(MovimientoDTO movi) {
		final String INSERT = "insert into movimiento (estado_id, deposito_cod, campaña_id, valor) values (?, ?, ?, ?)";
		
		try {
			
			psmt = CONN.prepareStatement(INSERT);
			psmt.setInt(1, movi.getEstado_id());
			psmt.setString(2, movi.getDeposito_cod());
			psmt.setString(3, movi.getCampanaId());
			psmt.setDouble(4, movi.getValor());
			
			int rowsAfected = psmt.executeUpdate();
			
			if (rowsAfected > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Movimiento:agregar:Error -> "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public List<MovimientoDTO> listarTodo() {
		final String SELECT = "select * from movimiento";
		List<MovimientoDTO> movimientos = new ArrayList<>();
		
		try {
			
			Statement stm = CONN.createStatement();
			ResultSet rs = stm.executeQuery(SELECT);
			
			while(rs.next()) {
				
				MovimientoDTO movimiento = new MovimientoDTO();
				movimiento.setEstado_id(rs.getInt("estado_id"));
				movimiento.setDeposito_cod(rs.getString("deposito_cod"));
				movimiento.setCampanaId(rs.getString("campana_id"));
				movimiento.setValor(rs.getDouble("valor"));
				movimiento.setFechaMov(rs.getDate("fecha_mov"));
				movimiento.setIdMovimiento(rs.getInt("id_movimiento"));
				
				movimientos.add(movimiento);
				
			}
			
			return movimientos;
			
		} catch (SQLException e) {
			System.out.println("Movimientos:seleccionarTodo:Error -> "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<MovimientoDTO> listarPorDeposito(String deeposito) {
		final String SELECT = "select * from movimiento where deposito_cod = ?";
		List<MovimientoDTO> movimientos = new ArrayList<>();
		
		try {
			
			psmt = CONN.prepareStatement(SELECT);
			psmt.setString(1, deeposito);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				MovimientoDTO movimiento = new MovimientoDTO();
				movimiento.setEstado_id(rs.getInt("estado_id"));
				movimiento.setDeposito_cod(rs.getString("deposito_cod"));
				movimiento.setCampanaId(rs.getString("campana_id"));
				movimiento.setValor(rs.getDouble("valor"));
				movimiento.setFechaMov(rs.getDate("fecha_mov"));
				movimiento.setIdMovimiento(rs.getInt("id_movimiento"));
				
				movimientos.add(movimiento);
				
			}
			
			return movimientos;
			
		} catch (SQLException e) {
			System.out.println("Movimiento:listarDeposito:Error -> "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<MovimientoDTO> listarPorCampana(String campana) {
		final String SELECT = "select * from movimiento where campana_id = ?";
		List<MovimientoDTO> movimientos = new ArrayList<>();
		
		try {
			
			psmt = CONN.prepareStatement(SELECT);
			psmt.setString(1, campana);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				MovimientoDTO movimiento = new MovimientoDTO();
				movimiento.setEstado_id(rs.getInt("estado_id"));
				movimiento.setDeposito_cod(rs.getString("deposito_cod"));
				movimiento.setCampanaId(rs.getString("campana_id"));
				movimiento.setValor(rs.getDouble("valor"));
				movimiento.setFechaMov(rs.getDate("fecha_mov"));
				movimiento.setIdMovimiento(rs.getInt("id_movimiento"));
				
				movimientos.add(movimiento);
				
			}
			
			return movimientos;
			
		} catch (SQLException e) {
			System.out.println("Movimiento:listarCampana:Error -> "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<MovimientoDTO> listarPorEstado(int estado) {
		final String SELECT = "select * from movimiento where estado_id = ?";
		List<MovimientoDTO> movimientos = new ArrayList<>();
		
		try {
			
			psmt = CONN.prepareStatement(SELECT);
			psmt.setInt(1, estado);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				MovimientoDTO movimiento = new MovimientoDTO();
				movimiento.setEstado_id(rs.getInt("estado_id"));
				movimiento.setDeposito_cod(rs.getString("deposito_cod"));
				movimiento.setCampanaId(rs.getString("campana_id"));
				movimiento.setValor(rs.getDouble("valor"));
				movimiento.setFechaMov(rs.getDate("fecha_mov"));
				movimiento.setIdMovimiento(rs.getInt("id_movimiento"));
				
				movimientos.add(movimiento);
				
			}
			
			return movimientos;
			
		} catch (SQLException e) {
			System.out.println("Movimiento:listarEstado:Error -> "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public MovimientoDTO obtenerPorId(int id) {
		final String FIND = "select * from movimiento where id_movimiento = ?";
		
		try {
			
			psmt = CONN.prepareStatement(FIND);
			psmt.setInt(1, id);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				
				MovimientoDTO movimiento = new MovimientoDTO();
				movimiento.setEstado_id(rs.getInt("estado_id"));
				movimiento.setDeposito_cod(rs.getString("deposito_cod"));
				movimiento.setCampanaId(rs.getString("campana_id"));
				movimiento.setValor(rs.getDouble("valor"));
				movimiento.setFechaMov(rs.getDate("fecha_mov"));
				movimiento.setIdMovimiento(rs.getInt("id_movimiento"));
				
				return movimiento;
			}
			
		} catch (SQLException e) {
			System.out.println("Movimiento:buscarId:Error -> "+e.getMessage());
		}
		
		return null;
	}

}
