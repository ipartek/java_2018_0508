package com.ipartek.formacion.pojo;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.LibrosArrayDAO;

public class pruebasLibro {
	
	private static LibrosArrayDAO INSTANCE = null;
	private static List<Libro> lista = null;
	
	//PATRON SINGLETON
		//Constructor Privado para que nadie pueda hacer un  new
		private void LibrosArrayDAO() {
			lista = new ArrayList<Libro>();
		}

	public static void main(String[] args) {
		Libro nuevo_libro = new Libro(123456, "9788416001460","aaaaaFARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA", "LIBROS DEL K.O", true);
		lista.add(nuevo_libro);	
		
		System.out.print(dao.getAll());
	}

}
