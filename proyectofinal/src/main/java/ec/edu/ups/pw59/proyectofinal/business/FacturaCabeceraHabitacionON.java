package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.FacturaCabeceraHabitacionDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraHabitacion;

@Stateless
public class FacturaCabeceraHabitacionON implements FacturaCabeceraHabitacionONRemote{
	
	@Inject
	private FacturaCabeceraHabitacionDAO daoFacturaCabeceraHabitacion;
	
	public void insert(FacturaCabeceraHabitacion p) throws Exception{
		daoFacturaCabeceraHabitacion.insert(p);
	}
	
	public void update(FacturaCabeceraHabitacion p) throws Exception{
		daoFacturaCabeceraHabitacion.update(p);
	}
	
	public void read(int id) throws Exception{
		daoFacturaCabeceraHabitacion.read(id);
	}
	
	public void delete(int id) throws Exception{
		daoFacturaCabeceraHabitacion.delete(id);
	}
	
	public List<FacturaCabeceraHabitacion> getFacturas(){
		return daoFacturaCabeceraHabitacion.getList();	
	}

}
