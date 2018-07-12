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
	//leer
	List<videoYoutube> getAll();
	//leer
	videoYoutube getById(long id);
	
	//update
	
	boolean update(videoYoutube video);
	
	boolean delete(long id);

}
