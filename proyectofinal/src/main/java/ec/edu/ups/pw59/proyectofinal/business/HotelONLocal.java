package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;

@Local
public interface HotelONLocal {
	
	public void insert(Hotel h) throws Exception;
	
	public void update(Hotel h) throws Exception;
	
	public void read(String id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Hotel> getHoteles();

}
