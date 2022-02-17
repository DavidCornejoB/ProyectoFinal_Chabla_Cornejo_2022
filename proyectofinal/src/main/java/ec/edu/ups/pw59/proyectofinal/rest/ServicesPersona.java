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

@Path("persona")
public class ServicesPersona {
	
	@Inject
	private PersonaONLocal personaON;
	
	@Inject
	private LoginONLocal loginON;
	
	private List<Login> logins;
	
	@PUT
	@Path("/registrar")
	@Produces(MediaType.APPLICATION_JSON)
	public Mensaje ingresarPersona(Persona persona) {//INSERTAR PERSONA
		
		Mensaje msj = new Mensaje();
		try {
			personaON.guardar(persona);
			msj.setCodigo("01");
			msj.setMensaje("OK");
			return msj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msj.setCodigo("99");
			msj.setMensaje("ERROR");
			return msj;
		}
		
	}//INSERTAR PERSONA
	
	@DELETE
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarPersona(String cedula) {//ELIMINAR PERSONA
		this.logins = loginON.getLogins();
		for(int i = 0; i < this.logins.size(); i++) {
			if(this.logins.get(i).getPersona().getCedula().equals(cedula)) {
				
				try {
					loginON.delete(this.logins.get(i).getCodigo());
					System.out.println("LOGIN ELIMINADO");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("NO SE HA PODIDO ELIMINAR EL LOGIN");
					e.printStackTrace();
				}
			}
		}
		
		try {
			personaON.delete(cedula);
			return "PERSONA ELIMINADA";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR PERSONA";
		}
	}//ELIMINAR PERSONA
	
	@GET
	@Path("/personas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> getPersonas(){
		List<Persona> personas = new ArrayList<Persona>();
		
		personas = personaON.getPersonas();
		return personas;
	}
	



}
