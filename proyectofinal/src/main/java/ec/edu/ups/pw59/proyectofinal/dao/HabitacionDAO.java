package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;

@Stateless
public class HabitacionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Habitacion op) {
		em.persist(op);
		
	}
	
	public void update(Habitacion op) {
			em.merge(op);
		}
	
	public Habitacion read(String id) {
		Habitacion op = em.find(Habitacion.class, id);
		return op;
	}
	
	public void delete(int id) {
		Habitacion op = em.find(Habitacion.class, id);
		em.remove(op);
	}
	
	public List<Habitacion> getList(){
		List<Habitacion> listado = new ArrayList<Habitacion>();
		
		String jpql = "SELECT op FROM Habitacion op";
				
		
		Query query = em.createQuery(jpql, Habitacion.class);
		
		listado = query.getResultList();
		
		return listado;
		
		//JSPQL -> SQL
		
	}

}
