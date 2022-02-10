package ec.edu.ups.pw59.proyectofinal.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.HotelONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;

@Named
@RequestScoped
public class clienteUbicacionBean {
	
	@Inject
	private HotelONLocal hotelON;
	
	private Hotel hotel = new Hotel();
	
	public clienteUbicacionBean() {
		
	}
	
	@PostConstruct
	public void init() {
		
	}

	public HotelONLocal getHotelON() {
		return hotelON;
	}

	public void setHotelON(HotelONLocal hotelON) {
		this.hotelON = hotelON;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	//MOSTRAR HOTELES DE COLOMBIA
	public String ubicacionColombia() {
		return "cliente-principal?id=Colombia";
	}
	
	//MOSTRAR HOTELES DE ECUADOR
	public String ubicacionEcuador() {
		return "cliente-principal?id=Ecuador";
	}
	
	//MOSTRAR HOTELES DE PERU
	public String ubicacionPeru() {
		return "cliente-principal?id=Peru";
		
	}

}
