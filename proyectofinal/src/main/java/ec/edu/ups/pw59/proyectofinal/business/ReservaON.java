package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.HabitacionDAO;
import ec.edu.ups.pw59.proyectofinal.dao.ReservaDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Reserva;

//OBJETO DE NEGOCIO PRINCIPAL. SE IMPLEMENTAN LOS OBJETOS DE NEGOCIO LOCALES Y REMOTOS
@Stateless
public class ReservaON implements ReservaONRemote, ReservaONLocal{

	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DE RESERVA
	@Inject
	private ReservaDAO daoReserva;
	
	@Inject
	private HabitacionDAO daoHabitacion;
	
	//METODO PARA INSERTAR RESERVAS
	public void insert(Reserva r) throws Exception{
		//LLAMAMOS AL MÉTODO INSERT DEL DAO, LE ENVIAMOS EL OBJETO RESERVA QUE SERA INSERTADO
		daoReserva.insert(r);
	}
	
	//METODO PARA ACTUALIZAR RESERVAS
	public void update(Reserva r) throws Exception{
		//LLAMAMOS AL MÉTODO UPDATE DEL DAO, LE ENVIAMOS EL OBJETO RESERVA QUE SERÁ ACTUALZIADO
		daoReserva.update(r);
	}
	
	//MÉTODO PARA LEER RESERVAS
	public void read(String id) throws Exception{
		//LLAMAMOS AL METODO READ DEL DAO, LE ENVIAMOS LA ID DEL OBJETO RESERVA QUE SERÁ LEIDA
		daoReserva.read(id);
	}
	
	//MÉTODO PARA ELIMINAR RESERVAS
	public void delete(int id) throws Exception{
		//LLAMAMOS AL METODO DELETE DEL DAO, LE ENVIAMOS LA ID DEL OBJETO RESERVA QUE SERÁ ELIMINADO
		daoReserva.delete(id);
	}

	//MÉTODO PARA LISTAR RESERVAS
	public List<Reserva> getReservas(){
		//RETORNAMOS EL METODO GETLIST DEL DAO
		return daoReserva.getList();
	}
	
	//METODO PARA BUSCAR HABITACIONES
	public Habitacion getHabitacion(int numero) {
		Habitacion h = daoHabitacion.read(numero);
		return h;
	}

}
