package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.LoginONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Login;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

/**
 * BEAN PARA CRUD DE LOGINS
 * @author luisd
 *
 */
@Named
@RequestScoped
public class loginBean {
	
	@Inject
	private LoginONLocal loginON;
	
	private Login login = new Login();
	
	private List<Login> logins;
	
	public loginBean() {
		
	}
	
	/**
	 * PostConstruct
	 */
	@PostConstruct
	public void init() {
		this.login.setPersona(new Persona());
		this.cargar();
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
	 * @return login
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
	 * METODO DE GUARDAR LOGINS
	 * @return formulario listado-logins
	 */
	public String guardar() {
		
		System.out.println("GUARDANDO LOGIN: " + this.login.getClave());
		
		try {
			loginON.insert(this.login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "listado-logins?faces-redirect=true";
	}
	
	/**
	 * METODO PARA CARGAR LOGINS
	 */
	public void cargar() {
		
		this.logins = loginON.getLogins();
	}
	
	/**
	 * METODO PARA CARGAR PERSONA
	 * @return null
	 */
	public String cargarPersona() {
		
		String id = this.login.getPersona().getCedula();
		
		Persona p = loginON.getPersona(id);
		this.login.setPersona(p);
		
		return null;
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
