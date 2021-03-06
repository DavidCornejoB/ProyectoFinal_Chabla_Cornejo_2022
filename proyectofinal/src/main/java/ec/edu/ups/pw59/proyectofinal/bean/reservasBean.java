package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.FacturaCabeceraHabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.business.FacturaDetalleHabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.business.HabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.business.ReservaONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleHabitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Reserva;

/**
 * 
 * @author luisd
 *
 */
@Named //ETIQUETA DE MANAGED BEANS
@RequestScoped
public class reservasBean {
	
	/*
	 * LLAMAMOS AL OBJETO DE NEGOCIO LOCAL QUE CONTIENE LOS MÉTODOS INSERT, UPDATE, READ Y DELETE
	 */
	@Inject
	private ReservaONLocal reservaON;
	
	@Inject
	private HabitacionONLocal habitacionON;
	
	@Inject
	private FacturaDetalleHabitacionONLocal detalleHabitacionON;
	
	@Inject
	private FacturaCabeceraHabitacionONLocal facturaHabitacionON;
	
	private List<SelectItem> listaHabitaciones;
		
	/*
	 * CREAMOS EL OBJETO RESERVA. COMO ESTÁ INSTANCIADO, ESTARÁN SUS VALORES VACÍOS, Y PODREMOS MODIFICARLOS DESDE EL FORMULARIO
	 */
	private Reserva reserva = new Reserva();
	
	/*
	 * LISTA DE RESERVAS
	 */
	private List<Reserva> reservas;
	
	/**
	 * CONSTRUCTOR
	 */
	public reservasBean() {
		
	}
	
	/**
	 * UTILIZAMOS LA ETIQUETA POSTCONSTRUCT POR SI QUEREMOS LISTAR ANTES DE TENER ELEMENTOS EN LA LISTA.
	 */
	@PostConstruct
	public void init() {
		//COMBOBOX HABITACIONES
		this.cargarComboboxHabitaciones();
		
		this.reserva.setHabitacion(new Habitacion());
		this.cargar();
	}
	
	/*
	 * METODOS GET() Y SET()
	 */
	
	/**
	 * 
	 * @return reservaON
	 */
	public ReservaONLocal getReservaON() {
		return reservaON;
	}
	
	/**
	 * 
	 * @param reservaON
	 */
	public void setReservaON(ReservaONLocal reservaON) {
		this.reservaON = reservaON;
	}

	/**
	 * 
	 * @return RESERVA
	 */
	public Reserva getReserva() {
		return reserva;
	}

	/**
	 * 
	 * @param reserva
	 */
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	/**
	 * 
	 * @return reservas
	 */
	public List<Reserva> getReservas() {
		return reservas;
	}

	/**
	 * 
	 * @param reservas
	 */
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
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
	 * @return listadoHabitaciones
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
	 * MÉTODO PARA GUARDAR RESERVAS
	 * @return formulario listado-reservas
	 */
	public String guardar() {
		
		System.out.println("GUARDANDO RESERVAS: " + this.reserva.getCodigo());
		
		Habitacion habitacion = new Habitacion();
		try {
			habitacion = habitacionON.read(this.reserva.getHabitacion().getNumero());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(habitacion.getEstado().equals("Ocupada")) {
			System.out.println("LA HABITACIÓN YA ESTÁ OCUPADA");
		} else {
			
			try {
				//USAMOS EL MÉTODO INSERT DE LA ENTIDAD DE NEGOCIO DE RESERVA
				reservaON.insert(this.reserva);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			habitacion.setEstado("Ocupada");
			
			try {
				habitacionON.update(habitacion);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		//UNA VEZ SE HA INGRESADO UNA RESERVA, SE REDIRIGIRÁ AL FORMULARIO DE LISTAR RESERVAS
		return "listado-reservas?faces-redirect=true";
	}
	
	/**
	 * METODO PARA ELIMINAR RESERVA
	 * @param codigo
	 * @return formulario eliminar-reserva
	 */
	public String eliminar(int codigo) {//ELIMINAR RESERVAS
		
		Reserva reserva = new Reserva();
		try {
			reserva = reservaON.read(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int numHabitacion = reserva.getHabitacion().getNumero();
		
		Habitacion habitacion = new Habitacion();
		try {
			habitacion = habitacionON.read(numHabitacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		habitacion.setEstado("Disponible");
		try {
			habitacionON.update(habitacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * ELIMINAR FACTURA
		 */
		
		List<FacturaDetalleHabitacion> detalles = new ArrayList<>();
		
		detalles = detalleHabitacionON.getFacturas();
		
		int codigoFactura;
		
		for(int i = 0; i < detalles.size(); i++) {
			if(detalles.get(i).getReserva().getCodigo() == codigo) {
				codigoFactura = detalles.get(i).getFacturaCabeceraHabitacion().getNumero();
				try {
					detalleHabitacionON.delete(detalles.get(i).getCodigo());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					facturaHabitacionON.delete(codigoFactura);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		/*
		 * ELIMINAR RESERVA
		 */
		try {
			reservaON.delete(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "eliminar-reserva";
		
	}//ELIMINAR RESERVAS
	
	
	/**
	 * MÉTODO PARA LISTAR RESERVAS
	 */
	public void cargar() {
		//LLAMAMOS AL MÉTODO GETRESERVAS() DEL OBJETO DE NEGOCIO
		this.reservas = reservaON.getReservas();
	}
	
	/**
	 * combobox habitacion
	 */
	public void cargarComboboxHabitaciones() {//COMBOBOX HABITACIONES
			
			listaHabitaciones = new ArrayList<SelectItem>();
			List<Habitacion> habitaciones = new ArrayList<>();
			habitaciones = habitacionON.getHabitaciones();
			
			for(int i = 0; i < habitaciones.size(); i++) {
				listaHabitaciones.add(new SelectItem(habitaciones.get(i).getNumero(), "Numero: " + habitaciones.get(i).getNumero()
						+ ", Hotel: " + habitaciones.get(i).getHotel().getNombre() + ", Estado: " + habitaciones.get(i).getEstado()));
			}
			
		}//COMBOBOX HABITACIONES
	
	/**
	 * MÉTODO PARA CARGAR LA HABITACION RESERVADA
	 * @return null
	 */
	public String cargarHabitacion() {
		
		int id = this.reserva.getHabitacion().getNumero();
		
		Habitacion h = reservaON.getHabitacion(id);
		this.reserva.setHabitacion(h);
		
		return null;
	}
	
	/**
	 * REDIRECCIONAR
	 * @return formulario reserva
	 */
	public String vovlerIngresar() {
		System.out.println("VOLVIENDO A INGRESO RESERVAS...");
		return "reserva";
	}
	
	/**
	 * REDIRECCIONAR EN BASE A LA RESERVA DEL CLIENTE
	 * @param numero
	 * @return cliente-reserva
	 */
	public String generarReserva(int numero) {
		return "cliente-reserva";
	}
	
	

}
