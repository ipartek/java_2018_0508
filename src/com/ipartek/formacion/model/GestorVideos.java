package com.ipartek.formacion.model;

import java.io.IOException;
import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;

public class GestorVideos {

	static private VideoYoutubeArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_ELIMINAR = 3;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(System.in);

		dao = VideoYoutubeArrayDAO.getInstance();

		cargarVideos();

		pintarMenu();

		switch (opcionSeleccionada) {
		case OPCION_LISTAR:
			listar();
			break;

		case OPCION_SALIR:
			salir();
			break;

		default:
			noOption();
			break;
		}

	}

	private static void salir() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("AGUR VENUR, esperamos verte pronto");

	}

	private static void noOption(){
		System.out.println("Lo sentimos No existe esa opcion");
		pintarMenu();

	}

	private static void listar(){

		for (VideoYoutube video : dao.getAll()) {
			System.out.println("    " + video);
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

		pintarMenu();

	}

	private static void cargarVideos() {
		VideoYoutube video = new VideoYoutube(1, "Nightmares On Wax Boiler Room London DJ Set", "Q692lHFaLVM");
		dao.insert(video);

		video = new VideoYoutube(2, "The Skatalites - Rock Fort Rock", "6bLVdKbPHHY");
		dao.insert(video);

	}

	private static void pintarMenu(){

		System.out.println("------------------------------------");
		System.out.println("--          youtube               --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar                     -");
		System.out.println("-    2. Añadir Nuevo               -");
		System.out.println("-    3. Eliminar                   -");
		System.out.println("-                                  -");
		System.out.println("-    0 - salir                     -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.println("Dime una opcion por favor");

		opcionSeleccionada = sc.nextInt();
		

	}

}