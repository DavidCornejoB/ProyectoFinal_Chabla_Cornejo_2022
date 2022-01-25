package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.HotelDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;

@Stateless
public class HotelON implements HotelONRemote{
	
	@Inject
	private HotelDAO daoHotel;
	
	public void insert(Hotel h) throws Exception{
		daoHotel.insert(h);
	}
	
	public void update(Hotel h) throws Exception{
		daoHotel.update(h);
	}
	
	public void read(String id) throws Exception{
		daoHotel.read(id);
	}
	
	public void delete(int id) throws Exception{
		daoHotel.delete(id);
	}
	
	public List<Hotel> getHoteles(){
		return daoHotel.getList();
	}

}
