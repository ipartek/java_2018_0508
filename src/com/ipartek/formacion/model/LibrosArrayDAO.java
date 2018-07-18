package com.ipartek.formacion.model;

import java.util.List;

import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.VideoYoutube;

public class LibrosArrayDAO implements CrudAble<Libro> {
			
		private static List<Libro> lista = null;

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
			//TODO MIRAR COMO LO HAGO MAS TARDE 
			/*
			boolean resul = false;
			Libro literacion=null;
			
			for(int i=0;i<lista.size();i++){
				//Cogemos un libro  
				literacion=lista.get(i);
				if(literacion==libro_modificado.getId()) {
					
				}
			}
				*/
			return false;
		}

		@Override
		public boolean delete(long id) {
			
			return false;
		}

		
		
}