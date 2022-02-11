package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;
import ec.edu.ups.pw59.proyectofinal.modelo.Paquete;
import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

//OBJETO DE NEGOCIO DE PAQUETE QUE SERÁ CONSUMIDO REMOTAMENTE
@Remote
public interface PaqueteONRemote {
	
	public void insert(Paquete p) throws Exception;
	
	public void update(Paquete p) throws Exception;
	
	public Paquete read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Paquete> getPaquetes();
	
	public Habitacion getHabitacion(int id);
	
	public Hotel getHotel(int id);
	
	public Servicio getServicio(int id);

}
