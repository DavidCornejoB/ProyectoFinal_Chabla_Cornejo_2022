package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetallePaquete;

@Remote
public interface FacturaDetallePaqueteONRemote {
	
	public void insert(FacturaDetallePaquete f) throws Exception;
	
	public void update(FacturaDetallePaquete f) throws Exception;
	
	public void read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<FacturaDetallePaquete> getFacturas();

}