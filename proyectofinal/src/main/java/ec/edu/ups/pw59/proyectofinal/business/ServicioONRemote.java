package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

@Remote
public interface ServicioONRemote {
	
	public void insert(Servicio s) throws Exception;
	
	public void update(Servicio s) throws Exception;
	
	public void read(String id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Servicio> getServicios();

}
