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

import ec.edu.ups.pw59.proyectofinal.business.FacturaCabeceraHabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.business.FacturaDetalleHabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.business.PersonaONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraHabitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleHabitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

@Path("facturahabitacion")
public class ServicesFacturaHabitacion {
	
	@Inject
	private FacturaCabeceraHabitacionONLocal facturaHabitacionON;
	
	@Inject
	private FacturaDetalleHabitacionONLocal detalleHabitacionON;
	
	@Inject
	private PersonaONLocal personaON;
	
	private List<FacturaDetalleHabitacion> detallesHabitacion;
	
	private List<Persona> personas;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String insertarFacturaHabitacion(FacturaCabeceraHabitacion facturaHabitacion) {//INSERTAR FACTURA
		return "";
	}//INSERTAR FACTURA

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarFacturaHabitacion(int id) {//ELIMINAR FACTURA
		return "";
	}//ELIMINAR FACTURA

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FacturaCabeceraHabitacion> getFacturas(){
		List<FacturaCabeceraHabitacion> facturasHabitacion = new ArrayList<FacturaCabeceraHabitacion>();
		facturasHabitacion = facturaHabitacionON.getFacturas();
		
		return facturasHabitacion;
	}


}
