package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
/**
 * 
 * @author WilliamChabla
 * Clase Reserva
 */

@Entity //ETIQUETA DE PERSISTENCIA PARA INGRESAR ÉSTA CLASE COMO ENTIDAD DE LA BASE DE DATOS
public class Reserva implements Serializable { //CLASE SERIALIZABLE

	private static final long serialVersionUID = 1L;

	@Id //ETIQUETA DE PERSISTENCIA PARA CLAVE PRIMARIA
	@GeneratedValue
	@Column(length = 20, name = "res_codigo") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private int codigo;
	
	@Column(name = "res_entrada") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String entrada;
	
	@Column(name = "res_salida") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String salida;
	
	//RELACION "ONE TO ONE" ENTRE ÉSTA ENTIDAD Y LA ENTIDAD "HABITACION"
	@OneToOne //ETIQUETA DE RELACION ENTRE ENTIDADES
	@JoinColumn(name = "hab_numero") //ENTIDAD CON LA QUE SE RELACIONA
	private Habitacion habitacion; //CLASE PERTENECIENTE A LA ENTIDAD CON LA QUE SE RELACIONA
	
	//METODOS GET() Y SET()

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the entrada
	 */
	public String getEntrada() {
		return entrada;
	}

	/**
	 * @param entrada the entrada to set
	 */
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	/**
	 * @return the salida
	 */
	public String getSalida() {
		return salida;
	}

	/**
	 * @param salida the salida to set
	 */
	public void setSalida(String salida) {
		this.salida = salida;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
}
