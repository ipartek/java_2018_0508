package com.ipartek.formacion.model;

import java.util.List;

import com.ipartek.formacion.pojo.VideoYoutube;

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
	 * Recupera todos los objetos
	 * <P>
	 * de la lista.
	 * 
	 * @return lista, vacía si no existen resultados.
	 */
	List<P> getAll(); // Read

	/**
	 * Función que devuelve el
	 * <P>
	 * con el id pasado por parámetro.
	 * 
	 * @param id, tipo long, que representa el identificador del video
	 * @return v, objeto VideoYoutube Si no encuentra el <b>id</b>, devuelve
	 *         <b>null</b>
	 */
	P getById(long id); // Read

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
	 * Función que elimina el
	 * <P>
	 * con el id pasado por parámetro.
	 * 
	 * @param id, tipo long, que representa el identificador del video
	 * @return result, boolean Si no encuentra el <b>id</b>, devuelve <b>false</b>
	 */
	boolean delete(long id); // Delete

}
