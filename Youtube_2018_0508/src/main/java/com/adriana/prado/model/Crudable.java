package com.adriana.prado.model;

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
 * @author ur00
 * 
 */
public interface Crudable<P> {

	boolean insert(P pojo);

	/**
	 * recupera todos los pojos
	 * 
	 * @return si no existen resultados retorna Lista vacia, no null
	 */
	List<P> getAll();

	/**
	 * Buscamos un Pojo por su identificador
	 * 
	 * @param id long identificador
	 * @return Pojo si lo encuentra, null si no encuentra
	 */
	P getById(String id);

	boolean update(P pojo);

	boolean delete(String id);

}
