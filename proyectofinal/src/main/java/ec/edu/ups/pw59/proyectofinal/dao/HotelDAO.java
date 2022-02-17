package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;
/**
 * 
 * @author WilliamChabla
 *
 */
@Stateless
public class HotelDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param op
	 */
	public void insert(Hotel op) {
		em.persist(op);
		
	}
	/**
	 * 
	 * @param op
	 */
	public void update(Hotel op) {
			em.merge(op);
		}
	
	/**
	 * 
	 * @param id
	 * @return op
	 */
	public Hotel read(int id) {
		Hotel op = em.find(Hotel.class, id);
		return op;
	}
	/**
	 * 
	 * @param id
	 */
	public void delete(int id) {
		Hotel op = em.find(Hotel.class, id);
		em.remove(op);
	}
	/**
	 * 
	 * @return listado hotel
	 */
	
	public List<Hotel> getList(){
		List<Hotel> listado = new ArrayList<Hotel>();
		
		String jpql = "SELECT op FROM Hotel op";
				
		
		Query query = em.createQuery(jpql, Hotel.class);
		
		listado = query.getResultList();
		
		return listado;
		
		//JSPQL -> SQL
		
	}


}
