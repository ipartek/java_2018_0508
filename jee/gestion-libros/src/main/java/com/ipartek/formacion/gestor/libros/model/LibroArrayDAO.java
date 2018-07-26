package com.ipartek.formacion.gestor.libros.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.gestor.libros.pojo.Libro;

/**
 * Clase DAO para gestionar los libros de Ipartek con ArrayList<> Usamos patron
 * Singleton
 * 
 * @see https://es.wikipedia.org/wiki/Singleton
 * @author Curso
 *
 */
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
	public boolean insert(Libro video) {

		boolean resul = false;
		if (video != null) {
			resul = lista.add(video);
		}

		return resul;
	}

	@Override
	public List<Libro> getAll() {

		return lista;

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

	@Override
	public boolean update(Libro libroUpdate) {

		boolean resul = false;
		Libro libroIteracion = null;
		int i = 0;

		if (libroUpdate != null) {
			
			Iterator<Libro> it = lista.iterator();
			while (it.hasNext()) {

				libroIteracion = it.next();
				if (libroIteracion.getId() == libroUpdate.getId()) {
					lista.set(i, libroUpdate);
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

			if (libroIteracion.getId() == id) {
				resul = lista.remove(libroIteracion);
				break;
			}
		}
		return resul;
	}

	public ArrayList<Libro> getByTitulo(String busqueda) {

		ArrayList<Libro> resul = new ArrayList<Libro>();

		// foreach
		for (Libro libroIteracion : lista) {

			if (libroIteracion.getTitulo().toLowerCase().contains(busqueda.toLowerCase())) {
				resul.add(libroIteracion);
			}

		}
		return resul;
	}

	public ArrayList<Libro> listarLibrosPrestados(boolean prestamo) {

		ArrayList<Libro> l = new ArrayList<Libro>();

		for (Libro libroIteracion : lista) {

			if (libroIteracion.isPrestado() == prestamo) {
				l.add(libroIteracion);
			}

		}
		return l;

	}
}
