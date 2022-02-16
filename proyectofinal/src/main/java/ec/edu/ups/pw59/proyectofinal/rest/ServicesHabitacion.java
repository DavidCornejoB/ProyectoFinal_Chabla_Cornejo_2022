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

import ec.edu.ups.pw59.proyectofinal.business.CategoriaONLocal;
import ec.edu.ups.pw59.proyectofinal.business.HabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Categoria;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;

@Path("habitacion")
public class ServicesHabitacion {
	
	@Inject
	private HabitacionONLocal habitacionON;
	
	@Inject
	private CategoriaONLocal categoriaON;
	
	private List<Categoria> categorias;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String ingresarHabitacion(Habitacion habitacion) {//INSERTAR HABITACION
		
		this.categorias = categoriaON.getCategorias();
		
		for(int i = 0; i < this.categorias.size(); i++) {
			if(habitacion.getCategoria().getCodigo() == this.categorias.get(i).getCodigo()) {
				
				try {
					habitacionON.insert(habitacion);
					return "HABITACION INSERTADA";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "ERROR AL INSERTAR HABITACION";
				}
				
			}
		}
		
		return "NO SE HA ENCONTRADO UNA CATEGORIA CON ÉSA ID (" + habitacion.getCategoria().getCodigo() + ")";

	}//INSERTAR HABITACION
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarHabitacion(int numero) {//ELIMINAR HABITACION
		
		Habitacion h = new Habitacion();
		try {
			h = habitacionON.read(numero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(h.getEstado().equals("Ocupada")) {
			return "NO SE HA PODIDO ELIMINAR LA HABITACION. YA EXISTE UNA RESERVA CON ÉSTA HABITACION";
		}
		
		try {
			habitacionON.delete(numero);
			return "HABITACION ELIMINADA";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR HABITACION";
		}
	}//ELIMINAR HABITACION
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Habitacion> getHabitaciones(){//GET HABITACIONES
		List<Habitacion> habitaciones = new ArrayList<>();
		
		habitaciones = habitacionON.getHabitaciones();
		return habitaciones;
	}//GET HABITACIONES



}
