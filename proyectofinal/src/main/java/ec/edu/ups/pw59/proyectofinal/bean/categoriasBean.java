package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.CategoriaONLocal;
import ec.edu.ups.pw59.proyectofinal.business.HabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Categoria;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;

@Named //EIQUETA DE MANAGED BEANS
@RequestScoped
public class categoriasBean {
	
	//LLAMAMOS AL OBJETO DE NEGOCIO LOCAL QUE CONTIENE LOS MÉTODOS INSERT, UPDATE, READ Y DELETE
	@Inject
	private CategoriaONLocal categoriaON;
	
	@Inject
	private HabitacionONLocal habitacionON;
	
	//CREAMOS EL OBJETO CATEGORIA. LOS VALORES ESTARÁN VACÍOS Y PODREMOS MANIPULARLOS
	private Categoria categoria = new Categoria();
	
	//VARIABLE LISTA QUE CONTIENE LA LISTA DE CATEGORÍAS INGRESADAS
	private List<Categoria> categorias;
	
	private List<Habitacion> habitaciones;
	
	//CONSTRUCTOR
	public categoriasBean() {
		
	}
	
	//UTILIZAMOS LA ETIQUETA POSTCOSTRCUT POR SI QUEREMOS LISTAR ANTES DE TENER ELEMENTOS EN LA LISTA
	@PostConstruct
	public void init() {
		this.cargar();
	}

	//METODOS GET() Y SET()
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public CategoriaONLocal getCategoriaON() {
		return categoriaON;
	}

	public void setCategoriaON(CategoriaONLocal categoriaON) {
		this.categoriaON = categoriaON;
	}

	public HabitacionONLocal getHabitacionON() {
		return habitacionON;
	}

	public void setHabitacionON(HabitacionONLocal habitacionON) {
		this.habitacionON = habitacionON;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	//METODO PARA GUARDAR CATEGORIAS
	public String guardar() {//GUARDAR CATEGORIAS
		
		System.out.println("GUARDANDO CATEGORIA: " + this.categoria.getNombre());
		
		try {
			//USAMOS EL MÉTODO INSERT DE LA ENTIDAD DE NEGOCIO DE CATEGORIA
			categoriaON.insert(this.categoria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//UNA VEZ SE HA INGRESADO UNA CATEGORIA, SE REDIRIGIRÁ AL FORMULARIO DONDE SE LISTAN LAS CATEGORIAS INGRESADAS
		return "listado-categorias?faces-redirect=true";
	}//GUARDAR CATEGORIAS
	
	public String eliminar(int codigo) {
		
		this.habitaciones = habitacionON.getHabitaciones();
		for(int i = 0; i < this.habitaciones.size(); i++) {
			if(this.habitaciones.get(i).getCategoria().getCodigo() == codigo) {
				
				return "error-eliminar-categoria";
			}
		}
		
		try {
			categoriaON.delete(codigo);
			return "eliminar-categoria";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	//METODO PARA LISTAR CATEGORIAS
	public void cargar() {
		//LLAMAMOS AL MÉTODO GETCATEGORIAS() DEL OBJETO DE NEGOCIO
		this.categorias = categoriaON.getCategorias();
	}
	
	public String volverIngresar() {
		System.out.println("VOLVIENDO A INGRESO CATEGORIAS...");
		return "categoria";
	}

}
