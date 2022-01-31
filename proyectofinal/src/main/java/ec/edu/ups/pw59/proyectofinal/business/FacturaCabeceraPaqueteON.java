package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.FacturaCabeceraPaqueteDAO;
import ec.edu.ups.pw59.proyectofinal.dao.PersonaDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraPaquete;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

//OBJETO DE NEGOCIO PRINCIPAL. SE IMPLEMENTAN LOS OBJETOS DE NEGOCIO LOCALES Y REMOTOS
@Stateless
public class FacturaCabeceraPaqueteON implements FacturaCabeceraPaqueteONRemote, FacturaCabeceraPaqueteONLocal{
	
	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DE FACTURACABECERAPAQUETE
	@Inject
	private FacturaCabeceraPaqueteDAO daoFacturaCabeceraPaquete;
	
	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DE PERSONA
	@Inject
	private PersonaDAO daoPersona;
	
	//MÉTODO PARA INSERTAR FACTURAS
	public void insert(FacturaCabeceraPaquete f) throws Exception{
		
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
		//LLAMAMOS AL MÉTODO INSERT DEL DAO, LE ENVIAMOS EL OBJETO FACTURA PARA SER INGRESADO
		daoFacturaCabeceraPaquete.insert(f);
	}
	
	//MÉTODO PARA ACTUALIZAR FACTURAS
	public void update(FacturaCabeceraPaquete f) throws Exception{
		//LLAMAMOS AL MÉTODO UPDATE DEL DAO, LE ENVIAMOS EL OBJETO FACTURA QUE SERÁ ACTUALIZADO
		daoFacturaCabeceraPaquete.update(f);
	}
	
	//MÉTODO PARA LEER FACTURAS
	public void read(int id) throws Exception{
		//LLAMAMOS AL MÉTODO READ DEL DAO, LE ENVIAMOS LA ID DE LA FACTURA QUE QUEREMOS LEER
		daoFacturaCabeceraPaquete.read(id);
	}
	
	//MÉTODO PARA ELIMINAR FACTURAS
	public void delete(int id) throws Exception{
		//LLAMAMOS AL METODO DELETE DEL DAO, LE ENVIAMOS LA ID DE LA FACTURA QUE QUEREMOS ELIMINAR
		daoFacturaCabeceraPaquete.delete(id);
	}
	
	//MÉTODO DE LISTAR FACTURAS. SE HACE USO DE UNA LISTA QUE ALMACENE TODAS LAS FACTURAS INGRESADAS
	public List<FacturaCabeceraPaquete> getFacturas(){
		//RETORNAMOS EL MÉTODO GETLIST() DEL DAO
		return daoFacturaCabeceraPaquete.getList();
	}
	
	//MÉTODO PARA BUSCAR PERSONAS
	public Persona getPersona(String cedula) {
		Persona p = daoPersona.read(cedula);
		return p;
	}

}
