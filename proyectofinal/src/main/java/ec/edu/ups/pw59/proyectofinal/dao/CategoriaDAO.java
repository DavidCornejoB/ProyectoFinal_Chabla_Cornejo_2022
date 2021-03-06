package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.Categoria;

/**
 * 
 * @author luisd
 *
 */
@Stateless
public class CategoriaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param entidad categoria
	 */
	public void insert(Categoria op) {
		em.persist(op);
		
	}
	
	/**
	 * 
	 * @param entidad categoria
	 */
	public void update(Categoria op) {
			em.merge(op);
		}
	
	/**
	 * 
	 * @param id de categoria
	 * @return categoria encontrada
	 */
	public Categoria read(int id) {
		Categoria op = em.find(Categoria.class, id);
		return op;
	}
	
	/**
	 * 
	 * @param id de categoria a eliminar
	 */
	public void delete(int id) {
		Categoria op = em.find(Categoria.class, id);
		em.remove(op);
	}
	
	/**
	 * 
	 * @return lista de categorias
	 */
	public List<Categoria> getList(){
		List<Categoria> listado = new ArrayList<Categoria>();
		
		String jpql = "SELECT cat FROM Categoria cat";
				
		
		Query query = em.createQuery(jpql, Categoria.class);
		
		listado = query.getResultList();
		
		return listado;
		
		//JSPQL -> SQL
		
	}


}
