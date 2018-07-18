package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.VideoYoutube;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Libro pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll(List<VideoYoutube> list) {
		// TODO Auto-generated method stub
		return false;
	}

	public Libro getByTitulo(String titulo) {
		Libro result = null;

		for (Libro libroIteracion : lista) {
			if (libroIteracion.getTitulo().endsWith(titulo)) {
				result = libroIteracion;
				break;
			}

		}

		return result;

	}

}
