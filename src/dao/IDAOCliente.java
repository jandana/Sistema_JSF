package dao;

import java.util.ArrayList;

import modelo.Cliente;

public interface IDAOCliente {
	public Cliente buscarCliente(String nombre);

	public ArrayList<Cliente> getTodosLosCLientes();

	public void actualizarCliente(int RUT, String nombre, String apellidoP,
			String apellidoM, String email);

	public void agregarCliente(int RUT, String nombre, String apellidoP,
			String apellidoM, String email);
}
