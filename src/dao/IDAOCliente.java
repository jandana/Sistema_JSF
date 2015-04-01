package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Cliente;

public interface IDAOCliente {
	public Cliente buscarCliente(String nombre) throws SQLException;

	public ArrayList<Cliente> getTodosLosCLientes() throws SQLException;

	public void actualizarCliente(int RUT, String nombre, String apellidoP,
			String apellidoM, String email) throws SQLException;

	public void agregarCliente(int RUT, String nombre, String apellidoP,
<<<<<<< HEAD
			String apellidoM, String email) throws SQLException;

	public void eliminaCliente(int RUT) throws SQLException;
=======
			String apellidoM, String email);

	public void eliminaCliente(int RUT);
>>>>>>> Sistema_JSF/master
}
