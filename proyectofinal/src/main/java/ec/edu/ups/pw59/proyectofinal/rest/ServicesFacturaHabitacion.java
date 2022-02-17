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
		Persona p = new Persona();
		try {
			p = personaON.read(facturaHabitacion.getPersona().getCedula());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(p == null) {
			return "PERSONA NO ENCONTRADA. NO SE PUEDE INSERTAR CABECERA";
		} else {
			try {
				facturaHabitacionON.insert(facturaHabitacion);
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
	public String eliminarFacturaHabitacion(int id) {//ELIMINAR FACTURA
		this.detallesHabitacion = detalleHabitacionON.getFacturas();
		for(int i = 0; i < this.detallesHabitacion.size(); i++) {
			if(this.detallesHabitacion.get(i).getFacturaCabeceraHabitacion().getNumero() == id) {
				try {
					detalleHabitacionON.delete(this.detallesHabitacion.get(i).getCodigo());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "NO SE PUDO ELIMINAR EL DETALLE ASOCIADO A ÉSTA CABECERA";
				}
			}
		}
		
		try {
			facturaHabitacionON.delete(id);
			return "CABECERA ELIMINADA";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR CABECRA";
		}
	}//ELIMINAR FACTURA

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FacturaCabeceraHabitacion> getFacturas(){
		List<FacturaCabeceraHabitacion> facturasHabitacion = new ArrayList<FacturaCabeceraHabitacion>();
		facturasHabitacion = facturaHabitacionON.getFacturas();
		
		return facturasHabitacion;
	}


}
