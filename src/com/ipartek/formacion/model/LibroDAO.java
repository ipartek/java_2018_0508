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
	
	/**
	 * Retorna los libros prestados o no prestados
	 * @param isPrestado boolean true -> listado de prestados.  false -> listado de no prestados
	 * @return Listado de libros
	 */
	public List<Libro> getAllPrestados(boolean isPrestado) {
		
		ArrayList<Libro> resultado = new ArrayList<Libro>(); 
		for(Libro libro : lista) {
			if( libro.isPrestado() == isPrestado ) {
				resultado.add(libro);
			}
		}		
		return resultado; 
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
	
	/**
	 * Buscamos libros que coincida el título, es ignoreCase, nos sirve cualquier coincidencia
	 * @param titulo String completo o parcial
	 * @return listado de libros que coincidan con la 'busqueda'
	 */
	public List<Libro> getByTitulo(String busqueda) {
		
		ArrayList<Libro> resultado = new ArrayList<Libro>();
		if ( busqueda != null ) {
			for(Libro libro : lista) {
				if( libro.getTitulo().toLowerCase().contains(busqueda.toLowerCase()) ) {
					resultado.add(libro);
				}
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
		
		boolean resultado = false;
		
		Libro libro = null;
		
		//Buscar libro a eliminar por su id.
		for (int i = 0; i < lista.size(); i++) {
			
			libro = lista.get(i); //Libro sobre el que iteramos
			
			if (id == libro.getId()) { //Libro encontrado.
				resultado = lista.remove(libro);
				break;
			}
		}
		
		return resultado;
	}
	
}
