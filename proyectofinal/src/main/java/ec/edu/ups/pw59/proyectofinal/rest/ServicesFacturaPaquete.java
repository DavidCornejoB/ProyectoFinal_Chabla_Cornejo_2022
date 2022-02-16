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
		Persona p = new Persona();
		try {
			p = personaON.read(facturaPaquete.getPersona().getCedula());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(p == null) {
			return "PERSONA NO ENCONTRADA. NO SE PUEDE INSERTAR CABECERA";
		} else {
			try {
				facturaPaqueteON.insert(facturaPaquete);
				return "CABECERA INSERTADA";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "ERROR AL INSERTAR CABECERA";
			}
		}
	}//INSERTAR FACTURA

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarFacturaPaquete(int id) {//ELIMINAR FACTURA
		this.detallesPaquete = detallePaqueteON.getFacturas();
		for(int i = 0; i < this.detallesPaquete.size(); i++) {
			if(this.detallesPaquete.get(i).getFacturaCabeceraPaquete().getNumero() == id) {
				try {
					detallePaqueteON.delete(this.detallesPaquete.get(i).getCodigo());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "NO SE HA PODIDO ELIMINAR EL DETALLE ASOCIADO A ÉSTA CABECERA";
				}
			}
		}
		try {
			facturaPaqueteON.delete(id);
			return "CABECERA ELIMINADA";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR CABECERA";
		}
	}//ELIMINAR FACTURA

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FacturaCabeceraPaquete> getFacturas(){
		List<FacturaCabeceraPaquete> facturasPaquete = new ArrayList<FacturaCabeceraPaquete>();
		facturasPaquete = facturaPaqueteON.getFacturas();
		
		return facturasPaquete;
	}


}
