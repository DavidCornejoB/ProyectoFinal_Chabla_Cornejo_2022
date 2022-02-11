package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Reserva;

//OBJETO DE NEGOCIO DE RESERVA QUE SE CONSUMIRA REMOTAMENTE
@Remote
public interface ReservaONRemote {
	
	public void insert(Reserva r) throws Exception;
	
	public void update(Reserva r) throws Exception;
	
	public Reserva read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Reserva> getReservas();
	
	public Habitacion getHabitacion(int numero);

}
