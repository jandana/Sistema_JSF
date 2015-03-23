package beans;

import javax.faces.bean.SessionScoped;

import dao.impl.DAOCliente;
import modelo.Cliente;
import java.io.Serializable;
/**
 * Session Bean implementation class ClienteBean
 */



import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;


@SessionScoped
public class ClienteBean {
	private DAOCliente daoCliente = new DAOCliente();
	private String nombre;
	private Cliente cliente;

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
		System.out.println("dadsad");
		return "resultado";

	}

	public DAOCliente getDaoCliente() {
		return daoCliente;
	}

	public void setDaoCliente(DAOCliente daoCliente) {
		this.daoCliente = daoCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
