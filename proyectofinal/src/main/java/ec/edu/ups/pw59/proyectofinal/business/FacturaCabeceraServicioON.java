package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.FacturaCabeceraServicioDAO;
import ec.edu.ups.pw59.proyectofinal.dao.PersonaDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraServicio;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

//OBJETO DE NEGOCIO PRINCIPAL. SE IMPLEMENTAN LOS OBJETOS DE NEGOCIO LOCALES Y REMOTOS
@Stateless
public class FacturaCabeceraServicioON implements FacturaCabeceraServicioONRemote, FacturaCabeceraServicioONLocal{
	
	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DE FACTURACABECERASERVICIO
	@Inject
	private FacturaCabeceraServicioDAO daoFacturaCabeceraServicio;
	
	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DE PERSONA
	@Inject
	private PersonaDAO daoPersona;
	
	//MÉTODO PARA INSERTAR FACTURAS
	public void insert(FacturaCabeceraServicio f) throws Exception{
		
		//BUSCAMOS SI ESTÁ INGRESADA LA PERSONA DE LA FACTURA
		Persona p = daoPersona.read(f.getPersona().getCedula());
		
		//SI NO EXISTE ESA PERSONA, LA INSERTAMOS
		if(p==null) {
			//INSERTAMOS ESA PERSONA
			daoPersona.insert(f.getPersona());
		} else {
			//ACTUALIZAMOS NUEVA FACTURA A PERSONA EXISTENTE
			daoPersona.update(f.getPersona());
		}
		//LLAMAMOS AL METODO INSERT DEL DAO, LE ENVIAMOS EL OBJETO FACTURA QUE SERÁ INSERTADO
		daoFacturaCabeceraServicio.insert(f);
	}
	
	//MÉTODO PARA ACTUALIZAR FACTURAS
	public void update(FacturaCabeceraServicio f) throws Exception{
		//LLAMAMOS AL MÉTODO UPDATE DEL DAO, LE ENVIAMOS EL OBJETO FACTURA QUE SERÁ ACTUALIZADO
		daoFacturaCabeceraServicio.update(f);
	}
	
	//MÉTODO PARA LEER FACTURAS
	public void read(int id) throws Exception{
		//LLAMAMOS AL MÉTODO READ DEL DAO, LE ENVIAMOS LA ID DEL OBJETO FACTURA QUE SERÁ LEIDO
		daoFacturaCabeceraServicio.read(id);
	}
	
	//MÉTODO PARA ELIMINAR FACTURAS
	public void delete(int id) throws Exception{
		//LLAMAMOS AL MÉTODO DELETE DEL DAO, LE ENVIAMOS LA ID DE LA FACTURA QUE SERÁ ELIMINADA
		daoFacturaCabeceraServicio.delete(id);
	}
	
	//MÉTODO PARA LISTAR FACTURAS
	public List<FacturaCabeceraServicio> getFacturas(){
		//RETORNAMOS EL METODO GETLIST DEL DAO
		return daoFacturaCabeceraServicio.getList();
	}
	
	//MÉTODO PARA BUSCAR PERSONAS
	public Persona getPersona(String cedula) {
		Persona p = daoPersona.read(cedula);
		return p;
	}

}
