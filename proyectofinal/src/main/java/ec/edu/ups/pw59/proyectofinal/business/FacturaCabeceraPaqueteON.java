package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.FacturaCabeceraPaqueteDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraPaquete;

@Stateless
public class FacturaCabeceraPaqueteON implements FacturaCabeceraPaqueteONRemote{
	
	@Inject
	private FacturaCabeceraPaqueteDAO daoFacturaCabeceraPaquete;
	
	public void insert(FacturaCabeceraPaquete f) throws Exception{
		daoFacturaCabeceraPaquete.insert(f);
	}
	
	public void update(FacturaCabeceraPaquete f) throws Exception{
		daoFacturaCabeceraPaquete.update(f);
	}
	
	public void read(int id) throws Exception{
		daoFacturaCabeceraPaquete.read(id);
	}
	
	public void delete(int id) throws Exception{
		daoFacturaCabeceraPaquete.delete(id);
	}
	
	public List<FacturaCabeceraPaquete> getFacturas(){
		return daoFacturaCabeceraPaquete.getList();
	}

}
