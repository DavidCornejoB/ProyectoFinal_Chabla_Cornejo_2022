package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "per_cedula")
	private String cedula;
	
	@Column(name = "per_nombre")
	private String nombre;
	
	@Column(name = "per_apellido")
	private String apellido;
	
	@Column(name = "per_direccion")
	private String direccion;
	
	@Column(name = "per_pais")
	private String pais;
	
	@Column(name = "per_ciudad")
	private String ciudad;
	
	@Column(name = "per_tipo")
	private String tipo;
	
	@JoinColumn(name = "per_login")
	private Login login;
	
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
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
	

}
