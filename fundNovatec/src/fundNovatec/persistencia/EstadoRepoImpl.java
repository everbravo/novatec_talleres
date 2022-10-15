package fundNovatec.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fundNovatec.conexion.Conexion;
import fundNovatec.dto.EstadoDTO;
import fundNovatec.repositorio.EstadoRepo;

public class EstadoRepoImpl implements EstadoRepo{
	
	private final static Connection CONN = Conexion.getConexion();
	private static PreparedStatement psmt;

	public EstadoRepoImpl() {
	}

	@Override
	public boolean agregar(EstadoDTO estado) {
		final String INSERT = "insert into estado (descripcion, categoria) values (?, ?)";
		
		try {
			
			psmt = CONN.prepareStatement(INSERT);
			psmt.setString(1, estado.getDescripcion());
			psmt.setString(2, String.valueOf(estado.getCategoria()));
			
			int rowsAfected = psmt.executeUpdate();
			
			if (rowsAfected > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Estado:agregar:Error -> "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public EstadoDTO buscarPorDescripcion(String desc) {
		final String FIND = "select * from estado where descripcion = ?";
		
		try {
			
			psmt = CONN.prepareStatement(FIND);
			psmt.setString(1, desc);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				
				EstadoDTO estado = new EstadoDTO();
				estado.setIdEstado(rs.getInt("id_estado"));
				estado.setCategoria(rs.getString("categoria").charAt(0));
				estado.setDescripcion(rs.getString("descripcion"));
				
				return estado;
			}
			
		} catch (SQLException e) {
			System.out.println("Estado:buscarDescripcion:Error -> "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public EstadoDTO buscarPorId(Integer id) {
		final String FIND = "select * from estado where id_estado = ?";
		
		try {
			
			psmt = CONN.prepareStatement(FIND);
			psmt.setInt(1, id);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				
				EstadoDTO estado = new EstadoDTO();
				estado.setIdEstado(rs.getInt("id_estado"));
				estado.setCategoria(rs.getString("categoria").charAt(0));
				estado.setDescripcion(rs.getString("descripcion"));
				
				return estado;
			}
			
		} catch (SQLException e) {
			System.out.println("Estado:buscarId:Error -> "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<EstadoDTO> listarTodo() {
		final String SELECT = "select * from estado";
		List<EstadoDTO> estados = new ArrayList<>();
		
		try {
			
			Statement stm = CONN.createStatement();
			ResultSet rs = stm.executeQuery(SELECT);
			
			while(rs.next()) {
				
				EstadoDTO estado = new EstadoDTO();
				estado.setIdEstado(rs.getInt("id_estado"));
				estado.setCategoria(rs.getString("categoria").charAt(0));
				estado.setDescripcion(rs.getString("descripcion"));
				
				estados.add(estado);
				
			}
			
			return estados;
			
		} catch (SQLException e) {
			System.out.println("Estado:seleccionarTodo:Error -> "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<EstadoDTO> listarPorCateg(char caracter) {
		final String SELECT = "select * from estado where categoria = ?";
		List<EstadoDTO> estados = new ArrayList<>();
		
		try {
			
			psmt = CONN.prepareStatement(SELECT);
			psmt.setString(1, String.valueOf(caracter));
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				EstadoDTO estado = new EstadoDTO();
				estado.setIdEstado(rs.getInt("id_estado"));
				estado.setCategoria(rs.getString("categoria").charAt(0));
				estado.setDescripcion(rs.getString("descripcion"));
				
				estados.add(estado);
				
			}
			
			return estados;
			
		} catch (SQLException e) {
			System.out.println("Estados:listarCateg:Error -> "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public boolean eliminar(int id) {
		EstadoDTO estado = buscarPorId(id);
		final String DELETE = "delete from estado where id_estado = ?";
		
		if(estado != null) {
			
			try {
				
				psmt = CONN.prepareStatement(DELETE);
				psmt.setInt(1, estado.getIdEstado());
				
				int affectedRows = psmt.executeUpdate();
				if(affectedRows > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Estado:eliminar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public boolean actualizar(int id, EstadoDTO est) {
		EstadoDTO moneda = buscarPorId(id);
		final String UPDATE = "update moneda set categoria = ?, descripcion = ? where id_estado = ?";
		
		if(moneda != null) {
			
			try {
				
				psmt = CONN.prepareStatement(UPDATE);
				psmt.setString(1, String.valueOf(est.getCategoria()));
				psmt.setString(2, est.getDescripcion());
				psmt.setInt(3, moneda.getIdEstado());
				
				int rowsAffected = psmt.executeUpdate();
				if(rowsAffected > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Estado:actualizar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}
	
	public static int getCodInactivo() {
		
		final String FIND = "select id_estado from estado where descripcion like '%INACTIVO%'";
		
		try {
			
			Statement stm = CONN.createStatement();
			ResultSet rs = stm.executeQuery(FIND);
			
			while(rs.next()) {
				return rs.getInt("id_estado");
			}
			
			
		} catch (SQLException e) {
			System.out.println("Estado:obtenerCodigoInactivo:Error -> "+e.getMessage());
		}
		
		return -1;
	}
	
	public static int getCodActivo() {
		
		final String FIND = "select id_estado from estado where descripcion like '%ACTIVO%'";
		
		try {
			
			Statement stm = CONN.createStatement();
			ResultSet rs = stm.executeQuery(FIND);
			
			while(rs.next()) {
				return rs.getInt("id_estado");
			}
			
			
		} catch (SQLException e) {
			System.out.println("Estado:obtenerCodigoActivo:Error -> "+e.getMessage());
		}
		
		return -1;
	}

}
