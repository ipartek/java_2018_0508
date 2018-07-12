package com.ipartek.formacion.model;

import java.util.List;

import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * Interfaz para especificar los métodos de <b>CRUD</b>
 * 
 * <ul>
 * 		<li> Create </li>
 * 		<li> Read 	</li>
 * 		<li> Update </li>
 * 		<li> Delete </li>
 * </ul>
 * @author Curso
 *
 */
public interface CrudAble {

	
	boolean insert(VideoYoutube video);	// Create
	
	List<VideoYoutube> getAll();		// Read
	
	VideoYoutube getById(long id);		// Read
	
	boolean update(VideoYoutube v);		// Update
	
	boolean delete(long id);			// Delete
	
	
}
