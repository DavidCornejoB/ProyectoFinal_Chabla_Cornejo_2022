package ec.edu.ups.pw59.proyectofinal.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.LoginONLocal;
import ec.edu.ups.pw59.proyectofinal.business.PersonaONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Login;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

/**
 * BEAN PARA EDITAR DATOS DEL USUARIO LOGUEADO
 * @author luisd
 *
 */
@Named
@RequestScoped
public class clienteEditarBean {
	
	@Inject
	private LoginONLocal loginON;
	
	@Inject
	private PersonaONLocal personaON;
	
	private Persona persona;
	
	private Login login;
	
	private clienteLoginBean clienteLogin;
	
	public clienteEditarBean() {
	}
	
	/**
	 * método PostConstruct
	 */
	@PostConstruct
	public void init() {
		loadData();

	}

	/**
	 * 
	 * @return objeto de negocio login
	 */
	public LoginONLocal getLoginON() {
		return loginON;
	}

	/**
	 * 
	 * @param loginON objeto de negocio de login
	 */
	public void setLoginON(LoginONLocal loginON) {
		this.loginON = loginON;
	}

	/**
	 * 
	 * @return objeto de negocio de persona personaON
	 */
	public PersonaONLocal getPersonaON() {
		return personaON;
	}

	/**
	 * 
	 * @param personaON objeto de negocio de persona
	 */
	public void setPersonaON(PersonaONLocal personaON) {
		this.personaON = personaON;
	}
	
	/**
	 * 
	 * @return entidad persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * 
	 * @param entidad persona
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * 
	 * @return entidad login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * 
	 * @param entidad login
	 */
	public void setLogin(Login login) {
		this.login = login;
	}
	
	/**
	 * METODO QUE REDIRECCIONA AL FORMULARIO DE EDITAR PERSONA
	 * @return formulario cliente-editar-persona
	 */
	public String editar() {
		return "cliente-editar-persona?faces-redirect=true";
	}

	/**
	 * MÉTODO PARA EDITAR DATOS DE PERSONA LOGUEADA
	 * @return formulario cliente-ubicacion
	 */
	public String editarPersona() {
		
		try {
			personaON.update(this.persona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			loginON.update(this.login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "cliente-ubicacion";
			
	}
	
	/**
	 * METODO PARA CARGAR DATOS DE PERSONA LOGUEADA
	 */
	public void loadData() {
		this.persona = clienteLogin.getLogueo().getPersona();
		this.login = clienteLogin.getLogueo();
	}
	

}
