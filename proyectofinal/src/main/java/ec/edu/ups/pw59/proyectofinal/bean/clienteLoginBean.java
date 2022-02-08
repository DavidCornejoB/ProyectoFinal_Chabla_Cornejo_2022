package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.LoginON;
import ec.edu.ups.pw59.proyectofinal.business.LoginONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Login;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

@Named
@RequestScoped
public class clienteLoginBean {

	@Inject
	private LoginONLocal loginON;

	private Login login = new Login();

	private List<Login> logins;

	public clienteLoginBean() {

	}

	@PostConstruct
	public void init() {
	}

	// METODOS GET() Y SET()

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

	public String guardar() {// GUARDAR LOGIN

		Persona p = new Persona();
		p = cargarPersona();

		if (p == null) {

			return "error-login";

		} else {// ELSE PERSONA NO ES NULL

			//PRIMERO SETEAMOS PERSONA
			this.login.setPersona(p);

			// VALIDACIÓN DE ROL:
			if (this.login.getPersona().getTipo().equals("Administrador")) 
			{// ADMINISTRADOR
				return "principal";
			} // ADMINISTRADOR
			else 
			{// CLIENTE
				return "cliente-principal";
			} // CLIENTE

		} // ELSE PERSONA NO ES NULL
	}// GUARDAR LOGIN
	
	//********************************************************************
	//********************************************************************

	// BUSCAR LA PERSONA POR CORREO
	public Persona cargarPersona() {

		String correo = this.login.getCorreo();
		String clave = this.login.getClave();
		
		List<Login> logins = new ArrayList<Login>();
		logins = loginON.getLogins();

		Persona p = new Persona();

		//BUSCAMOS UNA PERSONA CON ÉSE CORREO Y CLAVE
		for (int i = 0; i < logins.size(); i++) {
			if (logins.get(i).getCorreo().equals(correo)) {
				System.out.println("ENCONTRO CORREO");
				
				for(int j = 0; j < logins.size(); j++) {
					if(logins.get(j).getClave().equals(clave)) {
						System.out.println("ENCONTRO CLAVE");
						p = logins.get(i).getPersona();
						return p;
						
					}
				}
			}
		}
		
		System.out.println("NO ENCONTRO CORREO O CLAVE");
		return null;
	}

	public String volverIngresar() {
		System.out.println("VOLVIENDO A INGRESO LOGIN...");
		return "login";
	}

}
