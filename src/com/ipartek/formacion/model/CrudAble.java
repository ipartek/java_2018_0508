package com.ipartek.formacion.model;

import java.util.List;

//pojo (contructor, getters, setters y to String que se llame usuario y que va a tener un id que es un login y un password y email. Los atributos seran private
//Y una clase usuario DAO, que implementa la interfaz CrudAble
/**
 * Interfaz para determinar o especificar los metodos de <b>CRUD<b>:
 * <ul>
 * <li>Create</li>
 * <li>Read</li>
 * <li>Update</li>
 * <li>Delete</li>
 * </lu>
 * 
 * @author Curso
 *
 */

public interface CrudAble<P> {
	
	boolean insert(P pojo);
	
	/**
	 * recupera todos los VideoYoutube
	 * @return si no existen resultados retorna lista vacia, no null
	 */
	
	List<P> getAll();
	
	/**
	 * Buscamos un VideYoutube por su identificador
	 * @param id long identificador
	 * @return VideoYoutube si lo encuentra, null si no lo encuentra
	 */
	
	P getById(long id);
	
	boolean update(P pojo);
	
	boolean delete(long id);

}
