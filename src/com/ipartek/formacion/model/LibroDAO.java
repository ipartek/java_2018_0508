package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Libro;

public class LibroDAO implements CrudAble<Libro> {

	private static LibroDAO INSTANCE = null;
	private static List<Libro> lista = null;

	/**
	 * inicializa el array
	 */
	private LibroDAO() {

		lista = new ArrayList<Libro>();
	}

	/**
	 * metodo de acceso al DAO
	 * 
	 * @return INSTANCE
	 */
	public static synchronized LibroDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new LibroDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Libro libro) {
		boolean resul = false;
		if (libro != null) {

			resul = lista.add(libro);
		}

		return resul;
	}

	@Override
	public List<Libro> getALl() {
		return lista;
	}

	@Override
	public Libro getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Libro pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
