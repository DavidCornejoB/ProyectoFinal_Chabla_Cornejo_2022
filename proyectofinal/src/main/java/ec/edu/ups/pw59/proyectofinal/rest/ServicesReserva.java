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
import ec.edu.ups.pw59.proyectofinal.business.ReservaONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Reserva;

@Path("reserva")
public class ServicesReserva {
	
	@Inject
	private ReservaONLocal reservaON;
	
	@Inject
	private HabitacionONLocal habitacionON;
	
	private List<Habitacion> habitaciones;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String ingresarReserva(Reserva reserva) {//INGRESAR RESERVA
		
		if(reserva.getHabitacion().getEstado().equals("Ocupada")) {
			return "ESTA HABITACIÓN ESTÁ RESERVADA (NUM HABITACION: " + reserva.getHabitacion().getNumero() + ")";
		}
		
		this.habitaciones = habitacionON.getHabitaciones();
		for(int i = 0; i < this.habitaciones.size(); i++) {
			if(reserva.getHabitacion().getNumero() == this.habitaciones.get(i).getNumero()) {
				try {
					reservaON.insert(reserva);
					return "RESERVA INSERTADA";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "ERROR AL INSERTAR RESERVA";
				}
			}
		}
		
		return "NO SE HA ENCONTRADO UNA HABITACION CON ÉSA ID (" + reserva.getHabitacion().getNumero() + ")";
	}//INGRESAR RESERVA
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarReserva(int id) {//ELIMINAR RESERVA
		Reserva r = new Reserva();
		try {
			r = reservaON.read(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Habitacion h = new Habitacion();
		try {
			h = habitacionON.read(r.getHabitacion().getNumero());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		h.setEstado("Disponible");
		
		try {
			habitacionON.update(h);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			reservaON.delete(id);
			return "RESERVA ELIMINADA";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR RESERVA";
		}
	}//ELIMINAR RESERVA
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reserva> getReservas(){//GET RESERVAS
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		reservas = reservaON.getReservas();
		return reservas;
	}//GET RESERVAS

}
