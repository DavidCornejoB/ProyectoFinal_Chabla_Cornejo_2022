package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleServicio;
/**
 * 
 * @author WilliamChabla
 *
 */
@Stateless
public class FacturaDetalleServicioDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param detalleServicio
	 */
	public void insert(FacturaDetalleServicio detalleServicio) {
		
		em.persist(detalleServicio);
		
	}
	/**
	 * 
	 * @param detalleServicio
	 */
	
	public void update(FacturaDetalleServicio detalleServicio) {
		em.merge(detalleServicio);
		
	}
	/**
	 * 
	 * @param codigo
	 * @return d
	 */
	
	public FacturaDetalleServicio read(int codigo) {
		FacturaDetalleServicio d = em.find(FacturaDetalleServicio.class, codigo);
		return d;
	}
	/**
	 * 
	 * @param codigo
	 */
	
	public void delete(int codigo) {
		FacturaDetalleServicio d = em.find(FacturaDetalleServicio.class, codigo);
		em.remove(d);		
	}
	/**
	 * 
	 * @return detalles
	 */
	
	public List<FacturaDetalleServicio> getList(){
		
		String jpql2="SELECT p FROM FacturaDetalleServicio p";
		
		Query query= em.createQuery(jpql2, FacturaDetalleServicio.class);
		
		List<FacturaDetalleServicio> detalles=query.getResultList();
		return detalles;
		
	}

}
