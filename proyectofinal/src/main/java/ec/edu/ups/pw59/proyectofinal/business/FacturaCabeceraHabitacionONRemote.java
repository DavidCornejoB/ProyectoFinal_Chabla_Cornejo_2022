package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraHabitacion;

@Remote
public interface FacturaCabeceraHabitacionONRemote {
	
	public void insert(FacturaCabeceraHabitacion f) throws Exception;
	
	public void update(FacturaCabeceraHabitacion f) throws Exception;
	
	public void read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<FacturaCabeceraHabitacion> getFacturas();

}
