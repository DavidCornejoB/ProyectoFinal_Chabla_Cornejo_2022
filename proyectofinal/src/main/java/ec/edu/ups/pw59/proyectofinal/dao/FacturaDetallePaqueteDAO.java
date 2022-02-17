package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetallePaquete;
/**
 * 
 * @author WilliamChabla
 *
 */
@Stateless
public class FacturaDetallePaqueteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param detallePaquete
	 */
	public void insert(FacturaDetallePaquete detallePaquete) {
		
		em.persist(detallePaquete);
		
	}
	/**
	 * 
	 * @param detallePaquete
	 */
	public void update(FacturaDetallePaquete detallePaquete) {
		em.merge(detallePaquete);
		
	}
	/**
	 * 
	 * @param codigo
	 * @return d
	 */
	public FacturaDetallePaquete read(int codigo) {
		FacturaDetallePaquete d = em.find(FacturaDetallePaquete.class, codigo);
		return d;
	}
	/**
	 * 
	 * @param codigo
	 */
	public void delete(int codigo) {
		FacturaDetallePaquete d = em.find(FacturaDetallePaquete.class, codigo);
		em.remove(d);		
	}
	
	/**
	 * 
	 * @return detalle facturadetallepaquetes
	 */
	
	public List<FacturaDetallePaquete> getList(){
		
		String jpql2="SELECT p FROM FacturaDetallePaquete p";
		
		Query query= em.createQuery(jpql2, FacturaDetallePaquete.class);
		
		List<FacturaDetallePaquete> detalles=query.getResultList();
		return detalles;
		
	}

}
