package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.FacturaDetalleServicioDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleServicio;

/**
 * 
 * @author WilliamChabla
 *
 */
//OBJETO DE NEGOCIO PRINCIPAL. SE IMPLEMENTAN LOS OBJETOS DE NEGOCIO LOCALES Y REMOTOS
@Stateless
public class FacturaDetalleServicioON implements FacturaDetalleServicioONRemote, FacturaDetalleServicioONLocal{
	
	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DE DETALLESERVICIO
	@Inject
	private FacturaDetalleServicioDAO daoFacturaDetalleServicio;
	
	/**
	 * 	//MÉTODO PARA INSERTAR DETALLES
	 */
	public void insert(FacturaDetalleServicio f) throws Exception{
		//LLAMAMOS AL METODO INSERT DEL DAO, LE ENVIAMOS EL OBJETO DETALLE QUE SERÁ INSERTADO
		daoFacturaDetalleServicio.insert(f);
	}
	
	/**
	 * 	//MÉTODO PARA ACTUALIZAR DETALLES
	 */
	public void update(FacturaDetalleServicio f) throws Exception{
		//LLAMAMOS AL MÉTODO UPDATE DEL DAO, LE ENVIAMOS EL OBJETO DETALLE QUE SERÁ ACTUALIZADO
		daoFacturaDetalleServicio.update(f);
	}
	
	/**
	 * 	//METODO PARA LEER DETALLES
	 */
	public void read(int id) throws Exception{
		//LLAMAMOS AL MÉTODO READ DEL DAO, LE ENVIAMOS LA ID DEL OBJETO DETALLE QUE SERÁ LEIDO
		daoFacturaDetalleServicio.read(id);
	}
	
	/**
	 * 	//METODO PARA ELIMINAR DETALLES
	 */
	public void delete(int id) throws Exception{
		//LLAMAMOS AL MÉTODO DELETE DEL DAO, LE ENVIAMOS LA ID DEL OBJETO DETALLE QUE SERÁ ELIMINADO
		daoFacturaDetalleServicio.delete(id);
	}
	
	/**
	 * 	//MÉTODO PARA LISTAR DETALLES
	 */
	public List<FacturaDetalleServicio> getFacturas(){
		//RETORNAMOS EL METODO GETLIST DEL DAO
		return daoFacturaDetalleServicio.getList();
	}

}
