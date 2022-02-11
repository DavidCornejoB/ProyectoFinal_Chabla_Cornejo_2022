package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.PersonaONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

@Named //ETIQUETA DE MANAGED BEANS
@RequestScoped
public class PersonasBean {
	
	//LLAMAMOS AL OBJETO DE NEGOCIO LOCAL QUE CONTIENE LOS MÉTODOS INSERT, UPDATE, READ Y DELETE
	@Inject
	private PersonaONLocal personaON;
	
	//Llamamos a la cedula para los ajax (editar)
	private String cedula;
	
	//CREAMOS EL OBJETO PERSONA. COMO ESTÁ INSTANCIADO, ESTARÁN SUS VALORES VACÍOS, Y PODREMOS MODIFICARLOS DESDE EL FORMULARIO
	private Persona persona = new Persona();
	
	//LISTA DE PERSONAS
	private List<Persona> personas;
	
	//CONSTRUCTOR
	public PersonasBean() {
	}
	
	//UTILIZAMOS LA ETIQUETA POSTCONSTRUCT POR SI QUEREMOS LISTAR ANTES DE TENER ELEMENTOS EN LA LISTA.
	@PostConstruct
	public void init() {
		this.cargar();
	}

	//METODOS GET() Y SET()
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	//MÉTODO PARA GUARDAR PERSONAS
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
	
	//MÉTODO PARA EDITAR PERSONAS
	public String editar(String cedula) {
		System.out.println("EDITANDO " + cedula);
		return "persona?faces-redirect=true&id="+cedula;
	}
	
	//MÉTODO PARA LISTAR PERSONAS
	public void cargar() {
		//LLAMAMOS AL MÉTODO GETPERSONAS() DEL OBJETO DE NEGOCIO
		this.personas = personaON.getPersonas();
	}
	
	public String volverIngresar() {
		System.out.println("VOLVIENDO A INGRESAR...");
		return "persona";
	}
	
	//Metodo para cargar los datos y por medio de la cedula y lograr editar
	public void loadData() {
		if(cedula==null)
			return;
		
		Persona p = personaON.getPersona(cedula);
		persona = p;
	}
	


}
