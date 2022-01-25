package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.HabitacionDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;

@Stateless
public class HabitacionON implements HabitacionONRemote{
	
	@Inject
	private HabitacionDAO daoHabitacion;
	
	public void insert(Habitacion h) throws Exception{
		daoHabitacion.insert(h);
	}
	
	public void update(Habitacion h) throws Exception{
		daoHabitacion.update(h);
	}
	
	public void read(String id) throws Exception{
		daoHabitacion.read(id);
	}
	
	public void delete(int id) throws Exception{
		daoHabitacion.delete(id);
	}
	
	public List<Habitacion> getHabitaciones(){
		return daoHabitacion.getList();
	}

}
