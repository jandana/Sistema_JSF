package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Cliente;
import dao.IDAOCliente;

public class DAOCliente implements IDAOCliente {

	@Override
	public Cliente buscarCliente(String nombre) {
		Cliente cliente = new Cliente();
		DAOController dc = new DAOController();
		Connection con = dc.getConnection();
		try {
			// setup statement and retrieve results
			PreparedStatement pstmt = con
					.prepareStatement("select * from cliente where nombre = ?");
			pstmt.setString(1, nombre);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellidoP(rs.getString("apellidoPaterno"));
				cliente.setApellidoM(rs.getString("apellidoMaterno"));
				cliente.setRut(rs.getInt("RUT"));
				cliente.setEmail(rs.getString("email"));

			}

		} catch (Exception e) {
			e.printStackTrace();

			// throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
		} finally {
			try {
				con.close();
				// } catch (SQLException e) {
			} catch (SQLException e) {
				// throw new
				// DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
			}
		}
		return cliente;
	}

	@Override
	public ArrayList<Cliente> getTodosLosCLientes() {
		Cliente cliente;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		DAOController dc = new DAOController();
		Connection con = dc.getConnection();
		try {
			// setup statement and retrieve results
			PreparedStatement pstmt = con
					.prepareStatement("select * from cliente");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				cliente = new Cliente();
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellidoP(rs.getString("apellidoPaterno"));
				cliente.setApellidoM(rs.getString("apellidoMaterno"));
				cliente.setRut(rs.getInt("RUT"));
				cliente.setEmail(rs.getString("email"));
				clientes.add(cliente);
			}

		} catch (Exception e) {
			e.printStackTrace();

			// throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
		} finally {
			try {
				con.close();
				// } catch (SQLException e) {
			} catch (SQLException e) {
				// throw new
				// DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
			}
		}
		return clientes;
	}

}
