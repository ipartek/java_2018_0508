package com.ipartek.formacion.libreria;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.model.CrudAble;

public class LibroDAO implements CrudAble<Libro> {

	private static LibroDAO INSTANCE = null;
	private static List<Libro> lista = null;

	private LibroDAO() {
		lista = new ArrayList<Libro>();
	}

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
			lista.add(libro);
			resul = true;
		}
		return resul;
	}

	@Override
	public List<Libro> getAll() {
		return lista;
	}

	public List<Libro> getAllPrestados(boolean isPrestado) {
		ArrayList<Libro> resul = new ArrayList<Libro>();
		for (Libro libro : lista) {
			if (libro.isPrestado() == isPrestado) {
				resul.add(libro);
			}
		}
		return resul;
	}

	@Override
	public Libro getById(long id) {
		Libro resul = null;
		for (Libro libroIteracion : lista) {
			if (id == libroIteracion.getId()) {
				resul = libroIteracion;
				break;
			}
		}

		return resul;
	}

	public Libro getByTitulo(String titulo) {
		Libro resul = null;
		for (Libro libroIteracion : lista) {
			if (titulo == libroIteracion.getTitulo()) {
				resul = libroIteracion;
				break;
			}
		}

		return resul;
	}

	@Override
	public boolean update(Libro libro) {
		boolean resul = false;
		Libro libroIteracion = null;
		int i = 0;
		if (libro != null) {

			// Iterator
			Iterator<Libro> it = lista.iterator();
			while (it.hasNext()) {
				libroIteracion = it.next();
				if (libroIteracion.getId() == libro.getId()) {
					lista.set(i, libro);
					resul = true;
					break;
				}
				i++;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		Libro libroIteracion = null;
		for (int i = 0; i < lista.size(); i++) {
			libroIteracion = lista.get(i);
			if (id == libroIteracion.getId()) {
				resul = lista.remove(libroIteracion);
				break;
			}
		}
		return resul;
	}

	public List<Libro> buscarPorTitulo(String busqueda) {
		ArrayList<Libro> resul = new ArrayList<Libro>();
		if (busqueda != null) {
			for (Libro libro : lista) {
				if (libro.getTitulo().toLowerCase().contains(busqueda.toLowerCase())) {
					resul.add(libro);
				}
			}
		}
		return resul;
	}

}
