package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.FacturaDetallePaqueteDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetallePaquete;
/**
 * 
 * @author WilliamChabla
 *
 */
//OBJETO DE NEGOCIO PRINCIPAL. SE IMPLEMENTAN LOS OBJETOS DE NEGOCIO LOCALES Y REMOTOS
@Stateless
public class FacturaDetallePaqueteON implements FacturaDetallePaqueteONRemote, FacturaDetallePaqueteONLocal{
	
	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DE DETALLEPAQUETE
	@Inject
	private FacturaDetallePaqueteDAO daoFacturaDetallePaquete;
	
	/**
	 * 	//MÉTODO PARA INSERTAR DETALLES
	 */
	public void insert(FacturaDetallePaquete f) throws Exception{
		//LLAMAMOS AL METODO INSERT DEL DAO, LE ENVIAMOS EL OBJETO DETALLE QUE SERÁ INSERTADO
		daoFacturaDetallePaquete.insert(f);
	}
	
	/**
	 * 	//MÉTODO PARA ACTUALIZAR DETALLES
	 */
	public void update(FacturaDetallePaquete f) throws Exception{
		//LLAMAMOS AL MÉTODO UPDATE DEL DAO, LE ENVIAMOS EL OBJETO DETALLE QUE SERÁ ACTUALIZADO
		daoFacturaDetallePaquete.update(f);
	}
	
	/**
	 * 	//METODO PARA LEER DETALLES
	 */
	public void read(int id) throws Exception{
		//LLAMAMOS AL MÉTODO READ DEL DAO, LE ENVIAMOS LA ID DEL OBJETO DETALLE QUE SERÁ LEIDO
		daoFacturaDetallePaquete.read(id);
	}
	
	/**
	 * 	//METODO PARA ELIMINAR DETALLES
	 */
	public void delete(int id) throws Exception{
		//LLAMAMOS AL MÉTODO DELETE DEL DAO, LE ENVIAMOS LA ID DEL OBJETO DETALLE QUE SERÁ ELIMINADO
		daoFacturaDetallePaquete.delete(id);
	}
	
	/**
	 * 	//MÉTODO PARA LISTAR DETALLES
	 */
	public List<FacturaDetallePaquete> getFacturas(){
		//RETORNAMOS EL METODO GETLIST DEL DAO
		return daoFacturaDetallePaquete.getList();
	}

}
