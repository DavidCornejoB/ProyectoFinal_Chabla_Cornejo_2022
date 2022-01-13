package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class FacturaDetallePaquete implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "FacDetPaq_codigo")
	private int codigo;
	
	@Column(name = "FacDetPaq_descuento")
	private double descuento;
	
	@Column(name = "FacDetPaq_iva")
	private double iva;
	
	@Column(name = "FacDetPaq_total")
	private double total;
	
	@OneToOne
	@JoinColumn(name= "FactDetPaq_paquete")
	private Paquete paquete;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return the paquete
	 */
	public Paquete getPaquete() {
		return paquete;
	}

	/**
	 * @param paquete the paquete to set
	 */
	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

}
