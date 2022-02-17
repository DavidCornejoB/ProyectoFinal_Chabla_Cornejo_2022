package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraServicio;
/**
 * 
 * @author WilliamChabla
 *
 */
@Stateless
public class FacturaCabeceraServicioDAO {
	
	@PersistenceContext
	private EntityManager em;
	/**
	 * 
	 * @param facturaServicio
	 */
	public void insert(FacturaCabeceraServicio facturaServicio) {
		
		em.persist(facturaServicio);
		
	}
	/**
	 * 
	 * @param facturaServicio
	 */
	public void update(FacturaCabeceraServicio facturaServicio) {
		em.merge(facturaServicio);
		
	}
	/**
	 * 
	 * @param id
	 * @return p
	 */
	
	public FacturaCabeceraServicio read(int id) {
		FacturaCabeceraServicio p = em.find(FacturaCabeceraServicio.class, id);
		return p;
	}
	/**
	 * 
	 * @param id
	 */
	public void delete(int id) {
		FacturaCabeceraServicio p = em.find(FacturaCabeceraServicio.class, id);
		em.remove(p);		
	}
	
	/**
	 * 
	 * @return facturas
	 */
 public List<FacturaCabeceraServicio> getList(){
		
		String jpql2="SELECT p FROM FacturaCabeceraServicio p";
		
		Query query= em.createQuery(jpql2, FacturaCabeceraServicio.class);
		
		List<FacturaCabeceraServicio> facturas=query.getResultList();
		return facturas;
		
	}

}
