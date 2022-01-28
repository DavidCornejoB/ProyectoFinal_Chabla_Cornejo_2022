package ec.edu.ups.pw59.proyectofinal.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.PersonaONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

@Named
@RequestScoped
public class PersonasBean {
	
	@Inject
	private PersonaONLocal personaON;
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String direccion;
	private String pais;
	private String ciudad;
	private String tipo;
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String guardar() {
		
		System.out.println("GUARDANDO: " + this.nombre + " " + this.apellido);
		
		Persona p = new Persona();
		p.setCedula(this.cedula);
		p.setNombre(this.nombre);
		p.setApellido(this.apellido);
		p.setDireccion(this.direccion);
		p.setPais(this.pais);
		p.setCiudad(this.ciudad);
		p.setTipo(this.tipo);
		
		try {
			personaON.insert(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
