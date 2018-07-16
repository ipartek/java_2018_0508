package com.ipartek.formacion.videos;

//import java.lang.reflect.Method;
import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorVideos {

	static private VideoYoutubeArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_ELIMINAR = 3;
	static private final int ID_MIN_VALUE= 1;
	static private int idCounter = ID_MIN_VALUE;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		dao = VideoYoutubeArrayDAO.getInstance();

		cargarVideos();
		pintarMenu();

		sc.close();
	}

	private static void salir() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("AGUR VENUR, esperamos verte pronto");

	}

	private static void noOption() {
		System.out.println("Lo sentimos No existe esa opcion");
		pintarMenu();

	}

	private static void listar() {

		for (VideoYoutube video : dao.getAll()) {
			System.out.println("    " + video);
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		do {
			pintarMenu();
		} while (opcionSeleccionada>0 && opcionSeleccionada<4);

		

	}

	private static void cargarVideos() {
		VideoYoutube video = new VideoYoutube(idCounter++,"Nightmares On Wax Boiler Room London DJ Set", "Q692lHFaLVM");
		dao.insert(video);

		video = new VideoYoutube(idCounter++,"The Skatalites - Rock Fort Rock", "6bLVdKbPHHY");
		dao.insert(video);

		video = new VideoYoutube(idCounter++,"The sdfad - Rock Fort Rock", "fgfgdf");
		dao.insert(video);

	}

	private static void pintarMenu() {

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
		System.out.print("Dime una opcion por favor: ");

		opcionSeleccionada = sc.nextInt();
		
		switch (opcionSeleccionada) {
		case OPCION_LISTAR:
			listar();
			break;

		case OPCION_ANADIR:
			add();
			break;

		case OPCION_ELIMINAR:
			borrarVideo();
			break;

		case OPCION_SALIR:
			salir();
			break;

		default:
			noOption();
			break;
		}

	}

	public static void add() {

		System.out.println("Introduce los datos del nuevo video");
		System.out.println("-----------------------------------");
		String titulo = "";
		String codigo = "";
		boolean correcto = false;
		while (!correcto) {
			System.out.print("Titulo (entre 3 y 254 caracteres): ");
			titulo = sc.next();
			if (titulo.length() > 3 && titulo.length() < 254) {
				correcto = true;

			} else {
				System.out.println("ERROR, El titulo debe contener entre 3 y 254 caracteres");

			}
		}
		correcto =false;

		while (!correcto) {
			System.out.print("Codigo (minimo 11 caracteres): ");
			codigo = sc.next();
			if (codigo.length() < 11) {
				System.out.println("ERROR, El codigo debe tener al menos 11 caracteres");

			} else {
				correcto = true;
			}
		}

		try {

			VideoYoutube newVideo = new VideoYoutube(idCounter++,titulo, codigo);
			dao.insert(newVideo);
			pintarMenu();

		} catch (Exception e) {
			System.out.println("ERROR, los datos no son correctos");
			idCounter--;
			add();
		}

	}

	public static void borrarVideo() {

		System.out.print("Introduce un id: ");
		long id = sc.nextLong();
		try {
			dao.delete(id);
		} catch (Exception e) {
			System.out.println("ERROR, los datos introducidos no son correctos");
			borrarVideo();

			/*
			 * PRUEBAS FUNCION ERROR try { Class<?> classRef =
			 * Class.forName("com.ipartek.formacion.videos"); // Object instance =
			 * classRef.newInstance(); Method method = //
			 * classRef.getDeclaredMethod("validate" + "error"); error(e, method, instance);
			 * error(e, classRef.getDeclaredMethod("validate" + "error"),
			 * classRef.newInstance());
			 * 
			 * } catch (Exception e2) { // TODO: handle exception }
			 */

		}
		pintarMenu();

	}

	/*
	 * private static void error(Exception e, Method method, Object instance) { //
	 * TODO Auto-generated method stub try { method.invoke(instance);
	 * System.out.println("ERROR"); } catch (Exception e2) { // TODO: handle
	 * exception }
	 * 
	 * }
	 */

}
