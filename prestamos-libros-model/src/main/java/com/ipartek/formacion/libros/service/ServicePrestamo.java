package com.ipartek.formacion.libros.service;

import java.sql.Date;
import java.util.List;

import com.ipartek.formacion.libros.model.AlumnoDAO;
import com.ipartek.formacion.libros.model.LibroDAO;
import com.ipartek.formacion.libros.model.PrestamoDAO;
import com.ipartek.formacion.libros.pojo.Alumno;
import com.ipartek.formacion.libros.pojo.Libro;
import com.ipartek.formacion.libros.pojo.Prestamo;

public class ServicePrestamo implements IPrestamoService {
	
	private static ServicePrestamo INSTANCE = null;

	private static PrestamoDAO prestamosDAO;
	private static LibroDAO librosDAO;
	private static AlumnoDAO alumnosDAO;
	
	
	private ServicePrestamo() {
		super();
		prestamosDAO = PrestamoDAO.getInstance();
		librosDAO = LibroDAO.getInstance();
		alumnosDAO = AlumnoDAO.getInstance();
	}

	public static synchronized ServicePrestamo getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ServicePrestamo();
		}

		return INSTANCE;
	}

	@Override
	public boolean devolver(long idAlumno, long idlibro, Date fechaInicio, Date fechaRetorno) throws Exception {
		boolean resul = false;
			
		Alumno alumno = new Alumno();
		alumno.setId(idAlumno);
		
		Libro libro = new Libro();
		libro.setId(idlibro);
		
		Prestamo prestamo = new Prestamo();
		
		prestamo.setAlumno(alumno);
		prestamo.setLibro(libro);
		prestamo.setFechaInicio(fechaInicio);
		prestamo.setFechaRetorno(fechaRetorno);
		
		resul = prestamosDAO.delete(prestamo);
		
		return resul;
	}

	@Override
	public boolean prestar(long idAlumno, long idlibro, Date fechaInicio) throws Exception {
		boolean resul = false;
		
		Alumno alumno = new Alumno();
		alumno.setId(idAlumno);
		
		Libro libro = new Libro();
		libro.setId(idlibro);
		
		Prestamo prestamo = new Prestamo();
		
		prestamo.setAlumno(alumno);
		prestamo.setLibro(libro);
		prestamo.setFechaInicio(fechaInicio);

		
		resul = prestamosDAO.insert(prestamo);
		
		return resul;
	}
	
	public boolean prestar(Prestamo pojo) throws Exception {
		boolean resul = false;
		
		resul = prestamosDAO.insert(pojo);
		
		return resul;
	}
	
	public Prestamo obtenerPorId(long alumno, long libro, Date fecha) throws Exception {
		
		return prestamosDAO.getById(alumno, libro, fecha);
	}

	@Override
	public boolean modificar(long idAlumno, long idlibro, Date fechaInicio, Date fechaFin) throws Exception {
		boolean resul = false;

		resul = prestamosDAO.update(crearPrestamo(idAlumno, idlibro, fechaInicio, fechaFin, null));
		
		return resul;
	}

	@Override
	public List<Libro> librosDisponibles() throws Exception {
		
		return librosDAO.getAllDisponibles();
	}
	
	public List<Libro> listarLibros() throws Exception {
		
		return librosDAO.getAll();
	}

	@Override
	public List<Alumno> alumnosDisponibles() throws Exception {
		
		return alumnosDAO.getAllDisponible();
	}
	
	public List<Alumno> listarAlumnos() throws Exception {
		
		return alumnosDAO.getAll();
	}

	@Override
	public List<Prestamo> prestamosActivos() throws Exception {
		
		return prestamosDAO.getAllActivos();
	}
	
	public boolean modificarPrestamoActivo(long idAlumno, long idlibro, Date fechaInicio, long nuevoAlumno, long nuevoLibro, Date nuevaFecha, Date fechaFin) throws Exception {
		boolean resul;
		
		resul = prestamosDAO.update(idAlumno, idlibro, fechaInicio, nuevoAlumno, nuevoLibro, nuevaFecha, fechaFin, null);
		
		return resul;
	}

	@Override
	public List<Prestamo> historico() throws Exception {
		
		return prestamosDAO.getAllHistorico();
	}

	public boolean modificarHistorico(long idAlumno, long idlibro, Date fechaInicio, long nuevoAlumno, long nuevoLibro, Date nuevaFecha, Date fechaFin, Date fechaRetorno) throws Exception {
		boolean resul;
		
		resul = prestamosDAO.update(idAlumno, idlibro, fechaInicio, nuevoAlumno, nuevoLibro, nuevaFecha, fechaFin, fechaRetorno);
		
		return resul;
	}
	
	private Prestamo crearPrestamo(long idAlumno, long idlibro, Date fechaInicio, Date fechaFin, Date fechaRetorno) {
		
		Alumno alumno = new Alumno();
		alumno.setId(idAlumno);
		
		Libro libro = new Libro();
		libro.setId(idlibro);
		
		Prestamo prestamo = new Prestamo();
		prestamo.setAlumno(alumno);
		prestamo.setLibro(libro);
		prestamo.setFechaInicio(fechaInicio);
		prestamo.setFechaFin(fechaFin);
		prestamo.setFechaRetorno(fechaRetorno);
		
		return prestamo;
		
	}
	
	public boolean modificarPrestamoAPI(long idAlumno, long idLibro, Date fechaInicio, Prestamo pojo) throws Exception {
		boolean resul = false;
		
		resul = prestamosDAO.update(idAlumno, idLibro, fechaInicio, pojo);
		
		return resul;
	}

	
}