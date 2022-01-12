package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FacturaCabeceraHabitacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "facCabHab_numero")
	private int numero;
	
	@Column(name = "facCabHab_fecha")
	private String fecha;
	
	@Column(name = "facCabHab_persona")
	private Persona persona;
	
	private List<FacturaDetalleHabitacion> detallesHabitacion;
	
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
	
}
