package com.ipartek.formacion.gestor.libros.model;

import java.util.List;
/**
 * Interfaz paraespecificar los metodos de <b>CRUD</b>:
 * <ul>
 * <li>Create</li>
 * <li>Read</li>
 * <li>Update</li>
 * <li>Delete</li>
 * </ul>
 * 
 * @author Guillermo
 *
 */
public interface CrudAble<P>{

	boolean insert(P pojo);

	/**
	 * Recupera todos los pojos
	 * 
	 * @return si no existen resultados retorna Lista vacia, no null
	 */
	List<P> getAll();

	/**
	 * Buscamos un pojo por su identidicador
	 * 
	 * @param id long identificador
	 * @return VideoYoutube si lo encuentra, null si no encuentra
	 */
	P getById(long id);
	
	boolean update(P pojo);

	boolean delete(long id);

}
