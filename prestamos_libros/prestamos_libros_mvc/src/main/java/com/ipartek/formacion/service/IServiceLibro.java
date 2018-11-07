package com.ipartek.formacion.service;

import java.util.ArrayList;

import com.ipartek.formacion.pojo.Libro;

public interface IServiceLibro {

	/**
	 * Funcion de listado de una BBDD
	 * @return Retorna vacio si la base esta vacia
	 * @throws Exception
	 */
	ArrayList<Libro> listar() throws Exception;
	
	boolean crear(Libro libro) throws Exception;
	
	boolean modificar(Libro libro) throws Exception;
	
	boolean eliminar(long id) throws Exception;
	
	/**
	 * BUSQUEDA POR ID, NO LA LIES 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Libro buscar(long id) throws Exception;
	
}
