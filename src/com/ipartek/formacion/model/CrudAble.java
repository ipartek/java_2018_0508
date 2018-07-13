package com.ipartek.formacion.model;

import java.util.*;

import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * INterfaz para especificar los metodos de <b>crud</b>
 * 
 * <ul>
 * 		<li>Create</li> 
 * 		<li>Read</li>
 *		<li>Update</li>
 *		<li>Delete</li>
 * </ul>
 * @author Curso
 *
 */

public interface CrudAble {

	boolean insert(VideoYoutube video);
	
	/**
	 * recupera todos los videos de Youtube
	 * @return si no hay resultados devuelve lista vacia
	 */
	List<VideoYoutube> getAll();
	
	/**
	 * Busca video por identificador
	 * @param id long identificador
	 * @return VideoYoutube si lo encuentra sino null
	 */
	VideoYoutube getById(long id);
	
	boolean update(VideoYoutube video);
	
	boolean delete(long id);
	
	
}
