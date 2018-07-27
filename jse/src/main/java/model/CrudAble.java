package model;

import java.util.List;

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

public interface CrudAble<P> {

	boolean insert(P pojo);
	
	/**
	 * recupera todos los videos de Youtube
	 * @return si no hay resultados devuelve lista vacia
	 */
	List<P> getAll();
	
	/**
	 * Busca video por identificador
	 * @param id long identificador
	 * @return VideoYoutube si lo encuentra sino null
	 */
	P getById(long id);
	
	boolean update(P pojo);
	
	boolean delete(long id);
	
	
}
