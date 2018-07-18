package com.ipartek.formacion.ejercicios.video;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.Youtube;

public class GestorVideo {

	private static Scanner sr = new Scanner(System.in);

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_ELIMINAR = 3;
	
	private static VideoYoutubeArrayDAO dao = VideoYoutubeArrayDAO.getIntance();

	public static void main(String[] args) {

		int opcion = 0;

		do {

			try {
				mostrarMenu();

				opcion = sr.nextInt();
				sr.nextLine();

				switch (opcion) {
				case OPCION_LISTAR:

					List<Youtube> videos = dao.getAll();
					mostrarLista(videos);
					break;

				case OPCION_ANADIR:

					Youtube nuevoVideo = crearNuevoYoutube();
					dao.insert(nuevoVideo);
					break;

				case OPCION_ELIMINAR:

					borrarVideo();
					break;

				case OPCION_SALIR:

					System.out.println("Gracias por tu visita a nuestra aplicacion ");
					break;

				default:
					System.out.println("Has ingresado un numero ERRONEO");
				}
			} catch (InputMismatchException ex) {
				System.out.println("No has introducido un numero valido");
			}

		} while (opcion != OPCION_SALIR);

	}

	private static void borrarVideo() {
		long id;
		boolean borrado = false;
		do {
			System.out.println("Ingrese por favor el ID del video que quieres borrar");
			id = sr.nextLong();
			borrado = dao.delete(id);
			if (borrado == false) {
				System.out.println("El Id ingresado es el incorrecto ");
			} else {
				System.out.println(" Borrado el Id ingresado ");
			}
		} while (borrado != true);

	}

	private static void mostrarMenu() {
		System.out.println("Selecciona una opci�n:");
		System.out.println("1 - Listar");
		System.out.println("2 - Anadir");
		System.out.println("3 - Eliminar");
		System.out.println("0 - Salir");

	}

	private static void mostrarLista(List<Youtube> videos) {
		if (videos.size() == 0) {
			System.out.println("No hay caciones ");
		} else {
			for (int i = 0; i < videos.size(); i++) {
				Youtube vid = videos.get(i);
				System.out.println(vid.toString());
			}

		}

	}

	private static Youtube crearNuevoYoutube() {

		String titulo = "";
		boolean tituloCorrecto = false;

		do {
			System.out.println("Ingresa un titulo:");
			titulo = sr.nextLine();

			if (titulo.length() > 3 && titulo.length() < 255) {
				tituloCorrecto = true;
			} else {
				System.out.println("El titulo tiene que ser entre 3 y 255 caracteres ");
			}
		} while (tituloCorrecto != true);

		String codigo = "";
		boolean codigoCorrecto = false;

		do {
			System.out.println("Ingrese un codigo por favor : ");
			codigo = sr.nextLine();
			if (codigo.length() == 11) {
				codigoCorrecto = true;
			} else {
				System.out.println("El codigo tiene que ser de 11 caracters ");
			}
		} while (codigoCorrecto != true);

		Youtube nuevoVideo = new Youtube(titulo, codigo);

		return nuevoVideo;

	}

}
