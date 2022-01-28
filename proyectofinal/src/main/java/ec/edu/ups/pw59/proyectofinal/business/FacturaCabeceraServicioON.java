package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.FacturaCabeceraServicioDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraServicio;

@Stateless
public class FacturaCabeceraServicioON implements FacturaCabeceraServicioONRemote, FacturaCabeceraServicioONLocal{
	
	@Inject
	private FacturaCabeceraServicioDAO daoFacturaCabeceraServicio;
	
	public void insert(FacturaCabeceraServicio f) throws Exception{
		daoFacturaCabeceraServicio.insert(f);
	}
	
	public void update(FacturaCabeceraServicio f) throws Exception{
		daoFacturaCabeceraServicio.update(f);
	}
	
	public void read(int id) throws Exception{
		daoFacturaCabeceraServicio.read(id);
	}
	
	public void delete(int id) throws Exception{
		daoFacturaCabeceraServicio.delete(id);
	}
	
	public List<FacturaCabeceraServicio> getFacturas(){
		return daoFacturaCabeceraServicio.getList();
	}

}
