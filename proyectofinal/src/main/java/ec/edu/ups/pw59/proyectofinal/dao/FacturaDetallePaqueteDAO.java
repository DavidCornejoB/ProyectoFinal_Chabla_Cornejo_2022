package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetallePaquete;

@Stateless
public class FacturaDetallePaqueteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(FacturaDetallePaquete detallePaquete) {
		
		em.persist(detallePaquete);
		
	}
	
	public void update(FacturaDetallePaquete detallePaquete) {
		em.merge(detallePaquete);
		
	}
	
	public FacturaDetallePaquete read(int codigo) {
		FacturaDetallePaquete d = em.find(FacturaDetallePaquete.class, codigo);
		return d;
	}
	
	public void delete(int codigo) {
		FacturaDetallePaquete d = em.find(FacturaDetallePaquete.class, codigo);
		em.remove(d);		
	}
	
	
	
	public List<FacturaDetallePaquete> getDetallesFacturas(String nombre){
		
		String jpql2="SELECT p FROM FacturaDetallePaquete p";
		
		//nombre= nombre+"%";
		Query query= em.createQuery(jpql2, FacturaDetallePaquete.class);
		//query.setParameter(1, nombre);
		
		List<FacturaDetallePaquete> detalles=query.getResultList();
		return detalles;
		
	}

}
