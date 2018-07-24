package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;
import com.ipartek.formacion.pojo.Libro;

/**
 * Clase DAO para gestionar los Libro en un arraylist
 * Usamos patron Singleton
 * @author Curso
 *
 */
public class LibroDAO implements CrudAble<Libro>{

	private static LibroDAO INSTANCE = null;
	private static List<Libro> lista = null;
	
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
	public boolean insert(Libro pojo) {
		boolean resul = false;
		if(pojo != null) {
			resul = lista.add(pojo);
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
		
		//Buscar video a modificar
		for (Libro libroIteracion : lista) {
			if(id == libroIteracion.getId()) { //Libro encontrado
				resul = libroIteracion;
			}
		}
		return resul;
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
	 * Retorna los libros prestados o No prestados
	 * @param isPrestado boolean true => listado de prestados, false => listado No prestados
	 * @return listado de libros
	 */
	public List<Libro> getAllPrestados(boolean isPrestado) {
		ArrayList<Libro> resul = new ArrayList<Libro>();
		for (Libro libro : lista) {
			if(libro.isPrestado() == isPrestado) {
				resul.add(libro);
			}
		}
		
		return resul;
	}
	
	/**
	 * Buscamos libros que coincidan con la busqueda, es ignoreCase, nos sirve cualquier coincidencia no tiene porque ser el titulo exacto
	 * @param busqueda String termino a buscar
	 * @return listado de Libros que coincidan con la busqueda
	 */
	public List<Libro> buscarPorTitulo(String busqueda){
		ArrayList<Libro> resul = new ArrayList<Libro>();
		if(busqueda != null) {
			for (Libro libro : lista) {
				if(libro.getTitulo().toUpperCase().contains(busqueda.toUpperCase())) {
					resul.add(libro);
				}
			}
		}
		
		return resul;
	}

}
