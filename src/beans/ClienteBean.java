package beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;

import modelo.Cliente;
import dao.impl.DAOCliente;
import exceptions.ClienteException;

/**
 * Session Bean implementation class ClienteBean
 */
/* La anotacion @ManagedBean especifica que esta clase sera usada como un bean. Con la anotacion @ManagedBean(name="cliente") especificariamos el nombre 
 * las anotaciones reemplazan la definicion del bean en el faces-cofig.xml
 * */
@SessionScoped
public class ClienteBean {
	private DAOCliente daoCliente = new DAOCliente();
	private String nombre;
	private Cliente cliente;
	private Cliente nuevoCliente = new Cliente();
	private ArrayList<Cliente> todosLosClientes = new ArrayList<Cliente>();
	private HtmlDataTable tablaTodosLosClientes;

	public ClienteBean() {

	}

	// busca un cliente en base a su nombre
	public String BuscarCliente() throws SQLException, ClienteException {
		this.cliente = daoCliente.buscarCliente(nombre);
		if (cliente.getNombre() == null) {
			//throw new ClienteException();
			return "clienteNoEncontrado";
		} else {
			return "clienteEncontrado";
		}

	}

	// obtiene todos los clientes
	public ArrayList<Cliente> getTodosLosClientes() throws SQLException {
		todosLosClientes = daoCliente.getTodosLosCLientes();
		return todosLosClientes;
	}

	// Actualiza un cliente
	public String actualizarCliente() throws SQLException {
		daoCliente.actualizarCliente(cliente.getRut(), cliente.getNombre(),
				cliente.getApellidoP(), cliente.getApellidoM(),
				cliente.getEmail());
		return "exito";
	}

	// Agrega un cliente
	public String agregarCliente() throws SQLException {
		daoCliente.agregarCliente(nuevoCliente.getRut(),
				nuevoCliente.getNombre(), nuevoCliente.getApellidoP(),
				nuevoCliente.getApellidoM(), nuevoCliente.getEmail());
		nuevoCliente = new Cliente();
		return "agregadoExitosamente";
	}

	// Elimina un cliente
	public String eliminarCliente() throws SQLException {
		cliente = (Cliente) tablaTodosLosClientes.getRowData();
		daoCliente.eliminaCliente(cliente.getRut());
		return "eliminadoExitosamente";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public String seleccionCliente() {
		cliente = (Cliente) tablaTodosLosClientes.getRowData();
		return "EditarCliente";
	}

	public Cliente getNuevoCliente() {
		return nuevoCliente;
	}

	public void setNuevoCliente(Cliente nuevoCliente) {
		this.nuevoCliente = nuevoCliente;
	}

}
