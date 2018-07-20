package com.ipartek.formacion.uf2216;

import java.util.List;

/**
 * Interfaz para especficar los métodos de <b>Crud</b>:
 *
 * <ul>
 *     <li>Create</li>
 *     <li>Read</li>
 *     <li>Update</li>
 *     <li>Delete</li>
 * </ul>
 * @author Adrian Garcia
 *
 */
public interface CrudAbleRevista<P> {
	
	boolean insert(P revista);
	
	/**
	 * Recupera todas las revistas
	 * @return si no existen resultados retorna lista vacía, no null
	 */
	List<P> getAll();
	
	/**
	 * Buscamos una revista por su identificador
	 * @param id long identificador
	 * @return P pojo si lo encuentra, null si no lo encuentra
	 */
	Revista getById(long id);
	
	boolean update(P revista);
	
	boolean delete(long id);	
	
}
