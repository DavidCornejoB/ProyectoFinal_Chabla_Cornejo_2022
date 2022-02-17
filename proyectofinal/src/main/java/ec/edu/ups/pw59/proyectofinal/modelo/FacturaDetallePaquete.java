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
 * Factura Detalle de los paquetes turisticos
 *
 */
@Entity //ETIQUETA DE PERSISTENCIA PARA INGRESAR ÉSTA CLASE COMO ENTIDAD DE LA BASE DE DATOS
public class FacturaDetallePaquete implements Serializable{ //CLASE SERIALIZABLE

	private static final long serialVersionUID = 1L;

	@Id //ETIQUETA DE CLAVE PRIMARIA
	@GeneratedValue
	@Column(name = "FacDetPaq_codigo") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private int codigo;
	
	@Column(name = "FacDetPaq_descuento") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private double descuento;
	
	@Column(name = "FacDetPaq_iva") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private double iva;
	
	@Column(name = "FacDetPaq_total") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private double total;
	
	@ManyToOne
	@JoinColumn(name = "FacCabPaq_numero")
	private FacturaCabeceraPaquete facturaCabeceraPaquete;
	
	//RELACIÓN "MANY TO ONE" ENTRE ÉSTA ENTIDAD Y LA ENTIDAD "PAQUETE"
	@ManyToOne //ETIQUETA DE RELACIÓN ENTRE ENTIDADES
	@JoinColumn(name= "paq_codigo") //ENTIDAD CON LA QUE SE RELACIONA
	private Paquete paquete; //CLASE PERTENECIENTE A LA ENTIDAD CON LA QUE SE RELACIONA
	
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

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	/**
	 * 
	 * @return Iva
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
	 * @return paquete
	 */

	public Paquete getPaquete() {
		return paquete;
	}
	/**
	 * 
	 * @param paquete
	 */

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}
	/**
	 * 
	 * @return FacturaCabeceraPaquete
	 */

	public FacturaCabeceraPaquete getFacturaCabeceraPaquete() {
		return facturaCabeceraPaquete;
	}
	/**
	 * 
	 * @param facturaCabeceraPaquete
	 */

	public void setFacturaCabeceraPaquete(FacturaCabeceraPaquete facturaCabeceraPaquete) {
		this.facturaCabeceraPaquete = facturaCabeceraPaquete;
	}

}
