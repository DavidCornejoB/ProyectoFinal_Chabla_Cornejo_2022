package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;

//OBJETO DE NEGOCIO DE HOTEL QUE SERÁ CONSUMIDO LOCALMENTE
@Local
public interface HotelONLocal {
	
	public void insert(Hotel h) throws Exception;
	
	public void update(Hotel h) throws Exception;
	
	public Hotel read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Hotel> getHoteles();

}
