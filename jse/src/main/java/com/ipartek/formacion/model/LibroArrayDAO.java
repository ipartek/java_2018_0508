package com.ipartek.formacion.model;

import java.util.*;
import com.ipartek.formacion.pojo.Libro;

public class LibroArrayDAO implements CrudAble<Libro>{

	private static LibroArrayDAO INSTANCE = null;
	private List<Libro> libros = null;
	
	private LibroArrayDAO() {
		libros = new ArrayList<Libro>();
	}

	public static synchronized LibroArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new LibroArrayDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Libro pojo) {
		boolean resul = false;
		if (pojo != null) {
			resul = libros.add(pojo);
		}
		return resul;
	}

	@Override
	public List<Libro> getAll() {
		// TODO Auto-generated method stub
		return libros;
	}

	@Override
	public Libro getById(long id) {
		Libro resul = null;
		//foreach
		for (Libro libroIteracion : libros) {
			if ( id == libroIteracion.getId() ) {
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
		if ( libroUpdate != null ) {
			//Iterator		
			Iterator<Libro> it = libros.iterator();
			while( it.hasNext() ) {
				libroIteracion = it.next();
				if ( libroIteracion.getId() == libroUpdate.getId() ) {
					libros.set(i, libroUpdate);
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
		
		//buscar video a eliminar
		for (int i = 0; i < libros.size(); i++) {
			
			lIteracion = libros.get(i);   //libro sobre el que iteramos
			
			if ( id == lIteracion.getId() ) {    // libro encontrado
				resul = libros.remove(lIteracion);
				break;
			}
		}
		
		return resul;
	}
/**
 * retorna los libros prestados o no prestados
 * @param isPrestado boolean true => lista prestados
 * @return listado libros
 */
	public List<Libro> getAllPrestados(boolean isPrestado) {

		ArrayList<Libro> resul = new ArrayList<Libro>();
		for (Libro libro : libros) {
			if (libro.isPrestado() == isPrestado ) {
				resul.add(libro);
			}
		}
		
		return resul;
	}
/**
 * Buscamos libros que contengan titulo
 * @param titulo String termino a buscar
 * @return listado de Libros que coincidan con la busqueda
 */
	public List<Libro> buscarPorTitulo (String busqueda) {	
		ArrayList<Libro> resul = new ArrayList<Libro>();
		if (busqueda != null) {
			for (Libro libro : libros) {
				if (libro.getTitulo().toLowerCase().contains(busqueda.toLowerCase()) ) {
					resul.add(libro);
				}
			}
		}
		return null;
	}
	
}