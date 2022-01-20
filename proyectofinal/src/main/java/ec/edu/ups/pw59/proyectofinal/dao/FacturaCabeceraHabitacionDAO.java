package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraHabitacion;

@Stateless
public class FacturaCabeceraHabitacionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(FacturaCabeceraHabitacion facturaHabitacion) {
		
		em.persist(facturaHabitacion);
		
	}
	
	public void update(FacturaCabeceraHabitacion facturaHabitacion) {
		em.merge(facturaHabitacion);
		
	}
	
	public FacturaCabeceraHabitacion read(int id) {
		FacturaCabeceraHabitacion p = em.find(FacturaCabeceraHabitacion.class, id);
		return p;
	}
	
	public void delete(int id) {
		FacturaCabeceraHabitacion p = em.find(FacturaCabeceraHabitacion.class, id);
		em.remove(p);		
	}
	
	
public List<FacturaCabeceraHabitacion> getFacturas(){
		
		String jpql2="SELECT p FROM FacturaCabeceraHabitacion p";
		
		//nombre= nombre+"%";
		Query query= em.createQuery(jpql2, FacturaCabeceraHabitacion.class);
		//query.setParameter(1, nombre);
		
		List<FacturaCabeceraHabitacion> facturas=query.getResultList();
		return facturas;
		
	}

}
