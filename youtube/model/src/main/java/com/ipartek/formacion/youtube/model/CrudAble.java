package com.ipartek.formacion.youtube.model;

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
public interface CrudAble<P> {
	
	//Create
	boolean insert(P pojo) throws SQLException, Exception;
	
	//Read
	/**
	 * Recupera todos los objetos del tipo POJO de la BBDD.
	 * @return Si no existen resultados retorna Lista vacia, no null
	 */
	List<P> getAll() throws Exception;
	
	/**
	 * Buscamos un objeto de tipo POJO por su identificador
	 * @param id
	 * @return Objeto de tipo POJO si lo encuentra, null en caso contrario
	 */
	P getById(long id) throws Exception;
	
	//Upadte
	boolean update(P pojo) throws SQLException, Exception;
	
	//Delete
	boolean delete(long id) throws SQLException, Exception;

	

}
