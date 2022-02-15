package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.HotelONLocal;
import ec.edu.ups.pw59.proyectofinal.business.ServicioONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;
import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

@Named //ETIQUETA DE MANAGED BEANS
@RequestScoped
public class serviciosBean {
	
	//LLAMAMOS AL OBJETO DE NEGOCIO LOCAL QUE CONTIENE LOS MÉTODOS INSERT, UPDATE, READ Y DELETE
	@Inject
	private ServicioONLocal servicioON;
	
	@Inject
	private HotelONLocal hotelON;
	
	private List<SelectItem> listaHoteles;
	
	//CREAMOS EL OBJETO SERVICIO. COMO ESTÁ INSTANCIADO, ESTARÁN SUS VALORES VACÍOS, Y PODREMOS MODIFICARLOS DESDE EL FORMULARIO
	private Servicio servicio = new Servicio();
	
	//LISTA DE SERVICIOS
	private List<Servicio> servicios;
	
	//CONSTRUCTOR
	public serviciosBean() {
		
	}
	
	//UTILIZAMOS LA ETIQUETA POSTCONSTRUCT POR SI QUEREMOS LISTAR ANTES DE TENER ELEMENTOS EN LA LISTA.
	@PostConstruct
	public void init() {
		//COMBOBOX DE HOTELES
		this.cargarComboboxHoteles();
		
		this.servicio.setHotel(new Hotel());
		this.cargar();
	}
	
	//METODOS GET() Y SET()
	public ServicioONLocal getServicioON() {
		return servicioON;
	}

	public void setServicioON(ServicioONLocal servicioON) {
		this.servicioON = servicioON;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	public List<SelectItem> getListaHoteles() {
		return listaHoteles;
	}

	public void setListaHoteles(List<SelectItem> listaHoteles) {
		this.listaHoteles = listaHoteles;
	}

	//MÉTODO PARA GUARDAR SERVICIOS
	public String guardar() {
		
		System.out.println("GUARDANDO SERVICIO: " + this.servicio.getNombre());
		
		try {
			//USAMOS EL MÉTODO INSERT DE LA ENTIDAD DE NEGOCIO DE SERVICIO
			servicioON.insert(this.servicio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//UNA VEZ SE HA INGRESADO UNA SERVICIO, SE REDIRIGIRÁ AL FORMULARIO DE LISTAR SERVICIOS
		return "listado-servicios?faces-redirect=true";
	}
	
	//MÉTODO PARA LISTAR SERVICIOS
	public void cargar() {
		//LLAMAMOS AL MÉTODO GETSERVICIOS() DEL OBJETO DE NEGOCIO
		this.servicios = servicioON.getServicios();
	}
	
	public void cargarComboboxHoteles() {//COMBOBOX HOTELES
		
		listaHoteles = new ArrayList<SelectItem>();
		List<Hotel> hoteles = new ArrayList<>();
		hoteles = hotelON.getHoteles();
		
		for(int i = 0; i < hoteles.size(); i++) {
			listaHoteles.add(new SelectItem(hoteles.get(i).getCodigo(), hoteles.get(i).getNombre()));
		}
		
	}//COMBOBOX HOTELES
	
	public String cargarHotel() {
		int id = this.servicio.getHotel().getCodigo();
		
		Hotel h = servicioON.getHotel(id);
		this.servicio.setHotel(h);
		
		return null;
	}
	
	public String volverIngresar() {
		System.out.println("VOLVIENDO A INGRESO SERVICIOS...");
		return "servicio";
	}

}
