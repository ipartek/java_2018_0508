package com.ipartek.formacion.model;

import java.util.List;
import com.ipartek.formacion.pojo.VideoYoutube;

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
public interface CrudAble {
	
	//Create
	boolean insert(VideoYoutube video);
	
	//Read
	/**
	 * Recupera todos los VideoYoutube
	 * @return si no existe resultados retorna Lista vacia, no null
	 */
	List<VideoYoutube> getAll();
	
	/**
	 * Buscamos un VideoYoutube por su identificador
	 * @param id
	 * @return VideoYoutube si lo encuentra, null si no lo encuentra
	 */
	VideoYoutube getById(long id);
	
	//Upadte
	boolean update(VideoYoutube video);
	
	//Delete
	boolean delete(long id);

}
