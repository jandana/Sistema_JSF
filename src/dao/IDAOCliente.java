package dao;

import java.util.ArrayList;

import modelo.Cliente;

public interface IDAOCliente {
	public  Cliente buscarCliente(String nombre);
	public ArrayList<Cliente> getTodosLosCLientes();
}
