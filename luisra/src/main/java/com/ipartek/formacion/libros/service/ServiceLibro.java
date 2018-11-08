package com.ipartek.formacion.libros.service;

import java.sql.Date;
import java.util.List;

import com.ipartek.formacion.libros.model.AlumnoDAO;
import com.ipartek.formacion.libros.model.LibroDAO;
import com.ipartek.formacion.libros.model.PrestamoDAO;
import com.ipartek.formacion.libros.pojo.Alumno;
import com.ipartek.formacion.libros.pojo.Libro;
import com.ipartek.formacion.libros.pojo.Prestamo;

public class ServiceLibro implements ICRUDService<Libro> {
	
	private static ServiceLibro INSTANCE = null;

	private static LibroDAO librosDAO;
	
	
	private ServiceLibro() {
		super();
		librosDAO = LibroDAO.getInstance();
	}

	public static synchronized ServiceLibro getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ServiceLibro();
		}

		return INSTANCE;
	}

	
	@Override
	public List<Libro> listar() throws Exception {
		
		return librosDAO.getAll();
	}

	@Override
	public Libro obtener(long id) throws Exception {
		
		return librosDAO.getById(id);
	}

	@Override
	public boolean crear(Libro pojo) throws Exception {
	
		boolean resul = false;			
		resul = librosDAO.insert(pojo);
		
		return resul;
	}
	
	
	public boolean crearVarios(Libro pojo,int n_ejemplares) throws Exception {
	
		boolean resul = false;			
		resul = librosDAO.loopInsertLibro(pojo, n_ejemplares);
		
		return resul;
	}

	@Override
	public boolean modificar(Libro pojo) throws Exception {
		
		boolean resul = false;		
		resul = librosDAO.update(pojo);

		return resul;
	}

	@Override
	public boolean eliminar(String id) throws Exception {
		
		boolean resul = false;
		resul = librosDAO.delete(id);
		
		return resul;
	}
	
	

	
	
}