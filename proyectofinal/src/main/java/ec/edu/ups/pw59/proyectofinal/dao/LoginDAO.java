package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.Login;

@Stateless
public class LoginDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Login op) {
		em.persist(op);
		
	}
	
	public void update(Login op) {
			em.merge(op);
		}
	
	public Login read(String id) {
		Login op = em.find(Login.class, id);
		return op;
	}
	
	public void delete(int id) {
		Login op = em.find(Login.class, id);
		em.remove(op);
	}
	
	public List<Login> getList(){
		List<Login> listado = new ArrayList<Login>();
		
		String jpql = "SELECT op FROM Login op";
				
		
		Query query = em.createQuery(jpql, Login.class);
		
		listado = query.getResultList();
		
		return listado;
		
		//JSPQL -> SQL
		
	}


}
