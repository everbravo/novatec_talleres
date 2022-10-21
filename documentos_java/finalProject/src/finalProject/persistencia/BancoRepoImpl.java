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
import finalProject.modelo.Usuario;
import finalProject.repositorio.BancoRepo;

public class BancoRepoImpl implements BancoRepo {

	@Override
	public boolean agregar(Connection conn, Banco banco) {

		boolean respuesta = false;

		String INSERT = "INSERT INTO banco (nit, nombre_banco, nombre_usuario) VALUES (?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setString(1, banco.getNit());
			ps.setString(2, banco.getNombre());
			ps.setString(3, banco.getNombre_usuario().getNombre_usuario());

			int resultado = ps.executeUpdate();

			if (resultado > 0) {
				respuesta = true;
			}

		} catch (SQLException e) {
			System.out.println("SQL Error -> " + e.getMessage());
		}

		return respuesta;
	}

	@Override
	public boolean actualizar(Connection conn, String nit, Banco bc) throws ExcepcionesPersonalizadas {

		boolean res = false;
		String UPDATE = "UPDATE banco SET nombre_banco=? WHERE nit=?";

		Banco banc = obtenerBanco(conn, nit);
		if (banc != null) {

			try {

				PreparedStatement ps = conn.prepareStatement(UPDATE);
				ps.setString(1, bc.getNombre());
				ps.setString(2, banc.getNit());

				int resultado = ps.executeUpdate();

				if (resultado > 0) {
					res = true;
				}
				
				return res;

			} catch (SQLException e) {
				System.out.println("ERROR: datos no actualizados: " + e.getMessage());
			}

		} else {
			throw new ExcepcionesPersonalizadas("No se pobtuvieron datos del banco");
		}

		return res;
	}

	@Override
	public Banco obtenerBanco(Connection conn, String nit) {
		String FIND = "SELECT * FROM banco WHERE nit=?";

		try {

			PreparedStatement statement = conn.prepareStatement(FIND);
			statement.setString(1, nit);
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Banco banco = new Banco();
				banco.setNit(rs.getString("nit"));
				banco.setNombre(rs.getString("nombre_banco"));
				
				UsuarioRepoImpl usrimpl = new UsuarioRepoImpl();
				Usuario user = usrimpl.obtenerUsuario(conn, rs.getString("nombre_usuario"));
				
				banco.setNombre_usuario(user);

				return banco;
			}

		} catch (SQLException e) {
			System.out.println("Información no encontrada: " + e.getMessage());
		}
		return null;
	}
	
	public Banco obtenerBancoUser(Connection conn, String usern) {
		String FIND = "SELECT * FROM banco WHERE nombre_usuario=?";

		try {

			PreparedStatement statement = conn.prepareStatement(FIND);
			statement.setString(1, usern);
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Banco banco = new Banco();
				banco.setNit(rs.getString("nit"));
				banco.setNombre(rs.getString("nombre_banco"));
				
				UsuarioRepoImpl usrimpl = new UsuarioRepoImpl();
				Usuario user = usrimpl.obtenerUsuario(conn, rs.getString("nombre_usuario"));
				
				banco.setNombre_usuario(user);

				return banco;
			}

		} catch (SQLException e) {
			System.out.println("Información no encontrada: " + e.getMessage());
		}
		return null;
	}
	
	public List<Banco> obtenerBancoAll(Connection conn) {
		String SLECT = "SELECT * FROM banco";
		Statement stmt;
		List<Banco> bancos = new ArrayList<>();
		try {

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SLECT);
			
			while (rs.next()) {
				Banco banco = new Banco();
				banco.setNit(rs.getString("nit"));
				banco.setNombre(rs.getString("nombre_banco"));
				
				UsuarioRepoImpl usrimpl = new UsuarioRepoImpl();
				Usuario user = usrimpl.obtenerUsuario(conn, rs.getString("nombre_usuario"));
				
				banco.setNombre_usuario(user);
				bancos.add(banco);
				
			}
			return bancos;
		} catch (SQLException e) {
			System.out.println("Información no encontrada: " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean eliminar(Connection conn, String nit) {

		boolean listo = false;
		String DELETE = "DELETE FROM banco WHERE nit=?";

		try {

			PreparedStatement statement = conn.prepareStatement(DELETE);
			statement.setString(1, nit);

			int elimiandos = statement.executeUpdate();
			if (elimiandos > 0) {
				listo = true;
				System.out.println("Eliminado de forma correcta!");
			}

			return listo;

		} catch (SQLException e) {
			System.out.println("Error de inserción: " + e.getMessage());
		}

		return listo;
	}

}
