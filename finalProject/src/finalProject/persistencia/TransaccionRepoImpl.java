package finalProject.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import finalProject.basedatos.Conexion;
import finalProject.excepxiones.ExcepcionesPersonalizadas;
//import finalProject.excepxiones.ExcepcionesPersonalizadas;
import finalProject.modelo.Cuenta;
import finalProject.modelo.Transaccion;
import finalProject.repositorio.TransaccionRepo;

public class TransaccionRepoImpl implements TransaccionRepo{

	@Override
	public boolean agregar(Connection conn, Transaccion transac) {
		boolean respuesta = false;

		String INSERT = "INSERT INTO transaccion(estado_transaccion, desc_transaccion, numero_cuenta, monto) VALUES (?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setString(1, String.valueOf(transac.getEstado_transaccion()));
			ps.setString(2, transac.getDesc_transaccion());
			ps.setString(3, transac.getNumero_cuenta().getNumero_cuenta());
			ps.setDouble(4, transac.getMonto());

			int resultado = ps.executeUpdate();

			if (resultado > 0) {
				respuesta = true;
			}

		} catch (SQLException e) {
			System.out.println("TRANSACCION::SQL Error -> " + e.getMessage());
		}

		return respuesta;
	}

	@Override
	public List<Transaccion> obtener(Connection conn) {
		CuentaRepoImpl crimpl = new CuentaRepoImpl();
		Statement stmt;
		List<Transaccion> lt = new ArrayList<>();
		
		String SLECT = "SELECT * FROM transaccion";

		try {

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SLECT);
			
			while (rs.next()) {
				Transaccion trans = new Transaccion();
				trans.setTransaccion(rs.getInt("id_transaccion"));
				trans.setDesc_transaccion(rs.getString("desc_transaccion"));
				trans.setEstado_transaccion(rs.getString("estado_transaccion").trim().charAt(0));
				trans.setFecha_transaccion(rs.getDate("fecha_transaccion"));
				trans.setMonto(rs.getDouble("monto"));
				
				Cuenta cli = crimpl.obtenerCuenta(conn, rs.getString("numero_cuenta"));
				trans.setNumero_cuenta(cli);
				
				lt.add(trans);
			}
			
			return lt;

		} catch (SQLException e) {
			System.out.println("TRANSACCION::Información no encontrada: " + e.getMessage());
		}
		return lt;
	}

	/*@Override
	public boolean actualizar(Connection conn, Transaccion transc, int id) throws ExcepcionesPersonalizadas {
		CuentaRepoImpl crimpl = new CuentaRepoImpl();
		
		boolean res = false;
		String UPDATE = "UPDATE transaccion SET fecha_transaccion=?,estado_transaccion=?,desc_transaccion=?,numero_cuenta=?,  WHERE id_transaccion=?";

		Transaccion transac = obtenerTransaccion(conn, id);
		Cuenta cuenta = crimpl.obtenerCuenta(conn, transc.getNumero_cuenta().getNumero_cuenta());
		
		if (transac != null && cuenta != null) {

			try {

				PreparedStatement ps = conn.prepareStatement(UPDATE);
				ps.setDate(1, transc.getFecha_transaccion());
				ps.setString(2, String.valueOf(transc.getEstado_transaccion()));
				ps.setString(3, transc.getDesc_transaccion());
				ps.setString(4, cuenta.getNumero_cuenta());
				ps.setInt(5, transac.getTransaccion());

				int resultado = ps.executeUpdate();

				if (resultado > 0) {
					res = true;
				}
				
				return res;

			} catch (SQLException e) {
				System.out.println("TRANSACCION -> ERROR: datos no actualizados: " + e.getMessage());
			}

		} else {
			throw new ExcepcionesPersonalizadas("No se pobtuvieron datos de la transaccion");
		}

		return res;
	}*/

	@Override
	public List<Transaccion> obtenerTransaccion(Connection conn, String cuenta) {
		CuentaRepoImpl crimpl = new CuentaRepoImpl();
		List<Transaccion> tr = new ArrayList<>();
		
		String FIND = "SELECT * FROM transaccion WHERE numero_cuenta=?";

		try {

			PreparedStatement statement = conn.prepareStatement(FIND);
			statement.setString(1, cuenta);
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Transaccion trans = new Transaccion();
				trans.setTransaccion(rs.getInt("id_transaccion"));
				trans.setDesc_transaccion(rs.getString("desc_transaccion"));
				trans.setEstado_transaccion(rs.getString("estado_transaccion").trim().charAt(0));
				trans.setFecha_transaccion(rs.getDate("fecha_transaccion"));
				trans.setNumero_cuenta(crimpl.obtenerCuenta(conn, rs.getString("numero_cuenta")));
				trans.setMonto(rs.getDouble("monto"));
				
				tr.add(trans);
			}
			return tr;
		} catch (SQLException e) {
			System.out.println("TRANSACCION::Información no encontrada: " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean eliminar(Connection conn, int id) {
		boolean listo = false;
		
		String UPDATE = "UPDATE transaccion SET estado_transaccion=? WHERE id_transaccion=?";

			try {

				PreparedStatement ps = conn.prepareStatement(UPDATE);
				ps.setString(1, String.valueOf("I"));
				ps.setInt(2, id);

				int resultado = ps.executeUpdate();

				if (resultado > 0) {
					listo = true;
				}
				
				return listo;

			} catch (SQLException e) {
				System.out.println("TRANSACCION -> ERROR: datos no actualizados: " + e.getMessage());
			}


		return listo;
	}

	
	public static boolean verificarCriterioTransaccionRetiro(String numeroCuenta, Double monto) {
		
		boolean resul = false;
		Connection conn  = Conexion.getConexion();
		CuentaRepoImpl CUENTA = new CuentaRepoImpl();
		
		Cuenta cuentaOne = CUENTA.obtenerCuenta(conn, numeroCuenta);
		if(cuentaOne != null) {
			Double saldoActual = cuentaOne.getSaldo();
			Double saldoPostTrans = saldoActual - ((monto < 0)?-monto:monto);
			if(saldoPostTrans >= 5) {
				resul = true;
				cuentaOne.setSaldo(saldoPostTrans);
				try {
					boolean actualizada = CUENTA.actualizar(conn, cuentaOne, numeroCuenta);
					
					if(actualizada) {
						
						TransaccionRepoImpl trimpl = new TransaccionRepoImpl();
						boolean crearTrans = trimpl.agregar(conn, new Transaccion('A', "Retiro de dinero", cuentaOne, monto));
						
						if(!crearTrans) {
							conn.rollback();
						}
						
					}else {
						System.out.println("Error al procesar la transacción!");
					}
					
				} catch (ExcepcionesPersonalizadas | SQLException e) {
					System.out.println(e.getMessage());
				}
				
			}else {
				System.out.println("Saldo insuficiente...");
			}
			return resul;
			
		}else {
			System.out.println("Error al procesar la solicitud");
		}
		
		return resul;
	}

	
	public static boolean ingresarDineroCuenta(String numeroCuenta, Double monto) {
		boolean resul = false;
		Connection conn  = Conexion.getConexion();
		CuentaRepoImpl CUENTA = new CuentaRepoImpl();
		
		Cuenta cuentaOne = CUENTA.obtenerCuenta(conn, numeroCuenta);
		if(cuentaOne != null) {
			Double saldoActual = cuentaOne.getSaldo();
			Double saldoPostTrans = saldoActual + ((monto < 0)?-monto:monto);
			if(saldoPostTrans > 0) {
				resul = true;
				cuentaOne.setSaldo(saldoPostTrans);
				try {
					boolean actualizada = CUENTA.actualizar(conn, cuentaOne, numeroCuenta);
					
					if(actualizada) {
						
						TransaccionRepoImpl trimpl = new TransaccionRepoImpl();
						boolean crearTrans = trimpl.agregar(conn, new Transaccion('A', "Ingreso de dinero", cuentaOne, monto));
						
						if(!crearTrans) {
							conn.rollback();
						}
						
					}else {
						System.out.println("Error al procesar la transacción!");
					}
					
				} catch (ExcepcionesPersonalizadas | SQLException e) {
					System.out.println(e.getMessage());
				}
				
			}else {
				System.out.println("Monto no permitido...");
			}
			return resul;
			
		}else {
			System.out.println("Error al procesar la solicitud");
		}
		
		return resul;
	}
	
}
