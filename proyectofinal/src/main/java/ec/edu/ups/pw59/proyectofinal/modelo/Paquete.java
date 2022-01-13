package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Paquete implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "paq_codigo")
	private int codigo;
	
	@Column(name = "paq_nombre")
	private String nombre;
	
	@Column(name = "paq_tipo")
	private String tipo;
	
	@Column(name = "paq_precio")
	private double precio;
	
	@ManyToOne
	@JoinColumn(name = "paq_habitacion")
	private Habitacion habitacion;
	
	@OneToOne
	@JoinColumn(name = "paq_servicio")
	private Servicio servicio;
	
	@OneToOne
	@JoinColumn(name = "paq_hotel")
	private Hotel hotel;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the habitacion
	 */
	public Habitacion getHabitacion() {
		return habitacion;
	}

	/**
	 * @param habitacion the habitacion to set
	 */
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	/**
	 * @return the servicio
	 */
	public Servicio getServicio() {
		return servicio;
	}

	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
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
