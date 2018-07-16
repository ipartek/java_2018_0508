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

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		dao = VideoYoutubeArrayDAO.getInstance();

		cargarVideos();
		pintarMenu();

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

		pintarMenu();

	}

	private static void cargarVideos() {
		VideoYoutube video = new VideoYoutube(12650, "Nightmares On Wax Boiler Room London DJ Set", "Q692lHFaLVM");
		dao.insert(video);

		video = new VideoYoutube(701, "The Skatalites - Rock Fort Rock", "6bLVdKbPHHY");
		dao.insert(video);

		video = new VideoYoutube(401, "The sdfad - Rock Fort Rock", "fgfgdf");
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

	}

	public static void add() {

		System.out.print("Introduce los datos del nuevo video");

		long id = 1;
		String titulo = "";
		String codigo = "";
		boolean correcto = false;
		while (!correcto) {
			System.out.print("Titulo (minimo 11 caracteres): ");
			titulo = sc.next();
			if (titulo.length() <= 11) {
				System.out.println("ERROR, El titulo debe tener al menos 11 caracteres");

			} else {
				correcto = true;
			}
		}

		while (!correcto) {
			System.out.print("Codigo: ");
			codigo = sc.next();
			if (codigo.length() < 3) {
				System.out.println("ERROR, El codigo debe ser mayor que 254");

			} else {
				correcto = true;
			}
		}

		// if(254> titulo && titulo.length()==3 )
		// 11caracteres ||->no hace falta ....0-9 - a-A z-Z y _


		
		try {
			
			VideoYoutube newVideo = new VideoYoutube(id, titulo, codigo);
			dao.insert(newVideo);
			pintarMenu();

		} catch (Exception e) {
			System.out.println("ERROR, los datos no son correctos");
			add();
		}

	}

	private static String setAttributeString(String atr) {
		System.out.print(atr + ": ");
		return sc.next();

	}

	private static int setAttributeInt(String atr) {
		System.out.print(atr + ": ");
		return sc.nextInt();

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
