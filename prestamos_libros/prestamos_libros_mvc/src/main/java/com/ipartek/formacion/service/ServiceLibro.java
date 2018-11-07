package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.LibroDAO;
import com.ipartek.formacion.pojo.Libro;

public class ServiceLibro implements IServiceLibro {

	private static ServiceLibro INSTANCE = null;

	private static LibroDAO daoLibro = LibroDAO.getInstance();

	public static synchronized ServiceLibro getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceLibro();
		}
		return INSTANCE;
	}

	@Override
	public boolean crear(Libro l) throws Exception {
		boolean resul = false;
		if (daoLibro.insert(l)) {
			resul = true;
		}

		return resul;
	}

	@Override
	public boolean modificar(Libro l) throws Exception {
		boolean resul = false;
		if (daoLibro.update(l)) {
			resul = true;
		}

		return resul;
	}

	@Override
	public boolean eliminar(long id) throws Exception {
		boolean resul = false;
		if (daoLibro.delete(Long.toString(id))) {
			resul = true;
		}

		return resul;
	}

	@Override
	public Libro buscarPorId(long id) throws Exception {
		Libro l = null;

		if (Long.toString(id) != null) {
			l = daoLibro.getById(Long.toString(id));
		} else {
			l = new Libro();
		}

		return l;
	}

	@Override
	public List<Libro> listar() throws Exception {

		ArrayList<Libro> libros = (ArrayList<Libro>) daoLibro.getAll();

		return libros;
	}

}
