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

import ec.edu.ups.pw59.proyectofinal.business.HotelONLocal;
import ec.edu.ups.pw59.proyectofinal.business.ServicioONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;
import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

@Path("servicio")
public class ServicesServicio {
	
	@Inject
	private ServicioONLocal servicioON;
	
	@Inject
	private HotelONLocal hotelON;
	
	private List<Hotel> hoteles;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String ingresarServicio(Servicio servicio) {//INGRESAR SERVICIO
		
		this.hoteles = hotelON.getHoteles();
		for(int i = 0; i < this.hoteles.size(); i++) {
			if(servicio.getHotel().getCodigo() == this.hoteles.get(i).getCodigo()) {
				try {
					servicioON.insert(servicio);
					return "SERVICIO INSERTADO";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "ERROR AL INSERTAR SERVICIO";
				}
			}
		}
		
		return "NO SE HA ENCONTRADO UN HOTEL CON ÉSA ID (" + servicio.getHotel().getCodigo() + ")";
		
	}//INGRESAR SERVICIO
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarServicio(int id) {//ELIMINAR SERVICIO
		
		try {
			servicioON.delete(id);
			return "SERVICIO ELIMINADO";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR SERVICIO";
		}
	}//ELIMINAR SERVICIO
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Servicio> getServicios(){//GET SERVICIOS
		List<Servicio> servicios = new ArrayList<>();
		
		servicios = servicioON.getServicios();
		return servicios;
	}//GET SERVICIOS
	

	

}
