package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleHabitacion;
/**
 * 
 * @author WilliamChabla
 *
 */
@Stateless
public class FacturaDetalleHabitacionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param detalleHabitacion
	 */
	public void insert(FacturaDetalleHabitacion detalleHabitacion) {
		
		em.persist(detalleHabitacion);
		
	}
	/**
	 * 
	 * @param detalleHabitacion
	 */
	public void update(FacturaDetalleHabitacion detalleHabitacion) {
		em.merge(detalleHabitacion);
		
	}
	/**
	 * 
	 * @param codigo
	 * @return d
	 */
	
	public FacturaDetalleHabitacion read(int codigo) {
		FacturaDetalleHabitacion d = em.find(FacturaDetalleHabitacion.class, codigo);
		return d;
	}
	/**
	 * 
	 * @param codigo
	 */
	public void delete(int codigo) {
		FacturaDetalleHabitacion d = em.find(FacturaDetalleHabitacion.class, codigo);
		em.remove(d);		
	}
	
	/**
	 * 
	 * @return detalles facturadetallehabitacion
	 */
	public List<FacturaDetalleHabitacion> getList(){
		
		String jpql2="SELECT p FROM FacturaDetalleHabitacion p";
		
		//nombre= nombre+"%";
		Query query= em.createQuery(jpql2, FacturaDetalleHabitacion.class);
		//query.setParameter(1, nombre);
		
		List<FacturaDetalleHabitacion> detalles=query.getResultList();
		return detalles;
		
	}

}
