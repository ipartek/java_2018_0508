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

public static final String EXCEPTION_PARAMETROS_INCORRECTOS_PRESTAMO = "Necesitamos idLibro, idAlumno y FechaInicio";
public static final String EXCEPTION_PARAMETROS_INCORRECTOS_DEVOLUCION = "Necesitamos que idLibro, idAlumno, FechaInicio y 'devuelto' sean correctos";
public static final String EXCEPTION_NO_EXISTE_ALUMNO_LIBRO = "No podemos prestar si no existe el Alumno o Libro";
public static final String EXCEPTION_LIBRO_PRESTADO = "Libro ya tiene un prestamos activo";
public static final String EXCEPTION_ALUMNO_PRESTADO = "Alumno ya tiene un prestamos activo";
public static final String EXCEPTION_LIBRO_SIN_PRESTAMO = "El libro indicado no está prestado actualmente, por lo que no puede devolverlo";
public static final String EXCEPTION_ALUMNO_SIN_PRESTAMO = "El alumno indicado no tiene un préstamo actualmente.";

	
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
		
		if(comprobarDatosPrestamo(idLibro, idAlumno, fechaInicio)) {
			resul = daoPrestamo.prestar(idLibro, idAlumno, fechaInicio);
		}
		
		return resul;
		
	}

	@Override
	public boolean devolver(long idAlumno, long idLibro, Date fechaInicio, Date fechaDevolucion) throws Exception {
		
		boolean resul = false;
		
		if(comprobarDatosDevolucion(idLibro, idAlumno, fechaInicio, fechaDevolucion)) {
			resul = daoPrestamo.devolver(idLibro, idAlumno, fechaInicio, fechaDevolucion);
		}
		
		return resul;
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
		
		boolean resul = false;
		
		if(comprobarDatosModificacion(idLibro, idAlumno, fechaInicio, oldIdLibro, oldIdAlumno, oldFechaInicio)) {
			resul = daoPrestamo.modificarPrestamo(idLibro, idAlumno, fechaInicio, fechaFin, oldIdLibro, oldIdAlumno, oldFechaInicio);
		}
		
		return resul;
	}

	@Override
	public boolean modificarHistorico(long idLibro, long idAlumno, Date fechaInicio, Date fechaFin, Date fechaDevolucion, long oldIdLibro,
			 long oldIdAlumno, Date oldFechaInicio) throws Exception {
		
		return daoPrestamo.modificarHistorico(idLibro, idAlumno, fechaInicio, fechaFin, fechaDevolucion, oldIdLibro, oldIdAlumno, oldFechaInicio);
	}
	
	private boolean comprobarDatosPrestamo(long idLibro, long idAlumno, Date fechaInicio) throws Exception {
		boolean result = false;
		ArrayList<Libro> librosDisponibles = (ArrayList<Libro>) daoPrestamo.getLibrosDisponibles();
		ArrayList<Alumno> alumnosDisponibles = (ArrayList<Alumno>) daoPrestamo.getAlumnosDisponibles();
		Alumno alumno = daoAlumno.getById(idAlumno);
		Libro libro = daoLibro.getById(idLibro);

		if (idLibro < 1 || idAlumno < 1 || fechaInicio == null) {
			throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS_PRESTAMO);
			
		}

		if (libro == null || alumno == null) {
			throw new Exception(EXCEPTION_NO_EXISTE_ALUMNO_LIBRO);
		}

		if (!librosDisponibles.contains(libro)) {
			throw new Exception(EXCEPTION_LIBRO_PRESTADO);
		}

		if (!alumnosDisponibles.contains(alumno)) {
			throw new Exception(EXCEPTION_ALUMNO_PRESTADO);
		}
		result=true;

		return result;

	}

	
	
	private boolean comprobarDatosDevolucion(long idLibro, long idAlumno, Date fechaInicio, Date fechaDevolucion) throws Exception {
		boolean result = false;
		ArrayList<Libro> librosDisponibles = (ArrayList<Libro>) daoPrestamo.getLibrosDisponibles();
		ArrayList<Alumno> alumnosDisponibles = (ArrayList<Alumno>) daoPrestamo.getAlumnosDisponibles();
		Alumno alumno = daoAlumno.getById(idAlumno);
		Libro libro = daoLibro.getById(idLibro);

		if (idLibro < 1 || idAlumno < 1 || fechaInicio == null || fechaDevolucion == null) {
			throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS_DEVOLUCION);
			
		}

		if (libro.getId() == -1 || alumno.getId() == -1) {
			throw new Exception(EXCEPTION_NO_EXISTE_ALUMNO_LIBRO);
		}

		if (librosDisponibles.contains(libro)) {
			throw new Exception(EXCEPTION_LIBRO_SIN_PRESTAMO);
		}

		if (alumnosDisponibles.contains(alumno)) {
			throw new Exception(EXCEPTION_ALUMNO_SIN_PRESTAMO);
		}
		result=true;

		return result;

	}

	private boolean comprobarDatosModificacion(long idLibro, long idAlumno, Date fechaInicio, long oldIdLibro, long oldIdAlumno, Date oldFechaInicio) throws Exception {
		boolean result = false;
		ArrayList<Libro> librosDisponibles = (ArrayList<Libro>) daoPrestamo.getLibrosDisponibles();
		ArrayList<Alumno> alumnosDisponibles = (ArrayList<Alumno>) daoPrestamo.getAlumnosDisponibles();
		Alumno alumno = daoAlumno.getById(oldIdAlumno);
		Libro libro = daoLibro.getById(oldIdLibro);
		Alumno alumnoNuevo = daoAlumno.getById(idAlumno);
		Libro libroNuevo = daoLibro.getById(idLibro);

		if (idLibro < 1 || idAlumno < 1 || fechaInicio == null || oldIdLibro < 1 || oldIdAlumno < 1 || oldFechaInicio == null ) {
			throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS_PRESTAMO);
		}

		if (libro.getId() == -1 || alumno.getId() == -1 || libroNuevo.getId() == -1 || alumnoNuevo.getId() == -1) {
			throw new Exception(EXCEPTION_NO_EXISTE_ALUMNO_LIBRO);
		}

		if (librosDisponibles.contains(libro)) {
			throw new Exception(EXCEPTION_LIBRO_SIN_PRESTAMO);
		}

		if (alumnosDisponibles.contains(alumno)) {
			throw new Exception(EXCEPTION_ALUMNO_SIN_PRESTAMO);
		}
		
		if(libro.getId() != libroNuevo.getId()) {
			if (!librosDisponibles.contains(libroNuevo)) {
				throw new Exception(EXCEPTION_LIBRO_PRESTADO);
			}
		}
		
		if(alumno.getId() != alumnoNuevo.getId()) {
			if (!alumnosDisponibles.contains(alumnoNuevo)) {
				throw new Exception(EXCEPTION_ALUMNO_PRESTADO);
			}
		}
		
		result=true;

		return result;
	}

}
