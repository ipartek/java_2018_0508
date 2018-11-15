package com.ipartek.formacion.prestamos_libros.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import com.ipartek.formacion.prestamos_libros.model.PrestamoDAO;
import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.pojo.Prestamo;
import com.ipartek.formacion.prestamos_libros.pojo.Usuario;

public class ServicePrestamo implements IServicePrestamo {
	private PrestamoDAO daoPrestamo = PrestamoDAO.getInstance();
	private static ServicePrestamo INSTANCE = null;
	

	public ServicePrestamo() {
		// TODO Auto-generated constructor stub
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
		resul = daoPrestamo.insert(p);
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
