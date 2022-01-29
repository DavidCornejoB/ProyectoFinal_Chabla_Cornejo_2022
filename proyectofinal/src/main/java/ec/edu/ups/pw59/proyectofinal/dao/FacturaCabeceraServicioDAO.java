package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraServicio;

@Stateless
public class FacturaCabeceraServicioDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(FacturaCabeceraServicio facturaServicio) {
		
		em.persist(facturaServicio);
		
	}
	
	public void update(FacturaCabeceraServicio facturaServicio) {
		em.merge(facturaServicio);
		
	}
	
	public FacturaCabeceraServicio read(int id) {
		FacturaCabeceraServicio p = em.find(FacturaCabeceraServicio.class, id);
		return p;
	}
	
	public void delete(int id) {
		FacturaCabeceraServicio p = em.find(FacturaCabeceraServicio.class, id);
		em.remove(p);		
	}
	
	
 public List<FacturaCabeceraServicio> getList(){
		
		String jpql2="SELECT p FROM FacturaCabeceraServicio p";
		
		//nombre= nombre+"%";
		Query query= em.createQuery(jpql2, FacturaCabeceraServicio.class);
		//query.setParameter(1, nombre);
		
		List<FacturaCabeceraServicio> facturas=query.getResultList();
		return facturas;
		
	}

}
