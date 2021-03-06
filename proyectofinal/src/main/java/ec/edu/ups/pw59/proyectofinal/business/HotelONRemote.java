package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;

//OBJETO DE NEGOCIO DE HOTEL QUE SERÁ CONSUMIDO REMOTAMENTE
@Remote
public interface HotelONRemote {
	
	public void insert(Hotel h) throws Exception;
	
	public void update(Hotel h) throws Exception;
	
	public Hotel read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Hotel> getHoteles();

}
