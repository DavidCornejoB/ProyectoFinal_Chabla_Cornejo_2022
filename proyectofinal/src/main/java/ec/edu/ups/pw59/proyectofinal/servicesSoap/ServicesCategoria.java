package ec.edu.ups.pw59.proyectofinal.servicesSoap;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.pw59.proyectofinal.business.CategoriaONLocal;
import ec.edu.ups.pw59.proyectofinal.business.HabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Categoria;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;

@WebService
public class ServicesCategoria {
	
	@Inject
	private CategoriaONLocal categoriaON;
	
	@Inject
	private HabitacionONLocal habitacionON;
	
	@WebMethod
	public String insertarCategoria(Categoria categoria) { //INSERTAR CATEGORIA
		
		Categoria c = new Categoria();
		
		try {
			c = categoriaON.read(categoria.getCodigo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(c == null) {
			try {
				categoriaON.insert(categoria);
				return "CATEGORIA INGRESADA";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "ERROR AL INGRESAR CATEGORIA";
			}
		} else {
			return "LA CATAGORIA YA HA SIDO INGRESADA";
		}
		
	}//INSERTAR CATEGORIA
	
	//************************************************************
	//************************************************************

	@WebMethod
	public String actualizarCategoria(Categoria categoria) { //ACTUALIZAR CATEGORIA
		
		Categoria c = new Categoria();
		
		try {
			c = categoriaON.read(categoria.getCodigo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (c == null) {
			
			return "NO SE HA ENCONTRADO LA CATEGORIA A ACTUALIZAR";
		} else {
			try {
				categoriaON.update(categoria);
				return "CATEGORIA ACTUALIZADA";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "ERROR AL ACTUALIZAR CATEGORIA";
			}
		}
	}//ACTUALIZAR CATEGORIA
	
	//************************************************************
	//************************************************************
	
	@WebMethod
	public Categoria leerCategoria(int codigo) {//LEER CATEGORIA
		
		try {
			return categoriaON.read(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("NO SE HA ENCONTRADO LA CATEGORIA");
			return null;
		}
		
	}//LEER CATEGORIA
	
	//************************************************************
	//************************************************************
	
	@WebMethod
	public String eliminarCategoria(int codigo) {//ELIMINAR CATEGORIA
		
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		habitaciones = habitacionON.getHabitaciones();
		
		for (int i = 0; i < habitaciones.size(); i++) {
			if(habitaciones.get(i).getCategoria().getCodigo() == codigo) {
				
				try {
					habitacionON.delete(habitaciones.get(i).getNumero());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "ERROR AL ELIMINAR HABITACION DE CATEGORIA";
				}
				
			}
		}
		
		try {
			String c = categoriaON.read(codigo).getNombre();
			categoriaON.delete(codigo);
			return "CATEGORIA " + c + " ELIMINADA";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR AL ELIMINAR CATEGORIA";
		}
		
	}//ELIMINAR CATEGORIA
	
	//************************************************************
	//************************************************************
	
	@WebMethod
	public List<Categoria> getCategorias(){//LISTAR CATEGORIAS
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		categorias = categoriaON.getCategorias();
		
		return categorias;
		
	}//LISTAR CATEGORIAS

	
	

}
