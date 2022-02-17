package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author WilliamChabla
 * Servicio adicionales del hotel
 *
 */

@Entity //ETIQUETA DE PERSISTENCIA PARA INGRESAR ÉSTA CLASE COMO ENTIDAD DE LA BASE DE DATOS
public class Servicio implements Serializable{ //CLASE SERIALIZABLE

	private static final long serialVersionUID = 1L;

	@Id //ETIQUETA DE PERSISTENCIA PARA CLAVE PRIMARIA
	@GeneratedValue
	@Column(name = "ser_codigo") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private int codigo;
	
	@Column(name = "ser_nombre") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String nombre;
	
	@Column(name = "ser_precio") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private double precio;
	
	@ManyToOne
	@JoinColumn(name = "ho_codigo")
	private Hotel hotel; //CLASE PERTENECIENTE A LA ENTIDA CON LA QUE SE HACE RELACION
	
	//mETODOS GET() Y SET()
	/**
	 * 
	 * @return codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * 
	 * @param codigo
	 */

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * 
	 * @return nombre
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
	 * @return precio
	 */

	public double getPrecio() {
		return precio;
	}
	/**
	 * 
	 * @param precio
	 */

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
