package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.CategoriaDAO;
import ec.edu.ups.pw59.proyectofinal.dao.HabitacionDAO;
import ec.edu.ups.pw59.proyectofinal.dao.HotelDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Categoria;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;

//OBJETO DE NEGOCIO PRINCIPAL. SE IMPLEMENTAN LOS OBJETOS DE NEGOCIO LOCALES Y REMOTOS
@Stateless
public class HabitacionON implements HabitacionONRemote, HabitacionONLocal{
	
	//LLAMAMOS AL OBJETO DE ACCESO A ADATOS DE HABITACION
	@Inject
	private HabitacionDAO daoHabitacion;
	
	@Inject
	private CategoriaDAO daoCategoria;
	
	@Inject
	private HotelDAO daoHotel;
	
	//METODO PARA INSERTAR HABITACIONES
	public void insert(Habitacion h) throws Exception{
		//LLAMAMOS AL METODO INSERT DEL DAO, LE ENVIAMOS EL OBJETO HABITACION QUE SERÁ INSERTADO
		daoHabitacion.insert(h);
	}
	
	//MÉTODO PARA ACTUALIZAR HABITACIONES
	public void update(Habitacion h) throws Exception{
		//LLAMAMOS AL MÉTODO UPDATE DEL DAO, LE ENVIAMOS EL OBJETO HABITACION QUE SERÁ ACTUALIZADO
		daoHabitacion.update(h);
	}
	
	//METODO PARA LEER HABITACIONES
	public void read(int id) throws Exception{
		//LLAMAMOS AL MÉTODO READ DEL DAO, LE ENVIAMOS LA ID DE LA HABITACION QUE QUEREMOS LEER
		daoHabitacion.read(id);
	}
	
	//METODO APRA ELIMINAR HABITACIONES
	public void delete(int id) throws Exception{
		//LLAMAMOS AL MÉTODO DELETE DEL DAO, LE ENVIAMOS LA ID DE LA HABITACION QUE QUEREMOS ELIMINAR
		daoHabitacion.delete(id);
	}
	
	//METODO PARA LISTAR HABITACIONES
	public List<Habitacion> getHabitaciones(){
		//RETORNAMOS EL MÉTODO GETLIST DEL DAO
		return daoHabitacion.getList();
	}
	
	//METODO PARA BUSCAR CATEGORIAS EN HABITACION
	public Categoria getCategoria(int id) {
		Categoria cat = daoCategoria.read(id);
		return cat;
	}
	
	//METODO PARA BUSCAR HOTELES EN HABITACION
	public Hotel getHotel(int id) {
		Hotel h = daoHotel.read(id);
		return h;
	}

}
