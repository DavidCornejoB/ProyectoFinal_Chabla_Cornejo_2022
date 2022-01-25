package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.FacturaDetalleHabitacionDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleHabitacion;

@Stateless
public class FacturaDetalleHabitacionON implements FacturaDetalleHabitacionONRemote{
	
	@Inject
	private FacturaDetalleHabitacionDAO daoFacturaDetalleHabitacion;
	
	public void insert(FacturaDetalleHabitacion f) throws Exception{
		daoFacturaDetalleHabitacion.insert(f);
	}
	
	public void update(FacturaDetalleHabitacion f) throws Exception{
		daoFacturaDetalleHabitacion.update(f);
	}
	
	public void read(int id) throws Exception{
		daoFacturaDetalleHabitacion.read(id);
	}
	
	public void delete(int id) throws Exception{
		daoFacturaDetalleHabitacion.delete(id);
	}
	
	public List<FacturaDetalleHabitacion> getFacturas(){
		return daoFacturaDetalleHabitacion.getList();
	}

}
