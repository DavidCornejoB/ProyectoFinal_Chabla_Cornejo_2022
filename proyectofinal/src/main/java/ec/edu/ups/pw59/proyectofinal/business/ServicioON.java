package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.ServicioDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

//OBJETO DE NEGOCIO PRINCIPAL. SE IMPLEMENTAN LOS OBJETOS DE NEGOCIO LOCALES Y REMOTOS
@Stateless
public class ServicioON implements ServicioONRemote, ServicioONLocal{
	
	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DE SERVICIO
	@Inject
	private ServicioDAO daoServicio;
	
	//MÉTODO PARA INSERTAR SERVICIOS
	public void insert(Servicio s) throws Exception{
		//LLAMAMOS AL METODO INSERT DEL DAO, LE ENVIAMOS EL OBJETO SERVICIO QUE SERÁ INSERTADO
		daoServicio.insert(s);
	}
	
	//MÉTODO PARA ACTUALIZAR SERVICIOS
	public void update(Servicio s) throws Exception{
		//LLAMAMOS AL MÉTODO UPDATE DEL DAO, LE ENVIAMOS EL OBJETO SERVICIO QUE SERÁ ACTUALIZADO
		daoServicio.update(s);
	}
	
	//METODO PARA LEER SERVICIOS
	public void read(String id) throws Exception{
		//LLAMAMOS AL MÉTODO READ DEL DAO, LE ENVIAMOS LA ID DEL OBJETO SERVICIO QUE SERÁ LEIDO
		daoServicio.read(id);
	}
	
	//METODO PARA ELIMINAR SERVICIOS
	public void delete(int id) throws Exception{
		//LLAMAMOS AL MÉTODO DELETE DEL DAO, LE ENVIAMOS LA ID DEL OBJETO SERVICIO QUE SERÁ ELIMINADO
		daoServicio.delete(id);
	}
	
	//MÉTODO PARA LISTAR SERVICIOS
	public List<Servicio> getServicios(){
		//RETORNAMOS EL METODO GETLIST DEL DAO
		return daoServicio.getList();
	}

}
