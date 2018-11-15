package com.ipartek.formacion.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.PrestamoDAO;
import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.Prestamo;

public class ServicePrestamo implements IServicePrestamo {

	private static ServicePrestamo INSTANCE = null;
	private static PrestamoDAO daoPrestamo = PrestamoDAO.getInstance();
	private static final String EXCEPCION_NO_VALIDOS="Necesitamos el id del libro, id alumno y la fecha prestamo";
	private static final String EXCEPCION_NO_EXISTE="Alumno o libro no existen";
	private static final String EXCEPCION_EXISTE="Alumno o libro ya tiene un prestamo pendiente";
	
	

	private ServicePrestamo() {
		super();
	}

	public static synchronized ServicePrestamo getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicePrestamo();
		}
		return INSTANCE;
	}

	@Override
	public List<Prestamo> listarHistorico() throws Exception {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		prestamos = (ArrayList<Prestamo>) daoPrestamo.getHistorico();
		return prestamos;
	}

	@Override
	public List<Prestamo> listarPrestados() throws Exception {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		prestamos = (ArrayList<Prestamo>) daoPrestamo.getAllPrestados();
		return prestamos;
	}

	
	/*
	 * Funcion para prestar un libro.
	 * @param Prestamo p 
	 * necesitamos:
	 * 		 p.getAlumno().getId() para poder comprobar si el alumno existe en la bbdd y no tenga prestamo asociado
	 * 		 p.getLibro().getId()  para poder comprobar si el libro existe en la bbdd y no tenga prestamo asociado.
	 * 
	 * */
	@Override
	public boolean prestar(Prestamo p) throws Exception {
		
		boolean resul = false;
		boolean alumnoLibre = false;
		boolean libroLibre = false;

				
			// Comprobar que el alumno y el libro esten disponibles
			ArrayList<Alumno> alumnosDisponibles = (ArrayList<Alumno>) this.alumnosDisponibles();
			for (Alumno alumno : alumnosDisponibles) {

				if (alumno.getId() == p.getAlumno().getId()) {
					alumnoLibre = true;
					break;
				}
			}
			
			ArrayList<Libro> libroDisponibles = (ArrayList<Libro>) this.librosDisponibles();
			for (Libro libro : libroDisponibles) {

				if (libro.getId() == p.getLibro().getId()) {
					libroLibre = true;
					break;
				}
			}
			
			if (alumnoLibre && libroLibre) {
				if (daoPrestamo.insert(p)) {
					
					resul = true;
				}
			}
				
		return resul;
	}

	@Override
	public List<Libro> librosDisponibles() throws Exception {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		libros = (ArrayList<Libro>) daoPrestamo.librosDisponibles();
		return libros;
	}

	@Override
	public List<Alumno> alumnosDisponibles() throws Exception {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos = (ArrayList<Alumno>) daoPrestamo.alumnosDisponibles();
		return alumnos;
	}

	@Override
	public Prestamo buscarPorId(Prestamo pojo) throws Exception {
		Prestamo p = null;
		p = daoPrestamo.buscarPorId(pojo);
		return p;
	}

	@Override
	public boolean devolver(long idLibro, long idAlumno, Date fechaPrestado, Date fechaRetorno) throws Exception {
		boolean resul = false;
		Prestamo p = new Prestamo();

		Alumno a = new Alumno();
		a.setId(idAlumno);
		p.setAlumno(a);

		Libro l = new Libro();
		l.setId(idLibro);

		p.setLibro(l);

		p.setFecha_prestado(fechaPrestado);
		p.setFecha_retorno(fechaRetorno);

		if (daoPrestamo.update(p)) {
			resul = true;
		}
		return resul;
	}

	@Override
	public boolean update(long idLibroOld, long idAlumnoOld, Date fechaPrestadoOld, long idLibroNew, long idAlumnoNew,
			Date fechaPrestadoNew, Date fechaFinal, Date fechaRetorno) throws Exception {
		boolean resul = false;

		if (daoPrestamo.modifyAll(idAlumnoOld, idLibroOld, fechaPrestadoOld, idAlumnoNew, idLibroNew, fechaPrestadoNew,
				fechaFinal, fechaRetorno)) {
			resul = true;
		}
		return resul;
	}

}
