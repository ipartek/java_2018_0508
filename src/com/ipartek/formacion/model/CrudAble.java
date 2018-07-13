package com.ipartek.formacion.model;

import java.util.List;

import com.ipartek.formacion.pojo.VideoYoutube;

/**
 * Interfaz para determinar o especificar los medotos de <b>CRUD</b>:
 * 
 * <ul>
 * <li>Create</li>
 * <li>Read</li>
 * <li>Update</li>
 * <li>Delete</li>
 * </ul>
 * 
 * 
 * @author Curso
 *
 */

public interface CrudAble {

	boolean insert(VideoYoutube video);

	List<VideoYoutube> getAll();

	VideoYoutube getByID(long id);

	boolean update(VideoYoutube video);

	boolean delete(long id);

}
