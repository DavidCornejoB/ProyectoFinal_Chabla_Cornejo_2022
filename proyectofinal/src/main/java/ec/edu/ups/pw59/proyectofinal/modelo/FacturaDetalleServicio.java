package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity //ETIQUETA DE PERSISTENCIA PARA INGRESAR ÉSTA CLASE COMO ENTIDAD DE LA BASE DE DATOS
public class FacturaDetalleServicio implements Serializable{ //CLASE SERIALIZABLE
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id //ETIQUETA DE CLAVE PRIMARIA
	@GeneratedValue
	@Column(name = "FacDetSer_codigo") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private int codigo;
	
	@Column(name = "FacDetSer_descuento") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private double descuento;
	
	@Column(name = "FacDetSer_iva") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private double iva;
	
	@Column(name = "FacDetSer_total") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private double total;
	
	@ManyToOne
	@JoinColumn(name = "FacCabSer_numero")
	private FacturaCabeceraServicio facturaCabeceraServicio;
	
	//RELACIÓN "ONE TO ONE" ENTRE ESTA ENTIDAD Y LA ENTIDAD "SERVICIO"
	@ManyToOne //ETIQUETA DE RELACION ENTRE ENTIDADES
	@JoinColumn(name = "ser_codigo") //ENTIDAD CON LA QUE SE HACE LA RELACIÓN
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

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public FacturaCabeceraServicio getFacturaCabeceraServicio() {
		return facturaCabeceraServicio;
	}

	public void setFacturaCabeceraServicio(FacturaCabeceraServicio facturaCabeceraServicio) {
		this.facturaCabeceraServicio = facturaCabeceraServicio;
	}

}
