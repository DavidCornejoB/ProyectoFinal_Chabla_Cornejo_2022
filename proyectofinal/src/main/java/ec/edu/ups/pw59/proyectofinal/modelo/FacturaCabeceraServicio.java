package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity //ETIQUETA DE PERSISTENCIA PARA INGRESAR ÉSTA CLASE COMO ENTIDAD DE LA BASE DE DATOS
public class FacturaCabeceraServicio implements Serializable{ //CLASE SERIALIZABLE
	
	private static final long serialVersionUID = 1L;
	
	@Id //ETIQUETA DE CLAVE PRIMARIA
	@Column(name = "FacCabSer_numero") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private int numero;
	
	@Column(name = "FacCabSer_fecha")
	private String fecha;
	
	//CONEXION CON LA CLASE PERSONA
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="per_cedula")
	private Persona persona; //CLASE PERTENECIENTE A LA ENTIDAD CON LA QUE SE RELACIONA
	
	//RELACION "ONE TO MANY" ENTRE ÉSTA ENTIDAD Y LA ENTIDAD "FACTURA DETALLESERVICIO"
	@OneToMany(cascade = CascadeType.ALL) //ETIQUETA DE RELACIÓN ENTRE ENTIDADES
	@JoinColumn(name = "FacCabSer_numero") //ESPECIFICAMOS LA ID CON LA QUE SE CONECTARÁ A LA OTRA TABLA
	private List<FacturaDetalleServicio> detallesServicio; //CLASE PERTENECIENTE A LA ENTIDAD CON LA QUE SE RELACIONA
	
	//MÉTODOS GET() Y SET()

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

	public List<FacturaDetalleServicio> getDetallesServicio() {
		return detallesServicio;
	}

	public void setDetallesServicio(List<FacturaDetalleServicio> detallesServicio) {
		this.detallesServicio = detallesServicio;
	}

}
