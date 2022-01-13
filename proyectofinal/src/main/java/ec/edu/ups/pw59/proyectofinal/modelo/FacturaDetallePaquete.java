package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity //ETIQUETA DE PERSISTENCIA PARA INGRESAR ÉSTA CLASE COMO ENTIDAD DE LA BASE DE DATOS
public class FacturaDetallePaquete implements Serializable{ //CLASE SERIALIZABLE
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id //ETIQUETA DE CLAVE PRIMARIA
	@Column(name = "FacDetPaq_codigo") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private int codigo;
	
	@Column(name = "FacDetPaq_descuento") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private double descuento;
	
	@Column(name = "FacDetPaq_iva") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private double iva;
	
	@Column(name = "FacDetPaq_total") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private double total;
	
	//RELACIÓN "ONE TO ONE" ENTRE ÉSTA ENTIDAD Y LA ENTIDAD "PAQUETE"
	@OneToOne //ETIQUETA DE RELACIÓN ENTRE ENTIDADES
	@JoinColumn(name= "FactDetPaq_paquete") //ENTIDAD CON LA QUE SE RELACIONA
	private Paquete paquete; //CLASE PERTENECIENTE A LA ENTIDAD CON LA QUE SE RELACIONA
	
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
