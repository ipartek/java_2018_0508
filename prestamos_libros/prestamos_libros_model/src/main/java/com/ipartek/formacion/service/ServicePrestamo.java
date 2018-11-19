package com.ipartek.formacion.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.AlumnoDAO;
import com.ipartek.formacion.model.LibroDAO;
import com.ipartek.formacion.model.PrestamoDAO;
import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.Prestamo;

public class ServicePrestamo implements IServicePrestamo {

	PrestamoDAO daoPrestamo;
	LibroDAO daoLibro;
	AlumnoDAO daoAlumno;

	private static ServicePrestamo INSTANCE = null;

	public static final String EXCEPTION_PARAMETROS_PRESTAMO_INCORRECTO = "Prestamo no existe";
	public static final String EXCEPTION_PARAMETROS_INCORRECTOS = "Necesitamos idLibro, idAlumno y FechaInicio";
	public static final String EXCEPTION_NO_EXISTE_USUARIO_LIBRO = "No podemos prestar si no existe el Alumno o Libro";
	public static final String EXCEPTION_LIBRO_PRESTADO = "Libro ya tiene un prestamos activo";
	public static final String EXCEPTION_ALUMNO_PRESTADO = "Alumno ya tiene un prestamos activo";
	public static final String EXCEPTION_PRESTAMO_NO_EXISTE = "El prestamo no existe.";
	public static final String EXCEPTION_PRESTAMO_DEVUELTO = "El prestamo ya ha sido devuelto.";

	private ServicePrestamo() {
		super();
		daoPrestamo = PrestamoDAO.getInstance();
		daoLibro = LibroDAO.getInstance();
		daoAlumno = AlumnoDAO.getInstance();
	}

	public static synchronized ServicePrestamo getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicePrestamo();
		}
		return INSTANCE;
	}

	@Override
	public ArrayList<Prestamo> prestados() throws Exception {
		ArrayList<Prestamo> Prestamos = new ArrayList<Prestamo>();
		Prestamos = (ArrayList<Prestamo>) daoPrestamo.getByPrestados();
		return Prestamos;
	}

	@Override
	public ArrayList<Prestamo> historico() throws Exception {
		ArrayList<Prestamo> Prestamos = new ArrayList<Prestamo>();
		Prestamos = (ArrayList<Prestamo>) daoPrestamo.getByHistorico();
		return Prestamos;
	}

	@Override
	public ArrayList<Alumno> AlumnosDisponibles() throws Exception {
		ArrayList<Alumno> a = new ArrayList<Alumno>();
		a = (ArrayList<Alumno>) daoPrestamo.getByAlmunosLibres();
		return a;
	}

	@Override
	public ArrayList<Libro> LibrosDisponibles() throws Exception {
		ArrayList<Libro> l = new ArrayList<Libro>();
		l = (ArrayList<Libro>) daoPrestamo.getByLibrosLibres();
		return l;
	}

	@Override
	public boolean modificar(Prestamo p) throws Exception {
		//TODO modificar solo la fecha de un prestamo en activo.
		boolean resul = false;
		long idLibro = -1;
		long idAlumno = -1;
		Date fInicio = null;
		Date fDevuelto = null;

		// comprobar parametros obligatorios correctos
		try {
			idLibro = p.getLibro().getId();
			idAlumno = p.getAlumno().getId();
			fInicio = p.getFecha_inicio();
			fDevuelto = p.getFecha_devuelto();

			if (idLibro < 1 || idAlumno < 1 || fInicio == null) {
				throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);
			}

		} catch (Exception e) {

			throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);

		}

		// comprobar Existe Libro y Usuario
		Libro libro = daoLibro.getById(idLibro);
		Alumno alumno = daoAlumno.getById(idAlumno);

		if (libro == null || alumno == null) {
			throw new Exception(EXCEPTION_NO_EXISTE_USUARIO_LIBRO);
		}

		if(fDevuelto==null) {
			resul = daoPrestamo.modificar(p);
			if (resul) {
				p.setLibro(libro);
				p.setAlumno(alumno);
			}
		}else {
			// comprobar Libro y Usuario no tengan prestamos
			List<Libro> librosDisponibles = daoPrestamo.getByLibrosLibres();
				if (!librosDisponibles.contains(libro)) {
					throw new Exception(EXCEPTION_LIBRO_PRESTADO);
				}
				List<Alumno> alumnosDisponible = daoPrestamo.getByAlmunosLibres();
				if (!alumnosDisponible.contains(alumno)) {
					throw new Exception(EXCEPTION_ALUMNO_PRESTADO);

			}

			resul = daoPrestamo.modificar(p);
			if (resul) {
				p.setLibro(libro);
				p.setAlumno(alumno);
			}
		}
		

		return resul;
	}

	@Override
	public boolean devolver(Prestamo p) throws Exception {

		boolean resul = false;
		long idPrestamo = -1;
		long idLibro = -1;
		long idAlumno = -1;
		Date fInicio = null;
		Date fDevolver = null;

		try {
			idPrestamo=p.getId();
			idLibro = p.getLibro().getId();
			idAlumno = p.getAlumno().getId();
			fInicio = p.getFecha_inicio();
			fDevolver = p.getFecha_devuelto(); 

			if (idLibro < 1 || idAlumno < 1 || fInicio == null||fDevolver==null) {
				throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);
			}

		} catch (Exception e) {

			throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);

		}

		// comprobar Existe Libro y Usuario
		Prestamo prestamo = daoPrestamo.getById(idPrestamo);
		
		if(prestamo==null) {
			throw new Exception(EXCEPTION_PRESTAMO_NO_EXISTE);
		}
		
		Libro libro = daoLibro.getById(idLibro);
		Alumno alumno = daoAlumno.getById(idAlumno);

		if (libro == null || alumno == null) {
			throw new Exception(EXCEPTION_NO_EXISTE_USUARIO_LIBRO);
		}
		
		List<Libro> librosDisponibles = daoPrestamo.getByLibrosLibres();
		List<Alumno> alumnosDisponible = daoPrestamo.getByAlmunosLibres();
		
		if (librosDisponibles.contains(libro) || alumnosDisponible.contains(alumno)) {
			throw new Exception(EXCEPTION_PRESTAMO_DEVUELTO);
		}

		resul = daoPrestamo.devolucion(p);
		if (resul) {
			p.setLibro(libro);
			p.setAlumno(alumno);
		}
		return resul;
	}

	@Override
	public boolean prestar(Prestamo p) throws Exception {
		boolean resul = false;
		long idLibro = -1;
		long idAlumno = -1;
		Date fInicio = null;

		// comprobar parametros obligatorios correctos
		try {
			idLibro = p.getLibro().getId();
			idAlumno = p.getAlumno().getId();
			fInicio = p.getFecha_inicio();

			if (idLibro < 1 || idAlumno < 1 || fInicio == null) {
				throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);
			}

		} catch (Exception e) {

			throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);

		}

		// comprobar Existe Libro y Usuario
		Libro libro = daoLibro.getById(idLibro);
		Alumno alumno = daoAlumno.getById(idAlumno);

		if (libro == null || alumno == null) {
			throw new Exception(EXCEPTION_NO_EXISTE_USUARIO_LIBRO);
		}

		// comprobar Libro y Usuario no tengan prestamos
		List<Libro> librosDisponibles = daoPrestamo.getByLibrosLibres();
		if (!librosDisponibles.contains(libro)) {
			throw new Exception(EXCEPTION_LIBRO_PRESTADO);
		}

		List<Alumno> alumnosDisponible = daoPrestamo.getByAlmunosLibres();
		if (!alumnosDisponible.contains(alumno)) {
			throw new Exception(EXCEPTION_ALUMNO_PRESTADO);
		}

		resul = daoPrestamo.insert(p);
		if (resul) {
			p.setLibro(libro);
			p.setAlumno(alumno);
		}

		return resul;
	}

	@Override
	public Prestamo buscar(long id) throws Exception {
		Prestamo p = null;
		p = daoPrestamo.getById(id);
		return p;
	}

}
