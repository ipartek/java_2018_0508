package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Libro;

/**
 * Clase DAO para gestionar la clase Libro con ArrayList. Usamos el Patrón
 * Singleton.
 * 
 * @see https://es.wikipedia.org/wiki/Singleton#Java
 * @author Curso
 *
 */
public class LibroDAO implements CrudAble<Libro> {

	private static LibroDAO INSTANCE = null;
	private static ArrayList<Libro> lista;

	private LibroDAO() { // CONSTRUCTOR MEDIANTE SINGLETON PATTERN
		lista = new ArrayList<Libro>();
	}

	public static synchronized LibroDAO getInstance() {
		return (INSTANCE == null ? new LibroDAO() : INSTANCE);
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

	public List<Libro> getAllPrestados(boolean isPrestado) {

		ArrayList<Libro> librosEncontrados = new ArrayList<Libro>();
		if (lista.size() > 0) {

			for (Libro libro : lista) {
				if (libro.isPrestado() == isPrestado) {
					librosEncontrados.add(libro);
				}
			}
		}
		return librosEncontrados;
	}

	@Override
	public Libro getById(long id) {
		Libro libro = null;

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) {
				libro = lista.get(i);
				break;
			}
		}
		return libro;
	}

	/**
	 * Busca,ps ñibros que coincida el título. Es ignoreCase y nos sirve cualquier
	 * coincidencia
	 * 
	 * @param texto
	 * @return
	 */
	public ArrayList<Libro> busqueda(String texto) {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		if (texto != null) {
			for (Libro libro : lista) {
				if (libro.getTitulo().toLowerCase().contains(texto.toLowerCase().trim())) { // Coincide título

					libros.add(libro);
				} else if (libro.getAutor().toLowerCase().contains(texto.toLowerCase().trim())) { // Coincide autor

					libros.add(libro);
				} else if (libro.getEditorial().toLowerCase().contains(texto.toLowerCase().trim())) { // Coincide
																										// editorial

					libros.add(libro);
				}
			}
		}
		return libros;

	}

	@Override
	public boolean update(Libro pojo) {
		boolean result = false;

		if (pojo != null) {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getId() == pojo.getId()) {
					lista.set(i, pojo);
					result = true;
				}
			}
		}
		return result;
	}

	@Override
	public boolean delete(long id) {
		boolean result = false;

		for (Libro lIteracion : lista) {
			if (id == lIteracion.getId()) { // Libro encontrado
				result = lista.remove(lIteracion); // Eliminamos Libro y comprobamos
				break;
			}
		}

		return result;
	}

}
