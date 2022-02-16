package ec.edu.ups.pw59.proyectofinal.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.pw59.proyectofinal.business.CategoriaONLocal;
import ec.edu.ups.pw59.proyectofinal.business.HabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Categoria;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;

@Path("categoria")
public class ServicesCategoria {
	
	@Inject
	private CategoriaONLocal categoriaON;
	
	@Inject
	private HabitacionONLocal habitacionON;
	
	private List<Habitacion> habitaciones;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String ingresarCategoria(Categoria categoria) {//INSERTAR CATEGORIA
		try {
			categoriaON.insert(categoria);
			return "CATEGORIA INSERTADA";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL INSERTAR CATEGORIA";
		}
	}//INSERTAR CATEGORIA
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarCategoria(int codigo) {//ELIMINAR CATEGORIA
		this.habitaciones = habitacionON.getHabitaciones();
		for(int i = 0; i < this.habitaciones.size(); i++) {
			if(this.habitaciones.get(i).getCategoria().getCodigo() == codigo) {
				return "NO SE PUEDE ELIMINAR LA CATEGORIA PORQUE TIENE HABITACIONES ASIGNADAS";
			}
		}
		
		try {
			categoriaON.delete(codigo);
			return "CATEGORIA ELIMINADA";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR CATEGORIA";
		}
	}//ELIMINAR CATEGORIA
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categoria> getCategorias(){//GET CATEGORIAS
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		categorias = categoriaON.getCategorias();
		return categorias;
	}//GET CATEGORIAS




}
