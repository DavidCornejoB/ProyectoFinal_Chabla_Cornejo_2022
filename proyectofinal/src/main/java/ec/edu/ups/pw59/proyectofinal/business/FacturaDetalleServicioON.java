package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.FacturaDetalleServicioDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleServicio;

@Stateless
public class FacturaDetalleServicioON implements FacturaDetalleServicioONRemote{
	
	@Inject
	private FacturaDetalleServicioDAO daoFacturaDetalleServicio;
	
	public void insert(FacturaDetalleServicio f) throws Exception{
		daoFacturaDetalleServicio.insert(f);
	}
	
	public void update(FacturaDetalleServicio f) throws Exception{
		daoFacturaDetalleServicio.update(f);
	}
	
	public void read(int id) throws Exception{
		daoFacturaDetalleServicio.read(id);
	}
	
	public void delete(int id) throws Exception{
		daoFacturaDetalleServicio.delete(id);
	}
	
	public List<FacturaDetalleServicio> getFacturas(){
		return daoFacturaDetalleServicio.getList();
	}

}
