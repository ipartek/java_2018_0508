package com.ipartek.formacion.prestamolibros.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.prestamolibros.model.AlumnoDAO;
import com.ipartek.formacion.prestamolibros.model.LibroDAO;
import com.ipartek.formacion.prestamolibros.model.PrestamoDAO;
import com.ipartek.formacion.prestamolibros.pojo.Alumno;
import com.ipartek.formacion.prestamolibros.pojo.Libro;
import com.ipartek.formacion.prestamolibros.pojo.Prestamo;

public class ServicioPrestamo implements IServicePrestamo{
	
private static ServicioPrestamo INSTANCE = null;

public static final String EXCEPTION_PARAMETROS_INCORRECTOS = "Necesitamos idLibro, idAlumno y FechaInicio";
public static final String EXCEPTION_NO_EXISTE_USUARIO_LIBRO = "No podemos prestar si no existe el Usuario o Libro";
public static final String EXCEPTION_LIBRO_PRESTADO = "Libro ya tiene un prestamos activo";
public static final String EXCEPTION_ALUMNO_PRESTADO = "Alumno ya tiene un prestamos activo";

	
	private PrestamoDAO daoPrestamo;
	private AlumnoDAO daoAlumno;
	private LibroDAO daoLibro;
	
	private ServicioPrestamo() {
		super();
		daoPrestamo = PrestamoDAO.getInstance();
		daoAlumno = AlumnoDAO.getInstance();
		daoLibro = LibroDAO.getInstance();
	}

	public static synchronized ServicioPrestamo getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicioPrestamo();
		}
		return INSTANCE;
	}

	@Override
	public boolean prestar(long idLibro, long idAlumno, Date fechaInicio) throws Exception {
		
		boolean resul = false;
		
		comprobarAlumnoLibro(idLibro, idAlumno, fechaInicio);
		
		resul = daoPrestamo.prestar(idLibro, idAlumno, fechaInicio);
		
		return resul;
		
	}

	@Override
	public boolean devolver(long idAlumno, long idLibro, Date fechaInicio, Date fechaDevolucion) throws Exception {
		
		return daoPrestamo.devolver(idLibro, idAlumno, fechaInicio, fechaDevolucion);
	}

	@Override
	public List<Prestamo> prestados() throws Exception {
		
		return daoPrestamo.getPrestados();
	}

	@Override
	public List<Prestamo> historico() throws Exception{
		
		return daoPrestamo.getHistorico();
	}

	@Override
	public List<Libro> librosDisponibles() throws Exception {
		return daoPrestamo.getLibrosDisponibles();
	}

	@Override
	public List<Alumno> alumnosDisponibles() throws Exception {
		return daoPrestamo.getAlumnosDisponibles();
	}

	@Override
	public boolean modificarPrestamo(long idLibro, long idAlumno, Date fechaInicio, Date fechaFin, long oldIdLibro, long oldIdAlumno,
			Date oldFechaInicio) throws Exception {
		
		return daoPrestamo.modificarPrestamo(idLibro, idAlumno, fechaInicio, fechaFin, oldIdLibro, oldIdAlumno, oldFechaInicio);
	}

	@Override
	public boolean modificarHistorico(long idLibro, long idAlumno, Date fechaInicio, Date fechaFin, Date fechaDevolucion, long oldIdLibro,
			 long oldIdAlumno, Date oldFechaInicio) throws Exception {
		
		return daoPrestamo.modificarHistorico(idLibro, idAlumno, fechaInicio, fechaFin, fechaDevolucion, oldIdLibro, oldIdAlumno, oldFechaInicio);
	}
	
	private void comprobarAlumnoLibro(long idLibro, long idAlumno, Date fechaInicio) throws Exception{
		ArrayList<Libro> librosDisponibles = (ArrayList<Libro>) daoPrestamo.getLibrosDisponibles();
		ArrayList<Alumno> alumnosDisponibles = (ArrayList<Alumno>) daoPrestamo.getAlumnosDisponibles();
		Libro libro = daoLibro.getById(idLibro);
		Alumno alumno = daoAlumno.getById(idAlumno);
		
		if( idLibro < 1 || idAlumno < 1 || fechaInicio == null ) {
			throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);
		}
		
		if ( libro == null || alumno == null ) {
			throw new Exception(EXCEPTION_NO_EXISTE_USUARIO_LIBRO);
		}
		
		if ( !librosDisponibles.contains(libro) ) {
			throw new Exception(EXCEPTION_LIBRO_PRESTADO);
		}
		
		if ( !alumnosDisponibles.contains(alumno) ) {
			throw new Exception(EXCEPTION_ALUMNO_PRESTADO);
		}
	}

}
