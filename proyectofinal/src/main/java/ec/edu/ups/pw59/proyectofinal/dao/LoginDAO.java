package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.Login;
/**
 * 
 * @author WilliamChabla
 *
 */
@Stateless
public class LoginDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param op
	 */
	public void insert(Login op) {
		em.persist(op);
		
	}
	/**
	 * 
	 * @param op
	 */
	public void update(Login op) {
			em.merge(op);
		}
	/**
	 * 
	 * @param id
	 * @return op
	 */
	public Login read(int id) {
		Login op = em.find(Login.class, id);
		return op;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void delete(int id) {
		Login op = em.find(Login.class, id);
		em.remove(op);
	}
	
	/**
	 * 
	 * @return listado login
	 */
	public List<Login> getList(){
		List<Login> listado = new ArrayList<Login>();
		
		String jpql = "SELECT op FROM Login op";
				
		
		Query query = em.createQuery(jpql, Login.class);
		
		listado = query.getResultList();
		
		return listado;
		
		//JSPQL -> SQL
		
	}


}
