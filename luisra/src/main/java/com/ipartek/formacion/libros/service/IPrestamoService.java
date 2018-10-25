package com.ipartek.formacion.libros.service;


import java.sql.Date;
import java.util.List;

import com.ipartek.formacion.libros.pojo.Alumno;
import com.ipartek.formacion.libros.pojo.Libro;
import com.ipartek.formacion.libros.pojo.Prestamo;

public interface IPrestamoService {
	
	boolean devolver(long idAlumno, long idlibro, Date fechaFin);
	
	boolean prestar(long idAlumno, long idlibro, Date fechaInicio);
	
	boolean modificar(long idAlumno, long idlibro, Date fechaInicio, Date fechaFin);
	
	List<Libro> librosDisponibles();
	
	List<Alumno> alumnosDisponibles();
	
	List<Prestamo> historico();

}
