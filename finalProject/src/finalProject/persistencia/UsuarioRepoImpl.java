package finalProject.persistencia;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import finalProject.basedatos.Conexion;
import finalProject.excepxiones.ExcepcionesPersonalizadas;
import finalProject.modelo.Usuario;
import finalProject.repositorio.UsuarioRepo;

public class UsuarioRepoImpl implements UsuarioRepo{

	@Override
	public boolean agregar(Connection conn, Usuario user) {
		boolean respuesta = false;

		String INSERT = "INSERT INTO usuario (nombre_usuario, correo_usuario, contrasena_usuario, rol_usuario) VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setString(1, user.getNombre_usuario());
			ps.setString(2, user.getCorreo());
			ps.setString(3, user.getContraseña());
			ps.setString(4, String.valueOf(user.getRol()));

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
	public boolean actualizar(Connection conn, String username, Usuario us) throws ExcepcionesPersonalizadas {
		
		boolean res = false;
		String UPDATE = "UPDATE usuario SET correo_usuario=?, contrasena_usuario=?, rol_usuario=? WHERE nombre_usuario=?";

		Usuario user = obtenerUsuario(conn, username);
		if (user != null) {

			try {

				PreparedStatement ps = conn.prepareStatement(UPDATE);
				ps.setString(1, us.getCorreo());
				ps.setString(2, us.getContraseña());
				ps.setString(3, String.valueOf(us.getRol()));
				ps.setString(4, user.getNombre_usuario());

				int resultado = ps.executeUpdate();

				if (resultado > 0) {
					res = true;
				}
				
				return res;

			} catch (SQLException e) {
				System.out.println("ERROR: datos no actualizados: " + e.getMessage());
			}

		} else {
			throw new ExcepcionesPersonalizadas("No se pobtuvieron datos del usuario");
		}

		return res;
	}

	@Override
	public Usuario obtenerUsuario(Connection conn, String username) {

		String FIND = "SELECT * FROM usuario WHERE nombre_usuario=?";

		try {

			PreparedStatement statement = conn.prepareStatement(FIND);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Usuario user = new Usuario();
				user.setNombre_usuario(rs.getString("nombre_usuario"));
				user.setContraseña(rs.getString("contrasena_usuario"));
				user.setCorreo(rs.getString("correo_usuario"));
				user.setRol(Character.valueOf(rs.getString("rol_usuario").trim().charAt(0)));
				user.setHora_creacion(rs.getDate("hora_creacion"));
	
				return user;
			}

		} catch (SQLException e) {
			System.out.println("USUARIO -> Información no encontrada: " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean eliminar(Connection conn, String username) {
		boolean listo = false;
		String DELETE = "DELETE FROM usuario WHERE nombre_usuario=?";

		try {

			PreparedStatement statement = conn.prepareStatement(DELETE);
			statement.setString(1, username);

			int elimiandos = statement.executeUpdate();
			if (elimiandos > 0) {
				listo = true;
				System.out.println("Eliminado de forma correcta!");
			}

			return listo;

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}

		return listo;
	}
	
	public static Map<String, Usuario> iniciarSesion(String usuario, String contrasena){
		
		Map<String, Usuario> persistenciaUser = new HashMap<>();
		Connection conn = Conexion.getConexion();
		
		UsuarioRepoImpl USER = new UsuarioRepoImpl();
		Usuario us = USER.obtenerUsuario(conn, usuario);
		if(us!=null) {
			
			String pass = us.getContraseña();
			boolean coincidePass = pass.equals(contrasena);
			if(coincidePass) {
				persistenciaUser.put("USER", us);
			}
			
		}
		
		return persistenciaUser;
	}

}
