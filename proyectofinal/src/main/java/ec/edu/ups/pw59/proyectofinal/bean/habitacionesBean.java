package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.HabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;

@Named
@RequestScoped
public class habitacionesBean {
	
	@Inject
	private HabitacionONLocal habitacionON;
	
	private Habitacion habitacion = new Habitacion();
	
	private List<Habitacion> habitaciones;
	
	//CONSTRUCTOR
	public habitacionesBean() {
		
	}
	
	@PostConstruct
	public void init() {
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
			habitacionON.insert(this.habitacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "listado-habitaciones?faces-redirect=true";
	}
	
	//METODO PARA LISTAR HABITACIONES
	public void cargar() {
		this.habitaciones = habitacionON.getHabitaciones();
	}
	
}
