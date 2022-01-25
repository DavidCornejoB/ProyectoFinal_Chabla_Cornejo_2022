package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleServicio;

@Remote
public interface FacturaDetalleServicioONRemote {
	
	public void insert(FacturaDetalleServicio f) throws Exception;
	
	public void update(FacturaDetalleServicio f) throws Exception;
	
	public void read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<FacturaDetalleServicio> getFacturas();

}
