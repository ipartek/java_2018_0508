package com.ipartek.formacion.service;

import java.util.ArrayList;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.Prestamo;

public interface IServicePrestamo {


	/**
	 * Para poder prestar un libro a un alumno, es necesario los siguientes campos rellenos de prestamo:
	 * @param idLibro es el identificador del libro
	 * @param idAlumno es el identificador del alumno
	 * @param fecha_inicio es la fecha inicial de prestamo
	 * @return
	 * @throws Exception
	 */
	boolean prestar(Prestamo p) throws Exception;
	
	/**
	 * Para poder devolver  un libro a un alumno, es necesario los siguientes campos rellenos de prestamo:
	 * <ol>
	 * <li>el identificador del prestamo</li>
	 * <li>la fecha devolucion de prestamo</li>
	 * </ol>
	 * @param p
	 * @return
	 * @throws Exception
	 */
	
	boolean devolver(Prestamo p) throws Exception;
	
	/**
	 * Para poder devolver  un libro a un alumno, es necesario los siguientes campos rellenos de prestamo:
	 * <ol>
	 * <li>el identificador del libro</li>
	 * <li>el identificador del alumno</li>
	 * <li>la fecha inicial de prestamo</li>
	 * <li>la fecha final de prestamo</li>
	 * <li>la fecha devolucion de prestamo</li>
	 * </ol>
	 * @param p
	 * @return
	 * @throws Exception
	 */
	
	boolean modificar(Prestamo p) throws Exception;
	
	/**
	 * Coleccion de prestamos no devueltos
	 * @return
	 * @throws Exception
	 */

	ArrayList<Prestamo> prestados()throws Exception;
	
	/**
	 * Coleccion de prestamos ya devueltos
	 * @return
	 * @throws Exception
	 */
	ArrayList<Prestamo> historico()throws Exception;
	
	
	/**
	 * Coleccion de libros disponibles para prestar
	 * @return
	 * @throws Exception
	 */
	ArrayList<Alumno> AlumnosDisponibles() throws Exception;
	
	/**
	 * Coleccion de alumnos sin ningun libro prestado.
	 * Solo se puede prestar un libro y hasta que no lo devuelva no podra coger otro libro.
	 * @return
	 * @throws Exception
	 */
	
	ArrayList<Libro> LibrosDisponibles() throws Exception;
	
	/**
	 * BUSQUEDA POR ID
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Prestamo buscar(long id) throws Exception;
	
}

