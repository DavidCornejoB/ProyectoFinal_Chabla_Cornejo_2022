package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pw59.proyectofinal.modelo.Login;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

//OBJETO DE NEGOCIO DE LOGIN QUE SERA CONSUMIDO REMOTAMENTE
@Remote
public interface LoginONRemote {
	
	public void insert(Login l) throws Exception;
	
	public void update(Login l) throws Exception;
	
	public Login read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Login> getLogins();
	
	public Persona getPersona(String id);

}
