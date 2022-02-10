package ec.edu.ups.pw59.proyectofinal.bean;

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
	
	@PostConstruct
	public void init() {
		loadData();

	}

	public LoginONLocal getLoginON() {
		return loginON;
	}

	public void setLoginON(LoginONLocal loginON) {
		this.loginON = loginON;
	}

	public PersonaONLocal getPersonaON() {
		return personaON;
	}

	public void setPersonaON(PersonaONLocal personaON) {
		this.personaON = personaON;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	public String editar() {
		
		return "cliente-editar-persona?faces-redirect=true";
	}

	public void editarPersona() {
		
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
			
	}
	
	public void loadData() {
		this.persona = clienteLogin.getLogueo().getPersona();
		this.login = clienteLogin.getLogueo();
	}
	

}
