package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.ReservaDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Reserva;

@Stateless
public class ReservaON implements ReservaONRemote{
	
	@Inject
	private ReservaDAO daoReserva;
	
	public void insert(Reserva r) throws Exception{
		daoReserva.insert(r);
	}
	
	public void update(Reserva r) throws Exception{
		daoReserva.update(r);
	}
	
	public void read(String id) throws Exception{
		daoReserva.read(id);
	}
	
	public void delete(int id) throws Exception{
		daoReserva.delete(id);
	}
	
	public List<Reserva> getReservas(){
		return daoReserva.getList();
	}

}
