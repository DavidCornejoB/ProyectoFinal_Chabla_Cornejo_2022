package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetallePaquete;

@Local
public interface FacturaDetallePaqueteONLocal {
	
	public void insert(FacturaDetallePaquete f) throws Exception;
	
	public void update(FacturaDetallePaquete f) throws Exception;
	
	public void read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<FacturaDetallePaquete> getFacturas();

}