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

/**
 * BEAN PARA LISTAR HABITACIONES, SERVICIOS Y PAQUETES POR HOTEL SELECCIONADO
 * @author luisd
 *
 */
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
	
	/**
	 * METODO POST CONSTRUCT
	 */
	@PostConstruct
	public void init() {
		listarHabitaciones();
		listarServicios();
		listarPaquetes();
	}

	/**
	 * 
	 * @return habitacionON
	 */
	public HabitacionONLocal getHabitacionON() {
		return habitacionON;
	}

	/**
	 * 
	 * @param habitacionON
	 */
	public void setHabitacionON(HabitacionONLocal habitacionON) {
		this.habitacionON = habitacionON;
	}

	/**
	 * 
	 * @return servicioON
	 */
	public ServicioONLocal getServicioON() {
		return servicioON;
	}

	/**
	 * 
	 * @param servicioON
	 */
	public void setServicioON(ServicioONLocal servicioON) {
		this.servicioON = servicioON;
	}

	/**
	 * 
	 * @return paqueteON
	 */
	public PaqueteONLocal getPaqueteON() {
		return paqueteON;
	}

	/**
	 * 
	 * @param paqueteON
	 */
	public void setPaqueteON(PaqueteONLocal paqueteON) {
		this.paqueteON = paqueteON;
	}

	/**
	 * 
	 * @return habitacion
	 */
	public Habitacion getHabitacion() {
		return habitacion;
	}

	/**
	 * 
	 * @param habitacion
	 */
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	/**
	 * 
	 * @return servicio
	 */
	public Servicio getServicio() {
		return servicio;
	}

	/**
	 * 
	 * @param servicio
	 */
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
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
	 * @return habitaciones
	 */
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	/**
	 * 
	 * @param habitaciones
	 */
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	/**
	 * 
	 * @return servicios
	 */
	public List<Servicio> getServicios() {
		return servicios;
	}
	
	/**
	 * 
	 * @param servicios
	 */
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	/**
	 * 
	 * @return paquetes
	 */
	public List<Paquete> getPaquetes() {
		return paquetes;
	}

	/**
	 * 
	 * @param paquetes
	 */
	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}
	
	/**
	 * 
	 * @return idHotel
	 */
	public static int getIdHotel() {
		return idHotel;
	}

	/**
	 * 
	 * @param idHotel
	 */
	public static void setIdHotel(int idHotel) {
		clienteHotelBean.idHotel = idHotel;
	}

	/**
	 * 
	 * @return hotelON
	 */
	public HotelONLocal getHotelON() {
		return hotelON;
	}

	/**
	 * 
	 * @param hotelON
	 */
	public void setHotelON(HotelONLocal hotelON) {
		this.hotelON = hotelON;
	}

	/**
	 * 
	 * @return hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * 
	 * @param hotel
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	/**
	 * METODO LISTAR HABITACIONES
	 * @return formulario cliente-listar-habitaciones
	 */
	public String listarHabitaciones() {
		
		System.out.println("HOTEL: " + idHotel);
		
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		this.habitaciones = new ArrayList<Habitacion>();
		
		habitaciones = habitacionON.getHabitaciones();
		
		for (int i = 0; i < habitaciones.size(); i++) {
			if (habitaciones.get(i).getHotel().getCodigo() == idHotel) {
				this.habitaciones.add(habitaciones.get(i));
			}
		}
		
		return "cliente-listar-habitaciones?faces-redirect=true";
		
	}
	
	/**
	 * METODO LISTAR SERVICIOS
	 * @return formulario cliente-listar-servicios
	 */
	public String listarServicios() {
		
		System.out.println("HOTEL: " + idHotel);

		List<Servicio> servicios = new ArrayList<Servicio>();
		this.servicios = new ArrayList<Servicio>();
		
		servicios = servicioON.getServicios();
		
		for (int i = 0; i <servicios.size(); i++) {
			if(servicios.get(i).getHotel().getCodigo() == idHotel) {
				this.servicios.add(servicios.get(i));
			}
		}
		
		return "cliente-listar-servicios?faces-redirect=true";

	}
	
	/**
	 * METODO LISTAR PAQUETES
	 * @return formulario cliente-listar-paquetes
	 */
	public String listarPaquetes() {
		
		System.out.println("HOTEL: " + idHotel);

		List<Paquete> paquetes = new ArrayList<Paquete>();
		this.paquetes = new ArrayList<Paquete>();
		
		paquetes = paqueteON.getPaquetes();
		
		for(int i = 0; i <paquetes.size(); i++) {
			if(paquetes.get(i).getHotel().getCodigo() == idHotel) {
				this.paquetes.add(paquetes.get(i));
			}
		}
		
		return "cliente-listar-paquetes?faces-redirect=true";

	}

}
