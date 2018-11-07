package com.ipartek.formacion.prestamos_libros.model;

import java.sql.SQLException;
import java.util.List;

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
public interface CrudAble<P>{
	
	//Create
	boolean insert(P pojo) throws Exception;
	
	//Read
	/**
	 * Recupera todos los pojo
	 * @return si no existe resultados retorna Lista vacia, no null
	 */
	List<P> getAll() throws Exception;
	
	/**
	 * Buscamos un pojo por su identificador
	 * @param id
	 * @return VideoYoutube si lo encuentra, null si no lo encuentra
	 */
	P getById(String id) throws Exception;
	
	//Upadte
	boolean update(P pojo) throws Exception;
	
	//Delete
	boolean delete(String id) throws Exception;

}