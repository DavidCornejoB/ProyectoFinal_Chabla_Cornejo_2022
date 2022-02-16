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

import ec.edu.ups.pw59.proyectofinal.business.FacturaCabeceraPaqueteONLocal;
import ec.edu.ups.pw59.proyectofinal.business.FacturaDetallePaqueteONLocal;
import ec.edu.ups.pw59.proyectofinal.business.PersonaONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraPaquete;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetallePaquete;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

@Path("facturapaquete")
public class ServicesFacturaPaquete {
	
	@Inject
	private FacturaCabeceraPaqueteONLocal facturaPaqueteON;
	
	@Inject
	private FacturaDetallePaqueteONLocal detallePaqueteON;
	
	@Inject
	private PersonaONLocal personaON;
	
	private List<FacturaDetallePaquete> detallesPaquete;
	
	private List<Persona> personas;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String insertarFacturaPaquete(FacturaCabeceraPaquete facturaPaquete) {//INSERTAR FACTURA
		return "";
	}//INSERTAR FACTURA

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarFacturaPaquete(int id) {//ELIMINAR FACTURA
		return "";
	}//ELIMINAR FACTURA

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FacturaCabeceraPaquete> getFacturas(){
		List<FacturaCabeceraPaquete> facturasPaquete = new ArrayList<FacturaCabeceraPaquete>();
		facturasPaquete = facturaPaqueteON.getFacturas();
		
		return facturasPaquete;
	}


}
