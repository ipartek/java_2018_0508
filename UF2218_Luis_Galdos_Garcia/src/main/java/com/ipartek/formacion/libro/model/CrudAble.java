package com.ipartek.formacion.libro.model;

import java.util.List;

import com.ipartek.formacion.libro.pojo.Pagina;

/**
 * Interfaz para especificar los metodos de <b>CRUD</b>:
 * <ul>
 * <li>Create</li>
 * <li>Read</li>
 * <li>Update</li>
 * <li>Delete</li>
 * </ul>
 * @author Curso
 *
 */
public interface CrudAble<P> {
	
	//Create
	boolean insert(P pojo);
	
	//Read
	/**
	 * Recupera todos los pojo
	 * @return si no existe resultados retorna Lista vacia, no null
	 */
	List<P> getAll();
	
	/**
	 * Buscamos un pojo por su identificador
	 * @param id
	 * @return VideoYoutube si lo encuentra, null si no lo encuentra
	 */
	P getById(long id);
	
	//Upadte
	boolean update(P pojo);
	
	//Delete
	boolean delete(String id);


}
