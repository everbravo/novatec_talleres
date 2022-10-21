package finalProject.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import java.util.Random;

import finalProject.excepxiones.ExcepcionesPersonalizadas;
import finalProject.modelo.Cliente;
import finalProject.modelo.Cuenta;
import finalProject.reportes.ReporteClienteCuenta;
import finalProject.repositorio.CuentaRepo;

public class CuentaRepoImpl implements CuentaRepo{

	@Override
	public boolean agregar(Connection conn, Cuenta cuenta) {
		boolean respuesta = false;

		String INSERT = "INSERT INTO cuenta(numero_cuenta, saldo_cuenta, estado_cuenta, cedula) VALUES (?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setString(1, cuenta.getNumero_cuenta());
			ps.setDouble(2, cuenta.getSaldo());
			ps.setString(3, String.valueOf(cuenta.getEstado_cuenta()));
			ps.setString(4, cuenta.getCedula().getCedula());

			int resultado = ps.executeUpdate();

			if (resultado > 0) {
				respuesta = true;
			}

		} catch (SQLException e) {
			System.out.println("CUENTA::SQL Error -> " + e.getMessage());
		}

		return respuesta;
	}

	@Override
	public List<Cuenta> obtener(Connection conn, String cedula) {
		ClienteRepoImpl clrimpl = new ClienteRepoImpl();
		Statement stmt;
		List<Cuenta> lc = new ArrayList<>();
		
		String SLECT = "SELECT c.numero_cuenta, c.estado_cuenta, c.saldo_cuenta, c.cedula FROM cuenta c WHERE c.cedula="+cedula;

		try {

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SLECT);
			
			while (rs.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setNumero_cuenta(rs.getString("numero_cuenta"));
				cuenta.setEstado_cuenta(rs.getString("estado_cuenta").trim().charAt(0));
				cuenta.setSaldo(rs.getDouble("saldo_cuenta"));
				
				Cliente cli = clrimpl.obtenerCliente(conn, rs.getString("cedula"));
				
				cuenta.setCedula(cli);
				
				lc.add(cuenta);
			}
			
			return lc;

		} catch (SQLException e) {
			System.out.println("CUENTA::Información no encontrada: " + e.getMessage());
		}
		return lc;
	}

	public List<ReporteClienteCuenta> obtenerAll(Connection conn) {
		ClienteRepoImpl clrimpl = new ClienteRepoImpl();
		Statement stmt;
		List<ReporteClienteCuenta> lc = new ArrayList<>();
		
		String SLECT = "SELECT * from cuenta";

		try {

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SLECT);
			
			while (rs.next()) {
				ReporteClienteCuenta rcc = new ReporteClienteCuenta(); 
				rcc.setValor(rs.getDouble("saldo_cuenta"));
				rcc.setCuenta(rs.getString("numero_cuenta"));
				
				Cliente cli = clrimpl.obtenerCliente(conn, rs.getString("cedula"));
				rcc.setNombre(cli.getNombre());
				rcc.setCedula(cli.getCedula());
				
				lc.add(rcc);
			}
			
			return lc;

		} catch (SQLException e) {
			System.out.println("CUENTA::Información no encontrada: " + e.getMessage());
		}
		return lc;
	}
	
	@Override
	public boolean actualizar(Connection conn, Cuenta cuenta, String numero) throws ExcepcionesPersonalizadas {
		ClienteRepoImpl clrimpl = new ClienteRepoImpl();
		
		boolean res = false;
		String UPDATE = "UPDATE cuenta SET saldo_cuenta=? WHERE numero_cuenta=?";

		Cuenta cuent = obtenerCuenta(conn, numero);
		Cliente client = clrimpl.obtenerCliente(conn, cuenta.getCedula().getCedula());
		
		if (cuent != null && client != null) {

			try {

				PreparedStatement ps = conn.prepareStatement(UPDATE);
				ps.setDouble(1, cuenta.getSaldo());
				ps.setString(2, numero);

				int resultado = ps.executeUpdate();

				if (resultado > 0) {
					res = true;
				}
				
				return res;

			} catch (SQLException e) {
				System.out.println("CUENTA -> ERROR: datos no actualizados: " + e.getMessage());
			}

		} else {
			throw new ExcepcionesPersonalizadas("No se pobtuvieron datos de la cuenta");
		}

		return res;
	}

	@Override
	public Cuenta obtenerCuenta(Connection conn, String numero) {
		ClienteRepoImpl clrimpl = new ClienteRepoImpl();
		
		String FIND = "SELECT * FROM cuenta WHERE numero_cuenta=? AND estado_cuenta =?";

		try {

			PreparedStatement statement = conn.prepareStatement(FIND);
			statement.setString(1, numero);
			statement.setString(2, "A");
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setNumero_cuenta(rs.getString("numero_cuenta"));
				cuenta.setSaldo(rs.getDouble("saldo_cuenta"));
				cuenta.setEstado_cuenta(rs.getString("estado_cuenta").trim().charAt(0));
				
				Cliente client = clrimpl.obtenerCliente(conn, rs.getString("cedula"));
				
				cuenta.setCedula(client);
				
				return cuenta;
			}

		} catch (SQLException e) {
			System.out.println("CUENTA::Información no encontrada: " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean eliminar(Connection conn, String cuenta) {
		boolean listo = false;
		
		String UPDATE = "UPDATE cuenta SET estado_cuenta=? WHERE numero_cuenta=?";

			try {

				PreparedStatement ps = conn.prepareStatement(UPDATE);
				ps.setString(1, String.valueOf("I"));
				ps.setString(2, cuenta);

				int resultado = ps.executeUpdate();

				if (resultado > 0) {
					listo = true;
				}
				
				return listo;

			} catch (SQLException e) {
				System.out.println("CUENTA -> ERROR: datos no actualizados: " + e.getMessage());
			}


		return listo;
	}

	
	public static String generarNumeroCuenta() {
		
		String parte1 = String.valueOf((int)(100000 * Math.random()));
		String parte2 = String.valueOf((int)(100000 * Math.random()));
		/*
		Random random = new Random();
	    String contrasenia = "";
	    for (int i = 0; i < 10; i++){
	        contrasenia += (char) (random.nextInt(94)+33);
	    }
	    System.out.println(contrasenia);
		*/
		String numero = parte2 + parte1;
		if(numero.length() == 10) {
			return numero;
		}else {
			return generarNumeroCuenta();
		}
	}
	
	public static boolean existeCuenta(Connection conn, String numero) {
		
		String FIND = "SELECT * FROM cuenta WHERE numero_cuenta=?";

		try {

			PreparedStatement statement = conn.prepareStatement(FIND);
			statement.setString(1, numero);
			
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println("CUENTA:Numero:Información no encontrada: " + e.getMessage());
		}
		return false;
	}
	

	
}
