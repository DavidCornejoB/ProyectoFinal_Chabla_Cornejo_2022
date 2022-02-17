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
import ec.edu.ups.pw59.proyectofinal.business.ReservaONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraHabitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleHabitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Reserva;

@Path("detallehabitacion")
public class ServicesDetalleHabitacion {
	
	@Inject
	private FacturaDetalleHabitacionONLocal detalleHabitacionON;
	
	@Inject
	private FacturaCabeceraHabitacionONLocal facturaHabitacionON;
	
	@Inject
	private ReservaONLocal reservaON;
	
	private List<FacturaCabeceraHabitacion> facturasHabitacion;
	
	private List<Reserva> reservas;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String ingresarDetalle(FacturaDetalleHabitacion detalleHabitacion) {// INSERTAR DETALE
		this.facturasHabitacion = facturaHabitacionON.getFacturas();
		for(int i = 0; i < this.facturasHabitacion.size(); i++) {
			if(detalleHabitacion.getFacturaCabeceraHabitacion().getNumero() == this.facturasHabitacion.get(i).getNumero()) {
				System.out.println("CABECERA ENCONTRADA");
				
				this.reservas = reservaON.getReservas();
				for(int j = 0; j < this.reservas.size(); j++) {
					if(detalleHabitacion.getReserva().getCodigo() == this.reservas.get(j).getCodigo()) {
						try {
							detalleHabitacionON.insert(detalleHabitacion);
							return "DETALLE INSERTADO";
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							return "ERROR AL INSERTAR DETALLE";
						}
					}
				}
			}
		}
		return "NO SE HA PODIDO INSERTAR EL DETALLE. NO SE HA ENCONTRADO CABECERA O RESERVA";
	}//INSERTAR DETALLE
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarDetalle(int id) {//ELIMINAR DETALLE
	
		try {
			detalleHabitacionON.delete(id);
			return "DETALLE ELIMINADO";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR DETALLE";
		}
	}//ELIMINAR DETALLE
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FacturaDetalleHabitacion> getDetalles(){//GET DETALLES
		List<FacturaDetalleHabitacion> detallesHabitacion = new ArrayList<>();
		detallesHabitacion = detalleHabitacionON.getFacturas();
		
		return detallesHabitacion;
	}//GET DETALLES

}
