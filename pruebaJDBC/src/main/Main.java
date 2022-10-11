package main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import clases.Cliente;
import conexion.Conexion;

public class Main {

	public static void main(String[] args) throws SQLException {
		
			Connection conn = Conexion.getConexion();
			
			Cliente cl = new Cliente();
			Cliente d = new Cliente("Ever", "Vergara", "2453253", "3005242414444", Date.valueOf( LocalDate.of(2001, 10, 15)));
			d.setId(6);
			
			// Descomentar las lineas y ejecute, tenga en cuenta que deberá insertar registros y cambiar los valores de en el metodo eliminar, buscar y actualizar.
			
			cl.insertarCliente(conn, new Cliente("Ever", "", "100306", "3005242414444", Date.valueOf( LocalDate.of(2001, 10, 15))));
			//cl.listarClientes(conn);
			//cl.eliminarCliente(conn, 4);
			//cl.buscarCliente(conn, 5);
			//cl.actualizarCliente(conn, d);

			conn.close();
		
		
		
	}

}
