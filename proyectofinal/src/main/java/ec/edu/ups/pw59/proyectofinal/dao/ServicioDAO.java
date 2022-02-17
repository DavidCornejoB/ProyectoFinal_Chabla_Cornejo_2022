package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;
/**
 * 
 * @author WilliamChabla
 *
 */
@Stateless
public class ServicioDAO {
	
	@PersistenceContext
	private EntityManager em;
	/**
	 * 
	 * @param op
	 */
	public void insert(Servicio op) {
		em.persist(op);
		
	}
	/**
	 * 
	 * @param op
	 */
	
	public void update(Servicio op) {
			em.merge(op);
		}
	/**
	 * 
	 * @param id
	 * @return op
	 */
	public Servicio read(int id) {
		Servicio op = em.find(Servicio.class, id);
		return op;
	}
	/**
	 * 
	 * @param id
	 */
	
	public void delete(int id) {
		Servicio op = em.find(Servicio.class, id);
		em.remove(op);
	}
	/**
	 * 
	 * @return listado
	 */
	
	public List<Servicio> getList(){
		List<Servicio> listado = new ArrayList<Servicio>();
		
		String jpql = "SELECT op FROM Servicio op";
				
		
		Query query = em.createQuery(jpql, Servicio	.class);
		
		listado = query.getResultList();
		
		return listado;
		
		//JSPQL -> SQL
		
	}


}
