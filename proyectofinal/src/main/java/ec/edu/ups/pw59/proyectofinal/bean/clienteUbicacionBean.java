package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.HotelONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;

/**
 * BEAN PARA MOSTRAR HOTELES POR UBICACION
 * @author luisd
 *
 */
@Named
@RequestScoped
public class clienteUbicacionBean {
	
	@Inject
	private HotelONLocal hotelON;
	
	private Hotel hotel = new Hotel();
	
	private String pais;
	
	public static String ubicacion;
	
	private List<Hotel> hoteles;
	
	private clienteHotelBean clienteHotel;
	
	public clienteUbicacionBean() {
		
	}
	
	/**
	 * PostConstruct
	 */
	@PostConstruct
	public void init() {
		this.listarHoteles();
	}

	/**
	 * 
	 * @return hotelON
	 */
	public HotelONLocal getHotelON() {
		return hotelON;
	}

	/**
	 * 
	 * @param hotelON
	 */
	public void setHotelON(HotelONLocal hotelON) {
		this.hotelON = hotelON;
	}

	/**
	 * 
	 * @return hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * 
	 * @param hotel
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	/**
	 * 
	 * @return pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * 
	 * @param pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * 
	 * @return hoteles
	 */
	public List<Hotel> getHoteles() {
		return hoteles;
	}

	/**
	 * 
	 * @param hoteles
	 */
	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
	}
	
	/**
	 * 
	 * @return ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * 
	 * @param ubicacion
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * MOSTRAR HOTELES DE COLOMBIA
	 * @return formulario cliente-principal
	 */
	public String ubicacionColombia() {
		this.ubicacion = "Colombia";
		return "cliente-principal?faces-redirect=true";
	}
	
	/**
	 * MOSTRAR HOTELES DE ECUADOR
	 * @return formulario cliente-principal
	 */
	public String ubicacionEcuador() {
		this.ubicacion = "Ecuador";
		return "cliente-principal?faces-redirect=true";
	}
	
	/**
	 * MOSTRAR HOTELES DE PERU
	 * @return formulario cliente-principal
	 */
	public String ubicacionPeru() {
		this.ubicacion = "Peru";
		return "cliente-principal?faces-redirect=true";		
	}
	
	/**
	 * LISTAR HOTELES
	 */
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
	
	/**
	 * METODO PARA MOSTRAR HOTEL
	 * @param id
	 * @return formulario cliente-ventana-hotel
	 */
	public String mostrarHotel(int id) {
		System.out.println("ID ENVIADA: " + id);
		
		clienteHotel.setIdHotel(id);
		
		return "cliente-ventana-hotel?faces-redirect=true";
	}

}
