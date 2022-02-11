package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity //ETIQUETA DE PERSISTENCIA PARA INGRESAR ÉSTA CLASE COMO ENTIDAD DE LA BASE DE DATOS
public class FacturaCabeceraHabitacion implements Serializable{ //CLASE SERIALIZABLE

	private static final long serialVersionUID = 1L;

	@Id //ETIQUETA DE CLAVE PRIMARIA
	@Column(name = "facCabHab_numero") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private int numero;
	
	@Column(name = "facCabHab_fecha") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String fecha;
	
	//CONEXIÓN CON LA CLASE PERSONA
	@OneToOne
	@JoinColumn(name ="per_cedula")
	private Persona persona; //CLASE PERTENECIENTE A LA ENTIDAD RELACIONADA
	
	//MÉTODOS GET() Y SET()
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
