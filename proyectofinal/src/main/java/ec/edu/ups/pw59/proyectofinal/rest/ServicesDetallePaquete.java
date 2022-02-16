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
import ec.edu.ups.pw59.proyectofinal.business.PaqueteONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraPaquete;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetallePaquete;
import ec.edu.ups.pw59.proyectofinal.modelo.Paquete;

@Path("detallepaquete")
public class ServicesDetallePaquete {
	
	@Inject
	private FacturaDetallePaqueteONLocal detallePaqueteON;
	
	@Inject
	private FacturaCabeceraPaqueteONLocal facturaPaqueteON;
	
	@Inject
	private PaqueteONLocal paqueteON;
	
	List<FacturaCabeceraPaquete> facturasPaquete;
	
	List<Paquete> paquetes;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String insertarDetalle(FacturaDetallePaquete detallePaquete) {//INSERTAR DETALLE
		this.facturasPaquete = facturaPaqueteON.getFacturas();
		for(int i = 0; i < this.facturasPaquete.size(); i++) {
			if(detallePaquete.getFacturaCabeceraPaquete().getNumero() == this.facturasPaquete.get(i).getNumero()) {
				System.out.println("CABECERA ENCONTRADA");
				
				this.paquetes = paqueteON.getPaquetes();
				for(int j = 0; j < this.paquetes.size(); j++) {
					if(detallePaquete.getPaquete().getCodigo() == this.paquetes.get(i).getCodigo()) {
						try {
							detallePaqueteON.insert(detallePaquete);
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
		return "NO SE HA PODIDO INSERTAR EL DETALLE. NO SE HA ENCONTRADO CABECERA O PAQUETE";
	}//INSERTAR DETALLE
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarPaquete(int id) {//ELIMINAR PAQUETE
		
		try {
			detallePaqueteON.delete(id);
			return "DETALLE ELIMINADO";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR DETALLE";
		}
	}//ELIMINAR PAQUETE
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FacturaDetallePaquete> getDetalles(){//GET DETALLES
		List<FacturaDetallePaquete> detallesPaquete = new ArrayList<>();
		detallesPaquete = detallePaqueteON.getFacturas();
		
		return detallesPaquete;
	}//GET DETALLES

}
