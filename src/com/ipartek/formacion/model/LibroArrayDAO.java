package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Libro;

public class LibroArrayDAO implements CrudAble<Libro> {

	private static LibroArrayDAO INSTANCE = null;
	private static List<Libro> lista = null;

	private LibroArrayDAO() {
		lista = new ArrayList<Libro>();
	}

	public static synchronized LibroArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new LibroArrayDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Libro libro) {
		// TODO Auto-generated method stub
		boolean resul = false;
		if (libro != null) {
			resul = lista.add(libro);
		}
		return resul;
	}

	@Override
	public List<Libro> getAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Libro getById(long id) {
		// TODO Auto-generated method stub
		Libro resul = null;
		// foreach
		for (Libro libro : lista) {
			if (id == libro.getId()) {
				resul = libro;
				break;
			}
		}
		return resul;
	}
	
	public Libro getByTitle(String titulo) {
		// TODO Auto-generated method stub
		Libro resul = null;
		// foreach
		for (Libro libro : lista) {
			if (titulo == libro.getTitulo()) {
				resul = libro;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean update(Libro libro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public int length() {
		return lista.size();
	}
}
