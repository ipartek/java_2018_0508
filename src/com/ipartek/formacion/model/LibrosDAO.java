package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.pojo.Libro;

/**
 * DAO--> aplicacion por consola-->LIstar libros/Listar una serie de
 * libros/Prestados/Sin prestar/Buscar un libro por titulo
 * @author Curso
 *
 */
public class LibrosDAO implements CrudAble<Libro> {

	private static LibrosDAO INSTANCE = null;
	private static List<Libro> lista = null;

	private LibrosDAO() {
		lista = new ArrayList<Libro>();
	}

	public static synchronized LibrosDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new LibrosDAO();
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
	public List<Libro> getAll() {
		return lista;
	}

	@Override
	public Libro getById(long id) {
		Libro resul = null;
		// foreach
		for ( Libro libroIteracion : lista) {
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
			// Iterator
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

		Libro lIteracion = null;

		// buscar video a eliminar
		for (int i = 0; i < lista.size(); i++) {

			lIteracion = lista.get(i); // video sobre el que iteramos

			if (id == lIteracion.getId()) { // video encontrado
				resul = lista.remove(lIteracion);
				break;
			}
		}

		return resul;
	}

}