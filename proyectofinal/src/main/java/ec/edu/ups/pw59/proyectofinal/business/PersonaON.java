package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.PersonaDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

//OBJETO DE NEGOCIO PRINCIPAL. SE IMPLEMENTAN LOS OBJETOS DE NEGOCIO LOCALES Y REMOTOS
@Stateless
public class PersonaON implements PersonaONRemote, PersonaONLocal{
	
	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DE PERSONA
	@Inject
	private PersonaDAO daoPersona;
	
	//MÉTODO PARA VALIDAR CEDULA DE PERSONAS
	public boolean validarCedula(String cedula) {
		if(cedula.length()==10) {
			return true;
		}
		return false;
	}
	
	//METODO PARA INSERTAR PERSONAS
	public void insert(Persona p) throws Exception{
		
		//ENVIAMOS LA CEDULA AL MÉTODO VALIDARCEDULA Y RECIBIMOS SI ES VALIDA O NO
		if(!this.validarCedula(p.getCedula())) {
			throw new Exception("CEDULA INCORRECTA");
		}
		//LLAMAMOS AL METODO INSERT DEL DAO, LE ENVIAMOS EL OBJETO PERSONA QUE SERÁ INSERTADA
		daoPersona.insert(p);
	}
	
	//METODO PARA ACTUALIZAR PERSONAS
	public void update(Persona p) throws Exception{
		//LLAMAMOS AL METODO UPDATE DEL DAO, LE ENVIAMOS EL OBJETO PERSONA QUE SERÁ ACTUALZIADA
		daoPersona.update(p);
	}
	
	//METODO PARA LEER PERSONAS
	public Persona read(String id) throws Exception{
		//LLAMAMOS AL METODO READ DEL DAO, LE ENVIAMOS LA ID DEL OBJETO PERSONA QUE SERÁ LEIDA
		return daoPersona.read(id);
	}
	
	//METODO PARA ELIMINAR PERSONAS
	public void delete(String id) throws Exception{
		//LLAMAMOS AL METODO DELETE DEL DAO, LE ENVIAMOS LA ID DEL OBJETO PERSONA QUE SERA ELIMINADA
		daoPersona.delete(id);
	}
	
	//METODO PARA LISTAR PERSONAS
	public List<Persona> getPersonas(){
		//RETORNAMOS EL METODO GETLIST DEL DAO
		return daoPersona.getList();
	}

}
