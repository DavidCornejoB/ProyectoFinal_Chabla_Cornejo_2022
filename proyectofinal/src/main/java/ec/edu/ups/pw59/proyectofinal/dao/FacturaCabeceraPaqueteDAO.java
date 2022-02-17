package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraPaquete;
/**
 * 
 * @author WilliamChabla
 *
 */

@Stateless
public class FacturaCabeceraPaqueteDAO {
	
	@PersistenceContext
	private EntityManager em;
	/**
	 * 
	 * @param facturaPaquete
	 */
	public void insert(FacturaCabeceraPaquete facturaPaquete) {
		
		em.persist(facturaPaquete);
		
	}
	/**
	 * 
	 * @param facturaPaquete
	 */
	public void update(FacturaCabeceraPaquete facturaPaquete) {
		em.merge(facturaPaquete);
		
	}
	/**
	 * 
	 * @param id
	 * @return p
	 */
	public FacturaCabeceraPaquete read(int id) {
		FacturaCabeceraPaquete p = em.find(FacturaCabeceraPaquete.class, id);
		return p;
	}
	/**
	 * 
	 * @param id
	 */
	public void delete(int id) {
		FacturaCabeceraPaquete p = em.find(FacturaCabeceraPaquete.class, id);
		em.remove(p);		
	}
	/**
	 * 
	 * @return facturas facturacabecerapaquete
	 */
	
  public List<FacturaCabeceraPaquete> getList(){
		
		String jpql2="SELECT p FROM FacturaCabeceraPaquete p";
		
		Query query= em.createQuery(jpql2, FacturaCabeceraPaquete.class);
		
		List<FacturaCabeceraPaquete> facturas=query.getResultList();
		return facturas;
		
	}


}
