package com.ipartek.formacion.gestor.libros.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.gestor.libros.pojo.Libro;

public class LibroDAO implements CrudAble<Libro> {

	private static LibroDAO INSTANCE = null;
	private static List<Libro> lista;

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
	public boolean insert(Libro pojo) {
		boolean result = false;
		if (pojo != null) {
			result = lista.add(pojo);

		}

		return result;
	}

	@Override
	public List<Libro> getAll() {

		return lista;
	}

	@Override
	public Libro getById(long id) {
		Libro result = null;

		for (Libro libroIteracion : lista) {
			if (id == libroIteracion.getId()) {
				result = libroIteracion;
				break;
			}
		}

		return result;
	}

	@Override
	public boolean update(Libro pojo) {
		boolean result = false;
		Libro libroIteracion = null;
		int i = 0;

		if (pojo != null) {
			Iterator<Libro> it = lista.iterator();
			while (it.hasNext()) {
				libroIteracion = it.next();
				if (libroIteracion.getId() == pojo.getId()) {
					lista.set(i, pojo);
					result = true;
					break;
				}
				i++;
			}
		}

		return result;
	}

	@Override
	public boolean delete(long id) {
		boolean result = false;
		Libro aux = null;

		if (id >= 0) {

			for (Libro libro : lista) {
				aux = lista.get((int) libro.getId());
				if (aux.getId() == id) {
					result = lista.remove(aux);
					break;
				}

			}
		}
		return result;
	}

	@Override
	public boolean deleteAll(List<Libro> list) {
		boolean result = false;
		if (!list.isEmpty()) {
			list.clear();
			result = true;
		}

		return result;
	}

	public List<Libro> getByTitulo(String busqueda) {
		ArrayList<Libro> result = new ArrayList<Libro>();
		if (busqueda != null) {
			for (Libro libro : lista) {

				if (libro.getTitulo().toUpperCase().contains(busqueda.toUpperCase())) {
					result.add(libro);
				}
			}

		}
		return result;
	}

	/**
	 * Retorna los libros prestados o no prestados
	 * 
	 * @param isPrestados bollean true=> listado prestados, false=>listado no
	 *                    prestados
	 * @return
	 */

	public List<Libro> getAllPrestados(boolean isPrestado) {
		ArrayList<Libro> result = new ArrayList<Libro>();

		for (Libro libroIteracion : lista) {
			if (libroIteracion.isPrestado() == isPrestado) {
				result.add(libroIteracion);
			}

		}

		return result;
	}

}
