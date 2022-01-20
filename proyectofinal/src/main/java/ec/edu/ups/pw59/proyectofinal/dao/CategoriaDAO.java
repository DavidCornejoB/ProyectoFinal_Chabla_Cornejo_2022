package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.Categoria;

@Stateless
public class CategoriaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Categoria op) {
		em.persist(op);
		
	}
	
	public void update(Categoria op) {
			em.merge(op);
		}
	
	public Categoria read(String id) {
		Categoria op = em.find(Categoria.class, id);
		return op;
	}
	
	public void delete(int id) {
		Categoria op = em.find(Categoria.class, id);
		em.remove(op);
	}
	
	public List<Categoria> getList(){
		List<Categoria> listado = new ArrayList<Categoria>();
		
		String jpql = "SELECT op FROM Categoria op";
				
		
		Query query = em.createQuery(jpql, Categoria.class);
		
		listado = query.getResultList();
		
		return listado;
		
		//JSPQL -> SQL
		
	}


}
