package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.LoginDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Login;

//OBJETO DE NEGOCIO PRINCIPAL. SE IMPLEMENTAN LOS OBJETOS DE NEGOCIO LOCALES Y REMOTOS
@Stateless
public class LoginON implements LoginONRemote, LoginONLocal{
	
	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DEL LOGIN
	@Inject
	private LoginDAO daoLogin;
	
	//MÉTODO PARA INSERTAR LOGINS
	public void insert(Login l) throws Exception{
		//LLAMAMOS AL METODO INSERT DEL DAO, LE ENVIAMOS EL OBJETO LOGIN QUE QUEREMOS INSERTAR
		daoLogin.insert(l);
	}
	
	//METODO PARA ACTUALIZAR LOGINS
	public void update(Login l) throws Exception{
		//LLAMAMOS AL METODO UPDATE DEL DAO, LE ENVIAMOS EL OBJETO LOGIN QUE QUEREMOS ACTUALIZAR
		daoLogin.update(l);
	}
	
	//METODO PARA LEER LOGINS
	public void read(String id) throws Exception{
		//LLAMAMOS AL METODO READ DEL DAO, LE ENVIAMOS LA ID DEL OBJETO LOGIN QUE QUEREMOS LEER
		daoLogin.read(id);
	}
	
	//METODO PARA ELIMINAR LOGINS
	public void delete(int id) throws Exception{
		//LLAMAMOS AL METODO DELETE DEL DAO, LE ENVIAMOS EL ID DEL OBJETO LOGIN QUE QUEREMOS ELIMINAR
		daoLogin.delete(id);
	}
	
	//METODO PARA LISTAR LOGINS
	public List<Login> getLogin(){
		//RETORNAMOS EL METODO GETLIST DEL DAO
		return daoLogin.getList();
	}

}
