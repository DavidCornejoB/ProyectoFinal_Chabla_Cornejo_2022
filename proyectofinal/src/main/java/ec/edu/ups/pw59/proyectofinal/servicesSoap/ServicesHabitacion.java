package ec.edu.ups.pw59.proyectofinal.servicesSoap;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.pw59.proyectofinal.business.HabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;

@WebService
public class ServicesHabitacion {
	
	@Inject
	private HabitacionONLocal habitacionON;
	
	@WebMethod
	public String insertarHabitacion(Habitacion habitacion) { //INSERTAR HABITACION
		
		Habitacion h = new Habitacion();
		
		try {
			h = habitacionON.read(habitacion.getNumero());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (h == null) {
			try {
				habitacionON.insert(habitacion);
				return "HABITACION INSERTADA";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "NO SE HA PODIDO INSERTAR LA HABITACION";
			}
		} else {
			return "LA HABITACION YA HA SIDO INGRESADA";
		}
	} //INSERTAR HABITACION
	
	//************************************************************	
	//************************************************************
	
	@WebMethod
	public String actualizarHabitacion(Habitacion habitacion) {// ACTUALIZAR HABITACION
		
		Habitacion h = new Habitacion();
		
		try {
			h = habitacionON.read(habitacion.getNumero());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (h == null) {
			
			return "NO SE HA ENCONTRADO LA HABITACION A ACTUALIZAR";
		} else {
			
			try {
				habitacionON.update(habitacion);
				return "HABITACION ACTUALIZADA";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "ERROR AL ACTUALIZAR HABITACION";

			}
		}
		
	}//ACTUALIZAR HABITACION
	
	// ****************************************************
	// ****************************************************
	
	@WebMethod
	public Habitacion leerHabitacion(int numero) {// LEER HABITACION
		
		try {
			return habitacionON.read(numero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("NO SE HA ENCONTRADO LA HABITACION");
			return null;
		}
	}// LEER HABITACION
	
	// ****************************************************
	// ****************************************************
	
	@WebMethod
	public String eliminarHabitacion(Habitacion habitacion) {//ELIMINAR HABITACION
		
		try {
			habitacionON.delete(habitacion.getNumero());
			return "HABITACION " + habitacion.getNumero() + " ELIMINADA";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR HABITACION";
		}
	}//ELIMINAR HABITACION
	
	// ****************************************************
	// ****************************************************
	
	@WebMethod
	public List<Habitacion> habitaciones(){//LISTAR HABITACIONES
		
		List<Habitacion> habitaciones = new ArrayList<>();
		
		habitaciones = habitacionON.getHabitaciones();
		
		return habitaciones;
	}// LISTAR HABITACIONES


}
