package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FacturaCabeceraPaquete implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "FacCabPaq_numero")
	private int numero;
	
	@Column(name = "FacCabPaq_fecha")
	private String fecha;
	
	@Column(name = "FacCabPaq_persona")
	private Persona persona;
	
	private List<FacturaDetallePaquete> detallesPaquete;

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

	public List<FacturaDetallePaquete> getDetallesPaquete() {
		return detallesPaquete;
	}

	public void setDetallesPaquete(List<FacturaDetallePaquete> detallesPaquete) {
		this.detallesPaquete = detallesPaquete;
	}

}
