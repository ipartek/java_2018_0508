package com.ipartek.formacion.prestamolibros.service;

import java.util.List;

import com.ipartek.formacion.prestamolibros.model.LibroDAO;
import com.ipartek.formacion.prestamolibros.pojo.Libro;

public class ServicioLibro implements IService<Libro>{
	
	private static ServicioLibro INSTANCE = null;
	
	private LibroDAO daoLibro;
	
	private ServicioLibro() {
		super();
		daoLibro = LibroDAO.getInstance();
	}

	public static synchronized ServicioLibro getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicioLibro();
		}
		return INSTANCE;
	}

	@Override
	public boolean crear(Libro l) throws Exception {
		
		return daoLibro.insert(l);
	}

	@Override
	public boolean modificar(Libro l) throws Exception {
		
		return daoLibro.update(l);
	}

	@Override
	public boolean eliminar(long id) throws Exception {
		
		return daoLibro.delete(id);
	}

	@Override
	public Libro buscar(long id) throws Exception {
		
		return daoLibro.getById(id);
	}

	@Override
	public List<Libro> listar() throws Exception {
		
		return daoLibro.getAll();
	}

}
