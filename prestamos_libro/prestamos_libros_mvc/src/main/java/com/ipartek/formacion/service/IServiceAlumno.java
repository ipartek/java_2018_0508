package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Alumno;

public interface IServiceAlumno {
	
	/**
	 * Funcion que crear un nuevo alumno
	 * @param Alumno a
	 * @return true si se crea correctamente el Alumno, false si no se ha conseguido crear
	 * @throws Exception
	 */
	boolean crear(Alumno a) throws Exception;
	
	/**
	 * Funcion para modificar los datos de un alumno
	 * @param Alumno a
	 * @return true si se modifica correctamente el Alumno, false si no se ha podido modificar
	 * @throws Exception
	 */
	boolean modificar(Alumno a) throws Exception;
	
	/**
	 * Funcion para eliminar un alumno existente
	 * @param id long Id del alumno a eliminar
	 * @return true si se elimina correctamente el Alumno, false si no se ha podido eliminar
	 * @throws Exception
	 */
	boolean eliminar(long id) throws Exception;
	
	/**
	 * Funcion que retorna un objeto Alumno si se encuentra
	 * @param id long Id del alumno a eliminar
	 * @return Alumno a
	 * @throws Exception
	 */
	Alumno buscarPorId(long id) throws Exception;
	
	/**
	 * Funcion que devuelve todos los Alumnos que hay
	 * @return List<Alumno>
	 * @throws Exception
	 */
	List<Alumno> listar() throws Exception;
}
