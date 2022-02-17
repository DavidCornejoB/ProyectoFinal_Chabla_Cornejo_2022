package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
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
 * 
 * @author luisd
 *
 */
@Named //ETIQUETA DE MANAGED BEANS
@RequestScoped
public class paquetesBean {
	
	//LLAMAMOS AL OBJETO DE NEGOCIO LOCAL QUE CONTIENE LOS MÉTODOS INSERT, UPDATE, READ Y DELETE
	@Inject
	private PaqueteONLocal paqueteON;
	
	@Inject
	private HabitacionONLocal habitacionON;
	
	@Inject
	private ServicioONLocal servicioON;
	
	@Inject
	private HotelONLocal hotelON;
	
	private List<SelectItem> listaHabitaciones;
	private List<SelectItem> listaServicios;
	private List<SelectItem> listaHoteles;
	
	/**
	 * CREAMOS EL OBJETO PAQUETE. COMO ESTÁ INSTANCIADO, ESTARÁN SUS VALORES VACÍOS, Y PODREMOS MODIFICARLOS DESDE EL FORMULARIO
	 */
	private Paquete paquete = new Paquete();
	
	/**
	 * LISTA DE PAQUETES
	 */
	private List<Paquete> paquetes;
	
	/**
	 * CONSTRUCTOR
	 */
	public paquetesBean() {
		
	}
	
	/**
	 * UTILIZAMOS LA ETIQUETA POSTCONSTRUCT POR SI QUEREMOS LISTAR ANTES DE TENER ELEMENTOS EN LA LISTA.
	 */
	@PostConstruct
	public void init() {
		
		//COMBOBOX SERVICIOS
		this.cargarComboboxServicios();
		
		//COMBOBOX HABITACIONES
		this.cargarComboboxHabitaciones();
		
		//COMBOBOX HOTELES
		this.cargarComboboxHoteles();
		
		this.paquete.setHabitacion(new Habitacion());
		this.paquete.setHotel(new Hotel());
		this.paquete.setServicio(new Servicio());
		this.cargar();
	}

	/**
	 * METODOS GET() Y SET()
	 */
	
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
	 * @return listaHabitaciones
	 */
	public List<SelectItem> getListaHabitaciones() {
		return listaHabitaciones;
	}

	/**
	 * 
	 * @param listaHabitaciones
	 */
	public void setListaHabitaciones(List<SelectItem> listaHabitaciones) {
		this.listaHabitaciones = listaHabitaciones;
	}

	/**
	 * 
	 * @return listaServicios
	 */
	public List<SelectItem> getListaServicios() {
		return listaServicios;
	}

	/**
	 * 
	 * @param listaServicios
	 */
	public void setListaServicios(List<SelectItem> listaServicios) {
		this.listaServicios = listaServicios;
	}

	/**
	 * 
	 * @return listaHoteles
	 */
	public List<SelectItem> getListaHoteles() {
		return listaHoteles;
	}

	/**
	 * 
	 * @param listaHoteles
	 */
	public void setListaHoteles(List<SelectItem> listaHoteles) {
		this.listaHoteles = listaHoteles;
	}

	/**
	 * MÉTODO PARA GUARDAR PAQUETES
	 * @return formulario listado-paquetes
	 */
	public String guardar() {
		
		System.out.println("GUARDANDO PAQUETE: " + this.paquete.getNombre());
		
		try {
			//USAMOS EL MÉTODO INSERT DE LA ENTIDAD DE NEGOCIO DE PAQUETE
			paqueteON.insert(this.paquete);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//UNA VEZ SE HA INGRESADO UNA PAQUETE, SE REDIRIGIRÁ AL FORMULARIO DE LISTAR PAQUETES
		return "listado-paquetes?faces-redirect=true";
	}
	
	/**
	 * MÉTODO PARA LISTAR PAQUETES
	 */
	public void cargar() {
		//LLAMAMOS AL MÉTODO GETPAQUETES() DEL OBJETO DE NEGOCIO
		this.paquetes = paqueteON.getPaquetes();
	}
	
	/**
	 * CARGAR COMBOBOBX HABITACIONES
	 */
	public void cargarComboboxHabitaciones() {//COMBOBOX HABITACIONES
		
		listaHabitaciones = new ArrayList<SelectItem>();
		List<Habitacion> habitaciones = new ArrayList<>();
		habitaciones = habitacionON.getHabitaciones();
		
		for(int i = 0; i < habitaciones.size(); i++) {
			listaHabitaciones.add(new SelectItem(habitaciones.get(i).getNumero(), "Numero: " + habitaciones.get(i).getNumero()
					+ "Hotel: " + habitaciones.get(i).getHotel().getNombre()));
		}
		
	}//COMBOBOX HABITACIONES
	
	/**
	 * CARGAR COMBOBOX SERVICIOS
	 */
	public void cargarComboboxServicios() {//COMBOBOX SERVICIOS
		listaServicios = new ArrayList<>();
		List<Servicio> servicios = new ArrayList<>();
		servicios = servicioON.getServicios();
		
		for(int i = 0; i < servicios.size(); i++) {
			listaServicios.add(new SelectItem(servicios.get(i).getCodigo(), servicios.get(i).getNombre() + 
					", Hotel: " + servicios.get(i).getHotel().getNombre()));
		}
		
	}//COMBOBOX SERVICIOS
	
	/**
	 * CARGAR COMBOBOX HOTELES
	 */
	public void cargarComboboxHoteles() {//COMBOBOX HOTELES
		listaHoteles = new ArrayList<>();
		List<Hotel> hoteles = new ArrayList<>();
		hoteles = hotelON.getHoteles();
		
		for(int i = 0; i < hoteles.size(); i++) {
			listaHoteles.add(new SelectItem(hoteles.get(i).getCodigo(), hoteles.get(i).getNombre()));
		}
		
	}//COMBOBOX HOTELES
	
	/**
	 * METODO PARA CARGAR HABITACION
	 * @return null
	 */
	public String cargarHabitacion() {
		
		int id = this.paquete.getHabitacion().getNumero();
		
		Habitacion h = paqueteON.getHabitacion(id);
		this.paquete.setHabitacion(h);
		
		return null;
	}
	
	/**
	 * METODO PARA CARGAR HOTEL
	 * @return null
	 */
	public String cargarHotel() {
		
		int id = this.paquete.getHotel().getCodigo();
		
		Hotel h = paqueteON.getHotel(id);
		this.paquete.setHotel(h);
		
		return null;
		
	}
	
	/**
	 * METODO PARA CARGAR SERVICIOS
	 * @return null
	 */
	public String cargarServicio() {
		
		int id = this.paquete.getServicio().getCodigo();
		
		Servicio s = paqueteON.getServicio(id);
		this.paquete.setServicio(s);
		
		return null;
		
	}
	
	/**
	 * REDIRECCIONAR
	 * @return paquete
	 */
	public String volverIngresar() {
		System.out.println("VOLVIENDO A INGRESO PAQUETES... ");
		return "paquete";
	}
	
	

}
