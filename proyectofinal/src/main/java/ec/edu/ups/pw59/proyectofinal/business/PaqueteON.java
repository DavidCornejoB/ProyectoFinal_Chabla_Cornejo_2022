package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.HabitacionDAO;
import ec.edu.ups.pw59.proyectofinal.dao.HotelDAO;
import ec.edu.ups.pw59.proyectofinal.dao.PaqueteDAO;
import ec.edu.ups.pw59.proyectofinal.dao.ServicioDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;
import ec.edu.ups.pw59.proyectofinal.modelo.Paquete;
import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

//OBJETO DE NEGOCIO PRINCIPAL. SE IMPLEMENTAN LOS OBJETOS DE NEGOCIO LOCALES Y REMOTOS
@Stateless
public class PaqueteON implements PaqueteONRemote, PaqueteONLocal{
	
	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DE PAQUETE
	@Inject
	private PaqueteDAO daoPaquete;
	
	@Inject
	private HabitacionDAO daoHabitacion;
	
	@Inject
	private HotelDAO daoHotel;
	
	@Inject
	private ServicioDAO daoServicio;
	
	//METODO PARA INSERTAR PAQUETES
	public void insert(Paquete p) throws Exception{
		//LLAMAMOS AL METODO INSERT DEL DAO, LE ENVIAMOS EL OBJETO PAQUETE QUE SERÁ INGRESADO
		daoPaquete.insert(p);
	}
	
	//METODO PARA ACTUALIZAR PAQUETES
	public void update(Paquete p) throws Exception{
		//LLAMAMOS AL METODO UPDATE DEL DAO, EL ENVIAMOS EL OBJETO PAQUETE QUE SERÁ ACTUALIZADO
		daoPaquete.update(p);
	}
	
	//METODO PARA LEER PAQUETES
	public void read(int id) throws Exception{
		//LLAMAMOS AL METODO READ DEL DAO, LE ENVIAMOS LA ID DEL OBJETO PAQUETE QUE QUEREMOS LEER
		daoPaquete.read(id);
	}
	
	//METODO PARA ELIMINAR PAQUETES
	public void delete(int id) throws Exception{
		//LLAMAMOS AL METODO DELETE DEL DAO, LE ENVIAMOS LA ID DEL OBJETO PAQUETE QUE QUEREMOS ELIMINAR
		daoPaquete.delete(id);
	}
	
	//METODO PARA LISTAR PAQUETES
	public List<Paquete> getPaquetes(){
		//RETORNAMOS EL METODO GETLIST() DEL DAO
		return daoPaquete.getList();
	}
	
	public Habitacion getHabitacion(int id) {
		Habitacion hab = daoHabitacion.read(id);
		return hab;
	}
	
	public Hotel getHotel(int id) {
		Hotel hot = daoHotel.read(id);
		return hot;
	}
	
	public Servicio getServicio(int id) {
		Servicio ser = daoServicio.read(id);
		return ser;
	}

}
