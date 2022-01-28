package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.FacturaDetalleHabitacionDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleHabitacion;

//OBJETO DE NEGOCIO PRINCIPAL. SE IMPLEMENTARÁN LOS OBJETOS DE NEGOCIO LOCALES Y REMOTOS
@Stateless
public class FacturaDetalleHabitacionON implements FacturaDetalleHabitacionONRemote, FacturaDetalleHabitacionONLocal{
	
	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DE DETALLEHABITACION
	@Inject
	private FacturaDetalleHabitacionDAO daoFacturaDetalleHabitacion;
	
	//MÉTODO PARA INSERTAR DETALLES
	public void insert(FacturaDetalleHabitacion f) throws Exception{
		//LLAMAMOS AL MÉTODO INSERT DEL DAO, LE ENVIAMOS EL OBJETO DETALLE PARA SER INGRESADO
		daoFacturaDetalleHabitacion.insert(f);
	}
	
	//MÉTODO PARA ACTUALIZAR DETALLES
	public void update(FacturaDetalleHabitacion f) throws Exception{
		//LAMAMOS AL MÉTODO UPDATE DEL DAO, LE ENVIAMOS EL OBJETO DETALLE PARA SER ACTUALIZADO
		daoFacturaDetalleHabitacion.update(f);
	}
	
	//METODO PARA LEER DETALLES
	public void read(int id) throws Exception{
		//LLAMAMOS AL MÉTODO READ DEL DAO, LE ENVIAMOS LA ID DEL OBJETO DETALLE PARA SER LEIDO
		daoFacturaDetalleHabitacion.read(id);
	}
	
	//MÉTODO PARA ELIMINAR DETALLES
	public void delete(int id) throws Exception{
		//LLAMAMOS AL MÉTODO DELETE DEL DAO, LE ENVIAMOS LA ID DEL OBJETO DETALLE QUE SERÁ ELIMINADO
		daoFacturaDetalleHabitacion.delete(id);
	}
	
	//MÉTODO PARA LISTAR DETALLES
	public List<FacturaDetalleHabitacion> getFacturas(){
		//RETORNAMOS EL MÉTODO GETLIST DEL DAO
		return daoFacturaDetalleHabitacion.getList();
	}

}
