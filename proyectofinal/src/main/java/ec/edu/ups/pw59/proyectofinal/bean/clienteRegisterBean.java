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
	
	@PostConstruct
	public void init() {
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
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

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
	
	public void cargar() {
		
		this.logins = loginON.getLogins();
	}
	
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
	
	public String volverIngresar() {
		System.out.println("VOLVIENDO A INGRESO LOGIN...");
		return "login";
	}
	
	
	

}
