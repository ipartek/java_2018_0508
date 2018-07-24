package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.pojo.Libro;

public class LibroArrayDAO implements CrudAble<Libro> {

	// Singleton
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
		for (Libro libro : lista) {
			if (id == libro.getId()) {
				resul = libro;
				break;
			}
		}
		return resul;
	}

	/**
	 * Buscamos libros que coincida el titulo, es ignoreCase, nos sirve cualquiera
	 * sin necesidad de ser el titulo exacto
	 * 
	 * @param busqueda termino a buscar
	 * @return listado que coincida con la busqueda
	 */
	public List<Libro> getByTitle(String busqueda) {
		ArrayList<Libro> resul = new ArrayList<Libro>();
		// foreach
		if (busqueda != null) {
			for (Libro libro : lista) {
				if (libro.getTitulo().toLowerCase().contains(busqueda.toLowerCase().trim())) {
					resul.add(libro);
				}
			}
		}

		return resul;
	}

	@Override
	public boolean update(Libro libroUpdate) {
		boolean resul = false;
		Libro libroIteracion = null;
		int i = 0;
		if ( libroUpdate != null ) {
			//Iterator		
			Iterator<Libro> it = lista.iterator();
			while( it.hasNext() ) {
				libroIteracion = it.next();
				if ( libroIteracion.getId() == libroUpdate.getId() ) {
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
		return false;
	}

	/**
	 * Retorna los libros prestados o no prestados
	 * 
	 * @param isPrestados boolean => true listado prestados, false => lista No
	 *                    prestados
	 * @return Listado de libros
	 */
	public List<Libro> getAllPrestados(boolean isPrestado) {
		ArrayList<Libro> resul = new ArrayList<Libro>();

		for (Libro libro : lista) {
			if (libro.isPrestado() == isPrestado)
				resul.add(libro);
		}
		return resul;
	}

	public int length() {
		return lista.size();
	}
}
