package com.ipartek.formacion.videos;

import java.util.*;

import com.ipartek.formacion.model.LibroArrayDAO;
import com.ipartek.formacion.pojo.Libro;


public class GestorLibros {

	static private LibroArrayDAO dao;
	static Scanner sc = null;
	static private long idCounter = 1;

	
	public static void main(String[] args) {
		
		CargarVideos();
		
		listar();
		
		
	}

	
	private static void CargarVideos() {
		
		Libro libro = new Libro();
		
		try {
			libro = new Libro(idCounter, "9788416001460", "FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA", "LIBROS DEL K.O");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.insert(libro);
		idCounter++;
		
		try {
			libro = new Libro(idCounter, "9788467575057", "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA SAVIA ED 2015", "EDICIONES SM");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.insert(libro);
		idCounter++;

		try {
			libro = new Libro(idCounter, "9788467575071", "MATEMÁTICAS TRIMESTRAL SAVIA-15", "EDICIONES SM");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.insert(libro);
		idCounter++;

		try {
			libro = new Libro(idCounter, "9788461716098", "LA VOZ DE TU ALMA", "AUTOR-EDITOR");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.insert(libro);
		idCounter++;

		try {
			libro = new Libro(idCounter, "9788467569957", "LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES SAVIA CASTELLA NO ED 2014", "EDICIONES SM");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.insert(libro);
		idCounter++;

		try {
			libro = new Libro(idCounter, "9781380013835", "NEW HIGH FIVE 1 PUPILS BOOK PACK", "MACMILLAN CHILDRENS BOOKS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.insert(libro);
		idCounter++;


		try {
			libro = new Libro(idCounter, "9781380011718", "NEW HIGH FIVE 3 PUPILS BOOK", "MACMILLAN CHILDRENS BOOKS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.insert(libro);
		idCounter++;

		
	}
	
	private static void listar() {
		
		for ( Libro libro : dao.getAll() ) {
			System.out.println("    " + libro.toString());
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
				
	}

	
	
}
