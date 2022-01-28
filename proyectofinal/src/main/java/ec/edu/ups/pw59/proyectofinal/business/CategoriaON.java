package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.CategoriaDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Categoria;

@Stateless
public class CategoriaON implements CategoriaONRemote, CategoriaONLocal{
	
	@Inject
	private CategoriaDAO daoCategoria;
	
	public void insert(Categoria c) throws Exception{
		daoCategoria.insert(c);
	}
	
	public void update(Categoria c) throws Exception{
		daoCategoria.update(c);
	}
	
	public void read(String id) throws Exception{
		daoCategoria.read(id);
	}
	
	public void delete(int id) throws Exception{
		daoCategoria.delete(id);
	}
	
	public List<Categoria> getCategorias(){
		return daoCategoria.getList();
	}
}
