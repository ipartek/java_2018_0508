package com.ipartek.formacion.prestamos_libros.service;

import java.sql.Date;
import java.util.List;

import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;
import com.ipartek.formacion.prestamos_libros.pojo.Usuario;

public interface IServicePrestamo {
	/**
	 * para porder prestar un Libro a un Alumno, es necesarui kis siguientes campos
	 * rellenos del
	 * <ol>
	 * <li>indentificador del libro
	 * <li>Identificador del Alumno
	 * <li>Fecha Inicio del Prestamo
	 * 
	 * @param p Prestamo
	 * @return true si realiza el prestamo correcto, false en caso contrario
	 **/
	boolean crear(Prestamo p) throws Exception;

	// boolean prestar(long idLibro, long IdAlumno, DATE fechaInicio ) throws
	// Exception
	// boolean devolver(long idLibro, long IdAlumno, DATE fechaRetorno ) throws
	// Exception

	boolean modificar(Prestamo p) throws Exception;

	boolean modificarPrestamo(Prestamo p, Prestamo prestamoAntiguo) throws Exception;
	
	boolean modificarHistorico(Prestamo p, Prestamo prestamoAntiguo) throws Exception;

	List<Prestamo> listar() throws Exception;

	List<Prestamo> listardevueltos() throws Exception;

	List<Usuario> listarUsuariosDisponibles() throws Exception;

	List<Libro> listarLibrosDisponibles() throws Exception;
	
	Prestamo getByIds(String idLibro, String idUsuario, String fInicio) throws Exception;

	Prestamo historicoGetByIds(String idLibro, String idUsuario, String fInicio) throws Exception;
}
