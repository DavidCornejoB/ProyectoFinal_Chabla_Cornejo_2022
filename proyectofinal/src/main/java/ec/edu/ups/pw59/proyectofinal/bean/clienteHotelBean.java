package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.HabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.business.PaqueteONLocal;
import ec.edu.ups.pw59.proyectofinal.business.ServicioONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Paquete;
import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

@Named
@RequestScoped
public class clienteHotelBean {
	
	@Inject
	private HabitacionONLocal habitacionON;
	
	@Inject
	private ServicioONLocal servicioON;
	
	@Inject
	private PaqueteONLocal paqueteON;
	
	private String id;
	
	private Habitacion habitacion = new Habitacion();
	
	private Servicio servicio = new Servicio();
	
	private Paquete paquete = new Paquete();
	
	private List<Habitacion> habitaciones;
	
	private List<Servicio> servicios;
	
	private List<Paquete> paquetes;
	
	public clienteHotelBean() {
		
	}
	
	@PostConstruct
	public void init() {
		
	}

	public HabitacionONLocal getHabitacionON() {
		return habitacionON;
	}

	public void setHabitacionON(HabitacionONLocal habitacionON) {
		this.habitacionON = habitacionON;
	}

	public ServicioONLocal getServicioON() {
		return servicioON;
	}

	public void setServicioON(ServicioONLocal servicioON) {
		this.servicioON = servicioON;
	}

	public PaqueteONLocal getPaqueteON() {
		return paqueteON;
	}

	public void setPaqueteON(PaqueteONLocal paqueteON) {
		this.paqueteON = paqueteON;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Paquete getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public List<Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String mostrarHotel(int id) {
		System.out.println("******************************************");
		System.out.println("NOS VAMOS A CLIENTE VENTANA HOTEL " + id);
		return "cliente-ventana-hotel?faces-redirect=true&id=" + id;
	}
	
	

}
