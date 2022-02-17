package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author WilliamChabla
 * Clase Persona
 */

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
	/**
	 * @return the codigo
	 */
	
	public String getCedula() {
		return cedula;
	}
	/**
	 * 
	 * @param cedula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * 
	 * @return apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * 
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * 
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * 
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * 
	 * @return pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * 
	 * @param pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * 
	 * @return ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * 
	 * @param ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * 
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * 
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
