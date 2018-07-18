package com.ipartek.formacion.model;

import java.util.*;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.VideoYoutube;

public class LibroArrayDAO implements CrudAble<Libro>{

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
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Libro getById(long id) {
		Libro resul = null;
		//foreach
		for (Libro libroIteracion : lista) {
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
		boolean resul = false;
		
		Libro lIteracion = null;
		
		//buscar video a eliminar
		for (int i = 0; i < lista.size(); i++) {
			
			lIteracion = lista.get(i);   //libro sobre el que iteramos
			
			if ( id == lIteracion.getId() ) {    // libro encontrado
				resul = lista.remove(lIteracion);
				break;
			}
		}
		
		return resul;
	}

}