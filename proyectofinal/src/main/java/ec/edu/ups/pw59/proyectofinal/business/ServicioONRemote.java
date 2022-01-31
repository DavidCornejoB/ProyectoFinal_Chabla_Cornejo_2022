package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;
import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

//OBJETO DE NEGOCIO SERVICIO QUE SERÁ CONSUMIDO REMOTAMENTE
@Remote
public interface ServicioONRemote {
	
	public void insert(Servicio s) throws Exception;
	
	public void update(Servicio s) throws Exception;
	
	public void read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Servicio> getServicios();
	
	public Hotel getHotel(int id);

}
