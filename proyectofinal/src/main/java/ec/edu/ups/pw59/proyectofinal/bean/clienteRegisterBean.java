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
 * BEAN PARA REGISTRAR CLIENTES
 * @author luisd
 *
 */
@Named
@RequestScoped
public class clienteRegisterBean {
	
	@Inject
	private LoginONLocal loginON;
	
	@Inject
	private PersonaONLocal personaON;
	
	private Persona persona = new Persona();
		
	private Login login = new Login();
	
	private List<Login> logins;
	
	public clienteRegisterBean() {
		
	}
	
	/**
	 * PostConstruct
	 */
	@PostConstruct
	public void init() {
	}

	//METODOS GET() Y SET()
	
	/**
	 * 
	 * @return loginON
	 */
	public LoginONLocal getLoginON() {
		return loginON;
	}

	/**
	 * 
	 * @param loginON
	 */
	public void setLoginON(LoginONLocal loginON) {
		this.loginON = loginON;
	}

	/**
	 * 
	 * @return login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * 
	 * @param login
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * 
	 * @return logins
	 */
	public List<Login> getLogins() {
		return logins;
	}

	/**
	 * 
	 * @param logins
	 */
	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}
	
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
	 * METODO PARA GUARDAR REGISTRO
	 * @return error-register
	 */
	public String guardar() {
		
		boolean existePersona = leerPersona();
		
		if (existePersona == true) {
			
			try {
				this.persona.setTipo("Cliente");
				personaON.insert(this.persona);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error al insertar persona";
			}
			this.logins = loginON.getLogins();
			
			this.login.setPersona(this.persona);
			
			try {
				loginON.insert(this.login);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error al insertar login";
			}
			
			return "cliente-loguearse?faces-redirect=true";
			
		} else {
			
			return "error-register";
			
		}
	}
	
	/**
	 * METODO PARA CARGAR LOGINS
	 */
	public void cargar() {
		
		this.logins = loginON.getLogins();
	}
	
	/**
	 * METODO PARA LEER PERSONA
	 * @return formulario login
	 */
	public boolean leerPersona() {
		
		Persona p = new Persona();
		try {
			p = personaON.read(this.persona.getCedula());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(p == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * METODO PARA REDIRECCIONAR
	 * @return formulario login
	 */
	public String volverIngresar() {
		System.out.println("VOLVIENDO A INGRESO LOGIN...");
		return "login";
	}
	
	
	

}
