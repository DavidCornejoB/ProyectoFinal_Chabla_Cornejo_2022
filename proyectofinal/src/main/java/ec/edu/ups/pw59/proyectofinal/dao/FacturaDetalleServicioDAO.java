package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleServicio;

@Stateless
public class FacturaDetalleServicioDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(FacturaDetalleServicio detalleServicio) {
		
		em.persist(detalleServicio);
		
	}
	
	public void update(FacturaDetalleServicio detalleServicio) {
		em.merge(detalleServicio);
		
	}
	
	public FacturaDetalleServicio read(int codigo) {
		FacturaDetalleServicio d = em.find(FacturaDetalleServicio.class, codigo);
		return d;
	}
	
	public void delete(int codigo) {
		FacturaDetalleServicio d = em.find(FacturaDetalleServicio.class, codigo);
		em.remove(d);		
	}
	
	
	public List<FacturaDetalleServicio> getDetallesFacturas(String nombre){
		
		String jpql2="SELECT p FROM FacturaDetalleServicio p";
		
		//nombre= nombre+"%";
		Query query= em.createQuery(jpql2, FacturaDetalleServicio.class);
		//query.setParameter(1, nombre);
		
		List<FacturaDetalleServicio> detalles=query.getResultList();
		return detalles;
		
	}

}
