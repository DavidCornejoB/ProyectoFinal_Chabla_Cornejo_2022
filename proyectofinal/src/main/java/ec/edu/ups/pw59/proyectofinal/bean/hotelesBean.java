package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.HotelONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;

@Named
@RequestScoped
public class hotelesBean {
	
	@Inject
	private HotelONLocal hotelON;
	
	private Hotel hotel = new Hotel();
	
	private List<Hotel> hoteles;
	
	public hotelesBean() {
		
	}
	
	@PostConstruct
	public void init() {
		this.cargar();
	}
	
	//METODOS GET() Y SET()

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Hotel> getHoteles() {
		return hoteles;
	}

	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
	}
	
	//METODO PARA GUARDAR HOTELES
	public String guardar() {
		System.out.println("GUARDANDO HOTEL: " + this.hotel.getNombre());
		
		try {
			hotelON.insert(this.hotel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "listado-hoteles?faces-redirect=true";
	}
	
	//METODO PARA LISTAR HOTELES
	public void cargar() {
		this.hoteles = hotelON.getHoteles();
	}

}
