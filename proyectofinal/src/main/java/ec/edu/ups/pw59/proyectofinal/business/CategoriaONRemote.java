package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.pw59.proyectofinal.modelo.Categoria;

//OBJETO DE NEGOCIO DE CATEGORIA QUE SERÁ CONSUMIDO REMOTAMENTE
@Remote
public interface CategoriaONRemote {
	
	public void insert(Categoria c) throws Exception;
	
	public void update(Categoria c) throws Exception;
	
	public void read(int id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Categoria> getCategorias();

}
