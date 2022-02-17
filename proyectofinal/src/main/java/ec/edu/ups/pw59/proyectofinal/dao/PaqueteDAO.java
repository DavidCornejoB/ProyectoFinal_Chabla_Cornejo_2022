package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.Paquete;
/**
 * 
 * @author WilliamChabla
 *
 */
@Stateless
public class PaqueteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param op
	 */
	public void insert(Paquete op) {
		em.persist(op);
		
	}
	
	/**
	 * 
	 * @param op
	 */
	public void update(Paquete op) {
			em.merge(op);
		}
	
	/**
	 * 
	 * @param id
	 * @return op
	 */
	public Paquete read(int id) {
		Paquete op = em.find(Paquete.class, id);
		return op;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void delete(int id) {
		Paquete op = em.find(Paquete.class, id);
		em.remove(op);
	}
	/**
	 * 
	 * @return listado paquete
	 */
	public List<Paquete> getList(){
		List<Paquete> listado = new ArrayList<Paquete>();
		
		String jpql = "SELECT op FROM Paquete op";
				
		
		Query query = em.createQuery(jpql, Paquete.class);
		
		listado = query.getResultList();
		
		return listado;
		
		//JSPQL -> SQL
		
	}


}
