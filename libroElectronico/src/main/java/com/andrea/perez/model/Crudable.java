package com.andrea.perez.model;

import java.util.List;

import com.andrea.perez.pojo.Pagina;

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
 * @author andrea Perez
 * 
 */
public interface Crudable<P> {

	boolean insert(P pojo);

	/**
	 * recupera todos los pojos
	 * 
	 * @return si no existen resultados retorna Lista vacia, no null
	 */
	List<Pagina> getAll();

	/**
	 * Buscamos un Pojo por su identificador
	 * 
	 * @param numPag el numero de pagina del libro
	 * @return Pojo si lo encuentra, null si no encuentra
	 */
	P getById(int numPag);

	boolean update(P pojo);

	boolean delete(int numPag);

}
