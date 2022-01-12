package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;

public class Login implements Serializable{
	
	private int codigo;
	private String correo;
	private String clave;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	

}
