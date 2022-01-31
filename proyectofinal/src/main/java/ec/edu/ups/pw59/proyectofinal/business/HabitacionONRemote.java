package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pw59.proyectofinal.modelo.Categoria;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;

//OBJETO DE NEGOCIO DE HABITACION QUE SERÁ CONSUMIDO REMOTAMENTE
@Remote
public interface HabitacionONRemote {
	
	public void insert(Habitacion h) throws Exception;
	
	public void update(Habitacion h) throws Exception;
	
	public void read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Habitacion> getHabitaciones();
	
	public Categoria getCategoria(int id);
	
	public Hotel getHotel(int id);

}
