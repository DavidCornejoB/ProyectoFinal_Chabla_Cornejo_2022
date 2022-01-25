package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pw59.proyectofinal.modelo.Paquete;

@Remote
public interface PaqueteONRemote {
	
	public void insert(Paquete p) throws Exception;
	
	public void update(Paquete p) throws Exception;
	
	public void read(String id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Paquete> getPaquetes();

}
