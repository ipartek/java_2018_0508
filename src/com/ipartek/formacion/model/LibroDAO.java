package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Libro;

/**
 * Clase DAO para gestionar los Libro con ArrayList
 * Usamos patrón singleton
 * @see https://es.wikipedia.org/wiki/Singleton
 * @author Adrian Garcia
 *
 */
public class LibroDAO implements CrudAble<Libro>{
	
	public static LibroDAO INSTANCE = null;
	public static List<Libro> lista = null;
	
	private LibroDAO() {
		lista = new ArrayList<Libro>();
	}
	
	public static synchronized LibroDAO getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new LibroDAO();
		}
		
		return INSTANCE;
	}
	
	@Override
	public boolean insert(Libro libro) {
		boolean resultado = false;
		
		if(libro != null) {
			resultado = lista.add(libro);
		}
		return resultado;
	}

	@Override
	public List<Libro> getAll() {
		
		return lista;
	}

	@Override
	public Libro getById(long id) {
		
		Libro resultado = null;
		
		//foreach
		for (Libro libroIteracion : lista) {
			if(id == libroIteracion.getId()) {
				resultado = libroIteracion;
				break;
			}
		}
		
		return resultado;
	}
	
	public Libro getByTitulo(String titulo) {
		
		Libro resultado = null;
		
		//foreach
		for (Libro libroIteracion : lista) {
			if(titulo == libroIteracion.getTitulo()) {
				resultado = libroIteracion;
				break;
			}
		}
		
		return resultado;
	}

	@Override
	public boolean update(Libro pojo) {
		
		return false;
	}

	@Override
	public boolean delete(long id) {
		
		return false;
	}
	
}
