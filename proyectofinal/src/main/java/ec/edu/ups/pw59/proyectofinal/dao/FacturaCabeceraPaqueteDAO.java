package ec.edu.ups.pw59.proyectofinal.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraPaquete;


@Stateless
public class FacturaCabeceraPaqueteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(FacturaCabeceraPaquete facturaPaquete) {
		
		em.persist(facturaPaquete);
		
	}
	
	public void update(FacturaCabeceraPaquete facturaPaquete) {
		em.merge(facturaPaquete);
		
	}
	
	public FacturaCabeceraPaquete read(int id) {
		FacturaCabeceraPaquete p = em.find(FacturaCabeceraPaquete.class, id);
		return p;
	}
	
	public void delete(int id) {
		FacturaCabeceraPaquete p = em.find(FacturaCabeceraPaquete.class, id);
		em.remove(p);		
	}
	
	
  public List<FacturaCabeceraPaquete> getList(){
		
		String jpql2="SELECT p FROM facturacabecerapaquete p";
		
		//nombre= nombre+"%";
		Query query= em.createQuery(jpql2, FacturaCabeceraPaquete.class);
		//query.setParameter(1, nombre);
		
		List<FacturaCabeceraPaquete> facturas=query.getResultList();
		return facturas;
		
	}


}
