package com.ipartek.formacion.service;

import java.util.ArrayList;

import com.ipartek.formacion.pojo.Editorial;

public interface IServiceEditorial {

	/**
	 * Funcion de listado de una BBDD
	 * @return Retorna vacio si la base esta vacia
	 * @throws Exception
	 */
	ArrayList<Editorial> listar() throws Exception;
	
	boolean crear(Editorial editorial) throws Exception;
	
	boolean modificar(Editorial editorial) throws Exception;
	
	boolean eliminar(long id) throws Exception;
	
	/**
	 * BUSQUEDA POR ID, NO LA LIES 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Editorial buscar(long id) throws Exception;
	
}
