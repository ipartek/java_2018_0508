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

	private static ServicePrestamo INSTANCE = null;
	private static PrestamoDAO daoPrestamo = PrestamoDAO.getInstance();

	public static final String EXCEPTION_PARAMETROS_INCORRECTOS = "Necesitamos idLibro, idUsuario y FechaInicio";
	public static final String EXCEPTION_NO_EXISTE_ALUMNO_LIBRO = "No podemos prestar si no existe el Usuario o Libro";
	public static final String EXCEPTION_LIBRO_PRESTADO = "Libro ya tiene un prestamos activo";
	public static final String EXCEPTION_ALUMNO_PRESTADO = "Usuario ya tiene un prestamos activo";

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
	 * 
	 * @param Prestamo p necesitamos: p.getAlumno().getId() para poder comprobar si
	 * el alumno existe en la bbdd y no tenga prestamo asociado p.getLibro().getId()
	 * para poder comprobar si el libro existe en la bbdd y no tenga prestamo
	 * asociado.
	 * 
	 */
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
	public boolean devolver(Prestamo p) throws Exception {
		boolean resul = false;

		Alumno a = new Alumno();
		a.setId(p.getAlumno().getId());
		p.setAlumno(a);

		Libro l = new Libro();
		l.setId(p.getLibro().getId());

		p.setLibro(l);

		p.setFecha_prestado(p.getFecha_prestado());
		p.setFecha_retorno(p.getFecha_retorno());

		if (daoPrestamo.devolver(p)) {
			resul = true;
		}
		return resul;
	}

	/*
	 * No se usa en prestamo.
	 */
	@Override
	public boolean update(long idLibroOld, long idAlumnoOld, Date fechaPrestadoOld, long idLibroNew, long idAlumnoNew,
			Date fechaPrestadoNew, Date fechaFinal, Date fechaRetorno) throws Exception {

		return false;
	}

	public boolean modificar(long idLibroOld, long idAlumnoOld, Date fechaPrestadoOld, long idLibroNew,
			long idAlumnoNew, Date fechaPrestadoNew, Date fechaFinal, Date fechaRetorno) throws Exception {

		boolean resul = false;
		boolean alumnoEncontrado = false;
		boolean libroEncontrado = false;		

		if(idAlumnoNew < 1) {
			idAlumnoNew = idAlumnoOld;
		}
		
		if(idLibroNew < 1) {
			idLibroNew = idLibroOld;
		}
		
		if(fechaPrestadoNew == null) {
			fechaPrestadoNew = fechaPrestadoOld;
		}
		
		Prestamo p = new Prestamo(fechaPrestadoNew, new Alumno(idAlumnoNew, ""), new Libro(idLibroNew, "", "", 1, null));
		comprobaciones(p);
		
		if(idAlumnoOld != idAlumnoNew && idAlumnoNew > 0) {
			ArrayList<Alumno> alumnosDisponibles = (ArrayList<Alumno>) this.alumnosDisponibles();
			for(int i=0; i<alumnosDisponibles.size();i++) {
				if(alumnosDisponibles.get(i).getId() == idAlumnoNew) {
					alumnoEncontrado = true;
					break;
				}
			}
		}else {
			alumnoEncontrado = true;
		}
		
		if(idLibroOld != idLibroNew && idLibroNew > 0) {
			ArrayList<Libro> librosDisponibles = (ArrayList<Libro>) this.librosDisponibles();
			for(int i=0; i<librosDisponibles.size();i++) {
				if(librosDisponibles.get(i).getId() == idLibroNew) {
					libroEncontrado = true;
					break;
				}
			}
		}else {
			libroEncontrado = true;
		}
		
		if(alumnoEncontrado && libroEncontrado) {
			
			p = daoPrestamo.buscarPorId(p);
			
			if(fechaFinal == null) {
				fechaFinal = p.getFecha_fin();
			}
			
			if(fechaRetorno == null) {
				fechaRetorno = p.getFecha_retorno();
			}
			
			if (daoPrestamo.modifyAll(idAlumnoOld, idLibroOld, fechaPrestadoOld, idAlumnoNew, idLibroNew, fechaPrestadoNew, fechaFinal, fechaRetorno)) {
				resul=true;
			}
		}else if(!alumnoEncontrado){
			throw new Exception(EXCEPTION_ALUMNO_PRESTADO);
		}else if(!libroEncontrado) {
			throw new Exception(EXCEPTION_LIBRO_PRESTADO);
		}
		
		return resul;
	}

	/**
	 * Metodo que comprueba si existen el Libro y el Alumno en la bbdd
	 * 
	 * @param prestamo Objeto Prestamo a comprobar si existen su Alumno y su Libro
	 * @throws Exception
	 */
	public void comprobaciones(Prestamo prestamo) throws Exception {

		long idLibro = -1;
		long idAlumno = -1;
		Date fInicio = null;

		// comprobar parametros obligatorios correctos
		try {
			idLibro = prestamo.getLibro().getId();
			idAlumno = prestamo.getAlumno().getId();
			fInicio = prestamo.getFecha_prestado();

			if (idLibro < 1 || idAlumno < 1 || fInicio == null) {
				throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);
			}

		} catch (Exception e) {

			throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);
		}

		// comprobar Existe Libro y Usuario
		Libro libro = LibroDAO.getInstance().getById(String.valueOf(idLibro));
		Alumno alumno = AlumnoDAO.getInstance().getById(String.valueOf(idAlumno));

		if (libro.getId() < 0 || alumno.getId() < 0) {
			throw new Exception(EXCEPTION_NO_EXISTE_ALUMNO_LIBRO);
		}
	}

}
