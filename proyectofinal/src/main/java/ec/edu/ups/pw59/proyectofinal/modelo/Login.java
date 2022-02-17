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
 * permite el ingreso de usuario o administrador
 */
@Entity //ETIQUETA DE PERSISTENCIA PARA INGRESAR ÉSTA CLASE COMO ENTIDAD DE LA BASE DE DATOS
public class Login implements Serializable{ //CLASE SERIALIZABLE
	
	private static final long serialVersionUID = 1L;
	
	@Id //ETIQUETA DE CLAVE PRIMARIA
	@GeneratedValue
	@Column(name = "log_codigo") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private int codigo;
	
	@Column(name = "log_correo") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String correo;
	
	@Column(name = "log_clave") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String clave;
	
	@ManyToOne
	@JoinColumn(name="per_cedula")
	private Persona persona;
	
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
	 * @return correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * 
	 * @param correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * 
	 * @return clave
	 */
	public String getClave() {
		return clave;
	}
	/**
	 * 
	 * @param clave
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}
	/**
	 * 
	 * @return persona
	 */
	public Persona getPersona() {
		return persona;
	}
	/**
	 * 
	 * @param persona
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
