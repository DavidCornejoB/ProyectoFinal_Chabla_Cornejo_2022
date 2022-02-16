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
import ec.edu.ups.pw59.proyectofinal.business.ServicioONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraServicio;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleServicio;
import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

@Path("detalleservicio")
public class ServicesDetalleServicio {
	
	@Inject
	private FacturaDetalleServicioONLocal detalleServicioON;
	
	@Inject
	private FacturaCabeceraServicioONLocal facturaServicioON;
	
	@Inject
	private ServicioONLocal servicioON;
	
	private List<FacturaCabeceraServicio> facturasServicio;
	
	private List<Servicio> servicios;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String ingresarDetalle(FacturaDetalleServicio detalleServicio) {//INSERTAR DETALLE
		this.facturasServicio = facturaServicioON.getFacturas();
		for(int i = 0; i < this.facturasServicio.size(); i++) {
			if(detalleServicio.getFacturaCabeceraServicio().getNumero() == this.facturasServicio.get(i).getNumero()) {
				System.out.println("CABECERA ENCONTRADA");
				
				this.servicios = servicioON.getServicios();
				for(int j = 0; j < this.servicios.size(); j++) {
					if(detalleServicio.getServicio().getCodigo() == this.servicios.get(i).getCodigo()) {
						try {
							detalleServicioON.insert(detalleServicio);
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
		return "NO SE HA PODIDO INSERTAR EL DETALLE. NO SE HA ENCONTRADO CABECERA O SERVICIO";
	}//INSERTAR DETALLE
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarDetalle(int id) {//ELIMINAR DETALLE
		try {
			detalleServicioON.delete(id);
			return "DETALLE ELIMINADO";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR DETALLE";
		}
	}//ELIMINAR DETALLE
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FacturaDetalleServicio> getDetalles(){//GET DETALLES
		List<FacturaDetalleServicio> detallesServicio = new ArrayList<>();
		detallesServicio = detalleServicioON.getFacturas();
		
		return detallesServicio;
	}//GET DETALLES

}
