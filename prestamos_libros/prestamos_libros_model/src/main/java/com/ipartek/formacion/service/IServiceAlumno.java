package com.ipartek.formacion.service;

import java.util.ArrayList;

import com.ipartek.formacion.pojo.Alumno;

public interface IServiceAlumno {

	/**
	 * Funcion de listado de una BBDD
	 * @return Retorna vacio si la base esta vacia
	 * @throws Exception
	 */
	ArrayList<Alumno> listar() throws Exception;
	
	boolean crear(Alumno a) throws Exception;
	
	boolean modificar(Alumno a) throws Exception;
	
	boolean eliminar(long id) throws Exception;
	
	/**
	 * BUSQUEDA POR ID, NO LA LIES 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Alumno buscar(long id) throws Exception;
	
}
