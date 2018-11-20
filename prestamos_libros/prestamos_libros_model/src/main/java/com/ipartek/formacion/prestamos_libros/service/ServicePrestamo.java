package com.ipartek.formacion.prestamos_libros.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import com.ipartek.formacion.prestamos_libros.model.LibroDAO;
import com.ipartek.formacion.prestamos_libros.model.PrestamoDAO;
import com.ipartek.formacion.prestamos_libros.model.UsuarioDAO;
import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;
import com.ipartek.formacion.prestamos_libros.pojo.Usuario;

public class ServicePrestamo implements IServicePrestamo {
	private static ServicePrestamo INSTANCE = null;
	private static PrestamoDAO daoPrestamo;
	private static LibroDAO daoLibro;
	private static UsuarioDAO daoUsuario;
	
	public static final String EXCEPTION_PARAMETROS_INCORRECTOS = "Necesitamos idLibro, idUsuario y FechaInicio";
	public static final String EXCEPTION_PARAMETROS_INCORRECTOS_DEVOLUCION = "Necesitamos idLibro, idUsuario, FechaInicio y FechaDevuelto";
	public static final String EXCEPTION_LIBRO_PRESTADO = "El Libro ya tiene un prestamo activo";
	public static final String EXCEPTION_USUARIO_PRESTADO = "El Usuario ya tiene un prestamo activo";
	public static final String EXCEPTION_LIBRO_NO_PRESTADO = "El Libro no tiene un prestamo activo";
	public static final String EXCEPTION_USUARIO_NO_PRESTADO = "El Usuario no tiene un prestamo activo";
	public static final String EXCEPTION_NO_EXISTE_PRESTAMO = "El prestamo no existe";
	public static final String EXCEPTION_NO_EXISTE_USUARIO_LIBRO = "No podemos prestar si no existe el Usuario o Libro";
	
	public static synchronized ServicePrestamo getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicePrestamo();
		}
		return INSTANCE;
	}

	private ServicePrestamo() {
		super();
		daoPrestamo = PrestamoDAO.getInstance();
		daoLibro = LibroDAO.getInstance();
		daoUsuario = UsuarioDAO.getInstance();
	}

	@Override
	public boolean crear(Prestamo p) throws Exception {
		boolean resul = false;
		long idLibro = -1;
		long idUsuario = -1;
		Date fInicio = null;
		
		//Comprobar parametros obligatorios correctos
		try {
			idLibro = p.getLibro().getId();
			idUsuario = p.getUsuario().getId();
			fInicio = p.getFech_inicio();
			
			if(idLibro < 1 || idUsuario < 1 || fInicio == null) {
				throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);
			}
			
		}catch(Exception e) {
			throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);
		}
		
		//Comprobar si existe el libro y usuario
		Libro libro = daoLibro.getById( String.valueOf(idLibro) );
		Usuario usuario = daoUsuario.getById(String.valueOf(idUsuario));
		
		if ( libro.getId() == -1 || usuario.getId() == -1 ) {
			throw new Exception(EXCEPTION_NO_EXISTE_USUARIO_LIBRO);
		}
		
		//Comprobar que el libro y usuario no tengan prestamos
		List<Libro> librosDisponibles = daoPrestamo.getLibrosDisponibles();
		if(!librosDisponibles.contains(libro)) {
			throw new Exception(EXCEPTION_LIBRO_PRESTADO);
		}
		
		List<Usuario> usuariosDisponibles = daoPrestamo.getUsuariosDisponibles();
		if(!usuariosDisponibles.contains(usuario)) {
			throw new Exception(EXCEPTION_USUARIO_PRESTADO);
		}

		//Dar de alta prestamo
		resul = daoPrestamo.insert(p);
		if ( resul ) {
			p.setLibro(libro);
			p.setUsuario(usuario);
		}

		return resul;
	}

	@Override
	public boolean devolver(Prestamo p) throws Exception {
		boolean resul = false;
		
		long idLibro = -1;
		long idUsuario = -1;
		Date fInicio = null;
		Date fDevuelto = null;
		
		try {
			idLibro = p.getLibro().getId();
			idUsuario = p.getUsuario().getId();
			fInicio = p.getFech_inicio();
			fDevuelto = p.getFecha_devuelto();
			
			if(idLibro < 1 || idUsuario < 1 || fInicio == null || fDevuelto == null) {
				throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS_DEVOLUCION);
			}
			
		}catch(Exception e) {
			throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS_DEVOLUCION);
		}
		
		//Comprobar si existe el libro y usuario
		Libro libro = daoLibro.getById( String.valueOf(idLibro));
		Usuario usuario = daoUsuario.getById(String.valueOf(idUsuario));
				
		if ( libro.getId() == -1 || usuario.getId() == -1 ) {
			throw new Exception(EXCEPTION_NO_EXISTE_USUARIO_LIBRO);
		}

		//Realizamos la devolucion
		if (daoPrestamo.update(p)) {
			resul = true;
		}else {
			//Comprobar que el libro y usuario tengan prestamos activos
			throw new Exception(EXCEPTION_NO_EXISTE_PRESTAMO);
		}

		return resul;
	}

	@Override
	public List<Prestamo> listar() throws Exception {
		List<Prestamo> prestamos = daoPrestamo.getAll();
		return prestamos;
	}

	@Override
	public List<Prestamo> listardevueltos() throws Exception {
		List<Prestamo> prestamosDevueltos = daoPrestamo.getAllDevueltos();
		return prestamosDevueltos;
	}

	@Override
	public List<Usuario> listarUsuariosDisponibles() throws Exception {
		List<Usuario> usuariosDisponibles = daoPrestamo.getUsuariosDisponibles();
		return usuariosDisponibles;
	}

	@Override
	public List<Libro> listarLibrosDisponibles() throws Exception {
		List<Libro> librosDisponibles = daoPrestamo.getLibrosDisponibles();
		return librosDisponibles;
	}

	@Override
	public boolean modificarPrestamo(Prestamo p, Prestamo prestamoAntiguo) throws Exception {
		boolean resul = false;

		if (daoPrestamo.updatePrestamo(p, prestamoAntiguo)) {
			resul = true;
		}

		return resul;
	}
	
	@Override
	public boolean modificarHistorico(Prestamo prestamoAModificar, Prestamo prestamoOriginal) throws Exception {
		boolean resul = false;
		
		long idLibro = -1;
		long idUsuario = -1;
		Date fInicio = null;
		
		//Comprobar parametros obligatorios correctos
		try {
			idLibro = prestamoAModificar.getLibro().getId();
			idUsuario = prestamoAModificar.getUsuario().getId();
			fInicio = prestamoAModificar.getFech_inicio();
			
			if(idLibro < 1 || idUsuario < 1 || fInicio == null) {
				throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);
			}
			
		}catch(Exception e) {
			throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);
		}
		
		//Comprobar si existe el libro y usuario
		Libro libro = daoLibro.getById( String.valueOf(idLibro) );
		Usuario usuario = daoUsuario.getById(String.valueOf(idUsuario));
		
		if ( libro.getId() == -1 || usuario.getId() == -1 ) {
			throw new Exception(EXCEPTION_NO_EXISTE_USUARIO_LIBRO);
		}

		if (daoPrestamo.updateHistorico(prestamoAModificar, prestamoOriginal)) {
			resul = true;
		}else {
			//Comprobar que el libro y usuario tengan prestamos activos
			throw new Exception(EXCEPTION_NO_EXISTE_PRESTAMO);
		}

		return resul;
	}

	@Override
	public Prestamo getByIds(String idLibro, String idUsuario, String fInicio) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Date fecha = new Date(sdf.parse(fInicio).getTime());
				
		return daoPrestamo.getByIds(Long.parseLong(idLibro), Long.parseLong(idUsuario), fecha);
	}
	
	@Override
	public Prestamo historicoGetByIds(String idLibro, String idUsuario, String fInicio) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Date fecha = new Date(sdf.parse(fInicio).getTime());
				
		return daoPrestamo.historicoGetByIds(Long.parseLong(idLibro), Long.parseLong(idUsuario), fecha);
	}
	
	public void validarPrimaryKey() {
		
	}
	
	public void comprobarExisteLibroUsuario(long idLibro, long idUsuario) throws Exception {
		
	}

}
