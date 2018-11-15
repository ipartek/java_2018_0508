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
	
	
	private PrestamoDAO daoPrestamo;
	private LibroDAO daoLibro;
	private UsuarioDAO daoUsuario;
	
	private static ServicePrestamo INSTANCE = null;
	
	public static final String EXCEPTION_PARAMETROS_INCORRECTOS = "Necesitamos idLibro, idUsuario y FechaInicio";
	public static final String EXCEPTION_NO_EXISTE_USUARIO_LIBRO = "No podemos prestar si no existe el Usuario o Libro";
	public static final String EXCEPTION_LIBRO_PRESTADO = "Libro ya tiene un prestamos activo";
	public static final String EXCEPTION_USUARIO_PRESTADO = "Usuario ya tiene un prestamos activo";
	

	private ServicePrestamo() {	
		daoPrestamo = PrestamoDAO.getInstance();
		daoLibro = LibroDAO.getInstance();
		daoUsuario = UsuarioDAO.getInstance();		
	}
	
	public static synchronized ServicePrestamo getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicePrestamo();
		}
		return INSTANCE;
	}

	@Override
	public boolean crear(Prestamo p) throws Exception {
		boolean resul = false;	
		long idLibro = -1;
		long idUsuario = -1;
		Date fInicio = null;
		
		//comprobar parametros obligatorios correctos
		try {
			idLibro = p.getLibro().getId();
			idUsuario = p.getUsuario().getId();
			fInicio = p.getFech_inicio();
			
			if( idLibro < 1 || idUsuario < 1 || fInicio == null ) {
				throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);
			}
			
		}catch (Exception e) {
			
			throw new Exception(EXCEPTION_PARAMETROS_INCORRECTOS);
			
		}	
		
		//comprobar Existe Libro y Usuario
		Libro libro = daoLibro.getById( String.valueOf(idLibro) );
		Usuario usuario = daoUsuario.getById(String.valueOf(idUsuario));
		
		if ( libro == null || usuario == null ) {
			throw new Exception(EXCEPTION_NO_EXISTE_USUARIO_LIBRO);
		}
		
		
		
		//comprobar Libro y Usuario no tengan prestamos		
		List<Libro> librosDisponibles = daoPrestamo.getLibrosDisponibles();
		if ( !librosDisponibles.contains(libro) ) {
			throw new Exception(EXCEPTION_LIBRO_PRESTADO);
		}
		
		List<Usuario> usuariosDisponible = daoPrestamo.getUsuariosDisponibles();
		if ( !usuariosDisponible.contains(usuario)) {
			throw new Exception(EXCEPTION_USUARIO_PRESTADO);
		}
		
								
		resul = daoPrestamo.insert(p);
		if ( resul ) {
			p.setLibro(libro);
			p.setUsuario(usuario);
		}
		
		return resul;
	}

	@Override
	public boolean modificar(Prestamo p) throws Exception {
		boolean resul = false;
		Prestamo prestamo = daoPrestamo.getByIds(p.getLibro().getId(), p.getUsuario().getId(), p.getFech_inicio());
		if(prestamo.getLibro() != null) {
			daoPrestamo.update(p);
			resul = true;
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
	public boolean modificarHistorico(Prestamo p, Prestamo prestamoAntiguo) throws Exception {
		boolean resul = false;
		Prestamo prestamo = daoPrestamo.getByIds(prestamoAntiguo.getLibro().getId(), prestamoAntiguo.getUsuario().getId(), prestamoAntiguo.getFech_inicio());
		if(prestamo.getLibro() != null) {
			daoPrestamo.updateHistorico(p, prestamoAntiguo);
			resul = true;
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

}
