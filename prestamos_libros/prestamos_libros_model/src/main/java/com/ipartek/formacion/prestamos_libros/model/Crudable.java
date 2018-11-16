package com.ipartek.formacion.prestamos_libros.model;

import java.util.List;

/**
 * Interfaz para especificar los metodos de <b>CRUD</b>:
 * 
 * <ul>
	 * <li>Create</li>
	 * <li>Read</li>
	 * <li>Update</li>
	 * <li>Delete</li>
 * </ul>
 * 
 * @author Adriana,Andrea
 * 
 */
public interface Crudable<P> {

	/**
	 * Inserta un nuevo registro en nuestro modelo
	 * @param pojo P
	 * @return true si se ha podido insertar, false si ha ocurrido algun fallo
	 * @throws Exception
	 */
	boolean insert(P pojo) throws Exception;

	/**
	 * Recupera todos los pojos
	 * 
	 * @return List<P>. Si no existen resultados retorna Lista vacia
	 */
	List<P> getAll() throws Exception;

	/**
	 * Buscamos un Pojo por su identificador
	 * 
	 * @param id long identificador
	 * @return pojo P si lo encuentra, null si no encuentra
	 */
	P getById(String id) throws Exception;

	/**
	 * Actualiza un registro de nuestro modelo
	 * @param pojo a modificar
	 * @return true si se ha podido modificar, false si ha ocurrido algun fallo
	 * @throws Exception
	 */
	boolean update(P pojo) throws Exception;

	/**
	 * Elimina un registro del modelo
	 * @param id long Identificador
	 * @return true si se ha podido eliminar, false si ha ocurrido algun fallo
	 * @throws Exception
	 */
	boolean delete(String id) throws Exception;

}
