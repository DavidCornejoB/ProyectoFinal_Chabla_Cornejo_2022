package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pw59.proyectofinal.modelo.Reserva;

//OBJETO DE NEGOCIO DE RESERVA QUE SE CONSUMIRA LOCALMENTE
@Local
public interface ReservaONLocal {
	
	public void insert(Reserva r) throws Exception;
	
	public void update(Reserva r) throws Exception;
	
	public void read(String id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Reserva> getReservas();

}
