package com.ipartek.formacion.model;

import java.util.List;

/**
 * Interfaz para determinar o especificar los metodos de <b>CRUD</b>:
 * 
 * <ul>
 * <li>Create</li>
 * <li>Read</li>
 * <li>Update</li>
 * <li>Delete</li>
 * </ul>
 * 
 * 
 * @author Curso
 *
 */

public interface CrudAble<P> {

	boolean insert(P pojo);

	/**
	 * Recupera todos los pojo
	 * 
	 * @return si no existe resultado retorna lista vacia, no null
	 */

	List<P> getAll();// conseguir todos los videos

	/**
	 * Buscamos un VideoYoutube por su identificador
	 * 
	 * @param id long identificador
	 * @return VideoYoutube si lo encuentra, null si no encuentra
	 */
	
	P getById(long id);

	boolean update(P pojo);

	boolean delete(long id);

}
