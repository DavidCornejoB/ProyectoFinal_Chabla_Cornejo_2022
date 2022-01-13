package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class FacturaCabeceraPaquete implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "FacCabPaq_numero")
	private int numero;
	
	@Column(name = "FacCabPaq_fecha")
	private String fecha;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="per_cedula")
	private Persona persona;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="facCabHab_detallesPaquete")
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
