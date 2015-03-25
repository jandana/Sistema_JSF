package beans;

import java.util.ArrayList;

import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;

import dao.impl.DAOCliente;
import modelo.Cliente;

/**
 * Session Bean implementation class ClienteBean
 */

@SessionScoped
public class ClienteBean {
	private DAOCliente daoCliente = new DAOCliente();
	private String nombre;
	private Cliente cliente;
	private ArrayList<Cliente> todosLosClientes;
	private HtmlDataTable tablaTodosLosClientes;

	public ClienteBean() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String BuscarCliente() {
		this.cliente = daoCliente.buscarCliente(nombre);

		if (cliente.getNombre() == null) {
			return "clienteNoEncontrado";
		} else {
			return "clienteEncontrado";
		}

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Cliente> getTodosLosClientes() {

		return todosLosClientes = daoCliente.getTodosLosCLientes();
	}

	public void setTodosLosClientes(ArrayList<Cliente> todosLosClientes) {
		this.todosLosClientes = todosLosClientes;
	}

	public HtmlDataTable getTablaTodosLosClientes() {
		return tablaTodosLosClientes;
	}

	public void setTablaTodosLosClientes(HtmlDataTable tablaTodosLosClientes) {
		this.tablaTodosLosClientes = tablaTodosLosClientes;
	}

}
