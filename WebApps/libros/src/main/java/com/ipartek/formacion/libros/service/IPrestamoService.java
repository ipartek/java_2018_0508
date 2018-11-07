package com.ipartek.formacion.libros.service;


import java.sql.Date;
import java.util.List;

import com.ipartek.formacion.libros.pojo.Alumno;
import com.ipartek.formacion.libros.pojo.Libro;
import com.ipartek.formacion.libros.pojo.Prestamo;

public interface IPrestamoService {
		
	
	/**
	 * 
	 * @param idAlumno tipo long identificador del alumnos<br>
	 * @param idlibro tipo long identificador del libro<br>
	 * @param fechaRetorno java.sql.date FEcha de devolucion de prestamo<br>
	 * @return true si realiza los prestamos correcto, false en caso contrario<br>
	 * @throws Exception
	 */
	boolean devolver(long idAlumno, long idlibro, Date fechaInicio, Date fechaRetorno) throws Exception;
	
	/**
	 * 
	 * @param idAlumno tipo long identificador del alumnos<br>
	 * @param idlibro tipo long identificador del libro<br>
	 * @param fechaInicio java.sql.date FEcha de inicio de prestamo<br>
	 * @return true si realiza los prestamos correcto, false en caso contrario<br>
	 * @throws Exception
	 */
	boolean prestar(long idAlumno, long idlibro, Date fechaInicio) throws Exception;
	
	boolean modificar(long idAlumno, long idlibro, Date fechaInicio, Date fechaFin) throws Exception;
	
	
	/**
	 * 
	 * @return coleccion de libros que no estan prestados<br>
	 * @throws Exception
	 */
	List<Libro> librosDisponibles() throws Exception;
	
	
	/**
	 * 
	 * @return coleccion de alumnos que no tienen prestamos activos<br>
	 * solo se puede prestar por alumno, hasta que no se devuelva no puede realizar otro prestamos<br>
	 * @throws Exception
	 */
	List<Alumno> alumnosDisponibles() throws Exception;
	
	/**
	 * 
	 * @return Coleccion de prestamos que estan activos = fechaRetorno este a null 
	 * @throws Exception
	 */
	List<Prestamo> prestamosActivos() throws Exception;
	
	/**
	 * 
	 * @return coleccion de prestamos realizados y no activos que la fecha de retorno sea diferente a null
	 * @throws Exception
	 */
	List<Prestamo> historico() throws Exception;

}
