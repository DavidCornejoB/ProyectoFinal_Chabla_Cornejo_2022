package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.FacturaDetallePaqueteDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetallePaquete;

@Stateless
public class FacturaDetallePaqueteON implements FacturaDetallePaqueteONRemote{
	
	@Inject
	private FacturaDetallePaqueteDAO daoFacturaDetallePaquete;
	
	public void insert(FacturaDetallePaquete f) throws Exception{
		daoFacturaDetallePaquete.insert(f);
	}
	
	public void update(FacturaDetallePaquete f) throws Exception{
		daoFacturaDetallePaquete.update(f);
	}
	
	public void read(int id) throws Exception{
		daoFacturaDetallePaquete.read(id);
	}
	
	public void delete(int id) throws Exception{
		daoFacturaDetallePaquete.delete(id);
	}
	
	public List<FacturaDetallePaquete> getFacturas(){
		return daoFacturaDetallePaquete.getList();
	}

}
