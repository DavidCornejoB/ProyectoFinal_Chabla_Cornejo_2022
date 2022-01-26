package ec.edu.ups.pw59.proyectofinal.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.PersonaONRemote;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

@Named
@RequestScoped
public class ClientesBean {

	//@Inject
	//private PersonaONRemote PersonaONR;
	
	private String cedula;
	
	private Persona persona = new Persona();
	
	private List<Persona> clientes;

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * @return the clientes
	 */
	public List<Persona> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<Persona> clientes) {
		this.clientes = clientes;
	}
	
	
	
}
