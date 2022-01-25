package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pw59.proyectofinal.modelo.Login;

@Remote
public interface LoginONRemote {
	
	public void insert(Login l) throws Exception;
	
	public void update(Login l) throws Exception;
	
	public void read(String id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Login> getLogin();

}
