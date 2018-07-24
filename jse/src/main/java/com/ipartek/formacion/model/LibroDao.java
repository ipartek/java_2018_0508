package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.pojo.Libro;

public class LibroDao implements CrudAble<Libro> {

	private static LibroDao INSTANCE = null;
	private static List<Libro> libro = null;

	public static synchronized LibroDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LibroDao();
		}
		return INSTANCE;
	}

	private LibroDao() {
		libro = new ArrayList<Libro>();

	}

	public boolean insert(Libro pojo) {
		boolean resul = false;
		if (pojo != null) {
			resul = libro.add(pojo);
		}
		return resul;
	}

	public List<Libro> getAll() {

		return libro;
	}

	public Libro getById(long id) {
		Libro libroIteracion = null;
		Libro resul = null;
		for (int i = 0; i < libro.size(); i++) {
			libroIteracion = libro.get(i);
			if (libroIteracion.getId() == id) {
				resul = libroIteracion;
				break;
			}
		}
		return resul;
	}

	public boolean update(Libro pojo) {
		boolean resul = false;
		Libro libroIteracion = null;
		int i = 0;
		// comprobamos si es null hacer comprobacion
		if (pojo != null) {
			// iterator
			Iterator<Libro> it = libro.iterator();
			while (it.hasNext()) {
				libroIteracion = it.next();
				if (libroIteracion.getId() == pojo.getId()) {
					libro.set(i, pojo);
					resul = true;
					break;
				}

			}
		}
		return resul;
	}

	public boolean delete(long id) {

		boolean resul = false;
		Libro libroIteracion = null;
		for (int x = 0; x < libro.size(); x++) {
			libroIteracion = libro.get(x);
			if (id == libroIteracion.getId()) {
				resul = libro.remove(libroIteracion);
			}
		}

		return resul;
	}

	// metodo migrado desde la vista
	public List<Libro> listarPrestados(boolean isPrestado) {
		ArrayList<Libro> resul = new ArrayList<Libro>();
		for (Libro lib : libro) {
			if (lib.isPrestado() == isPrestado) {
				resul.add(lib);
			}
		}
		return resul;
	}

	// metodo migrado desde la vista
	public List<Libro> listarNoPrestados(boolean isPrestado) {
		/*
		 * ArrayList<Libro> resul= new ArrayList<Libro>(); for (Libro libro : resul ) {
		 * if(libro.isPrestado()== isPrestado) { resul.add(libro); } }
		 * 
		 * return resul;
		 */
		ArrayList<Libro> resul = new ArrayList<Libro>();
		for (Libro lib : libro) {
			if (lib.isPrestado() == isPrestado) {
				resul.add(lib);
			}
		}
		return resul;
	}

	/**
	 * coincidencias por titulo usaremos ignorecasen para hacer busquedas indisti
	 * 
	 * @param titulo
	 * @return
	 */
	// migrado desde gestor de libro
	public List<Libro> listarTodosTitulo(String busqueda) {
		ArrayList<Libro> resul = new ArrayList<Libro>();

		for (Libro lib : libro) {
			if (lib.getTitulo().contains(busqueda.toUpperCase())) {
				resul.add(lib);
			}
		}
		return resul;

	}

}
