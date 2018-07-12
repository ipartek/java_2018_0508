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
	List<VideoYoutube> getAll(); //Leer todos
	VideoYoutube getById(long id); //Leer por ID
	
	//Upadte
	boolean update(VideoYoutube video);
	
	//Delete
	boolean delete(long id);

}
