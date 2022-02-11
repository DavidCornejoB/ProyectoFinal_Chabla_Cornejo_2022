package ec.edu.ups.pw59.proyectofinal.servicesSoap;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.pw59.proyectofinal.business.PaqueteONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Paquete;

@WebService
public class ServicesPaquete {
	
	@Inject
	private PaqueteONLocal paqueteON;
	
	@WebMethod
	public String insertarPaquete(Paquete paquete) {//INSERTAR PAQUETE
		
		Paquete p = new Paquete();
		
		try {
			p = paqueteON.read(paquete.getCodigo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (p == null) {
			try {
				paqueteON.insert(paquete);
				return "PAQUETE INSERTADO";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "NO SE HA PODIDO INSERTAR EL PAQUETE";
			}
		} else {
			return "EL PAQUETE YA HA SIDO INSERTADO";
		}
	}//INSERTAR PAQUETE
	
	@WebMethod
	public String actualizarPaquete(Paquete paquete) {//ACTUALIZAR PAQUETE
		
		Paquete p = new Paquete();
		
		try {
			p = paqueteON.read(paquete.getCodigo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(p == null) {
			
			return "NO SE HA ENCONTRADO EL PAQUETE A ACTUALIZAR";
		} else {
			
			try {
				paqueteON.update(paquete);
				return "PAQUETE ACTUALIZADO";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "ERROR AL ACTUALIZAR EL PAQUETE";
			}
		}
	}//ACTUALIZAR PAQUETE
	
	@WebMethod
	public Paquete leerPaquete(int numero) {//LEER PAQUETE
		
		try {
			return paqueteON.read(numero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("NO SE HA ENCONTRADO EL PAQUETE");
			return null;
		}
	}//LEER PAQUETE
	
	@WebMethod
	public String eliminarPaquete(Paquete paquete) {//ELIMINAR PAQUETE
		
		try {
			paqueteON.delete(paquete.getCodigo());
			return "PAQUETE " + paquete.getCodigo() + " ELIMINADO";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR PAQUETE";
		}
	}//ELIMINAR PAQUETE
	
	@WebMethod
	public List<Paquete> paquetes(){//LISTAR PAQUETES
		
		List<Paquete> paquetes = new ArrayList<>();
		
		paquetes = paqueteON.getPaquetes();
		
		return paquetes;
	}//LISTAR PAQUETES

}
