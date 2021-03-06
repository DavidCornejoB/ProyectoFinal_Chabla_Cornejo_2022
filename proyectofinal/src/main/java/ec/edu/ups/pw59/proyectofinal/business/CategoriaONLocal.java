package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.pw59.proyectofinal.modelo.Categoria;

//OBJETO DE NEGOCIO QUE SERÁ CONSUMIDO LOCALMENTE
@Local
public interface CategoriaONLocal {
	
	public void insert(Categoria c) throws Exception;
	
	public void update(Categoria c) throws Exception;
	
	public Categoria read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Categoria> getCategorias();

}
