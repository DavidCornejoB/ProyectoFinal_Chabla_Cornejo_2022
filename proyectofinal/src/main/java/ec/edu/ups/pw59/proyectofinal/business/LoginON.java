package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.LoginDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Login;

@Stateless
public class LoginON implements LoginONRemote, LoginONLocal{
	
	@Inject
	private LoginDAO daoLogin;
	
	public void insert(Login l) throws Exception{
		daoLogin.insert(l);
	}
	
	public void update(Login l) throws Exception{
		daoLogin.update(l);
	}
	
	public void read(String id) throws Exception{
		daoLogin.read(id);
	}
	
	public void delete(int id) throws Exception{
		daoLogin.delete(id);
	}
	
	public List<Login> getLogin(){
		return daoLogin.getList();
	}

}
