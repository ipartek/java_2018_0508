package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.VideoYoutube;

public class LibrosArrayDAO implements CrudAble<Libro> {
		//Atributos estatictos
		private static LibrosArrayDAO INSTANCE = null;
		private static List<Libro> lista = null;
		
		private LibrosArrayDAO() {
			lista = new ArrayList<Libro>();
		}

		public static synchronized LibrosArrayDAO getInstance() {
			if (INSTANCE == null) {
				INSTANCE = new LibrosArrayDAO();
			}
			return INSTANCE;
		}
		
		
		//Todo lo que hereda de CrudAble
		
		@Override
		public boolean insert(Libro nuevo_libro) {
			boolean resul = false;
			if ( nuevo_libro != null ) {
				resul = lista.add(nuevo_libro);			
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
			//foreach
			for (Libro libroIteracion : lista) {
				if ( id == libroIteracion.getId() ) { //Si coinciden los ID
					resul = libroIteracion;//Guardamos resultado
					break;
				}
			}
			return resul;
		}

		@Override
		public boolean update(Libro libro_modificado) {
			boolean resul = false;
			Libro lIteracion = null;
			//buscar libro a eliminar
			for (int i = 0; i < lista.size(); i++) {
				
				lIteracion = lista.get(i);   //libro sobre el que iteramos
				
				if ( libro_modificado.getId() == lIteracion.getId() ) {    // libro encontrado
					lista.set(i, libro_modificado);
					resul = true;
				}
			}
			return resul;
		}

		@Override
		public boolean delete(long id) {
			boolean resul = false;
			Libro lIteracion = null;
			
			//buscar libro a eliminar
			for (int i = 0; i < lista.size(); i++) {
				
				lIteracion = lista.get(i);   //video sobre el que iteramos
				
				if ( id == lIteracion.getId() ) {    // video encontrado
					resul = lista.remove(lIteracion);
					break;
				}
			}
			return false;
		}

		
		
}