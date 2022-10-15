package fundNovatec.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fundNovatec.conexion.Conexion;
import fundNovatec.dto.PersonaDTO;
import fundNovatec.reporte.PersonaDonadorPtllDTO;
import fundNovatec.repositorio.PersonaRepo;

public class PersonaRepoImpl implements PersonaRepo{

	private final static Connection CONN = Conexion.getConexion();
	private static PreparedStatement psmt;
	
	public PersonaRepoImpl() {
	}

	@Override
	public boolean agregar(PersonaDTO persona) {
		final String INSERT = "insert into persona (identificacion, nombre, apellidos, nacimiento, sexo_id, rol_usuario, fn_nit) values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			psmt = CONN.prepareStatement(INSERT);
			psmt.setString(1, persona.getIdentificacion());
			psmt.setString(2, persona.getNombre());
			psmt.setString(3, persona.getApellidos());
			psmt.setDate(4, persona.getNacimiento());
			psmt.setInt(5, persona.getSexo_id());
			psmt.setInt(6, persona.getRol_usuario());
			psmt.setString(7, persona.getFn_nit());
			
			int rowsAfected = psmt.executeUpdate();
			
			if (rowsAfected > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Persona:agregar:Error -> "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean inactivar(String identificacion, int idEst) {
		PersonaDTO persona = obtenerPorIdentificacion(identificacion);
		final String UPDATE = "update persona set id_estado = ? where identificacion = ?";
		
		if(persona != null) {
			
			try {
				
				psmt = CONN.prepareStatement(UPDATE);
				psmt.setInt(1, idEst);
				psmt.setString(2, persona.getIdentificacion());
				
				int rowsAffected = psmt.executeUpdate();
				if(rowsAffected > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Persona:inactivar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}


	@Override
	public boolean activar(String identificacion, int idEst) {
		PersonaDTO persona = obtenerPorIdentificacion(identificacion);
		final String UPDATE = "update persona set estado_id = ? where identificacion = ?";
		
		if(persona != null) {
			
			try {
				
				psmt = CONN.prepareStatement(UPDATE);
				psmt.setInt(1, idEst);
				psmt.setString(2, persona.getIdentificacion());
				
				int rowsAffected = psmt.executeUpdate();
				if(rowsAffected > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Persona:activar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public boolean actulizar(String identificacion, PersonaDTO persona) {
		PersonaDTO per = obtenerPorIdentificacion(identificacion);
		final String UPDATE = "update persona set nombre = ?, apellidos = ?, nacimiento = ?, sexo_id = ?, rol_usuario = ? where identificacion = ?";
		
		if(per != null) {
			
			try {
				
				psmt = CONN.prepareStatement(UPDATE);
				psmt.setString(1, persona.getNombre());
				psmt.setString(2, persona.getApellidos());
				psmt.setDate(3, persona.getNacimiento());
				psmt.setInt(4, persona.getSexo_id());
				psmt.setInt(5, persona.getRol_usuario());
				psmt.setString(6, per.getIdentificacion());
				
				int rowsAffected = psmt.executeUpdate();
				if(rowsAffected > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Persona:actualizar:Error -> "+e.getMessage());
			}
			
		}
		
		return false;
	}

	@Override
	public PersonaDTO obtenerPorIdentificacion(String identificacion) {
		final String FIND = "select * from persona where identificacion = ?";
		
		try {
			
			psmt = CONN.prepareStatement(FIND);
			psmt.setString(1, identificacion);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				
				PersonaDTO persona = new PersonaDTO();
				persona.setIdentificacion(rs.getString("identificacion"));
				persona.setNombre(rs.getString("nombre"));
				persona.setApellidos(rs.getString("apellidos"));
				persona.setNacimiento(rs.getDate("nacimiento"));
				persona.setSexo_id(rs.getInt("sexo_id"));
				persona.setRol_usuario(rs.getInt("rol_usuario"));
				persona.setFn_nit(rs.getString("fn_nit"));
				
				return persona;
			}
			
		} catch (SQLException e) {
			System.out.println("Persona:buscarId:Error -> "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<PersonaDonadorPtllDTO> generarReporteDonacion(String cedula, LocalDate fecha1, LocalDate fecha2) {
		
		final String QUERY = "select p.nombre as nombre, p.apellidos as apellido, ru.descripcion as rol, "
				+ "m.valor as val, m.fecha_mov as fmov, c.nombre_campana as ncamp, c.objetivo_campana as objcamp, c.id_campana as campid "
				+ "from persona p join rol_usuario ru on ru.id_rol = p.rol_usuario "
				+ "join deposito d on ? = d.persona_id "
				+ "join movimiento m on d.codigo_deposito = m.deposito_cod "
				+ "join campana c on m.campana_id = c.id_campana "
				+ "where (m.fecha_mov between ? and ?) ";
		
		PersonaDTO donador = obtenerPorIdentificacion(cedula);
		if(donador != null) {
			 
			List<PersonaDonadorPtllDTO> reporte = new ArrayList<>();
			
			try {
				
				psmt = CONN.prepareStatement(QUERY);
				psmt.setString(1, cedula);
				psmt.setDate(2, Date.valueOf(fecha1));
				psmt.setDate(3, Date.valueOf(fecha2));
				
				ResultSet rs = psmt.executeQuery();
				
				while(rs.next()) {
					
					PersonaDonadorPtllDTO rows = new PersonaDonadorPtllDTO();
					rows.setNombre(rs.getString("nombre"));
					rows.setApellidos(rs.getString("apellido"));
					rows.setFecha_donacion(rs.getDate("fmov"));
					rows.setValor(rs.getDouble("val"));
					rows.setNombre_campana(rs.getString("ncamp"));
					rows.setCodigo_campana(rs.getString("campid"));
					rows.setFecha_emision(LocalDateTime.now());
					rows.setObjetivo_campaña(rs.getString("objcamp"));
					rows.setRol(rs.getString("rol"));
					
					reporte.add(rows);
					
				}
				
				return reporte;
				
			} catch (SQLException e) {
				System.out.println("Persona:generarReporte:Error -> "+e.getMessage());
			}
			
		}
		
		return null;
	}

}
