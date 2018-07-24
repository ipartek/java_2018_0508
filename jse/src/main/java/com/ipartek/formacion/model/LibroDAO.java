package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.ejercicios.interfaces.CrudAble;

import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.Youtube;



public class LibroDAO implements CrudAble<Libro> {
	
	private static LibroDAO INSTANCE = null;
	private static  List<Libro> Lista = null;
	private static long id = 1;

	
	private LibroDAO() {
		Lista = new ArrayList<Libro>();
	}
	
	public static synchronized LibroDAO getIntance() {
		if (INSTANCE == null) {
			INSTANCE = new LibroDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Libro lib) {
		boolean result = false;
		if (lib != null) {
			lib.setId(id);
			result = Lista.add(lib);
			id++;
			
		}
		return result;
	}

	@Override
	public List<Libro> getAll() {
		return Lista;
	}

	@Override
	public Libro getByID(long id) {
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
	/*public List<Libro> getAllPrestados( boolean isPrestados) {
		ArrayList<Libro> resul  = new ArrayList<Libro>();
		for(Libro libro : libros) {
			if(libro.isPrestado()== isPrestados) {
				resul.add(libro);
			}
		}
		return resul;
	}*/
	/**
	 * Lisbros que coincida el titulo, es ignoreCase, nos sirve cualquier coincidencia
	 * @param titulo String termino a buscar
	 * @return listado de libros que coincidan con la busqueda
	 */
	/*public List<Libro> buscarPorTitulo(String busqueda){
		
		ArrayList<Libro> resul  = new ArrayList<Libro>();
		if(busqueda != null) {
			for(Libro libro : libros) {
				if(libro.getTitulo().toLowerCase().contains(busqueda.toLowerCase())) {
					resul.add(libro);
				}
			
		}
		
		return resul;*/
	
}
	
	
	
