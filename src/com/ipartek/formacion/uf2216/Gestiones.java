package com.ipartek.formacion.uf2216;

import java.util.List;

/**
 * Interfaz que declara los metodos para gestionar revistas
 * <ul>
 * <li>Listar
 * <li>
 * <li>Anadir
 * <li>
 * <li><Buscar por ID
 * <li>
 * 
 * @author Curso
 *
 * @param <P>
 */
public interface Gestiones<P> {

	/**
	 * Metodo que devuelve la lista con todos los pojos
	 * 
	 * @return Lista de pojos
	 */
	List<P> GetAll();

	/**
	 * Metodo para insertar un pojo en la Lista de pojos
	 * 
	 * @param pojo
	 * @return boolean true si el objeto existe, false si el objeto es null
	 */
	boolean insert(P pojo);

}
