package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.Persona;
/**
 * 
 * @author WilliamChabla
 *
 */

@Stateless
public class PersonaDAO {
	
	@PersistenceContext
	private EntityManager em;
	/**
	 * 
	 * @param op
	 */
	public void insert(Persona op) {
		em.persist(op);		
	}
	
	/**
	 * 
	 * @param op
	 */
	public void update(Persona op) {
			em.merge(op);
		}
	/**
	 * 
	 * @param id
	 * @return op
	 */
	public Persona read(String id) {
		Persona op = em.find(Persona.class, id);
		return op;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void delete(String id) {
		Persona op = em.find(Persona.class, id);
		em.remove(op);
	}
	
	/**
	 * 
	 * @return listado
	 */
	public List<Persona> getList(){
		List<Persona> listado = new ArrayList<Persona>();
		
		String jpql = "SELECT op FROM Persona op";
				
		
		Query query = em.createQuery(jpql, Persona.class);
		
		listado = query.getResultList();
		
		return listado;
		
		
		
		//JSPQL -> SQL
		
	}

}
