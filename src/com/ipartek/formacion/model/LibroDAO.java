package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;
import com.ipartek.formacion.pojo.Libro;

public class LibroDAO implements CrudAble<Libro> {

	private static LibroDAO INSTANCE = null;
	private static List<Libro> lista = null;

	public LibroDAO() {
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

		boolean correcto = false;
		if (libro != null) {
			lista.add(libro);
			correcto = true;
		}
		return correcto;
	}

	@Override
	public List<Libro> getAll() {
		return lista;
	}

	@Override
	public Libro getById(long id) {

		Libro l = null;
		for (Libro libro : lista) {
			if (libro.getId() == id) {
				l = libro;
				break;
			}
		}

		return l;
	}

	@Override
	public boolean update(Libro libro) {

		boolean encontrado = false;
		for (Libro l : lista) {
			if (l.getId() == l.getId()) {
				l = libro;
				encontrado = true;
				break;
			}
		}

		return encontrado;
	}

	@Override
	public boolean delete(long id) {
		
		boolean eliminado = false;
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getId() == id) {
				lista.remove(i);		
				eliminado= true;
			}
		}

		return eliminado;
	}

}
