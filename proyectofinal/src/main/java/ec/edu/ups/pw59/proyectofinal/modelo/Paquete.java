package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Paquete implements Serializable{
	
	@Id
	@Column(name = "paq_codigo")
	private int codigo;
	
	@Column(name = "paq_nombre")
	private String nombre;
	
	@Column(name = "paq_tipo")
	private String tipo;
	
	@Column(name = "paq_precio")
	private double precio;
	
	//@Column(name = "paq_habitacion")
	//private Habitacion habitacion;
	
	//@Column(name = "paq_servicio")
	//private Servicio servicio;
	
	//@Column(name = "paq_hotel")
	//private Hotel hotel;
	
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

}
