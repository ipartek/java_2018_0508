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
	
	public static final String EXCEPTION_PARAMETROS_INCORRECTOS = "Necesitamos idLibro, idUsuario y FechaInicio";
	public static final String EXCEPTION_NO_EXISTE_USUARIO_LIBRO = "No podemos prestar si no existe el Usuario o Libro";
	public static final String EXCEPTION_LIBRO_PRESTADO = "Libro ya tiene un prestamos activo";
	public static final String EXCEPTION_USUARIO_PRESTADO = "Usuario ya tiene un prestamos activo";

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
	public boolean prestar(/*long idLibro, long idAlumno, Date fechaInicio*/Prestamo prestamo) throws Exception {
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
//			Prestamo p = new Prestamo();
//			p.setFecha_prestado(prestamo.getFecha_prestado());
//
//			Alumno a = new Alumno();
//			a.setId(prestamo.getAlumno().getId());
//			p.setAlumno(a);
//
//			Libro l = new Libro();
//			l.setId(prestamo.getLibro().getId());
//			p.setLibro(l);

			if (daoPrestamo.insert(prestamo)) {
				resul = true;
			}
		}else if(!alumnoEncontrado) {
			throw new Exception(EXCEPTION_USUARIO_PRESTADO);
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
	public boolean devolver(long idLibro, long idAlumno, Date fechaPrestado, Date fechaRetorno) throws Exception {
		boolean resul = false;
		Prestamo p = new Prestamo();
		
		boolean alumnoEncontrado = false;
		boolean libroEncontrado = false;
		
		ArrayList<Alumno> alumnosDisponibles = (ArrayList<Alumno>) this.alumnosDisponibles();
		
		for(int i=0; i<alumnosDisponibles.size();i++) {
			if(alumnosDisponibles.get(i).getId() == idAlumno) {
				alumnoEncontrado = true;
				break;
			}
		}
		
		ArrayList<Libro> librosDisponibles = (ArrayList<Libro>) this.librosDisponibles();
		
		for(int i=0; i<librosDisponibles.size();i++) {
			if(librosDisponibles.get(i).getId() == idLibro) {
				libroEncontrado = true;
				break;
			}
		}
		
		if(alumnoEncontrado && libroEncontrado) {
			Alumno a = new Alumno();
			a.setId(idAlumno);
			p.setAlumno(a);

			Libro l = new Libro();
			l.setId(idLibro);

			p.setLibro(l);
			
			p.setFecha_prestado(fechaPrestado);
			p.setFecha_retorno(fechaRetorno);		

			if (daoPrestamo.update(p)) {
				resul=true;
			}
		}else if(!alumnoEncontrado) {
			throw new Exception(EXCEPTION_USUARIO_PRESTADO);
		}else if(!libroEncontrado) {
			throw new Exception(EXCEPTION_LIBRO_PRESTADO);
		}

//		Alumno a = new Alumno();
//		a.setId(idAlumno);
//		p.setAlumno(a);
//
//		Libro l = new Libro();
//		l.setId(idLibro);
//
//		p.setLibro(l);
//		
//		p.setFecha_prestado(fechaPrestado);
//		p.setFecha_retorno(fechaRetorno);		
//
//		if (daoPrestamo.update(p)) {
//			resul=true;
//		}
		
		return resul;
	}

	@Override
	public boolean update(long idLibroOld, long idAlumnoOld, Date fechaPrestadoOld, long idLibroNew, long idAlumnoNew,
			Date fechaPrestadoNew, Date fechaFinal, Date fechaRetorno) throws Exception {
		boolean resul = false;

		if (daoPrestamo.modifyAll(idAlumnoOld, idLibroOld, fechaPrestadoOld, idAlumnoNew, idLibroNew, fechaPrestadoNew, fechaFinal, fechaRetorno)) {
			resul=true;
		}
		return resul;
	}
	
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
		
		if ( libro == null || alumno == null ) {
			throw new Exception(EXCEPTION_NO_EXISTE_USUARIO_LIBRO);
		}
	}
}
