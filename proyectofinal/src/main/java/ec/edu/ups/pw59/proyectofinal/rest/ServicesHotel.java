package ec.edu.ups.pw59.proyectofinal.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.pw59.proyectofinal.business.HabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.business.HotelONLocal;
import ec.edu.ups.pw59.proyectofinal.business.PaqueteONLocal;
import ec.edu.ups.pw59.proyectofinal.business.ServicioONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;
import ec.edu.ups.pw59.proyectofinal.modelo.Paquete;
import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

@Path("hotel")
public class ServicesHotel {
	
	@Inject
	private HotelONLocal hotelON;
	
	@Inject
	private HabitacionONLocal habitacionON;
	
	@Inject
	private ServicioONLocal servicioON;
	
	@Inject
	private PaqueteONLocal paqueteON;
	
	private List<Habitacion> habitaciones;
	
	private List<Servicio> servicios;
	
	private List<Paquete> paquetes;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String ingresarHotel(Hotel hotel) {//INGRESAR HOTEL
		
		try {
			hotelON.insert(hotel);
			return "HOTEL INSERTADO";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL INSERTAR HOTEL";
		}
	}//INGRESAR HOTEL
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarHotel(int codigo) {//ELIMINAR HOTEL
		
		this.habitaciones = habitacionON.getHabitaciones();
		for(int i = 0; i < this.habitaciones.size(); i++) {
			if(this.habitaciones.get(i).getHotel().getCodigo() == codigo) {
				return "NO SE PUEDE ELIMINAR EL HOTEL PORQUE TIENE HABITACIONES ASIGNADAS";
			}
		}
		
		this.servicios = servicioON.getServicios();
		for(int i = 0; i < this.servicios.size(); i++) {
			if(this.servicios.get(i).getHotel().getCodigo() == codigo) {
				return "NO SE PUEDE ELIMINAR EL HOTEL PORQUE TIENE SERVICIOS ASIGNADOS";
			}
		}
		
		this.paquetes = paqueteON.getPaquetes();
		for(int i = 0; i < this.paquetes.size(); i++) {
			if(this.paquetes.get(i).getHotel().getCodigo() == codigo) {
				return "NO SE PUEDE ELIMINAR EL HOTEL PORQUE TIENE PAQUETES ASIGNADOS";
			}
		}
		
		try {
			hotelON.delete(codigo);
			return "HOTEL ELIMINADO";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR HOTEL";
		}
	}//ELIMINAR HOTEL
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hotel> getHoteles(){//GET HOTELES
		List<Hotel> hoteles = new ArrayList<Hotel>();
		
		hoteles = hotelON.getHoteles();
		return hoteles;
	}//GET HOTELES
	

}
