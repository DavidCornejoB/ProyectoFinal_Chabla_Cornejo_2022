package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.CategoriaON;
import ec.edu.ups.pw59.proyectofinal.business.HabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Categoria;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;

@Named //ETIQUETA DE MANAGED BEANS
@RequestScoped
public class habitacionesBean {
	
	//LLAMAMOS AL OBJETO DE NEGOCIO LOCAL QUE CONTIENE LOS MÉTODOS INSERT, UPDATE, READ Y DELETE
	@Inject
	private HabitacionONLocal habitacionON;
	
	//CREAMOS EL OBJETO HABITACION. SE INICIALIZA CON VALORES VACIOS
	private Habitacion habitacion = new Habitacion();
	
	//VARIABLE LISTA QUE CONTIENE TODAS LAS HABITACIONES INGRESADAS
	private List<Habitacion> habitaciones;
	
	//CONSTRUCTOR
	public habitacionesBean() {
		
	}
	
	//UTILIZAMOS LA ETIQUETA POSTCONSTRUCT POR SI QUEREMOS LISTAR ANTES DE TENER ELEMENTOS EN LA LISTA.
	@PostConstruct
	public void init() {
		this.habitacion.setCategoria(new Categoria());
		this.habitacion.setHotel(new Hotel());
		this.cargar();
	}
	
	//METODOS GET() Y SET()
	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	//METODO PARA GUARDAR HABITACIONES
	public String guardar() {
		
		System.out.println("GUARDANDO HABITACION: " + this.habitacion.getNumero());
		
		try {
			//USAMOS EL MÉTODO INSERT DEL OBJETO DE NEGOCIO DE HABITACION
			habitacionON.insert(this.habitacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//UNA VEZ SE HA INGRESADO UNA HABITACION, SE REDIRIGIRÁ AL FORMULARIO DE LISTAR HABITACIONES
		return "listado-habitaciones?faces-redirect=true";
	}
	
	//METODO PARA LISTAR HABITACIONES
	public void cargar() {
		//LLAMAMOS AL MÉTODO GETHABITACIONES() DEL OBJETO DE NEGOCIO
		this.habitaciones = habitacionON.getHabitaciones();
	}
	
	public String cargarCategoria() {
		
		int id = this.habitacion.getCategoria().getCodigo();
		
		Categoria cat = habitacionON.getCategoria(id);
		this.habitacion.setCategoria(cat);
		
		return null;
	}
	
	public String cargarHotel() {
		int id = this.habitacion.getHotel().getCodigo();
		
		Hotel h = habitacionON.getHotel(id);
		this.habitacion.setHotel(h);
		
		return null;
	}
	
	public String volverIngresar() {
		System.out.println("VOLVIENDO A INGRESO HABITACIONES... ");
		return "habitacion";
	}
	
}
