package com.ipartek.formacion.videos;

import java.util.Scanner;

import com.ipartek.formacion.model.LibrosArrayDAO;


public class GestorLibros {
	//CONSTANTES
	static private LibrosArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;
	
	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_ELIMINAR = 3;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		dao = LibrosArrayDAO.getInstance();
		
		cargarLibros();
		

	}

}
