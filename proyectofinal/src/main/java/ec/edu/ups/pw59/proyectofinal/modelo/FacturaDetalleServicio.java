package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 * 
 * @author WilliamChabla
 * Factura detalle de los servicios solicitados
 */
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
	/**
	 * 
	 * @return codigo
	 */

	public int getCodigo() {
		return codigo;
	}
	/**
	 * 
	 * @param codigo
	 */

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * 
	 * @return descuento
	 */

	public double getDescuento() {
		return descuento;
	}
	/**
	 * 
	 * @param descuento
	 */

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	/**
	 * 
	 * @return iva
	 */

	public double getIva() {
		return iva;
	}
	/**
	 * 
	 * @param iva
	 */

	public void setIva(double iva) {
		this.iva = iva;
	}
	/**
	 * 
	 * @return total
	 */

	public double getTotal() {
		return total;
	}
	/**
	 * 
	 * @param total
	 */

	public void setTotal(double total) {
		this.total = total;
	}
	/**
	 * 
	 * @return servicio
	 */

	public Servicio getServicio() {
		return servicio;
	}
	/**
	 * 
	 * @param servicio
	 */

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	/**
	 * 
	 * @return FacturaCabeceraServicio
	 */

	public FacturaCabeceraServicio getFacturaCabeceraServicio() {
		return facturaCabeceraServicio;
	}
	/**
	 * 
	 * @param facturaCabeceraServicio
	 */

	public void setFacturaCabeceraServicio(FacturaCabeceraServicio facturaCabeceraServicio) {
		this.facturaCabeceraServicio = facturaCabeceraServicio;
	}

}
