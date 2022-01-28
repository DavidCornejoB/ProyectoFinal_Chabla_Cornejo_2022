package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraServicio;

//OBJETO DE NEGOCIO DE FACTURACABECERASERVICIO QUE SERA CONSUMIDO LOCALMENTE
@Local
public interface FacturaCabeceraServicioONLocal {
	
	public void insert(FacturaCabeceraServicio f) throws Exception;
	
	public void update(FacturaCabeceraServicio f) throws Exception;
	
	public void read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<FacturaCabeceraServicio> getFacturas();

}
