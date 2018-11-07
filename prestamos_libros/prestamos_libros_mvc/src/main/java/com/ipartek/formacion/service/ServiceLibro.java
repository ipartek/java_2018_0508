package com.ipartek.formacion.service;

import java.util.ArrayList;


import com.ipartek.formacion.model.LibroDAO;

import com.ipartek.formacion.pojo.Libro;

public class ServiceLibro implements IServiceLibro {

	LibroDAO daoLibro;

	private static ServiceLibro INSTANCE = null;

	private ServiceLibro() {
		super();
		daoLibro = LibroDAO.getInstance();
	}

	public static synchronized ServiceLibro getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceLibro();
		}
		return INSTANCE;
	}
	
	
	@Override
	public ArrayList<Libro> listar() throws Exception {
		ArrayList<Libro> Libros = new ArrayList<Libro>();
		Libros = (ArrayList<Libro>) daoLibro.getAll();
		return Libros;
	}

	@Override
	public boolean crear(Libro Libro) throws Exception {
		boolean resul = false;
		resul = daoLibro.insert(Libro);
		return resul;
	}

	@Override
	public boolean modificar(Libro Libro) throws Exception {
		boolean resul = false;
		resul = daoLibro.update(Libro);
		return resul;
	}

	@Override
	public boolean eliminar(long id) throws Exception {
		boolean resul = false;
		resul = daoLibro.delete(id);
		return resul;
	}

	@Override
	public Libro buscar(long id) throws Exception {
		Libro l = null;
		l = daoLibro.getById(id);
		return l;
	}

}
