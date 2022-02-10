package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.HabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.business.HotelONLocal;
import ec.edu.ups.pw59.proyectofinal.business.PaqueteONLocal;
import ec.edu.ups.pw59.proyectofinal.business.ServicioONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;
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
	
	@Inject
	private HotelONLocal hotelON;
		
	private Habitacion habitacion = new Habitacion();
	
	private Servicio servicio = new Servicio();
	
	private Paquete paquete = new Paquete();
	
	private Hotel hotel = new Hotel();
	
	public static int idHotel;
		
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
	
	public static int getIdHotel() {
		return idHotel;
	}

	public static void setIdHotel(int idHotel) {
		clienteHotelBean.idHotel = idHotel;
	}

	public void listarHabitaciones() {
		
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		this.habitaciones = new ArrayList<Habitacion>();
		
		habitaciones = habitacionON.getHabitaciones();
		
		for (int i = 0; i < habitaciones.size(); i++) {
			if (habitaciones.get(i).getHotel().getCodigo() == idHotel) {
				this.habitaciones.add(habitaciones.get(i));
			}
		}
		
	}
	
	public void listarServicios() {
		List<Servicio> servicios = new ArrayList<Servicio>();
		this.servicios = new ArrayList<Servicio>();
		
		servicios = servicioON.getServicios();
		
		for (int i = 0; i <servicios.size(); i++) {
			if(servicios.get(i).getHotel().getCodigo() == idHotel) {
				this.servicios.add(servicios.get(i));
			}
		}
	}
	
	public void listarPaquetes() {
		List<Paquete> paquetes = new ArrayList<Paquete>();
		this.paquetes = new ArrayList<Paquete>();
		
		paquetes = paqueteON.getPaquetes();
		
		for(int i = 0; i <paquetes.size(); i++) {
			if(paquetes.get(i).getHotel().getCodigo() == idHotel) {
				this.paquetes.add(paquetes.get(i));
			}
		}
	}
	
	


}
