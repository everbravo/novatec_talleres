package clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Cliente {

	private int id;
	private String nombre;
	private String apellidos;
	private String documento;
	private String telefono;
	private Date nacimineto;
	

	public Cliente() {
		super();
	}

	
	
	public Cliente(String nombre, String apellidos, String documento, String telefono, Date nacimineto) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.documento = documento;
		this.telefono = telefono;
		this.nacimineto = nacimineto;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getNacimineto() {
		return nacimineto;
	}

	public void setNacimineto(Date nacimineto) {
		this.nacimineto = nacimineto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos + ", documento=" + documento + ", telefono="
				+ telefono + ", nacimineto=" + nacimineto + "]";
	}

	public void insertarCliente(Connection conn, Cliente cl) {
		
		String INSERT = "INSERT INTO cliente (nombre, apellidos, documento, telefono, nacimiento) values (?,?,?,?,?) ";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setString(1, cl.getNombre());
			ps.setString(2, cl.getApellidos());
			ps.setString(3, cl.getDocumento());
			ps.setString(4, cl.getTelefono());
			ps.setDate(5, cl.getNacimineto());
			
			int resultado = ps.executeUpdate();

			if (resultado > 0) {
			    System.out.println("Registro insertado!");
			}
			
		} catch (SQLException e) {
			System.out.println("Error de inserción: "+e.getMessage());
		}
	}
	
	public void listarClientes(Connection conn) {
		
		@SuppressWarnings("unused")
		Statement stmt;
		String SELECT = "SELECT * FROM cliente";
		
		try {
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT);

			while(rs.next()) {
				System.out.print("Id: "+rs.getInt("id")+", ");
				System.out.print("Nombre: "+rs.getString("nombre")+", ");
				System.out.print("Apellidos: "+rs.getString("apellidos")+", ");
				System.out.print("Documento: "+rs.getString("documento")+", ");
				System.out.print("Telefono: "+rs.getString("telefono")+", ");
				Date nacimiento = rs.getDate("nacimiento");
				System.out.println("Edad: "+calcularEdad(nacimiento));
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error de inserción: "+e.getMessage());
		}
	}
	
	public int calcularEdad(Date nac) {
		LocalDate nacimiento = nac.toLocalDate();
		return (int) ChronoUnit.YEARS.between(nacimiento, LocalDate.now());
	}
	
	public void eliminarCliente(Connection conn, int id) {
		
		String DELETE = "DELETE FROM cliente WHERE id=?";
		
		try {
			
			PreparedStatement statement = conn.prepareStatement(DELETE);
			statement.setInt(1, id);
			
			
		
			int elimiandos = statement.executeUpdate();
			if (elimiandos > 0) {
				System.out.println("Eliminado de forma correcta!");
			}
			
		} catch (SQLException e) {
			System.out.println("Error de inserción: "+e.getMessage());
		}
	}
	
	public void buscarCliente(Connection conn, int id) {
		
		String FIND = "SELECT * FROM cliente WHERE id=?";
		
		try {
			
			PreparedStatement statement = conn.prepareStatement(FIND);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				System.out.print("Id: "+rs.getInt("id")+", ");
				System.out.print("Nombre: "+rs.getString("nombre")+", ");
				System.out.print("Apellidos: "+rs.getString("apellidos")+", ");
				System.out.print("Documento: "+rs.getString("documento")+", ");
				System.out.print("Telefono: "+rs.getString("telefono")+", ");
				Date nacimiento = rs.getDate("nacimiento");
				System.out.println("Edad: "+calcularEdad(nacimiento));
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error de inserción: "+e.getMessage());
		}
	}
	
	public void actualizarCliente(Connection conn, Cliente cl) {
		
		String UPDATE = "UPDATE cliente SET nombre=?, apellidos=?, documento=?, telefono=?, nacimiento=? WHERE id=?";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			ps.setString(1, cl.getNombre());
			ps.setString(2, cl.getApellidos());
			ps.setString(3, cl.getDocumento());
			ps.setString(4, cl.getTelefono());
			ps.setDate(5, cl.getNacimineto());
			ps.setInt(6, cl.getId());
			
			int resultado = ps.executeUpdate();

			if (resultado > 0) {
			    System.out.println("Registro Actualizado!");
			}
			
		} catch (SQLException e) {
			System.out.println("Error de inserción: "+e.getMessage());
		}
	}

}
