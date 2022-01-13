package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity //ETIQUETA DE PERSISTENCIA PARA INGRESAR ÉSTA CLASE COMO ENTIDAD DE LA BASE DE DATOS
public class FacturaDetalleServicio implements Serializable{ //CLASE SERIALIZABLE
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id //ETIQUETA DE CLAVE PRIMARIA
	@Column(name = "FacDetSer_codigo") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private int codigo;
	
	@Column(name = "FacDetSer_descuento") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private double descuento;
	
	@Column(name = "FacDetSer_iva") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private double iva;
	
	@Column(name = "FacDetSer_total") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private double total;
	
	//RELACIÓN "ONE TO ONE" ENTRE ESTA ENTIDAD Y LA ENTIDAD "SERVICIO"
	@OneToOne //ETIQUETA DE RELACION ENTRE ENTIDADES
	@JoinColumn(name= "FactDetSer_servicio") //ENTIDAD CON LA QUE SE HACE LA RELACIÓN
	private Servicio servicio; //CLASE PERTENECIENTE A LA ENTIDAD CON LA QUE SE HACE LA RELACION
	
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
	 * @return the servicio
	 */
	public Servicio getServicio() {
		return servicio;
	}

	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}
