package com.ipartek.formacion.gestor.libros.model;

import java.util.List;

/**
 * Interface para especificar los metodos de <b>CRUD</b>:
 * <ul>
 * <li>Create</li>
 * <li>Read</li>
 * <li>Update</li>
 * <li>Delete</li>
 * </ul>
 * 
 * @author andreaPerez
 *
 */
public interface CrudAble<P> {// <P> Necesita ser casteada a un tipo generico

	boolean insert(P pojo);

	/**
	 * recupera todos los P
	 * 
	 * @return si no existen resultados retorna Lista vacia,no null
	 */
	List<P> getALl();

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
