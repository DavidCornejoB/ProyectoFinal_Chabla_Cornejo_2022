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
public class ServicesPersona {

	@Inject
	private PersonaONLocal personaON;

	@Inject
	private LoginONLocal loginON;

	@WebMethod
	public String insertarPersona(Persona persona) {// INSERTAR PERSONA

		Persona p = new Persona();

		try {
			p = personaON.read(persona.getCedula());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (p == null) {

			try {
				personaON.insert(persona);
				return "PERSONA INGRESADA";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "ERROR AL INGRESAR PERSONA";
			}

		} else {
			return "LA PERSONA YA HA SIDO INGRESADA";
		}

	}// INSERTAR PERSONA

	// ****************************************************
	// ****************************************************

	@WebMethod
	public String actualizarPersona(Persona persona) {// ACTUALIZAR PERSONA

		Persona p = new Persona();

		try {
			p = personaON.read(persona.getCedula());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (p == null) {

			return "NO SE HA ENCONTRADO LA PERSONA A ACTUALIZAR";

		} else {

			try {
				personaON.update(persona);
				return "PERSONA ACTUALIZADA";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "ERROR AL ACTUALIZAR PERSONA";
			}

		}
	}// ACTUALIZAR PERSONA

	// ****************************************************
	// ****************************************************

	@WebMethod
	public Persona leerPersona(Persona persona) {// LEER PERSONA

		try {
			return personaON.read(persona.getCedula());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("NO SE HA ENCONTRADO LA PERSONA");
			return null;
		}
	}// LEER PERSONA

	// ****************************************************
	// ****************************************************

	@WebMethod
	public String eliminarPersona(Persona persona) {// ELIMINAR PERSONA

		//PARA PODER ELIMINAR PERSONA, COMPROBAMOS SI ÉSTA TIENE UN LOGIN
		//1. primero, guardamos una lista de todos los login
		List<Login> logins = new ArrayList<Login>();
		logins = loginON.getLogins();

		//2. Buscamos si existe un login cuya variable de persona pertenezca a la persona que queremos eliminar
		for (int i = 0; i < logins.size(); i++) {
			if (logins.get(i).getPersona().getCedula().equals(persona.getCedula())) {
				
				System.out.println("SE HA ENCONTRADO LOGIN CON ÉSA PERSONA");
				
				try {
					loginON.delete(logins.get(i).getCodigo());
					System.out.println("LOGIN ELIMINADO");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("NO SE HA PODIDO ELIMINAR EL LOGIN");
				}
			}
		}
		
		//3. Una vez eliminado el login, podemos eliminar la persona
		try {
			personaON.delete(persona.getCedula());
			return "PERSONA: " + persona.getCedula() + " ELIMINADA";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR PERSONA";
		}

	}// ELIMINAR PERSONA

	// ******************************************************
	// ******************************************************

	@WebMethod
	public List<Persona> getPersonas() {// LISTAR PERSONAS

		List<Persona> personas = new ArrayList<Persona>();

		personas = personaON.getPersonas();

		return personas;

	}// LISTAR PERSONAS

}
