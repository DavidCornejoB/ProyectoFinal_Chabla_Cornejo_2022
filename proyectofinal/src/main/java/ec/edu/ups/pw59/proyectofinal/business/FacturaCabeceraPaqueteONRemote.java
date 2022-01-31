package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraPaquete;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

//OBJETO DE NEGOCIO DE FACTURACABECERAPAQUETE QUE SERÁ CONSUMIDO REMOTAMENTE
@Remote
public interface FacturaCabeceraPaqueteONRemote {
	
	public void insert(FacturaCabeceraPaquete f) throws Exception;
	
	public void update(FacturaCabeceraPaquete f) throws Exception;
	
	public void read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<FacturaCabeceraPaquete> getFacturas();
	
	public Persona getPersona(String cedula);

}
