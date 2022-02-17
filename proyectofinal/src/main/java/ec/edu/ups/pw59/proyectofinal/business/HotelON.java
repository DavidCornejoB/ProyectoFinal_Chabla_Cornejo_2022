package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.HotelDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;

/**
 * 
 * @author WilliamChabla
 *
 */
//OBJETO DE NEGOCIO PRINCIPAL. SE IMPLEMENTAN LOS OBJETOS DE NEGOCIO LOCALES Y REMOTOS
@Stateless
public class HotelON implements HotelONRemote, HotelONLocal{
	
	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DE HOTEL
	@Inject
	private HotelDAO daoHotel;
	
	/**
	 * 	//MÉTODO PARA INSERTAR HOTELES
	 */
	public void insert(Hotel h) throws Exception{
		//LLAMAMOS AL METODO INSERT DEL DAO, LE ENVIAMOS EL OBJETO HOTEL QUE QUEREMOS INSERTAR
		daoHotel.insert(h);
	}
	
	/**
	 * 	//MÉTODO PARA ACTUALIZAR HOTELES
	 */
	public void update(Hotel h) throws Exception{
		//LLAMAMOS AL METODO UPDATE DEL DAO, LE ENVIAMOS EL OBJETO HOTEL QUE QUEREMOS ACTUALIZAR
		daoHotel.update(h);
	}
	
	/**
	 * 	//METODO PARA LEER HOTELES
	 */
	public Hotel read(int id) throws Exception{
		//LLAMAMOS AL METODO READ DEL DAO, LE ENVIAMOS LA ID DEL HOTEL QUE QUEREMOS LEER
		return daoHotel.read(id);
	}
	
	/**
	 * 	//METODO PARA ELIMINAR HOTELES
	 */
	public void delete(int id) throws Exception{
		//LLAMAMOS AL METODO DELETE DEL DAO, LE ENVIAMOS LA ID DEL OBJETO HOTEL QUE QUEREMOS ELIMINAR
		daoHotel.delete(id);
	}
	
	/**
	 * 	//METODO PARA LISTAR HOTELES
	 */
	public List<Hotel> getHoteles(){
		//RETORNAMOS EL MEOTOD GETLIST DEL DAO
		return daoHotel.getList();
	}

}
