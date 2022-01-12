package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FacturaDetalleHabitacion implements Serializable{
	
	@Id
	@Column(name = "FacDetHab_codigo")
	private int codigo;
	
	@Column(name = "FacDetHab_descuento")
	private double descuento;
	
	@Column(name = "FacDetHab_iva")
	private double iva;
	
	@Column(name = "FacDetHab_total")
	private double total;

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
	
	

}
