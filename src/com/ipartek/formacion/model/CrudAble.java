package com.ipartek.formacion.model;

import java.util.List;

/**
 * Interfaz para especificar los metodos de <b>CRUD<b>
 * 
 * <ul>
 * <li>Create</li>
 * <li>Read</li>
 * <li>Update</li>
 * <li>Delete</li>
 * </ul>
 * 
 * @author Curso
 *
 */
public interface CrudAble<P> {

	boolean insert(P pojo);

	/**
	 * Recupera todos los VideoYoutube
	 * 
	 * @return si no exiten resultados retorna Lista vacia, no null
	 */
	List<P> getAll();

	/**
	 * Buscamos un VideoYoutube por su identificador
	 * 
	 * @param id long indentificador
	 * @return VideoYoutube si lo encuentra, null si no encuentra
	 */
	P getById(long id);

	boolean update(P pojo);

	boolean delete(long id);
}
