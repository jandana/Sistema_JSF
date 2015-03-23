package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.IDAOController;

public class DAOController implements IDAOController {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://127.12.148.130:3306/SistemaEjemplo";
	public static final String USER = "root";
	public static final String PASSWORD = "";
	
	Connection con = null;
	
	@Override
	public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			// throw new DAOException(DAOException.IMPOSIBLE_FIND_DRIVER);
		}
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println(e);
			// throw new
			// DAOException(DAOException.IMPOSIBLE_ESTABLISH_CONNECTION);
		}
		return con;
	}

}
