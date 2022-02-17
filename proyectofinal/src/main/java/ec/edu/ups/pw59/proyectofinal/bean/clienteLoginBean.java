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

/**
 * BEAN PARA VALIDAR LOGIN DE CLIENTE Y ADMINISTRADOR
 * @author luisd
 *
 */
@Named
@RequestScoped
public class clienteLoginBean {

	@Inject
	private LoginONLocal loginON;

	private Login login = new Login();
	
	public static Login logueo;

	private List<Login> logins;

	public clienteLoginBean() {

	}

	/**
	 * PostConstruct
	 */
	@PostConstruct
	public void init() {
	}

	// METODOS GET() Y SET()

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
	 * @return logueo
	 */
	public static Login getLogueo() {
		return logueo;
	}

	/**
	 * 
	 * @param logueo
	 */
	public static void setLogueo(Login logueo) {
		clienteLoginBean.logueo = logueo;
	}

	/**
	 * METODO PARA GUARDAR LOGIN
	 * @return cliente-ubicacion
	 */
	public String guardar() {// GUARDAR LOGIN

		Persona p = new Persona();
		p = cargarPersona();

		if (p == null) {//SI PERSONA ES NULL...

			//...SE LE PEDIRÁ REGISTRARSE
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
				this.logueo = this.login;
				return "cliente-ubicacion";
			} // CLIENTE

		} // ELSE PERSONA NO ES NULL
	}// GUARDAR LOGIN
	
	//********************************************************************
	//********************************************************************

	/**
	 * BUSCAR LA PERSONA POR CORREO
	 * @return null
	 */
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

	/**
	 * METODO PARA VOLVER AL FORMULARIO ANTERIOR
	 * @return formulario login
	 */
	public String volverIngresar() {
		System.out.println("VOLVIENDO A INGRESO LOGIN...");
		return "login";
	}

}
