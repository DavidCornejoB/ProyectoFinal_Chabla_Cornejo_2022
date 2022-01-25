package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.PaqueteDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Paquete;

@Stateless
public class PaqueteON implements PaqueteONRemote{
	
	@Inject
	private PaqueteDAO daoPaquete;
	
	public void insert(Paquete p) throws Exception{
		daoPaquete.insert(p);
	}
	
	public void update(Paquete p) throws Exception{
		daoPaquete.update(p);
	}
	
	public void read(String id) throws Exception{
		daoPaquete.read(id);
	}
	
	public void delete(int id) throws Exception{
		daoPaquete.delete(id);
	}
	
	public List<Paquete> getPaquetes(){
		return daoPaquete.getList();
	}

}
