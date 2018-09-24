package com.ipartek.formacion.supermercado.model.pojo;

import java.util.List;



/**
 * Interfaz para especificar los métodos de <b>CRUD</b>
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

	boolean insert(P pojo); // Create

	/**
	 * Recupera todos los objetos de la lista.
	 * 
	 * @return lista, vacía si no existen resultados.
	 */
	List<P> getAll(); // Read

	/**
	 * Función que devuelve el objeto con el id pasado por par�metro.
	 * 
	 * @param id, tipo long, que representa el identificador del video
	 * @return v, objeto VideoYoutube Si no encuentra el <b>id</b>, devuelve
	 *         <b>null</b>
	 */
	P getById(String id); // Read

	/**
	 * Función que modifica el
	 * <P>
	 * pasado por parámetro.
	 * 
	 * @param video, objeto de clase VideoYoutube, que representa un video
	 * @see VideoYoutube
	 * @return result, boolean Si no encuentra el video, devuelve <b>false</b>
	 */
	boolean update(P pojo); // Update

	/**
	 * Función que elimina el con el id pasado por parámetro.
	 * 
	 * @param id, tipo long, que representa el identificador del video
	 * @return result, boolean Si no encuentra el <b>id</b>, devuelve <b>false</b>
	 */
	boolean delete(String id); // Delete



}
