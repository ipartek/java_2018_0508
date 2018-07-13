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
public interface CrudAble {

	boolean insert(VideoYoutube video); // Create

	/**
	 * Recupera todos los VideoYoutube de la lista.
	 * 
	 * @return lista, vacía si no existen resultados.
	 */
	List<VideoYoutube> getAll(); // Read

	/**
	 * Función que devuelve el video con el id pasado por parámetro.
	 * 
	 * @param id, tipo long, que representa el identificador del video
	 * @return v, objeto VideoYoutube Si no encuentra el <b>id</b>, devuelve
	 *         <b>null</b>
	 */
	VideoYoutube getById(long id); // Read

	/**
	 * Función que modifica el video pasado por parámetro.
	 * 
	 * @param video, objeto de clase VideoYoutube, que representa un video
	 * @see VideoYoutube
	 * @return result, boolean Si no encuentra el video, devuelve <b>false</b>
	 */
	boolean update(VideoYoutube v); // Update

	/**
	 * Función que elimina el video con el id pasado por parámetro.
	 * 
	 * @param id, tipo long, que representa el identificador del video
	 * @return result, boolean Si no encuentra el <b>id</b>, devuelve <b>false</b>
	 */
	boolean delete(long id); // Delete

}
