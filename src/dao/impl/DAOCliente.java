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
				cliente.setRut(rs.getInt("RUT"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellidoP(rs.getString("apellidoPaterno"));
				cliente.setApellidoM(rs.getString("apellidoMaterno"));
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

	@Override
	public void actualizarCliente(int RUT, String nombre, String apellidoP,
			String apellidoM, String email) {
		DAOController dc = new DAOController();
		Connection con = dc.getConnection();

		try {
			// setup statement and retrieve results
			PreparedStatement pstmt = con
					.prepareStatement("update cliente set nombre=?,apellidoPaterno=?, apellidoMaterno=?, email=? where RUT=?");
			
			pstmt.setString(1, nombre);
			pstmt.setString(2, apellidoP);
			pstmt.setString(3, apellidoM);
			pstmt.setString(4, email);
			pstmt.setInt(5, RUT);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

			// throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// throw new
				// DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
			}
		}
	}

//	public static void main(String arrg[]) {
//		DAOCliente c = new DAOCliente();
//		c.actualizarCliente(174580227,"javierga","andana","quijada","dadasdada");
//	}

}
