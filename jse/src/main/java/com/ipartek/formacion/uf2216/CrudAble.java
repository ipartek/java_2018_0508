package com.ipartek.formacion.uf2216;

import java.util.List;

/**
 * Interfaz para especificar los metodos de <b>CRUD</b>:
 * 
 * <ul>
 * <li>Create</li>
 * <li>Read</li>
 * <li>Update</li>
 * <li>Delete</li>
 * </ul>
 * 
 * @author Asier Cornejo
 *
 *
 */
public interface CrudAble<P> {

	boolean insert(P pojo);

	/**
	 * Recupera todos los pojos
	 * 
	 * @return si no existen retorna Lista vacia, no null
	 */
	List<P> getAll();

	/**
	 * Buscamos un P por su identificador
	 * 
	 * @param id long identificador
	 * @return si lo encuentra, null si no lo encuentra
	 */

	P getById(long id);

	boolean update(P pojo);

	boolean delete(long id);

	boolean deleteAll(List<P> list);
}
