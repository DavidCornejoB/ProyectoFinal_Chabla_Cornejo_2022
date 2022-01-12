package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Servicio implements Serializable{
	
	@Id
	@Column(name = "ser_codigo")
	private int codigo;
	
	@Column(name = "ser_nombre")
	private String nombre;
	
	@Column(name = "ser_precio")
	private double precio;
	
	//@Column(name = "ser_hotel")
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	

}
