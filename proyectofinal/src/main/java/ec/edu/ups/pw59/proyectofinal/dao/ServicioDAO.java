package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

@Stateless
public class ServicioDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Servicio op) {
		em.persist(op);
		
	}
	
	public void update(Servicio op) {
			em.merge(op);
		}
	
	public Servicio read(String id) {
		Servicio op = em.find(Servicio.class, id);
		return op;
	}
	
	public void delete(int id) {
		Servicio op = em.find(Servicio.class, id);
		em.remove(op);
	}
	
	public List<Servicio> getList(){
		List<Servicio> listado = new ArrayList<Servicio>();
		
		String jpql = "SELECT op FROM servicio op";
				
		
		Query query = em.createQuery(jpql, Servicio	.class);
		
		listado = query.getResultList();
		
		return listado;
		
		//JSPQL -> SQL
		
	}


}
