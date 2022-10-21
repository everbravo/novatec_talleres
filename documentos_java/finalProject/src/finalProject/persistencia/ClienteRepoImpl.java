package finalProject.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import finalProject.excepxiones.ExcepcionesPersonalizadas;
import finalProject.modelo.Banco;
import finalProject.modelo.Cliente;
import finalProject.modelo.Usuario;
import finalProject.repositorio.ClienteRepo;

public class ClienteRepoImpl implements ClienteRepo{

	@Override
	public boolean agregar(Connection con, Cliente cliente) {
		boolean respuesta = false;

		String INSERT = "INSERT INTO cliente(cedula, nombre_cliente, apellidos_cliente, fecha_nacimiento, sexo, banco, nombre_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(INSERT);
			ps.setString(1, cliente.getCedula());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setDate(4, cliente.getFecha_nacimiento());
			ps.setString(5, String.valueOf(cliente.getSexo()));			
			ps.setString(6, cliente.getBanco().getNit());
			ps.setString(7, cliente.getNombre_usuario().getNombre_usuario());

			int resultado = ps.executeUpdate();

			if (resultado > 0) {
				respuesta = true;
			}

		} catch (SQLException e) {
			System.out.println("CLIENTE::SQL Error -> " + e.getMessage());
		}

		return respuesta;
	}

	@Override
	public List<Cliente> obtener(Connection con) {
		BancoRepoImpl brimpl = new BancoRepoImpl();
		UsuarioRepoImpl usrimpl = new UsuarioRepoImpl();
		Statement stmt;
		List<Cliente> lcl = new ArrayList<>();
		
		String SLECT = "SELECT * FROM cliente";

		try {

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SLECT);
			
			while (rs.next()) {
				Cliente client = new Cliente();
				client.setCedula(rs.getString("cedula"));
				client.setNombre(rs.getString("nombre_cliente"));
				client.setApellidos(rs.getString("apellidos_cliente"));
				client.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
				client.setSexo(rs.getString("sexo").trim().charAt(0));
				
				Banco banc = brimpl.obtenerBanco(con, rs.getString("banco"));
				Usuario user = usrimpl.obtenerUsuario(con, rs.getString("nombre_usuario"));
				
				client.setBanco(banc);
				client.setNombre_usuario(user);
				
				lcl.add(client);
			}
			
			return lcl;

		} catch (SQLException e) {
			System.out.println("CLIENTE::Información no encontrada: " + e.getMessage());
		}
		return lcl;
	}

	@Override
	public boolean actualizar(Connection con, Cliente cliente, String ident) throws ExcepcionesPersonalizadas {
		
		BancoRepoImpl brimpl = new BancoRepoImpl();
		UsuarioRepoImpl usrimpl = new UsuarioRepoImpl();
		
		boolean res = false;
		String UPDATE = "UPDATE cliente SET nombre_cliente=?, apellidos_cliente=?, fecha_nacimiento=?,sexo=?, banco=?, nombre_usuario=? WHERE cedula = ?";

		Cliente client = obtenerCliente(con, ident);
		Banco banc = brimpl.obtenerBanco(con, cliente.getBanco().getNit());
		Usuario user = usrimpl.obtenerUsuario(con, cliente.getNombre_usuario().getNombre_usuario());
		
		if (banc != null && user != null) {

			try {

				PreparedStatement ps = con.prepareStatement(UPDATE);
				ps.setString(1, cliente.getNombre());
				ps.setString(2, cliente.getApellidos());
				ps.setDate(3, cliente.getFecha_nacimiento());
				ps.setString(4, String.valueOf(cliente.getSexo()));
				ps.setString(5, banc.getNit());
				ps.setString(6, user.getNombre_usuario());
				ps.setString(7, client.getCedula());

				int resultado = ps.executeUpdate();

				if (resultado > 0) {
					res = true;
				}
				
				return res;

			} catch (SQLException e) {
				System.out.println("CLIENTE -> ERROR: datos no actualizados: " + e.getMessage());
			}

		} else {
			throw new ExcepcionesPersonalizadas("No se pobtuvieron datos del cliente");
		}

		return res;
		
		
	}

	@Override
	public Cliente obtenerCliente(Connection con, String cedula) {
		
		BancoRepoImpl brimpl = new BancoRepoImpl();
		UsuarioRepoImpl usrimpl = new UsuarioRepoImpl();
		
		String FIND = "SELECT * FROM cliente WHERE cedula=?";

		try {

			PreparedStatement statement = con.prepareStatement(FIND);
			statement.setString(1, cedula);
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Cliente client = new Cliente();
				client.setCedula(rs.getString("cedula"));
				client.setNombre(rs.getString("nombre_cliente"));
				client.setApellidos(rs.getString("apellidos_cliente"));
				client.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
				client.setSexo(rs.getString("sexo").trim().charAt(0));
				
				Banco banc = brimpl.obtenerBanco(con, rs.getString("banco"));
				Usuario user = usrimpl.obtenerUsuario(con, rs.getString("nombre_usuario"));
				
				client.setBanco(banc);
				client.setNombre_usuario(user);
				
				return client;
			}

		} catch (SQLException e) {
			System.out.println("CLIENTE::Información no encontrada: " + e.getMessage());
		}
		return null;
		
	}

	@Override
	public boolean eliminar(Connection con, String cedula) {
		boolean listo = false;
		String DELETE = "DELETE FROM cliente WHERE cedula=?";

		try {

			PreparedStatement statement = con.prepareStatement(DELETE);
			statement.setString(1, cedula);

			int elimiandos = statement.executeUpdate();
			if (elimiandos > 0) {
				listo = true;
				System.out.println("CLIENTE::Eliminado de forma correcta!");
			}

			return listo;

		} catch (SQLException e) {
			System.out.println("Error de Eliminación: " + e.getMessage());
		}

		return listo;
	}

	@Override
	public Cliente obtenerByUser(Connection con, String nombre_user) {
		BancoRepoImpl brimpl = new BancoRepoImpl();
		UsuarioRepoImpl usrimpl = new UsuarioRepoImpl();
		
		String FIND = "SELECT * FROM cliente WHERE nombre_usuario=?";

		try {

			PreparedStatement statement = con.prepareStatement(FIND);
			statement.setString(1, nombre_user);
			//System.out.println(statement);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Cliente client = new Cliente();
				client.setCedula(rs.getString("cedula"));
				client.setNombre(rs.getString("nombre_cliente"));
				client.setApellidos(rs.getString("apellidos_cliente"));
				client.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
				client.setSexo(rs.getString("sexo").trim().charAt(0));
				
				Banco banc = brimpl.obtenerBanco(con, rs.getString("banco"));
				Usuario user = usrimpl.obtenerUsuario(con, rs.getString("nombre_usuario"));
				
				client.setBanco(banc);
				client.setNombre_usuario(user);
				
				return client;
			}

		} catch (SQLException e) {
			System.out.println("CLIENTE:USUARIO:Información no encontrada: " + e.getMessage());
		}
		return null;
	}



}
