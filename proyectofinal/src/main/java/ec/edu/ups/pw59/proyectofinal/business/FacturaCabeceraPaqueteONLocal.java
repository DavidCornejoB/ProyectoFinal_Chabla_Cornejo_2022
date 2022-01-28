package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraPaquete;

@Local
public interface FacturaCabeceraPaqueteONLocal {
	
	public void insert(FacturaCabeceraPaquete f) throws Exception;
	
	public void update(FacturaCabeceraPaquete f) throws Exception;
	
	public void read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<FacturaCabeceraPaquete> getFacturas();

}
