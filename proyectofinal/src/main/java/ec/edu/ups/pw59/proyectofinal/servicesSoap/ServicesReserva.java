package ec.edu.ups.pw59.proyectofinal.servicesSoap;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.pw59.proyectofinal.business.ReservaONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Reserva;

@WebService
public class ServicesReserva {
	
	@Inject
	private ReservaONLocal reservaON;
	
	@WebMethod
	public String insertarReserva(Reserva reserva) {//INSERTAR RESERVA
		
		Reserva r = new Reserva();
		
		try {
			r = reservaON.read(reserva.getCodigo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(r == null) {
			try {
				reservaON.insert(reserva);
				return "RESERVA INSERTADA";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "NO SE HA PODIDO INSERTAR LA RESERVA";
			}
		} else {
			return "LA RESERVA YA HA SIDO INGRESADA";
		}
		
	}//INSERTAR RESERVA
	
	@WebMethod
	public String actualizarReserva(Reserva reserva) {//ACTUALIZAR RESERVA
		
		Reserva r = new Reserva();
		
		try {
			r = reservaON.read(reserva.getCodigo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (r == null) {
			
			return "NO SE HA ENCONTRADO LA RESERVA A ACTUALIZAR";
		} else {
			try {
				reservaON.update(reserva);
				return "RESERVA ACTUALIZADA";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "ERROR AL ACTUALIZAR LA RESERVA";
			}
		}
	}//ACTUALIZAR RESERVA
	
	@WebMethod
	public Reserva leerReserva(int numero) {//LEER RESERVA
		
		try {
			return reservaON.read(numero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("NO SE HA ENCONTRADO LA RESERVA");
			return null;
		}
	}//LEER RESERVA
	
	@WebMethod
	public String eliminarReserva(Reserva reserva) {//ELIMINAR RESERVA
		
		try {
			reservaON.delete(reserva.getCodigo());
			return "RESERVA " + reserva.getCodigo() + " ELIMINADA";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR RESERVA";
		}
		
	}//ELIMINAR RESERVA
	
	@WebMethod
	public List<Reserva> reservas(){//LISTAR RESERVAS
		
		List<Reserva> reservas = new ArrayList<>();
		
		reservas = reservaON.getReservas();
		
		return reservas;
		
	}//LISTAR RESERVAS

}
