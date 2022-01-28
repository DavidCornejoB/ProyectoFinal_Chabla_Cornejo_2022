package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleHabitacion;
//OBJETO DE NEGOCIO DE DETALLEHABITACION QUE SERÁ CONSUMIDO REMOTAMENTE
@Remote
public interface FacturaDetalleHabitacionONRemote {
	
	public void insert(FacturaDetalleHabitacion f) throws Exception;
	
	public void update(FacturaDetalleHabitacion f) throws Exception;
	
	public void read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<FacturaDetalleHabitacion> getFacturas();

}
