package com.ipartek.formacion.uf2216;

import java.util.List;

/**
 * Interfaz para determinar o especificar los metodos de <b>CRUD</b>:
 * 
 * <ul>
 * 		<li>Create</li>
 * 		<li>Read</li>
 *		<li>Update</li>
 * 		<li>Delete</li>
 * </ul>
 * 
 * @author Curso
 *
 */
public interface CrudAble<P> {

	boolean insert(P pojo);

	/**
	 * recupera todos los P
	 * 
	 * @return si no existen resultados retorna Lista vacia, no null
	 */
	List<P> getAll();

	/**
	 * Buscamos un P por su identificador
	 * 
	 * @param id long identificador
	 * @return P si lo encuentra, null si no encuentra
	 */
	P getById(long id);

	boolean update(P pojo);

	boolean delete(long id);

}
