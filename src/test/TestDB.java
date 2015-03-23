package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Cliente;



public class TestDB {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/SistemaEjemplo";
	public static final String USER = "root";
	public static final String PASSWORD = "";

	public static void main(String[] args) throws Exception {
		Connection con =  TestDB.getConnection();
		Cliente cliente = new Cliente();

		try {
			// setup statement and retrieve results
			PreparedStatement pstmt =  con.prepareStatement("select * from cliente where nombre = ?");
			pstmt.setString(1, "javier");
			ResultSet rs = pstmt.executeQuery();

			// create the transfer object using data from rs
			while (rs.next()) {
				cliente.setRut(rs.getInt("RUT"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellidoP(rs.getString("apellidopaterno"));
				cliente.setApellidoM(rs.getString("apellidomaterno"));
				cliente.setEmail(rs.getString("email"));

			}
			System.out.println(cliente.toString());

		} catch (Exception e) {
		
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}

	}

	public static java.sql.Connection getConnection() throws Exception {

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

		}
		try {
			conn = DriverManager.getConnection(URL, USER,
					PASSWORD);
		} catch (SQLException e) {
			System.out.println(e);

		}
		return conn;
	}
}
