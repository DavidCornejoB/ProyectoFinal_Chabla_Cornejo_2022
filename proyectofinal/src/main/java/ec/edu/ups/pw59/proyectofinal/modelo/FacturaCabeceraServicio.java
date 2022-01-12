package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FacturaCabeceraServicio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "FacCabSer_numero")
	private int numero;
	
	@Column(name = "FacCabSer_fecha")
	private String fecha;
	
	@Column(name = "FacCabSer_persona")
	private Persona persona;
	
	private List<FacturaDetalleServicio> detallesServicio;

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

	public List<FacturaDetalleServicio> getDetallesServicio() {
		return detallesServicio;
	}

	public void setDetallesServicio(List<FacturaDetalleServicio> detallesServicio) {
		this.detallesServicio = detallesServicio;
	}

}
