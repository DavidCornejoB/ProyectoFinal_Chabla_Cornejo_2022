package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.LoginONLocal;
import ec.edu.ups.pw59.proyectofinal.business.PersonaONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Login;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

/**
 * 
 * @author luisd
 *
 */
@Named //ETIQUETA DE MANAGED BEANS
@RequestScoped
public class PersonasBean {
	
	/**
	 * LLAMAMOS AL OBJETO DE NEGOCIO LOCAL QUE CONTIENE LOS MÉTODOS INSERT, UPDATE, READ Y DELETE
	 */
	@Inject
	private PersonaONLocal personaON;
	
	@Inject
	private LoginONLocal loginON;
	
	//Llamamos a la cedula para los ajax (editar)
	private String cedula;
	
	/**
	 * CREAMOS EL OBJETO PERSONA. COMO ESTÁ INSTANCIADO, ESTARÁN SUS VALORES VACÍOS, Y PODREMOS MODIFICARLOS DESDE EL FORMULARIO
	 */
	private Persona persona = new Persona();
	
	/**
	 * LISTA DE PERSONAS
	 */
	private List<Persona> personas;
	
	private List<Login> logins;
	
	/**
	 * CONSTRUCTOR
	 */
	public PersonasBean() {
	}
	
	/**
	 * UTILIZAMOS LA ETIQUETA POSTCONSTRUCT POR SI QUEREMOS LISTAR ANTES DE TENER ELEMENTOS EN LA LISTA.
	 */
	@PostConstruct
	public void init() {
		this.cargar();
	}

	/*
	 * METODOS GET() Y SET()
	 */
	
	/**
	 * 
	 * @return persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * 
	 * @param persona
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * 
	 * @return personas
	 */
	public List<Persona> getPersonas() {
		return personas;
	}

	/**
	 * 
	 * @param personas
	 */
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	/**
	 * 
	 * @return cedula
	 */
	public String getCedula() {
		return cedula;
	}
	
	/**
	 * 
	 * @param cedula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * MÉTODO PARA GUARDAR PERSONAS
	 * @return formulario listado-personas
	 */
	public String guardar() {
		
		System.out.println("GUARDANDO PERSONA: " + this.persona.getNombre() + " " + this.persona.getApellido());
		
		try {
			//USAMOS EL MÉTODO INSERT DE LA ENTIDAD DE NEGOCIO DE PERSONA
			personaON.guardar(this.persona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//UNA VEZ SE HA INGRESADO UNA PERSONA, SE REDIRIGIRÁ AL FORMULARIO DE LISTAR PERSONAS
		return "listado-personas?faces-redirect=true";
	}
	
	/**
	 * MÉTODO PARA EDITAR PERSONAS
	 * @param cedula
	 * @return formulario persona
	 */
	public String editar(String cedula) {
		System.out.println("EDITANDO " + cedula);
		return "persona?faces-redirect=true&id="+cedula;
	}
	
	/**
	 * METODO PARA ELIMINAR PERSONAS
	 * @param cedula
	 * @return null
	 */
	public String eliminar(String cedula) {
		
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
			return "eliminar-persona";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * MÉTODO PARA LISTAR PERSONAS
	 */
	public void cargar() {
		//LLAMAMOS AL MÉTODO GETPERSONAS() DEL OBJETO DE NEGOCIO
		this.personas = personaON.getPersonas();
	}
	
	/**
	 * METODO PARA REDIRECCIONAR
	 * @return formulario persona
	 */
	public String volverIngresar() {
		System.out.println("VOLVIENDO A INGRESAR...");
		return "persona";
	}
	
	/**
	 * Metodo para cargar los datos y por medio de la cedula y lograr editar
	 */
	public void loadData() {
		if(cedula==null)
			return;
		
		Persona p = personaON.getPersona(cedula);
		persona = p;
	}
}
