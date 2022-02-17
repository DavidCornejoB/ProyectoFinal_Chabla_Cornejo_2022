package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraHabitacion;
/**
 * 
 * @author WilliamChabla
 *
 */
@Stateless
public class FacturaCabeceraHabitacionDAO {

	@PersistenceContext
	private EntityManager em;
	/**
	 * 
	 * @param f
	 */
	public void insert(FacturaCabeceraHabitacion f) {
		em.persist(f);

	}
	/**
	 * 
	 * @param f
	 */
	public void update(FacturaCabeceraHabitacion f) {
		em.merge(f);

	}
	/**
	 * 
	 * @param id
	 * @return p
	 */
	public FacturaCabeceraHabitacion read(int id) {
		FacturaCabeceraHabitacion p = em.find(FacturaCabeceraHabitacion.class, id);
		return p;
	}
	/**
	 * 
	 * @param id
	 */
	public void delete(int id) {
		FacturaCabeceraHabitacion p = em.find(FacturaCabeceraHabitacion.class, id);
		em.remove(p);
	}
	/**
	 * 
	 * @return facturas FacturaCabeceraHabitacion
	 */
	public List<FacturaCabeceraHabitacion> getList() {
		List<FacturaCabeceraHabitacion> facturas = new ArrayList<FacturaCabeceraHabitacion>();
		
		String jpql = "SELECT p FROM FacturaCabeceraHabitacion p";

		Query query = em.createQuery(jpql, FacturaCabeceraHabitacion.class);

		facturas = query.getResultList();
		
		return facturas;

	}

}
