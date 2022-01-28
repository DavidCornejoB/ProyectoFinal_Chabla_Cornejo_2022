package ec.edu.ups.pw59.proyectofinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw59.proyectofinal.dao.CategoriaDAO;
import ec.edu.ups.pw59.proyectofinal.modelo.Categoria;

//OBJETO DE NEGOCIO PRINCIPAL. SE IMPLEMENTAN LOS OBJETOS DE NEGOCIO LOCALES Y REMOTOS
@Stateless
public class CategoriaON implements CategoriaONRemote, CategoriaONLocal{
	
	//LLAMAMOS AL OBJETO DE ACCESO A DATOS DE CATEGORIA
	@Inject
	private CategoriaDAO daoCategoria;
	
	//MÉTODO PARA INSERTAR CATEGORIAS.
	public void insert(Categoria c) throws Exception{
		//LLAMAMOS AL MÉTODO INSERT DEL DAO, Y LE ENVIAMOS EL OBJETO CATEGORIA PARA SER INGRESADO
		daoCategoria.insert(c);
	}
	
	//MÉTODO PARA ACTUALIZAR CATEGORIAS
	public void update(Categoria c) throws Exception{
		//LLAMAMOS AL MÉTODO UPDATE DEL DAO, Y LE ENVIAMOS EL OBJETO CATEGORIA QUE SERÁ ACTUALIZADO
		daoCategoria.update(c);
	}
	
	//METODO PARA LEER CATEGORIAS
	public void read(String id) throws Exception{
		//LLAMAMOS LA MÉTODO READ DEL DAO, Y LE ENVIAMOS LA ID DEL OBJETO CATEGORÍA QUE QUEREMOS LEER
		daoCategoria.read(id);
	}
	
	//MÉTODO PARA ELIMINAR CATEGORÍAS
	public void delete(int id) throws Exception{
		//LLAMAMOS AL MÉTODO DELETE DEL DAO, LE ENVIAMOS LA ID DEL OBJETO CATEGORÍA QUE QUEREMOS ELIMINAR
		daoCategoria.delete(id);
	}
	
	//MÉTODO PARA LISTAR CATEGORÍAS. SE HACE USO DE UNA LISTA QUE ALMACENE TODAS LAS CATEGORIAS CREADAS
	public List<Categoria> getCategorias(){
		return daoCategoria.getList();
	}
}
