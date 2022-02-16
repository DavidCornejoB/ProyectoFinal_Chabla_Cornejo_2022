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

import ec.edu.ups.pw59.proyectofinal.business.FacturaCabeceraServicioONLocal;
import ec.edu.ups.pw59.proyectofinal.business.FacturaDetalleServicioONLocal;
import ec.edu.ups.pw59.proyectofinal.business.PersonaONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraServicio;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleServicio;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

@Path("facturaservicio")
public class ServicesFacturaServicio {
	
	@Inject
	private FacturaCabeceraServicioONLocal facturaServicioON;
	
	@Inject
	private FacturaDetalleServicioONLocal detalleServicioON;
	
	@Inject
	private PersonaONLocal personaON;
	
	private List<FacturaDetalleServicio> detallesServicio;
	
	private List<Persona> personas;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String insertarFacturaServicio(FacturaCabeceraServicio facturaServicio) {//INSERTAR FACTURA
		return "";
	}//INSERTAR FACTURA

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarFacturaServicio(int id) {//ELIMINAR FACTURA
		return "";
	}//ELIMINAR FACTURA

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FacturaCabeceraServicio> getFacturas(){
		List<FacturaCabeceraServicio> facturasServicio = new ArrayList<FacturaCabeceraServicio>();
		facturasServicio = facturaServicioON.getFacturas();
		
		return facturasServicio;
	}


}
