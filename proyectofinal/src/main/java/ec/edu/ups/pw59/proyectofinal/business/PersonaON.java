package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.PersonaDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

@Stateless
public class PersonaON implements PersonaONRemote, PersonaONLocal{
	
	@Inject
	private PersonaDAO daoPersona;
	
	public void insert(Persona p) throws Exception{
		daoPersona.insert(p);
	}
	
	public void update(Persona p) throws Exception{
		daoPersona.update(p);
	}
	
	public void read(String id) throws Exception{
		daoPersona.read(id);
	}
	
	public void delete(int id) throws Exception{
		daoPersona.delete(id);
	}
	
	public List<Persona> getPersonas(){
		return daoPersona.getList();
	}

}
