package ec.edu.ups.pw59.proyectofinal.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity //ETIQUETA DE PERSISTENCIA PARA INGRESAR ÉSTA CLASE COMO ENTIDAD DE LA BASE DE DATOS
public class Hotel implements Serializable{ //CLASE SERIALIZABLE

	private static final long serialVersionUID = 1L;

	@Id //ETIQUETA DE CLAVE PRIMARIA
	@Column(length = 20, name = "ho_codigo") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private int codigo;
	
	@Column(name = "ho_nombre") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String nombre;
	
	@Column(name = "ho_pais") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String pais;
	
	@Column(name = "ho_provicia") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String provincia;
	
	@Column(name = "ho_ciudad") //ETIQUETA COLUMN PARA NOMBRE Y TAMAÑO DEL PARÁMETRO EN LA BASE DE DATOS
	private String ciudad;
	
	//RELACION "ONE TO MANY" ENTRE HOTEL Y SERVICIO. UN HOTEL TIENE VARIOS SERVICIOS. LOS SERVICIOS SE LISTARÁN EN LA PAG DEL HOTEL
	@OneToMany(mappedBy = "hotel")
	private List <Servicio> servicios;
	
	//RELACION "ONE TO MANY" ENTRE HOTEL Y HABITACION. UN HOTEL TIENE VARIAS HABITACIONES. LAS HABITACIONES SE LISTARÁN EN LA PAG DEL HOTEL
	@OneToMany(mappedBy = "hotel")
	private List <Habitacion> habitaciones;
	
	//RELACION "ONE TO MANY" ENTRE HOTEL Y PAQUETE. UN HOTEL TIENE VARIOS PAQUETES DE PROMOCIÓN. LOS PAQUETES DE PROMOCIÓN SE LISTARÁN EN LA PAG DEL HOTEL
	@OneToMany(mappedBy = "hotel")
	private List <Paquete> paquetes;
	
	//MÉTODOS GET() Y SET()
	
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}
	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	public List<Paquete> getPaquetes() {
		return paquetes;
	}
	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

}
