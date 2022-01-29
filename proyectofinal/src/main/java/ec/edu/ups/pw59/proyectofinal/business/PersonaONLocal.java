package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

//OBJETO DE NEGOCIO DE PERSONA QUE SERÁ CONSUMIDO LOCALMENTE
@Local
public interface PersonaONLocal {
	
	public void insert(Persona p) throws Exception;
	
	public void update(Persona p) throws Exception;
	
	public void read(String id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Persona> getPersonas();

}
