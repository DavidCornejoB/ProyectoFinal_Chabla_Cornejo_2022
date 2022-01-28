package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

@Local
public interface ServicioONLocal {
	
	public void insert(Servicio s) throws Exception;
	
	public void update(Servicio s) throws Exception;
	
	public void read(String id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Servicio> getServicios();

}
