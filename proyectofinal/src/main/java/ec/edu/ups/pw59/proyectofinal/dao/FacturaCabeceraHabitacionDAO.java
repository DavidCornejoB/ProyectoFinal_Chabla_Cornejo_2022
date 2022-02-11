package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.ArrayList;
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

	public void insert(FacturaCabeceraHabitacion f) {
		em.persist(f);

	}

	public void update(FacturaCabeceraHabitacion f) {
		em.merge(f);

	}

	public FacturaCabeceraHabitacion read(int id) {
		FacturaCabeceraHabitacion p = em.find(FacturaCabeceraHabitacion.class, id);
		return p;
	}

	public void delete(int id) {
		FacturaCabeceraHabitacion p = em.find(FacturaCabeceraHabitacion.class, id);
		em.remove(p);
	}

	public List<FacturaCabeceraHabitacion> getList() {
		List<FacturaCabeceraHabitacion> facturas = new ArrayList<FacturaCabeceraHabitacion>();
		
		String jpql = "SELECT p FROM FacturaCabeceraHabitacion p";

		Query query = em.createQuery(jpql, FacturaCabeceraHabitacion.class);

		facturas = query.getResultList();
		
		return facturas;

	}

}
