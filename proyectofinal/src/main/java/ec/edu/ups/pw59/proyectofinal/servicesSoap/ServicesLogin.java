package ec.edu.ups.pw59.proyectofinal.servicesSoap;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.pw59.proyectofinal.business.LoginONLocal;
import ec.edu.ups.pw59.proyectofinal.business.PersonaONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Login;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

@WebService
public class ServicesLogin {
	
	@Inject
	private LoginONLocal loginON;
	
	@Inject
	private PersonaONLocal personaON;
	
	@WebMethod
	public String insertarLogin(Login login) {//INSERTAR LOGINS
		
		Persona p = login.getPersona();
		
		try {
			p = personaON.read(p.getCedula());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(p == null) {
			return "NO SE PUEDE CREAR LOGIN. NO EXISTE UNA PERSONA CON LA CEDULA " + login.getPersona().getCedula();
		} else {
			try {
				loginON.insert(login);
				return "LOGIN INSERTADO CORRECTAMENTE";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "ERROR AL INSERTAR LOGIN";
			}
		}
	}//INSERTAR LOGINS
	
	//**************************************************
	//**************************************************
	
	@WebMethod
	public String actualizarLogin(Login login) {//ACTUALIZAR LOGIN
		
		Login l = new Login();
		
		try {
			l = loginON.read(login.getCodigo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(l == null) {
			
			return "NO SE HA ENCONTRADO EL LOGIN A ACTUALIZAR";
		
		} else {
			
			try {
				loginON.update(login);
				return "LOGIN ACTUALIZADO";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "NO SE HA PODIDO ACTUALIZAR EL LOGIN";
			}
		}
	}//ACTUALIZAR LOGIN
	
	//***************************************************
	//***************************************************
	
	@WebMethod
	public Login leerLogin(Login login) {//LEER LOGIN
		try {
			return loginON.read(login.getCodigo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}//LEER LOGIN
	
	//***************************************************
	//***************************************************
	
	@WebMethod
	public String eliminarLogin(Login login) {//ELIMINAR LOGIN
		
		try {
			loginON.delete(login.getCodigo());
			return "LOGIN ELIMINADO CON EXITO";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "NO SE HA PODIDO ELIMINAR EL LOGIN";
		}
	}//ELIMINAR LOGIN
	
	//***************************************************
	//***************************************************
	
	@WebMethod
	public List<Login> getLogins(){
		
		List<Login> logins = new ArrayList<Login>();
		
		logins = loginON.getLogins();
		
		return logins;
	}

}
