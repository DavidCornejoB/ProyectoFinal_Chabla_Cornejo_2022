package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.ArrayList;
import java.util.List;

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
	
	private String pais;
	
	public static String ubicacion;
	
	private List<Hotel> hoteles;
	
	public clienteUbicacionBean() {
		
	}
	
	@PostConstruct
	public void init() {
		this.listarHoteles();
		
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
	
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Hotel> getHoteles() {
		return hoteles;
	}

	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	//MOSTRAR HOTELES DE COLOMBIA
	public String ubicacionColombia() {
		this.ubicacion = "Colombia";
		return "cliente-principal?faces-redirect=true";
	}
	
	//MOSTRAR HOTELES DE ECUADOR
	public String ubicacionEcuador() {
		this.ubicacion = "Ecuador";
		return "cliente-principal?faces-redirect=true";
	}
	
	//MOSTRAR HOTELES DE PERU
	public String ubicacionPeru() {
		this.ubicacion = "Peru";
		return "cliente-principal?faces-redirect=true";		
	}
	
	public void listarHoteles() {
		
		List<Hotel> hoteles = hotelON.getHoteles();
		List<Hotel> hotelesPais = new ArrayList<Hotel>();
		
		for(int i = 0; i < hoteles.size(); i++) {
			if(hoteles.get(i).getPais().equals(this.ubicacion)) {
				hotelesPais.add(hoteles.get(i));
			}
		}
		
		this.hoteles = hotelesPais;
		
	}
	
	public String mostrarHotel(int id) {
		System.out.println("******************************************");
		System.out.println("NOS VAMOS A CLIENTE VENTANA HOTEL " + id);
		return "cliente-ventana-hotel?faces-redirect=true&id=" + id;
	}

}
