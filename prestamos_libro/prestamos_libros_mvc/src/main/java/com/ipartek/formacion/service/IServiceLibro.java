package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Libro;

public interface IServiceLibro {
	
	/**
	 * Funcion que crear un nuevo libro
	 * @param Libro l
	 * @return true si se crea correctamente el Libro, false si no se ha conseguido crear
	 * @throws Exception
	 */
	boolean crear(Libro l) throws Exception;

	/**
	 * Funcion para modificar los datos de un Libro
	 * @param Libro l
	 * @return true si se modifica correctamente el Libro, false si no se ha conseguido modificar
	 * @throws Exception
	 */
	boolean modificar(Libro l) throws Exception;

	/**
	 * Funcion para eliminar un libro existente
	 * @param id long identificador del Libro
	 * @return true si se elimina correctamente el Libro, false si no se ha conseguido eliminar
	 * @throws Exception
	 */
	boolean eliminar(long id) throws Exception;

	/**
	 * Funcion que retorna un objeto Libro si se encuentra
	 * @param id long identificador del libro
	 * @return Libro l
	 * @throws Exception
	 */
	Libro buscarPorId(long id) throws Exception;

	/**
	 * Funcion que devuelve todos los Libros que hay
	 * @return List<Libro>
	 * @throws Exception
	 */
	List<Libro> listar() throws Exception;

}
