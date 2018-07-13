package com.ipartek.formacion.model;

import java.util.List;

import com.ipartek.formacion.pojo.videoYoutube;

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
public interface CrudAble {
	
	//insertar
	boolean insert(videoYoutube video) ;
	/**
	 * recupera todos los VideoYoutube
	 * 
	 * @return si no existen resultados retorna lista vacia , no null
	 */
	//leer
	List<videoYoutube> getAll();
	//leer
	videoYoutube getById(long id);
	/**
	 * Buscamos un videoyoutube por su identifacodr el long id 
	 * @param video
	 * @return video si lo encuentra, null si no lo encuentra
	 */
	
	//update
	
	boolean update(videoYoutube video);
	/**
	 * Le pasamos un video y lo modifica
	 * @param id
	 * @return obligatorio
	 */
	boolean delete(long id);

}
