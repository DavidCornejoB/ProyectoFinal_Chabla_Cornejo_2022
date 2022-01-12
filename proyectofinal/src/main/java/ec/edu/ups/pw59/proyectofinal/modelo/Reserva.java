package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Reserva implements Serializable {
	
	@Id
	@Column(length = 20, name = "res_codigo")
	private int codigo;
	
	@Column(name = "res_entrada")
	private String entrada;
	
	@Column(name = "res_salida")
	private String salida;
	
	@JoinColumn(name = "res_habitacion")
	private Habitacion habitacion;

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

	/**
	 * @return the habitacion
	 */
	public Habitacion getHabitacion() {
		return habitacion;
	}

	/**
	 * @param habitacion the habitacion to set
	 */
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
	
	
	

}
