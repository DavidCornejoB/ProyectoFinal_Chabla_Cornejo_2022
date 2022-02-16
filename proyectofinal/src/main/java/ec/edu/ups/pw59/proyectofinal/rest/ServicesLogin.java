package ec.edu.ups.pw59.proyectofinal.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.pw59.proyectofinal.business.LoginONLocal;
import ec.edu.ups.pw59.proyectofinal.business.PersonaONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Login;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

@Path("login")
public class ServicesLogin {
	
	@Inject
	private LoginONLocal loginON;
	
	@Inject
	private PersonaONLocal personaON;
	
	private List<Persona> personas;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String ingresarLogins(Login login) {//INGRESAR LOGIN
		
		Persona p = new Persona();
		try {
			p = personaON.read(login.getPersona().getCedula());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(p == null) {
			return "NO SE ENCONTRÓ UNA PERSONA CON LA CÉDULA " + login.getPersona().getCedula();
		} else {
			try {
				loginON.insert(login);
				return "LOGIN INSERTADO";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "ERROR AL INSERTAR LOGIN";
			}
		}
		
	}//INGRESAR LOGIN
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarLogin(int id) {//ELIMINAR LOGIN
		
		try {
			loginON.delete(id);
			return "LOGIN ELIMINADO";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR EL LOGIN";
		}
	}//ELIMINAR LOGIN
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Login> getLogins(){//GET LOGINS
		List<Login> logins = new ArrayList<>();
		logins = loginON.getLogins();
		
		return logins;
		
	}//GET LOGINS

}
