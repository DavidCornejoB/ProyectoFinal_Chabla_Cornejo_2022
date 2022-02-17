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

/**
 * 
 * @author luisd
 *
 */
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
	
	/**
	 * UTILIZAMOS LA ETIQUETA POSTCOSTRCUT POR SI QUEREMOS LISTAR ANTES DE TENER ELEMENTOS EN LA LISTA
	 */
	@PostConstruct
	public void init() {
		this.cargar();
	}

	//METODOS GET() Y SET()
	
	/**
	 * 
	 * @return categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * 
	 * @param categoria
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * 
	 * @return lista de categorias
	 */
	public List<Categoria> getCategorias() {
		return categorias;
	}

	/**
	 * 
	 * @param categorias
	 */
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	/**
	 * 
	 * @return objeto de negocio categoria
	 */
	public CategoriaONLocal getCategoriaON() {
		return categoriaON;
	}

	/**
	 * 
	 * @param categoriaON
	 */
	public void setCategoriaON(CategoriaONLocal categoriaON) {
		this.categoriaON = categoriaON;
	}

	/**
	 * 
	 * @return objeto de negocio habitacion
	 */
	public HabitacionONLocal getHabitacionON() {
		return habitacionON;
	}

	/**
	 * 
	 * @param habitacionON
	 */
	public void setHabitacionON(HabitacionONLocal habitacionON) {
		this.habitacionON = habitacionON;
	}

	/**
	 * 
	 * @return lista de habitaciones
	 */
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	/**
	 * 
	 * @param habitaciones
	 */
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	/*
	 * METODO PARA GUARDAR CATEGORIAS
	 */
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
	
	/**
	 * METODO PARA ELIMINAR CATEGORIAS
	 * @param codigo
	 * @return formulario eliminar-categoria
	 */
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
	
	/**
	 * METODO PARA LISTAR CATEGORIAS
	 */
	public void cargar() {
		//LLAMAMOS AL MÉTODO GETCATEGORIAS() DEL OBJETO DE NEGOCIO
		this.categorias = categoriaON.getCategorias();
	}
	
	/**
	 * METODO PARA VOLVER A INGRESAR AL FORMULARIO
	 * @return formulario categorias
	 */
	public String volverIngresar() {
		System.out.println("VOLVIENDO A INGRESO CATEGORIAS...");
		return "categoria";
	}

}
