package ec.edu.ups.pw59.proyectofinal.servicesSoap;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.pw59.proyectofinal.business.HabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.business.HotelONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;

@WebService
public class ServicesHotel {
	
	@Inject
	private HotelONLocal hotelON;
	
	@Inject
	private HabitacionONLocal habitacionON;
	
	@WebMethod
	public String insertarHotel(Hotel hotel) { //INSERTAR HOTEL
		
		Hotel h = new Hotel();
		
		try {
			h = hotelON.read(hotel.getCodigo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(h == null) {
			try {
				hotelON.insert(hotel);
				return "HOTEL INGRESADO";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "ERROR AL INGRESAR HOTEL";
			}
		} else {
			return "EL HOTEL YA HA SIDO INGRESADO";
		}
	} //INSERTAR HOTEL
	
	//******************************************
	//******************************************
	
	@WebMethod
	public String actualizarHotel(Hotel hotel) { //ACTUALIZAR HOTEL
		
		Hotel h = new Hotel();
		
		try {
			h = hotelON.read(hotel.getCodigo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (h == null) {
			 return "NO SE HA ENCONTRADO EL HOTEL A ACTUALZIAR";
		} else {
			try {
				hotelON.update(hotel);
				return "HOTEL ACTUALIZADO CORRECTAMENTE";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "ERROR AL ACTUALIZAR EL HOTEL";
			}
		}
		
	}//ACTUALIZAR HOTEL
	
	//******************************************
	//******************************************
	
	@WebMethod
	public Hotel leerHotel (Hotel hotel) { //LEER HOTEL
		
		try {
			return hotelON.read(hotel.getCodigo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("NO SE HA ENCONTRADO EL HOTEL");
			return null;
		}
	} //LEERHOTEL
	
	//******************************************
	//******************************************
	
	@WebMethod
	public String eliminarHotel(Hotel hotel) { //ELIMINAR HOTEL
		
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		habitaciones = habitacionON.getHabitaciones();
		
		for (int i = 0; i < habitaciones.size(); i++) {
			if (habitaciones.get(i).getHotel().getCodigo() == hotel.getCodigo()) {
				
				System.out.println("SE HA ENCONTRADO HABITACIONES CON ÉSE HOTEL");
				
				try {
					habitacionON.delete(habitaciones.get(i).getNumero());
					System.out.println("HABITACION ELIMINADA");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("NO SE HA PODIDO ELIMINAR LA HABITACION");
				}
			}
		}
		
		try {
			hotelON.delete(hotel.getCodigo());
			return "HOTEL " + hotel.getNombre() + " ELIMINADO";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR HOTEL " + hotel.getNombre();
		}
		
	}//ELIMINAR HOTEL
	
	//******************************************
	//******************************************
	
	@WebMethod
	public List<Hotel> getHoteles(){// LISTAR HOTELES
		
		List<Hotel> hoteles = new ArrayList<Hotel>();
		
		hoteles = hotelON.getHoteles();
		
		return hoteles;
		
	}// LISTAR HOTELES
	
	
	

}
