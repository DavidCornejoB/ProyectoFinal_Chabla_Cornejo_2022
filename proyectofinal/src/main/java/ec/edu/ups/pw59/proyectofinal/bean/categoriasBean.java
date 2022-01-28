package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.CategoriaONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Categoria;

@Named
@RequestScoped
public class categoriasBean {
	
	@Inject
	private CategoriaONLocal categoriaON;
	
	private Categoria categoria = new Categoria();
	
	private List<Categoria> categorias;
	
	//CONSTRUCTOR
	public categoriasBean() {
		
	}
	
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
	
	//METODO PARA GUARDAR CATEGORIAS
	public String guardar() {
		
		System.out.println("GUARDANDO CATEGORIA: " + this.categoria.getNombre());
		
		try {
			categoriaON.insert(this.categoria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	//METODO PARA LISTAR CATEGORIAS
	public void cargar() {
		this.categorias = categoriaON.getCategorias();
	}

}
