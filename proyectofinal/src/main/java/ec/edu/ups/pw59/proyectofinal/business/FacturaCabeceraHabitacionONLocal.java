package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraHabitacion;

//OBJETO DE NEGOCIO DE FACTURACABECERAHABITACION QUE SERÁ CONSUMIDO LOCALMENTE
@Local
public interface FacturaCabeceraHabitacionONLocal {
	
	public void insert(FacturaCabeceraHabitacion f) throws Exception;
	
	public void update(FacturaCabeceraHabitacion f) throws Exception;
	
	public void read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<FacturaCabeceraHabitacion> getFacturas();

}
