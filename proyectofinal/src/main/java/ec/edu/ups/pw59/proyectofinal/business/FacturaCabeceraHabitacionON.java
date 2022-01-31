package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.FacturaCabeceraHabitacionDAO;
import ec.edu.ups.pw59.proyectofinal.dao.PersonaDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraHabitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

//OBJETO DE NEGOCIO PRINCIPAL. SE IMPLEMENTAN LOS OBJETOS DE NEGOCIO LOCALES Y REMOTOS
@Stateless
public class FacturaCabeceraHabitacionON implements FacturaCabeceraHabitacionONRemote, FacturaCabeceraHabitacionONLocal{
	
	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DE FACTURACABECERAHABITACION
	@Inject
	private FacturaCabeceraHabitacionDAO daoFacturaCabeceraHabitacion;
	
	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DE PERSONA
	@Inject
	private PersonaDAO daoPersona;
	
	//MÉTODO PARA INSERTAR FACTURAS DE HABITACION
	public void insert(FacturaCabeceraHabitacion f) throws Exception{
		
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
		//LLAMAMOS AL MÉTODO INSERT DEL DAO. LE ENVIAMOS EL OBJETO FACTURA PARA SER INYECTADO
		daoFacturaCabeceraHabitacion.insert(f);
	}
	
	//MÉTODO PARA ACTUALIZAR FACTURAS DE HABITACION
	public void update(FacturaCabeceraHabitacion f) throws Exception{
		//LLAMAMOS AL MÉTODO UPDATE DEL DAO. LE ENVIAMOS EL OBJETO FACTURA PARA SER ACTUALIZADO
		daoFacturaCabeceraHabitacion.update(f);
	}
	
	//MÉTODO PARA LEER FACTURAS DE HABITACION
	public void read(int id) throws Exception{
		//LLAMAMOS AL METODO READ DEL DAO. LE ENVIAMOS LA ID DE LA FACTURA QUE QUEREMOS LEER
		daoFacturaCabeceraHabitacion.read(id);
	}
	
	//MÉTODO PARA ELIMINAR FACTURAS DE HABITACION
	public void delete(int id) throws Exception{
		//LLAMAMOS AL METODO DELETE DEL DAO. LE ENVIAMOS LA ID DE LA FACTURA QUE QUEREMOS ELIMINAR
		daoFacturaCabeceraHabitacion.delete(id);
	}
	
	//MÉTODO PARA LISTAR FACTURAS DE HABITACION. SE HACE USO DE UNA LISTA QUE ALAMACENE TODAS LAS FACTURAS DE HABITACION
	public List<FacturaCabeceraHabitacion> getFacturas(){
		return daoFacturaCabeceraHabitacion.getList();	
	}
	
	//MÉTODO PARA BUSCAR PERSONAS
	public Persona getPersona(String cedula) {
		Persona p = daoPersona.read(cedula);
		return p;
	}

}
