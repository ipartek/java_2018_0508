package com.ipartek.formacion.videos;

//TODO el titulo tiene que tener al menos 3 caracteres y como mucho 254.
//TOdo el codigo tiene que tener 11 caracteres alfanumericos de el 0 al 9 y de la A a la Z y tambien valen minusculas
import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;
import com.sun.corba.se.impl.io.TypeMismatchException;

public class VideoClub {
	static private VideoYoutubeArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_ELIMINAR = 3;
	static private final int OPCION_SALIR = 4;

	static int cont = 1;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		dao = VideoYoutubeArrayDAO.getInstance();
		cargarVideo();
		pintarMenu();

	}

	private static void cargarVideo() {

		dao.insert(new VideoYoutube(0, "Manifiesto", "3A2KtOXRpOo"));
		dao.insert(new VideoYoutube(1, "Vivir para contarlo", "brwIP1wI-FA"));
		dao.insert(new VideoYoutube(2, "Para los mios", "fp47VcTlwWQ"));
		dao.insert(new VideoYoutube(3, "Paquito el chocolatero", "3A2KtOXRpOo"));
		dao.insert(new VideoYoutube(4, "Marijaia", "fp67VcT1wWQ"));
		cont = dao.getAll().size();

	}

	private static void pintarMenu() {

		System.out.println("----------------------------------");
		System.out.println("--------------youtube-------------");
		System.out.println("----------------------------------");
		System.out.println("    1.Listar                      ");
		System.out.println("    2.Añadir                      ");
		System.out.println("    3.Eliminar                    ");
		System.out.println("    4.Salir                       ");
		System.out.println("----------------------------------");
		System.out.println("Elige una opcion");
		try {
			opcionSeleccionada = sc.nextInt();
		} catch (TypeMismatchException e) {
			System.out.println("Lo sentimos pero debe introducir un numero de la lista");
			sc.next();
			pintarMenu();

		} catch (Exception e) {
			System.out.println("Lo siento pero no has introducido una opcion correcta");
			System.out.println("Introduzca una numero entre 1 y 4 por favor");
			sc.next();
			pintarMenu();
		}
		sc.reset();
		switch (opcionSeleccionada) {
		case OPCION_LISTAR:
			listarVideos();
			pintarMenu();
			break;

		case OPCION_ANADIR:
			añadirVideo();
			pintarMenu();
			break;

		case OPCION_ELIMINAR:
			eliminarVideo();
			pintarMenu();
			break;

		case OPCION_SALIR:
			System.exit(0);
			break;

		default:
			System.out.println("Lo siento pero no has introducido una opcion correcta");
			System.out.println("Introduzca una numero entre 1 y 4 por favor");
			pintarMenu();
			break;
		}
	}

	private static void eliminarVideo() {
		int codElim = 0;
		VideoYoutube videoElim;
		listarVideos();
		System.out.println("Introduce el id del video que desea  eliminar");
		try {

			codElim = sc.nextInt();

		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("Lo sentimos pero debe introducir un numero entre 0");

		} catch (TypeMismatchException e) {

			System.out.println("Lo sentimos pero debe introducir un numero");

		} catch (Exception e) {

			System.out.println("Lo sentimos pero ha ocurrido un error, por favor intentelo de nuevo");
			pintarMenu();
		}
		sc.nextLine();
		try {
			dao.delete(codElim);
		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("Lo sentimos pero debe introducir un numero entre 0 y ");

		}
		System.out.println("El video seleccionado ha sido eliminado");
		cont++;

	}

	private static void listarVideos() {
		for (int i = 0; i < dao.getAll().size(); i++) {
			System.out.println("." + dao.getById(i).toString());
		}

	}

	private static void añadirVideo() {
		String cod = "";
		String tit = "";

		System.out.println("Introduce el codigo del video");
		try {

			cod = sc.next();
			if (VideoClub.controlarCodigo(cod)) {
				System.out.println("Introduzca el titulo del video");
				tit = sc.next();
				if (VideoClub.controlarTitulo(tit)) {
					cont++;
					dao.insert(new VideoYoutube(cont, tit, cod));

					System.out.println("Video añadido a la lista.");
				}
			}

		} catch (TypeMismatchException e) {

			System.out.println("Lo sentimos pero debe introducir un numero");

		} catch (Exception e) {

			System.out.println("Lo sentimos pero ha ocurrido un error, por favor intentelo de nuevo");

			pintarMenu();
		}

		pintarMenu();

	}

	private static boolean controlarTitulo(String tit) {
		boolean result = false;
		if (tit.length() >= 3 || tit.length() <= 254) {
			result = true;
		}
		return result;
	}

	private static boolean controlarCodigo(String codigo) {
		boolean result = false;
		try {

			if (codigo.length() == 11) {
				for (int i = 0; i < codigo.length(); i++) {
					if (codigo.charAt(i) >= 48 || codigo.charAt(i) <= 122) {
						result = true;
					} else {
						System.out.println("El codigo contiene caracteres no permitidos");

					}

				}
			} else {
				System.out.println("Debes introducir un codigo de 11 caracteres");
			}

		} catch (TypeMismatchException e) {

			System.out.println("Lo sentimos pero debe introducir un numero");

		} catch (Exception e) {

			System.out.println("Lo sentimos pero ha ocurrido un error, por favor intentelo de nuevo");

		}
		return result;
	}
}