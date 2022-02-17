package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.HotelDAO;
import ec.edu.ups.pw59.proyectofinal.dao.ServicioDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;
import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

/**
 * 
 * @author WilliamChabla
 *
 */
//OBJETO DE NEGOCIO PRINCIPAL. SE IMPLEMENTAN LOS OBJETOS DE NEGOCIO LOCALES Y REMOTOS
@Stateless
public class ServicioON implements ServicioONRemote, ServicioONLocal{
	
	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DE SERVICIO
	@Inject
	private ServicioDAO daoServicio;
	
	@Inject
	private HotelDAO daoHotel;
	
	/**
	 * 	//MÉTODO PARA INSERTAR SERVICIOS
	 */
	public void insert(Servicio s) throws Exception{
		//LLAMAMOS AL METODO INSERT DEL DAO, LE ENVIAMOS EL OBJETO SERVICIO QUE SERÁ INSERTADO
		daoServicio.insert(s);
	}
	
	/**
	 * 	//MÉTODO PARA ACTUALIZAR SERVICIOS
	 */
	public void update(Servicio s) throws Exception{
		//LLAMAMOS AL MÉTODO UPDATE DEL DAO, LE ENVIAMOS EL OBJETO SERVICIO QUE SERÁ ACTUALIZADO
		daoServicio.update(s);
	}
	
	/**
	 * 	//METODO PARA LEER SERVICIOS
	 */
	public Servicio read(int id) throws Exception{
		//LLAMAMOS AL MÉTODO READ DEL DAO, LE ENVIAMOS LA ID DEL OBJETO SERVICIO QUE SERÁ LEIDO
		return daoServicio.read(id);
	}
	
	/**
	 * 	//METODO PARA ELIMINAR SERVICIOS
	 */
	public void delete(int id) throws Exception{
		//LLAMAMOS AL MÉTODO DELETE DEL DAO, LE ENVIAMOS LA ID DEL OBJETO SERVICIO QUE SERÁ ELIMINADO
		daoServicio.delete(id);
	}
	
	/**
	 * 	//MÉTODO PARA LISTAR SERVICIOS
	 */
	public List<Servicio> getServicios(){
		//RETORNAMOS EL METODO GETLIST DEL DAO
		return daoServicio.getList();
	}
	
	/**
	 * 	//METODO PARA BUSCAR HOTELES EN SERVICIO
	 */
	public Hotel getHotel(int id) {
		Hotel h = daoHotel.read(id);
		return h;
	}

}
