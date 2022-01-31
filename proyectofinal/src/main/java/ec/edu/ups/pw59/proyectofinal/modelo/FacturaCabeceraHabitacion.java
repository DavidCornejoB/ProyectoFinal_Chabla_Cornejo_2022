package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity //ETIQUETA DE PERSISTENCIA PARA INGRESAR ÉSTA CLASE COMO ENTIDAD DE LA BASE DE DATOS
public class FacturaCabeceraHabitacion implements Serializable{ //CLASE SERIALIZABLE

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id //ETIQUETA DE CLAVE PRIMARIA
	@GeneratedValue
	@Column(name = "facCabHab_numero") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private int numero;
	
	@Column(name = "facCabHab_fecha") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String fecha;
	
	//CONEXIÓN CON LA CLASE PERSONA
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="per_cedula")
	private Persona persona; //CLASE PERTENECIENTE A LA ENTIDAD RELACIONADA
	
	//RELACIÓN "ONE TO MANY" ENTRE ÉSTA ENTIDAD Y LA ENTIDAD "FACTURADETALLEHABITACION"
	@OneToMany(cascade = CascadeType.ALL) //ETIQUETA DE RELACIÓN ENTRE TABLAS
	@JoinColumn(name = "facCabHab_numero") //ESPECIFICAMOS LA ID CON LA QUE SE CONECTARÁ A LA OTRA TABLA
	private List<FacturaDetalleHabitacion> detallesHabitacion; //CLASE PERTENECIENTE A LA ENTIDAD RELACIONADA	
	
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
	public List<FacturaDetalleHabitacion> getDetallesHabitacion() {
		return detallesHabitacion;
	}
	public void setDetallesHabitacion(List<FacturaDetalleHabitacion> detallesHabitacion) {
		this.detallesHabitacion = detallesHabitacion;
	}
	
	//METODO PARA INSERTAR UN NUEVO DETALLE HABITACIÓN EN LA FACTURA
	public void addDetalleHabitacion(FacturaDetalleHabitacion detalleHabitacion) {
		if(detallesHabitacion == null) {
			detallesHabitacion = new ArrayList<FacturaDetalleHabitacion>();
		}
		detallesHabitacion.add(detalleHabitacion);
	}
	
}
