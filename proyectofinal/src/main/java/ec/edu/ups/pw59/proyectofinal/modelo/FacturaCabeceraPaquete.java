package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
/**
 * 
 * @author WilliamChabla
 *
 */
@Entity //ETIQUETA DE PERSISTENCIA PARA INGRESAR ÉSTA CLASE COMO ENTIDAD DE LA BASE DE DATOS
public class FacturaCabeceraPaquete implements Serializable{ //CLASE SERIALIZABLE
	
	private static final long serialVersionUID = 1L;
	
	@Id //ETIQUETA DE CLAVE PRIMARIA
	@GeneratedValue
	@Column(name = "FacCabPaq_numero") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private int numero;
	
	@Column(name = "FacCabPaq_fecha")
	private String fecha;
	
	//CONEXION CON LA CLASE PERSONA
	@OneToOne
	@JoinColumn(name ="per_cedula")
	private Persona persona; //CLASE PERTENECIENTE A LA ENTIDAD CON LA QUE SE RELACIONA
	
	//MÉTODOS GET() Y SET()
	/**
	 * 
	 * @return numero
	 */

	public int getNumero() {
		return numero;
	}
	/**
	 * 
	 * @param numero
	 */

	public void setNumero(int numero) {
		this.numero = numero;
	}
	/**
	 * 
	 * @return fecha
	 */

	public String getFecha() {
		return fecha;
	}
	/**
	 * 
	 * @param fecha
	 */

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * 
	 * @return persona
	 */

	public Persona getPersona() {
		return persona;
	}
	/**
	 * 
	 * @param persona
	 */

	public void setPersona(Persona persona) {
		this.persona = persona;
	}


}
