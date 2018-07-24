package com.ipartek.formacion.videos;

import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

public class VideoClub {

	static VideoYoutubeArrayDAO dao;

	static private final int OPCION_MINIMA = 0;
	static private final int OPCION_MAXIMA = 4;
	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ELIMINAR = 2;
	static private final int OPCION_MODIFICAR = 3;
	static private final int OPCION_ANADIR = 4;
	static private final int VALOR_CHIVATO = -1;
	static private int ULTIMO_ID = 0;
	static private final int MAX_TITULO = 254;
	static private final int MIN_TITULO = 3;
	static private final int TAMANO_CODIGO = 11;

	private static Scanner sc = null;

	public static void main(String[] args) {

		try {

			sc = new Scanner(System.in);

			dao = VideoYoutubeArrayDAO.getInstance();

			cargarVideos();

			ULTIMO_ID = dao.getAll().size() + 1;

			int opc = VALOR_CHIVATO;

			while (opc != OPCION_SALIR) {

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
					System.out.println("Adios!!!! Vuelva pronto.");
					break;
				default:

					break;
				}

			}
		} catch (Exception e) {

			System.out.println("Disculpen las molestias pero hemos tenido un problema tecnico.");

		} finally {

			if (sc != null) {
				sc.close();
			}
			dao = null;
		}
	}

	/**
	 * Ya que no tenemos una BBDD, cargamos en memoria unos videos.
	 */
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

		System.out.println("***************************************");
		System.out.println("----------------Youtube----------------");
		System.out.println("***************************************");
		System.out.println("-------------1. Listar-----------------");
		System.out.println("***************************************");
		System.out.println("-------------2. Eliminar---------------");
		System.out.println("***************************************");
		System.out.println("-------------3. Modificar--------------");
		System.out.println("***************************************");
		System.out.println("-------------4. Alta-------------------");
		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("-------------0. Salir------------------");
		System.out.println("***************************************");

	}

	/**
	 * Funcion que pinta el menu, trata el numero/valor que nos introduzca el
	 * usuario. Se tiene en cuenta, que nos introduzca un entero, se trata la
	 * excepcion si nos introduce
	 * 
	 * @return
	 */
	private static int opcion() {

		pintarMenu();

		int opc = VALOR_CHIVATO;
		try {
			do {

				System.out.println("Elige una opcion:");
				opc = sc.nextInt();
				sc.nextLine();

				if (opc > OPCION_MAXIMA || opc < OPCION_MINIMA) {
					System.out.println("No existe la opcion, vuelve a probar.");
				}

			} while (opc > OPCION_MAXIMA || opc < OPCION_MINIMA);

		} catch (Exception e) {
			System.out.println("OPCION NO VALIDA, introduce numeros por favor.");
			sc.nextLine();
		}
		return opc;
	}

	private static void listarVideos() {

		if (dao.getAll().size() == 0) {
			System.out.println("No hay musica :( \n Empieza a a�adir.");
		} else {
			System.out.println(dao.getAll());
		}

	}

	private static void eliminarVideo() {

		long id = pedirID("modificar");

		if (id == VALOR_CHIVATO || id >= ULTIMO_ID) {
			System.out.println("El video que quieres eliminar no existe.");
		} else {
			System.out.println((dao.delete(id) == true) ? "El video se ha borrado correctamente."
					: "UPSS, no se ha podido borrar el video.");
		}
	}

	private static void modficarVideo() {

		long id = pedirID("modificar");

		VideoYoutube video = dao.getById(id);

		if (video != null) {
			int opc = VALOR_CHIVATO;
			do {

				try {
					System.out.println("Que quieres modificar:\n1.-Titulo:" + video.getTitulo() + "\n2.-Codigo:"
							+ video.getCodigo());
					opc = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Uppsss, Tienes que meter un numero, sin letras.");
					opc = (VALOR_CHIVATO);
					sc.nextLine();
				}

			} while (opc == VALOR_CHIVATO);

			switch (opc) {
			case 1:
				String titulo = "";
				while (titulo == "") {
					System.out.println("Escribe el nuevo titulo:");
					titulo = sc.nextLine();
					titulo = comprobarTitulo(titulo);
				}
				video.setTitulo(titulo);
				break;

			case 2:
				String codigo = "";
				while (codigo == "") {
					System.out.println("Escribe el nuevo codigo:");
					codigo = sc.nextLine();
					codigo = comprobarCodigo(codigo);
				}
				video.setTitulo(codigo);
				break;
			default:
				System.out.println("No quieres modificar nada.");
				break;
			}

			dao.update(video);
		} else {
			System.out.println("El video no existe.");
		}

	}

	private static void altaVideo() {

		VideoYoutube video = new VideoYoutube();

		video.setId(ULTIMO_ID);

		String titulo = "";

		while (titulo == "") {
			System.out.println("Introduce el titulo de la nueva cancion::");
			titulo = sc.nextLine();
			titulo = comprobarTitulo(titulo);
		}

		video.setTitulo(titulo);

		String codigo = "";

		while (codigo == "") {
			System.out.println("Introduce el codigo de la nueva cancion::");
			codigo = sc.nextLine();
			codigo = comprobarCodigo(codigo);
		}

		video.setCodigo(codigo);

		System.out.println((dao.insert(video) == true) ? "El video se ha a�adido correctamente."
				: "UPSS, no se ha podido a�adir el video.");

		ULTIMO_ID = dao.getAll().size() + 1;
	}

	/**
	 * comprueba el titulo
	 * 
	 * @param titulo
	 * @return devuelve cadena vacia si no cumple el limite de 3 y 254
	 */
	private static String comprobarTitulo(String titulo) {
		if (titulo.trim().length() >= MAX_TITULO || titulo.trim().length() <= MIN_TITULO) {
			System.out.println("El nombre del titulo tiene que estar entre 3 y 254 caracteres.");
			titulo = "";
		}
		return titulo;
	}

	/**
	 * comprueba el codigo
	 * 
	 * @param codigo
	 * @return devuelve cadena vacia si no cumple el tama�o de 11
	 */
	private static String comprobarCodigo(String codigo) {
		if (codigo.trim().length() != TAMANO_CODIGO) {
			System.out.println("El codigo tiene que tener 11 digitos.");
			codigo = "";
		}
		return codigo;
	}

	/**
	 * comprueba que el id sea un numero, coge la excepcion
	 * 
	 * @param metodo para reutilizarlo en borrar y modificar
	 * @return el id en formato long
	 */
	private static long pedirID(String metodo) {
		long id = VALOR_CHIVATO;
		do {

			try {
				System.out.println("Introduce el ID de la cancion a " + metodo);
				id = (long) sc.nextInt();
			} catch (Exception e) {
				System.out.println("Uppsss, Tienes que meter un numero, sin letras.");
				id = VALOR_CHIVATO;
				sc.nextLine();
			}

		} while (id == VALOR_CHIVATO);

		return id;
	}
}
