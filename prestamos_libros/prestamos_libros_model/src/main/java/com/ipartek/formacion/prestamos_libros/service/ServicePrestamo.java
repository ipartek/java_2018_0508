package com.ipartek.formacion.prestamos_libros.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.prestamos_libros.model.AlumnoDAO;
import com.ipartek.formacion.prestamos_libros.model.LibroDAO;
import com.ipartek.formacion.prestamos_libros.model.PrestamoDAO;
import com.ipartek.formacion.prestamos_libros.pojo.Alumno;
import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;


public class ServicePrestamo implements IServicePrestamo {

	private static ServicePrestamo INSTANCE = null;
	private static PrestamoDAO daoPrestamo = PrestamoDAO.getInstance();
	private static LibroDAO daoLibro = LibroDAO.getInstance();
	private static AlumnoDAO daoAlumno = AlumnoDAO.getInstance();
	
	public static final String EXCEPTION_PARAMETROS_INCORRECTOS = "Necesitamos idLibro, idUsuario y FechaInicio válidos";
	public static final String EXCEPTION_NO_EXISTE_ALUMNO_LIBRO = "No podemos prestar si no existe el Alumno o el Libro";
	public static final String EXCEPTION_LIBRO_PRESTADO = "Libro ya tiene un prestamos activo";
	public static final String EXCEPTION_ALUMNO_PRESTADO = "Alumno ya tiene un prestamos activo";
	public static final String EXCEPTION_PRESTAMO_YA_FINALIZADO = "No se puede finalizar un préstamo ya finalizado.";
	public static final String EXCEPTION_FECHA_RETORNO_VACIA = "Es obligatorio introducir la fecha de retorno";

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

	@Override
	public boolean prestar(Prestamo prestamo) throws Exception {
		boolean resul = false;
		boolean alumnoEncontrado = false;
		boolean libroEncontrado = false;
		
		comprobaciones(prestamo);
		
		ArrayList<Alumno> alumnosDisponibles = (ArrayList<Alumno>) this.alumnosDisponibles();
		
		for(int i=0; i<alumnosDisponibles.size();i++) {
			if(alumnosDisponibles.get(i).getId() == prestamo.getAlumno().getId()) {
				alumnoEncontrado = true;
				break;
			}
		}
		
		ArrayList<Libro> librosDisponibles = (ArrayList<Libro>) this.librosDisponibles();
		
		for(int i=0; i<librosDisponibles.size();i++) {
			if(librosDisponibles.get(i).getId() == prestamo.getLibro().getId()) {
				libroEncontrado = true;
				break;
			}
		}
		
		if(alumnoEncontrado && libroEncontrado) {

			if (daoPrestamo.insert(prestamo)) {
				resul = true;
			}
		}else if(!alumnoEncontrado) {
			throw new Exception(EXCEPTION_ALUMNO_PRESTADO);
		}else if(!libroEncontrado) {
			throw new Exception(EXCEPTION_LIBRO_PRESTADO);
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
	public Prestamo buscarPorId(long idLibro, long idAlumno, Date fecha_prestado) throws Exception {
		Prestamo p = null;
		p = daoPrestamo.buscarPorId( idLibro, idAlumno, fecha_prestado);
		return p;
	}

	@Override
	public boolean devolver(Prestamo p) throws Exception {
		boolean resul = false;
		
		comprobaciones(p);
		
		Prestamo prestamo = buscarPorId(p.getLibro().getId(), p.getAlumno().getId(), p.getFecha_prestado());
		
		if(prestamo != null && prestamo.getFecha_retorno() == null) {
			Alumno a = new Alumno();
			a.setId(p.getAlumno().getId());
			p.setAlumno(a);

			Libro l = new Libro();
			l.setId(p.getLibro().getId());

			p.setLibro(l);
			
			p.setFecha_prestado(p.getFecha_prestado());
			
			if(p.getFecha_retorno() != null) {
				p.setFecha_retorno(p.getFecha_retorno());
				if (daoPrestamo.devolver(p)) {
					resul=true;
				}
			}else {
				throw new Exception(EXCEPTION_FECHA_RETORNO_VACIA);
			}
			
		}else {
			throw new Exception(EXCEPTION_PRESTAMO_YA_FINALIZADO);
		}
		
		return resul;
	}

	@Override
	public boolean update(long idLibroOld, long idAlumnoOld, Date fechaPrestadoOld, long idLibroNew, long idAlumnoNew,
			Date fechaPrestadoNew, Date fechaFinal, Date fechaRetorno) throws Exception {
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
			
			p = daoPrestamo.buscarPorId(idLibroOld, idAlumnoOld, fechaPrestadoOld);
			
			if(fechaFinal == null) {
				fechaFinal = p.getFecha_fin();
			}
			
			if(fechaRetorno == null) {
				fechaRetorno = p.getFecha_retorno();
			}
			
			if (daoPrestamo.updateAll(idAlumnoOld, idLibroOld, fechaPrestadoOld, idAlumnoNew, idLibroNew, fechaPrestadoNew, fechaFinal, fechaRetorno)) {
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
	 * @param prestamo Objeto Prestamo a comprobar si existen su Alumno y su Libro
	 * @throws Exception
	 */
	public void comprobaciones(Prestamo prestamo) throws Exception {

		long idLibro = -1;
		long idAlumno = -1;
		Date fInicio = null;
		
		//comprobar parametros obligatorios correctos
		try {
			idLibro = prestamo.getLibro().getId();
			idAlumno = prestamo.getAlumno().getId();
			fInicio = prestamo.getFecha_prestado();
			
			if( idLibro < 1 || idAlumno < 1 || fInicio == null ) {
				throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);
			}
			
		}catch (Exception e) {
			
			throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);
		}	
		
		//comprobar Existe Libro y Usuario
		Libro libro = daoLibro.getById( String.valueOf(idLibro) );
		Alumno alumno = daoAlumno.getById(String.valueOf(idAlumno));
		
		if ( libro.getId() < 0 || alumno.getId() < 0 ) {
			throw new Exception(EXCEPTION_NO_EXISTE_ALUMNO_LIBRO);
		}
	}
}
