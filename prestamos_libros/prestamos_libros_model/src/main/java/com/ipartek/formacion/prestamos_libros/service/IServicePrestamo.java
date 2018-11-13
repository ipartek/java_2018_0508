package com.ipartek.formacion.prestamos_libros.service;

import java.sql.Date;
import java.util.List;

import com.ipartek.formacion.prestamos_libros.pojo.Alumno;
import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;

public interface IServicePrestamo {

	/**
	 * Para poder prestar un Libro a un Alumno, son necesarios los siguientes parametros
	 * @param idLibro long Identificador del Libro
	 * @param idAlumno long Identificador del Alumno
	 * @param fechaInicio java.sql.Date Fecha de inicio del prestamo
	 * @return true si todo ha ido bien, false si no se ha podido prestar
	 * @throws Exception
	 */
//	boolean prestar(long idLibro, long idAlumno, Date fechaInicio) throws Exception;
	boolean prestar(Prestamo p) throws Exception;
	
	/**
	 * Metodo para devolver un libro prestado.
	 * Prestamos por defecto son 15 dias desde el inicio
	 * @param idLibro long Identificador del Libro
	 * @param idAlumno long Identificador del Alumno
	 * @param fechaPrestado java.sql.Date Fecha de inicio del prestamo
	 * @param fechaRetorno java.sql.Date fecha real de devolucion
	 * @return true si se realiza correctamente la modificacion, false si ocurre algun fallo
	 * @throws Exception
	 */
	boolean devolver(long idLibro, long idAlumno, Date fechaPrestado, Date fechaRetorno) throws Exception;
	
	/**
	 * 
	 * @param idLibro long Identificador del Libro
	 * @param idAlumno long Identificador del Alumno
	 * @param fecha_prestado java.sql.Date fecha de inicio del prestamo
	 * @return Pojo Prestamo en caso de que lo encuentre, en caso contrario null
	 * @throws Exception
	 */
	Prestamo buscarPorId(long idLibro, long idAlumno, Date fecha_prestado) throws Exception;
	
	/**
	 *  Devuelve un listado de prestamos realizados y no activos, fechaRetorno != null
	 * @return Lista List<Prestamos>
	 * @throws Exception
	 */
	List<Prestamo> listarHistorico() throws Exception;
	
	/**
	 * Devuelve un listado de prestamos pendientes
	 * @return Lista List<Prestamos>
	 * @throws Exception
	 */
	List<Prestamo> listarPrestados() throws Exception;
	
	/**
	 * Devuelve una lista de los libros que actualmente no estan prestados
	 * @return Lista de libros List<Libro>
	 * @throws Exception
	 */
	List<Libro> librosDisponibles() throws Exception;
	
	/**
	 * Devuelve una lista de alumnos que actualmente no tienen prestamos pendientes/activos
	 * Solo se puede prestar un libro por Alumno simultaneamente
	 * @return Lista de alumnos List<Alumno>
	 * @throws Exception
	 */
	List<Alumno> alumnosDisponibles() throws Exception;

	/**
	 * Funcion que modifica los valores de un prestamo
	 * @param idLibroOld long Identificador del Libro
	 * @param idAlumnoOld long Identificador del Alumno
	 * @param fechaPrestadoOld java.sql.Date Fecha de inicio del prestamo
	 * @param idLibroNew long Identificador del NUEVO Libro 
	 * @param idAlumnoNew long Identificador del  NUEVO Alumno
	 * @param fechaPrestadoNew java.sql.Date Fecha del NUEVO inicio del prestamo 
	 * @param fechaRetorno java.sql.Date fecha real de devolucion
	 * @return true si se ha conseguido modificar el prestamo, false si no
	 * @throws Exception
	 */
	boolean update(long idLibroOld, long idAlumnoOld, Date fechaPrestadoOld, long idLibroNew, long idAlumnoNew, Date fechaPrestadoNew, Date fechaFinal, Date fechaRetorno) throws Exception;
}
