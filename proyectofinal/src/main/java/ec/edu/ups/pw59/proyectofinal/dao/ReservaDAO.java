package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.Reserva;
/**
 * 
 * @author WilliamChabla
 *
 */
@Stateless
public class ReservaDAO {
	
	@PersistenceContext
	private EntityManager em;
	/**
	 * 
	 * @param op
	 */
	public void insert(Reserva op) {
		em.persist(op);
		
	}
	/**
	 * 
	 * @param op
	 */
	
	public void update(Reserva op) {
			em.merge(op);
		}
	/**
	 * 
	 * @param id
	 * @return op
	 */
	
	public Reserva read(int id) {
		Reserva op = em.find(Reserva.class, id);
		return op;
	}
	/**
	 * 
	 * @param id
	 */
	
	public void delete(int id) {
		Reserva op = em.find(Reserva.class, id);
		em.remove(op);
	}
	/**
	 * 
	 * @return listado
	 */
	
	public List<Reserva> getList(){
		List<Reserva> listado = new ArrayList<Reserva>();
		
		String jpql = "SELECT op FROM Reserva op";
				
		
		Query query = em.createQuery(jpql, Reserva.class);
		
		listado = query.getResultList();
		
		return listado;
		
		//JSPQL -> SQL
		
	}

	

}
