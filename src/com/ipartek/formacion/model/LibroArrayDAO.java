package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Libro;

public class LibroArrayDAO implements CrudAble<Libro> {

	private static LibroArrayDAO INSTANCE = null;
	private List<Libro> libros; 
	
	private LibroArrayDAO() {
		libros = new ArrayList<Libro>();
	}
	
	public static synchronized LibroArrayDAO getInstance() {
		
		if ( INSTANCE == null ) {
			INSTANCE = new LibroArrayDAO();
		}
		
		return INSTANCE;
	}
	
	
	@Override
	public boolean insert(Libro pojo) {
		boolean resul = false;
		if( pojo != null ) {
			resul = libros.add(pojo);
		}
		return resul;
	}

	@Override
	public List<Libro> getAll() {
		// TODO Auto-generated method stub
		return null;
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
	
	/**
	 * Retorna los libros prestados o No prestados 
	 * @param isPrestado boolean true => listado prestados, false => listado No prestados
	 * @return listado de libros
	 */
	public List<Libro> getAllPrestados( boolean isPrestado ) {		
		ArrayList<Libro> resul = new ArrayList<Libro>(); 
		for(Libro libro : libros) {
			if( libro.isPrestado() == isPrestado ) {
				resul.add(libro);
			}
		}		
		return resul; 
	}
	
	/**
	 * Buscamos Libros que coincida el titulo, es ignoreCase, nos sirve cualquier coincidencia no tiene porque ser el titulo exacto
	 * @param busqueda String termino a buscar
	 * @return listado de Libros que coincidan con la 'busqueda'
	 */
	public List<Libro> buscarPorTitulo( String busqueda ){
		ArrayList<Libro> resul = new ArrayList<Libro>();
		if ( busqueda != null ) {
			for(Libro libro : libros) {
				if( libro.getTitulo().toLowerCase().contains(busqueda.toLowerCase()) ) {
					resul.add(libro);
				}
			}		
		}
		return resul;
	}
	
	

}
