package com.ipartek.formacion.videos;

import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

public class VideoClub {

	static VideoYoutubeArrayDAO dao;

	private static final int OPC_MINIMA = 0;
	private static final int OPC_MAXIMA = 4;
	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ELIMINAR = 2;
	static private final int OPCION_MODIFICAR = 3;
	static private final int OPCION_ANADIR = 4;

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		dao = VideoYoutubeArrayDAO.getInstance();

		cargarVideos();

		int opc = -1;

		while (opc!=0) {
			opc = opcion();
			switch (opc) {
			case OPCION_LISTAR:
				listarVideos();
				break;

			case OPCION_ELIMINAR:
				eliminarVideo();
				break;

			case OPCION_MODIFICAR:
				modficarVideo();
				break;

			case OPCION_ANADIR:
				altaVideo();
				break;

			case OPCION_SALIR:
			default:
				System.out.println("Adios!!!!");
				break;
			}

		}
		
		sc.close();
	}

	private static void cargarVideos() {

		VideoYoutube video = new VideoYoutube(1, "yuFI5KSPAt4",
				"Red Hot Chili Peppers - Snow (Hey Oh) (Official Music Video)");
		dao.insert(video);
		dao.insert(new VideoYoutube(2, "hTWKbfoikeg", "Nirvana - Smells Like Teen Spirit"));
		dao.insert(new VideoYoutube(3, "iywaBOMvYLI", "System Of A Down - Toxicity"));
		dao.insert(new VideoYoutube(4, "1V_xRb0x9aw", "Gorillaz - Clint Eastwood (Official Video)"));
		dao.insert(new VideoYoutube(5, "LPHJLB1ZeAc", "BODY COUNT - Raining In Blood (OFFICIAL VIDEO)"));

	}

	private static void pintarMenu() {

		System.out.println("---------------------------------------");
		System.out.println("----------------Youtube----------------");
		System.out.println("---------------------------------------");
		System.out.println("-------------1. Listar-----------------");
		System.out.println("---------------------------------------");
		System.out.println("-------------2. Eliminar---------------");
		System.out.println("---------------------------------------");
		System.out.println("-------------3. Modificar--------------");
		System.out.println("---------------------------------------");
		System.out.println("-------------4. Alta-------------------");
		System.out.println("---------------------------------------");
		System.out.println("-------------0. Salir------------------");
		System.out.println("---------------------------------------");
	}

	private static int opcion() {
		
		pintarMenu();
		
		int opc = -1;
		try {
			do {

				System.out.println("Elige una opcion:");
				opc = sc.nextInt();
				sc.nextLine();

				if (opc > OPC_MAXIMA || opc < OPC_MINIMA) {
					System.out.println("No existe la opcion, vuelve a probar.");
				}

			} while (opc > OPC_MAXIMA || opc < OPC_MINIMA);

		} catch (Exception e) {
			System.out.println("OPCION NO VALIDA, introduce numeros por favor.");
			sc.nextLine();
		}
		return opc;
	}

	private static void listarVideos() {

		System.out.println(dao.getAll());

	}

	private static void eliminarVideo() {

		sc.nextLine();
		long id;

		System.out.println("Dime el id de una cancion para borrarla...");
		id = (long) sc.nextInt();

		dao.delete(id);

		listarVideos();

	}

	private static void modficarVideo() {

		sc.nextLine();

		System.out.println("Dime el video a modificar:");
		long id = (long) sc.nextInt();

		VideoYoutube video = dao.getById(id);

		System.out
				.println("Que quieres modificar:\n1.-Titulo:" + video.getTitulo() + "\n2.-Codigo:" + video.getCodigo());
		int opc = sc.nextInt();

		switch (opc) {
		case 1:
			System.out.println("Escribe el nuevo titulo:");
			String titulo = sc.nextLine();
			video.setTitulo(titulo);
			break;

		case 2:
			System.out.println("Escribe el nuevo codigo:");
			String codigo = sc.nextLine();
			video.setTitulo(codigo);
			break;
		default:
			System.out.println("No quieres modificar nada.");
			break;
		}

		dao.update(video);

		listarVideos();

	}

	private static void altaVideo() {

		sc.nextLine();
		VideoYoutube video = new VideoYoutube();

		System.out.println("Introduce el ID de la nueva cancion:");
		video.setId((long) sc.nextInt());

		sc.nextLine();
		
		System.out.println("Introduce el titulo de la nueva cancion:");
		video.setTitulo(sc.nextLine());

		System.out.println("Introduce el codigo de la nueva cancion:");
		video.setCodigo(sc.nextLine());

		dao.insert(video);

		listarVideos();
	}
}
