package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;
import com.ipartek.formacion.pojo.Libro;

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

		boolean correcto = false;
		if (libro != null) {
			correcto = lista.add(libro);
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
			if (lista.get(i).getId() == id) {
				lista.remove(i);
				eliminado = true;
			}
		}

		return eliminado;
	}

	/**
	 * Retorna los libros prestados o no prestados
	 * 
	 * @param isPrestado boolean true => listado prestados, false => listado no
	 *                   prestados
	 * @return listado de libros
	 */
	public List<Libro> getAllPrestados(boolean isPrestado) {

		ArrayList<Libro> result = new ArrayList<>();
		for (Libro libro : lista) {
			if (libro.isPrestado() == isPrestado) {
				result.add(libro);
			}
		}

		return result;

	}

	/**
	 * Buscamos libros que coincida el titulo, es ignoreCase, nos sirve cualquier
	 * coincidencia
	 * 
	 * @param busqueda String termino a buscar
	 * @return listado de Libros
	 */

	public List<Libro> buscarPorTitulo(String busqueda) {

		ArrayList<Libro> result = new ArrayList<>();
		if (busqueda != null) {
			for (Libro libro : lista) {
				if (libro.getTitulo().toLowerCase().contains(busqueda.toLowerCase())) {
					result.add(libro);
				}
			}
		}
		return result;
	}

}
