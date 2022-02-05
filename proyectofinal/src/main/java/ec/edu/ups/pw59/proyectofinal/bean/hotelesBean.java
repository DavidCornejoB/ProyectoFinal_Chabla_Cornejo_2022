package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.HotelONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;

@Named //ETIQUETA DE MANAGED BEANS
@RequestScoped
public class hotelesBean {
	
	//LLAMAMOS AL OBJETO DE NEGOCIO LOCAL QUE CONTIENE LOS MÉTODOS INSERT, UPDATE, READ Y DELETE
	@Inject
	private HotelONLocal hotelON;
	
	//CREAMOS EL OBJETO HOTEL CON PARÁMETROS VACÍOS
	private Hotel hotel = new Hotel();
	
	//VARIABLE LISTA QUE CONTIENE TODOS LOS OBJETOS HOTEL CREADOS
	private List<Hotel> hoteles;
	
	public hotelesBean() {
		
	}
	
	//UTILIZAMOS LA ETIQUETA POSTCONSTRUCT POR SI QUEREMOS LISTAR ANTES DE TENER ELEMENTOS EN LA LISTA.
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
			//USAMOS EL MÉTODO INSERT DE LA ENTIDAD DE NEGOCIO DE HOTEL
			hotelON.insert(this.hotel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//UNA VEZ SE HA INSERTADO UN HOTEL, SE REDIRIGIRÁ AL FORMULARIO DONDE SE LISTAN TODOS LOS HOTELES INGRESADOS
		return "listado-hoteles?faces-redirect=true";
	}
	
	//METODO PARA LISTAR HOTELES
	public void cargar() {
		//LLAMAMOS AL MÉTODO GETHOTELES() DEL OBJETO DE NEGOCIO
		this.hoteles = hotelON.getHoteles();
	}
	
	public String volverIngresar() {
		System.out.println("VOLVIENDO A INGRESAR HOTEL...");
		return "hotel";
	}

}
