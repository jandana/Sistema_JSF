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
	public Cliente buscarCliente(String nombre) throws SQLException {
		Cliente cliente = new Cliente();
		DAOController dc = new DAOController();
		Connection con = dc.getConnection();
		try {
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

		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// throw new
				throw new SQLException(e.getMessage());
			}
		}
		return cliente;
	}

	@Override
	public ArrayList<Cliente> getTodosLosCLientes() throws SQLException {
		Cliente cliente;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		DAOController dc = new DAOController();
		Connection con = dc.getConnection();
		try {
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
			throw new SQLException(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new SQLException(e.getMessage());
			}
		}
		return clientes;
	}

	@Override
	public void actualizarCliente(int RUT, String nombre, String apellidoP,
			String apellidoM, String email) throws SQLException {
		DAOController dc = new DAOController();
		Connection con = dc.getConnection();

		try {
			PreparedStatement pstmt = con
					.prepareStatement("update cliente set nombre=?,apellidoPaterno=?, apellidoMaterno=?, email=? where RUT=?");

			pstmt.setString(1, nombre);
			pstmt.setString(2, apellidoP);
			pstmt.setString(3, apellidoM);
			pstmt.setString(4, email);
			pstmt.setInt(5, RUT);
			pstmt.executeUpdate();

		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new SQLException(e.getMessage());
			}
		}
	}

	@Override
	public void agregarCliente(int RUT, String nombre, String apellidoP,
			String apellidoM, String email) throws SQLException {
		DAOController dc = new DAOController();
		Connection con = dc.getConnection();

		try {
			PreparedStatement pstmt = con
					.prepareStatement("insert into cliente(RUT,nombre,apellidoPaterno,apellidoMaterno,email) VALUES (?,?,?,?,?)");

			pstmt.setInt(1, RUT);
			pstmt.setString(2, nombre);
			pstmt.setString(3, apellidoP);
			pstmt.setString(4, apellidoM);
			pstmt.setString(5, email);
			pstmt.executeUpdate();

		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new SQLException(e.getMessage());
			}
		}

	}

	@Override
<<<<<<< HEAD
	public void eliminaCliente(int RUT) throws SQLException {
=======
	public void eliminaCliente(int RUT) {
>>>>>>> Sistema_JSF/master
		DAOController dc = new DAOController();
		Connection con = dc.getConnection();

		try {
<<<<<<< HEAD
=======
			// setup statement and retrieve results
>>>>>>> Sistema_JSF/master
			PreparedStatement pstmt = con
					.prepareStatement("DELETE FROM cliente WHERE RUT=?");

			pstmt.setInt(1, RUT);
<<<<<<< HEAD
			pstmt.executeUpdate();

		} catch (Exception e) {
			throw new SQLException(e.getMessage());
=======

			int a = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

			// throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
>>>>>>> Sistema_JSF/master
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
<<<<<<< HEAD
				throw new SQLException(e.getMessage());
=======
				// throw new
				// DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
>>>>>>> Sistema_JSF/master
			}
		}
	}

	public static void main(String arrg[]) {
<<<<<<< HEAD
		// DAOCliente c = new DAOCliente();
=======
		DAOCliente c = new DAOCliente();
>>>>>>> Sistema_JSF/master
		// c.actualizarCliente(174580227, "javierga", "andana", "quijada",
		// F "dadasdada");
		// c.agregarCliente(123456789, "bart", "simpson", "bubie",
		// "bart@gmail.com");
<<<<<<< HEAD
		// c.eliminaCliente(123456789);
		// System.out.println("dadasdasd");
		// try {
		// System.out.println("Main");
		// c.buscarCliente("dasdadasd");
		// } catch (SQLException e) {
		// System.out.println(e.getMessage());
		// }

=======
		//c.eliminaCliente(123456789);
>>>>>>> Sistema_JSF/master
	}

}
