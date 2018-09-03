package com.ipartek.formacion.gestor.libros.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.gestor.libros.pojo.Libro;


public class LibroDAO implements CrudAble<Libro> {

	private static LibroDAO INSTANCE = null;
	private static List<Libro> lista = null;

	/**
	 * Constructor inicializa el array
	 */
	private LibroDAO() {

		lista = new ArrayList<Libro>();
	}

	/**
	 * PAtron singlenton---metodo sincronizado de acceso al DAO desde fuera para que
	 * solo hay uno accediendo
	 * 
	 * @return INSTANCE la propia clase
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
		
		return null;
	}

	@Override
	public boolean update(Libro pojo) {
		return false;
	}

	@Override
	public boolean delete(long id) {
		
		return false;
	}

	/**
	 * Buscamos libros donde coincida el texto,es ignoreCase, nos sirve cualquier
	 * coincidencia, no tiene porque ser el titulo exacto
	 * 
	 * @param texto String que puede ser completo o parcial
	 * @return listado de libros que coincidan con el texto a buscar
	 */
	public List<Libro> getByTitulo(String texto) {
		ArrayList<Libro> resul = new ArrayList<Libro>();

		if (texto != null) {
			for (Libro libroIteracion : lista) {
				if (libroIteracion.getTitulo().toLowerCase().trim().contains(texto.toLowerCase().trim())) {
					resul.add(libroIteracion);

				}
			}

		}

		return resul;

	}

	/**
	 * Retorna los libros prestados o no prestados
	 * 
	 * @param isPrestado boolean true ==> listado de prestados, false==> listado no
	 *                   prestados
	 * @return lista de libros
	 */
	public List<Libro> getALlPrestados(boolean isPrestado) {

		ArrayList<Libro> resul = new ArrayList<Libro>();

		for (Libro libro : lista) {
			if (libro.isPrestado() == isPrestado) {
				resul.add(libro);
			}
		}
		return resul;
	}

}
