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

@Path("paquete")
public class ServicesPaquete {
	
	@Inject
	private PaqueteONLocal paqueteON;
	
	@Inject
	private ServicioONLocal servicioON;
	
	@Inject
	private HabitacionONLocal habitacionON;
	
	@Inject
	private HotelONLocal hotelON;
	
	private List<Servicio> servicios;
	private List<Habitacion> habitaciones;
	private List<Hotel> hoteles;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String ingresarPaquete(Paquete paquete) {//INGRESAR PAQUETE
		
		boolean servicios = false;
		this.servicios = servicioON.getServicios();
		for(int i = 0; i < this.servicios.size(); i++) {
			if(paquete.getServicio().getCodigo() == this.servicios.get(i).getCodigo()) {
				System.out.println("SE ENCONTRÓ SERVICIO");
				servicios = true;
			} else {
				servicios = false;
			}
		}
		
		if(servicios == false) {
			return "NO EXISTE UN SERVICIO CON ÉSA ID (" + paquete.getServicio().getCodigo() + ")";
		}
		
		boolean habitaciones = false;
		this.habitaciones = habitacionON.getHabitaciones();
		for(int i = 0; i < this.habitaciones.size(); i++) {
			if(paquete.getHabitacion().getNumero() == this.habitaciones.get(i).getNumero()) {
				System.out.println("SE ENCONTRÓ HABITACION");
				habitaciones = true;
			} else {
				habitaciones = false;
			}
		}
		
		if(habitaciones == false) {
			return "NO EXISTE UNA HABITACION CON ÉSA ID (" + paquete.getHabitacion().getNumero() + ")";
		}
		
		boolean hoteles = false;
		this.hoteles = hotelON.getHoteles();
		for(int i = 0; i < this.hoteles.size(); i++) {
			if(paquete.getHotel().getCodigo() == this.hoteles.get(i).getCodigo()) {
				System.out.println("SE ENCONTRÓ HOTEL");
				hoteles = true;
			} else {
				hoteles = false;
			}
		}
		
		if(hoteles == false) {
			return "NO EXISTE UN HOTEL CON ÉSA ID (" + paquete.getHabitacion().getNumero() + ")";
		}
		
		try {
			paqueteON.insert(paquete);
			return "PAQUETE INSERTADO";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL INSERTAR PAQUETE";
		}
	}//INGRESAR PAQUETE
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarPaquete(int id) {//ELIMINAR PAQUETE
		
		try {
			paqueteON.delete(id);
			return "PAQUETE ELIMINADO";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR PAQUETE";
		}
	}//ELIMINAR PAQUETE
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Paquete> getPaquetes(){//GET PAQUETES
		List<Paquete> paquetes = new ArrayList<>();
		
		paquetes = paqueteON.getPaquetes();
		return paquetes;
	}//GET PAQUETES
	

}
