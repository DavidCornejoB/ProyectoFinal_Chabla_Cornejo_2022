package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity //ETIQUETA DE PERSISTENCIA PARA INGRESAR ÉSTA CLASE COMO ENTIDAD DE LA BASE DE DATOS
public class Persona implements Serializable{ //CLASE SERIALIZABLE
	
	private static final long serialVersionUID = 1L;
	
	@Id //ETIQUETA DE CLAVE PRIMARIA
	@Column(name = "per_cedula") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String cedula;
	
	@Column(name = "per_nombre") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String nombre;
	
	@Column(name = "per_apellido") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String apellido;
	
	@Column(name = "per_direccion") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String direccion;
	
	@Column(name = "per_pais") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String pais;
	
	@Column(name = "per_ciudad") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String ciudad;
	
	@Column(name = "per_tipo") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String tipo;
	
	//MÉTODOS GET() Y SET()
	
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

}
