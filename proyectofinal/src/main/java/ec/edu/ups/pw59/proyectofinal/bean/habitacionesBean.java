package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.CategoriaON;
import ec.edu.ups.pw59.proyectofinal.business.CategoriaONLocal;
import ec.edu.ups.pw59.proyectofinal.business.HabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.business.HotelONLocal;
import ec.edu.ups.pw59.proyectofinal.business.PaqueteONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Categoria;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;
import ec.edu.ups.pw59.proyectofinal.modelo.Paquete;

@Named //ETIQUETA DE MANAGED BEANS
@RequestScoped
public class habitacionesBean {
	
	//LLAMAMOS AL OBJETO DE NEGOCIO LOCAL QUE CONTIENE LOS MÉTODOS INSERT, UPDATE, READ Y DELETE
	@Inject
	private HabitacionONLocal habitacionON;
	
	@Inject
	private PaqueteONLocal paqueteON;
	
	@Inject
	private HotelONLocal hotelON;
	
	@Inject
	private CategoriaONLocal categoriaON;
	
	private List<SelectItem> listaHoteles;
	private List<SelectItem> listaCategorias;
	
	//CREAMOS EL OBJETO HABITACION. SE INICIALIZA CON VALORES VACIOS
	private Habitacion habitacion = new Habitacion();
	
	//VARIABLE LISTA QUE CONTIENE TODAS LAS HABITACIONES INGRESADAS
	private List<Habitacion> habitaciones;
	
	private List<Paquete> paquetes;
	
	//CONSTRUCTOR
	public habitacionesBean() {
		
	}
	
	//UTILIZAMOS LA ETIQUETA POSTCONSTRUCT POR SI QUEREMOS LISTAR ANTES DE TENER ELEMENTOS EN LA LISTA.
	@PostConstruct
	public void init() {
		
		//COMBOBOX DE HOTELES
		this.cargarComboboxHoteles();
		
		//COMBOBOX DE CATEGORIAS
		this.cargarComboboxCategorias();
		
		this.habitacion.setCategoria(new Categoria());
		this.habitacion.setHotel(new Hotel());
		this.cargar();

	}
	
	//METODOS GET() Y SET()
	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	public List<SelectItem> getListaHoteles() {
		return listaHoteles;
	}

	public void setListaHoteles(List<SelectItem> listaHoteles) {
		this.listaHoteles = listaHoteles;
	}
	
	public List<SelectItem> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<SelectItem> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	//METODO PARA GUARDAR HABITACIONES
	public String guardar() {
		
		System.out.println("GUARDANDO HABITACION: " + this.habitacion.getNumero());
		
		try {
			//USAMOS EL MÉTODO INSERT DEL OBJETO DE NEGOCIO DE HABITACION
			habitacionON.insert(this.habitacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//UNA VEZ SE HA INGRESADO UNA HABITACION, SE REDIRIGIRÁ AL FORMULARIO DE LISTAR HABITACIONES
		return "listado-habitaciones?faces-redirect=true";
	}
	
	public String eliminar(int numero) {//ELIMINAR HABITACIONES
		
		Habitacion habitacion = new Habitacion();
		try {
			habitacion = habitacionON.read(numero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(habitacion.getEstado().equals("Ocupada")) {
			return "error-eliminar-habitacion";
		} else {
			
			this.paquetes = paqueteON.getPaquetes();
			
			for(int i = 0; i < this.paquetes.size(); i++) {
				if(this.paquetes.get(i).getHabitacion().getNumero() == numero) {
					return "error-eliminar-habitacion";
				}
			}
			
			try {
				habitacionON.delete(numero);
				return "eliminar-habitacion";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	}//ELIMINAR HABITACIONES
	
	//METODO PARA LISTAR HABITACIONES
	public void cargar() {//CARGAR HABITACIONES
		//LLAMAMOS AL MÉTODO GETHABITACIONES() DEL OBJETO DE NEGOCIO
		this.habitaciones = habitacionON.getHabitaciones();
	}//CARGAR HABITACIONES
	
	public void cargarComboboxHoteles() {//COMBOBOX HOTELES
		
		listaHoteles = new ArrayList<SelectItem>();
		List<Hotel> hoteles = new ArrayList<>();
		hoteles = hotelON.getHoteles();
		
		for(int i = 0; i < hoteles.size(); i++) {
			listaHoteles.add(new SelectItem(hoteles.get(i).getCodigo(), hoteles.get(i).getNombre()));
		}
		
	}//COMBOBOX HOTELES
	
	public void cargarComboboxCategorias() {//COMBOBOX CATEGORIAS
		
		listaCategorias = new ArrayList<SelectItem>();
		List<Categoria> categorias = new ArrayList<>();
		categorias = categoriaON.getCategorias();
		
		for(int i = 0; i < categorias.size(); i++) {
			listaCategorias.add(new SelectItem(categorias.get(i).getCodigo(), categorias.get(i).getNombre()));
		}
		
	}//COMBOBOX CATEGORIAS
	
	public String cargarCategoria() {
		
		int id = this.habitacion.getCategoria().getCodigo();
		
		Categoria cat = habitacionON.getCategoria(id);
		this.habitacion.setCategoria(cat);
		
		return null;
	}
	
	public String cargarHotel() {
		int id = this.habitacion.getHotel().getCodigo();
		
		Hotel h = habitacionON.getHotel(id);
		this.habitacion.setHotel(h);
		
		return null;
	}
	
	public String volverIngresar() {
		System.out.println("VOLVIENDO A INGRESO HABITACIONES... ");
		return "habitacion";
	}
	
}
