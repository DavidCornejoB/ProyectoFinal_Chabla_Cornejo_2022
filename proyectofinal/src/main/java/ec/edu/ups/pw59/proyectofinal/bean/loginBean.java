package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.LoginONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Login;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

@Named
@RequestScoped
public class loginBean {
	
	@Inject
	private LoginONLocal loginON;
	
	private Login login = new Login();
	
	private List<Login> logins;
	
	public loginBean() {
		
	}
	
	@PostConstruct
	public void init() {
		this.login.setPersona(new Persona());
		this.cargar();
	}

	//METODOS GET() Y SET()
	
	public LoginONLocal getLoginON() {
		return loginON;
	}

	public void setLoginON(LoginONLocal loginON) {
		this.loginON = loginON;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Login> getLogins() {
		return logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}
	
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
	
	public void cargar() {
		
		this.logins = loginON.getLogins();
	}
	
	public String cargarPersona() {
		
		String id = this.login.getPersona().getCedula();
		
		Persona p = loginON.getPersona(id);
		this.login.setPersona(p);
		
		return null;
	}
	
	public String volverIngresar() {
		System.out.println("VOLVIENDO A INGRESO LOGIN...");
		return "login";
	}
	
	
	

}
