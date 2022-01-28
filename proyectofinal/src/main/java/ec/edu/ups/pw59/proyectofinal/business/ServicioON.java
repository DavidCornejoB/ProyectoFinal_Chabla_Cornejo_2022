package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.ServicioDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

@Stateless
public class ServicioON implements ServicioONRemote, ServicioONLocal{
	
	@Inject
	private ServicioDAO daoServicio;
	
	public void insert(Servicio s) throws Exception{
		daoServicio.insert(s);
	}
	
	public void update(Servicio s) throws Exception{
		daoServicio.update(s);
	}
	
	public void read(String id) throws Exception{
		daoServicio.read(id);
	}
	
	public void delete(int id) throws Exception{
		daoServicio.delete(id);
	}
	
	public List<Servicio> getServicios(){
		return daoServicio.getList();
	}

}
