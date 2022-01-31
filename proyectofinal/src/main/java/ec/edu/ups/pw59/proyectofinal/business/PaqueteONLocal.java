package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;
import ec.edu.ups.pw59.proyectofinal.modelo.Paquete;
import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

//OBJETO DE NEGOCIO DE PAQUETE QUE SERÁ CONSUMIDO LOCALMENTE
@Local
public interface PaqueteONLocal {
	
	public void insert(Paquete p) throws Exception;
	
	public void update(Paquete p) throws Exception;
	
	public void read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Paquete> getPaquetes();
	
	public Habitacion getHabitacion(int id);
	
	public Hotel getHotel(int id);
	
	public Servicio getServicio(int id);

}
