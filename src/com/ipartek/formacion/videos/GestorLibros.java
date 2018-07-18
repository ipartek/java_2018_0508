package com.ipartek.formacion.videos;

import java.util.Scanner;

import com.ipartek.formacion.model.LibrosArrayDAO;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.VideoYoutube;


public class GestorLibros {
	//CONSTANTES
	static private LibrosArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;
	
	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR_PRESTADO = 1;
	static private final int OPCION_LISTAR_NO_PRESTADO = 2;
	static private final int OPCION_BUSCADOR = 3;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		dao = LibrosArrayDAO.getInstance();
		
		cargarLibros();
		

	}
	private static void cargarLibros() {
		Libro nuevo_libro = new Libro(12650, "Nightmares On Wax Boiler Room London DJ Set", "Q692lHFaLVM");
		dao.insert(nuevo_libro);
		
		video = new VideoYoutube(701, "The Skatalites - Rock Fort Rock", "6bLVdKbPHHY");
		dao.insert(video);
		
		
	}

}
