package com.ipartek.formacion.model;

import java.util.List;

/**
 * 
 * @author Curso Interfaz para especificar los metodos de <b>CRUD<b>:
 *         <ol>
 *         <li>Create</li>
 *         <li>Read</li>
 *         <li>Update</li>
 *         <li>Delete</li>
 *         </ol>
 */
public interface CrudAble<P> {
	
	//insertar
	boolean insert(P pojo) ;
	/**
	 * recupera todos los VideoYoutube
	 * 
	 * @return si no existen resultados retorna lista vacia , no null
	 */
	//leer
	List<P> getAll();
	//leer
	P getById(long id);
	/**
	 * Buscamos un P por su identifacodr el long id 
	 * @param video
	 * @return video si lo encuentra, null si no lo encuentra
	 */
	
	//update
	
	boolean update(P pojo);
	/**
	 * Le pasamos un video y lo modifica
	 * @param id
	 * @return obligatorio
	 */
	boolean delete(long id);

}
