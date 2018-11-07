package com.ipartek.formacion.libros.service;

import java.sql.Date;
import java.util.List;

import com.ipartek.formacion.libros.pojo.Alumno;
import com.ipartek.formacion.libros.pojo.Libro;
import com.ipartek.formacion.libros.pojo.Prestamo;

public class ServicePrestamo implements IPrestamoService {

	@Override
	public boolean devolver(long idAlumno, long idlibro, Date fechaFin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean prestar(long idAlumno, long idlibro, Date fechaInicio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(long idAlumno, long idlibro, Date fechaInicio, Date fechaFin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Libro> librosDisponibles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> alumnosDisponibles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prestamo> historico() {
		// TODO Auto-generated method stub
		return null;
	}

}