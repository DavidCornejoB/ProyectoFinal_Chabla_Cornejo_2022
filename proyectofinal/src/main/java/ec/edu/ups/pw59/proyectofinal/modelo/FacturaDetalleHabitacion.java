package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity //ETIQUETA DE PERSISTENCIA PARA INGRESAR ÉSTA CLASE COMO ENTIDAD DE LA BASE DE DATOS
public class FacturaDetalleHabitacion implements Serializable{ //CLASE SERIALIZABLE
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id //ETIQUETA DE CLAVE PRIMARIA
	@Column(name = "FacDetHab_codigo") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private int codigo;
	
	@Column(name = "FacDetHab_descuento")
	private double descuento;
	
	@Column(name = "FacDetHab_iva")
	private double iva;
	
	@Column(name = "FacDetHab_total")
	private double total;
	
	//RELACIÓN ONE TO ONE ENTRE ÉSTA ENTIDAD Y LA ENTIDAD "RESERVA"
	@OneToOne
	@JoinColumn(name= "FacDetHab_reserva") //ENTIDAD CON LA QUE SE RELACIONA
	private Reserva reserva; //CLASE PERTENECIENTE A LA ENTIDAD CON LA QUE SE RELACIONA
	
	//MÉTODOS GET() Y SET()

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
	 * @return the reserva
	 */
	public Reserva getReserva() {
		return reserva;
	}

	/**
	 * @param reserva the reserva to set
	 */
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
}
