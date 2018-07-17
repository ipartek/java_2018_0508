package com.ipartek.formacion.videos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.ipartek.formacion.model.VideoYoutubeArrayDao;
import com.ipartek.formacion.pojo.videoYoutube;

public class GestorVideos {
	// La declaracion se puede hacer aqui
	static videoYoutube[] videos;
	static videoYoutube[] videoB;
	static VideoYoutubeArrayDao dao;
	int contador = 0;
	static boolean contador2;

	public static void main(String[] args) throws Exception {
		// La inicializacion es mas correcta hacerla aqui
		videos = new videoYoutube[5];
		videoB = new videoYoutube[1];
		contador2 = false;
		cargarMenu();
	}

	private static void pintarMenu() throws Exception {

		int opcion;
		System.out.println("-----------------------");
		System.out.println("-------Youtube---------");
		System.out.println("-------Opciones--------");
		System.out.println("------1: Listar--------");
		System.out.println("------2: Añadirr--------");
		System.out.println("------3: Eliminar------");
		System.out.println("------4: salir------");
		System.out.println("------Seleccione una opcion------");
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			opcion = Integer.parseInt(br.readLine());

			dao = VideoYoutubeArrayDao.getInstance();
			// quito las opciones para ser llamadas desde una funcion
			opcionesMenu(opcion);

		} catch (Exception e) {
			System.out.println("Opcion incorrecta");
			pintarMenu();
		}

	}

	private static void cargarMenu() throws Exception {

		pintarMenu();
		cargarCanciones();
	}

	private static void Anadir() throws Exception {

		char agregarMas;
		long id = 0;
		String cancion;
		String codigo = "";

		do {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("------Opcion añadir------");
			System.out.println(
					"------Introduzca el nombre de la cancion de mas de 3 caracteres y menos de 256 caracteres------");
			cancion = br.readLine();

			if (!comprobarTitulo(cancion)) {
				try {
					System.out.println("Ha introducido un titulo de menos de 3 caracteres o mas de 256 caracteres");
					System.out.println("Vuelva a introducir nuevamente el titulo de la cancion");
					cancion = br.readLine();
					if (!comprobarTitulo(cancion)) {
						System.out.println("Titulo introducido incorrectamente , comenzamos de nuevo");
						Anadir();
					}
				} catch (Exception e) {
					try {
						System.out.println("Comenzamos de nuevo...");
						Anadir();
					} catch (Exception e2) {
						System.out.println("ha vuelto a introducir mal el titulo de la cancion");
					}

				}
			}

			do {
				System.out.println("------Introduzca el codigo de la cancion------");
				codigo = br.readLine();
			} while (comprobarCodigo(codigo));

			System.out.println("Ha introducido un codigo incorrecto");

			System.out.println("------ERROR.Introduzca el codigo de la cancion de 11 caracteres------");
			codigo = br.readLine();

			comprobarCodigo(codigo);
			id = dao.getAll().size();
			id++;
			videoYoutube test1 = new videoYoutube(id, cancion, codigo);
			dao.insert(test1);

			System.out.println("------Quiere aÃ±adir otra cancion------");
			agregarMas = (char) br.read();

		} while (agregarMas == 'S' || agregarMas == 's');
		if (agregarMas != 'S' || agregarMas != 's') {
			pintarMenu();
		}

	}

	private static void listarCanciones() throws Exception {

		int opcion = 0;
		VideoYoutubeArrayDao videoarray = cargarInicialCanciones();
		System.out.println("------Listar Menu------");

		try {
			for (videoYoutube video : videoarray.getAll()) {
				System.out.println("Id: " + video.getId() + "-" + video.getCodigo() + "-" + video.getTitulo());
			}

			System.out.println(
					"pulse 1 Listar. pulse 2.Para Añadir canciones: Pulsar 3. Para Eliminar canciones. Pulsar 4 para salir ");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			opcion = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("Por favor introduzca una opcion correcta");

			try {
				System.out.println(
						"pulse 1 Menu principal. pulse 2.Para Añadir canciones: Pulsar 3. Para Eliminar canciones . Pulsar 4 para salir ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				opcion = Integer.parseInt(br.readLine());
			} catch (Exception e2) {
				System.out.println(("Empezemos de nuevo...."));
				listarCanciones();
			}
		}
		opcionesMenu(opcion);
	}

	private static void eliminarCancion() throws Exception {

		long userDelete;
		int opcion;

		try {

			System.out.println("Menu elimina canciones");
			System.out.println("introduce el id de la cancion que quieres borrar");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			userDelete = (long) Integer.parseInt(br.readLine());
			videoB[0] = dao.getById(userDelete);
			if (videoB[0] != null) {
				if (videoB[0].getId() == userDelete) {
					dao.delete(userDelete);
					System.out.println("Registro " + userDelete + " eliminado correctamente");
				}

			} else {
				System.out.println(
						"Registro no encontrado intentalo de nuevo, si necesitas recordar las canciones, puedes listarlas");
			}
			System.out.println(
					"pulse 1 Menu principal. pulse 2.Para Añadir canciones: Pulsar 3. Para Eliminar canciones Pulsar 3. Pulsar 4 para salir ");
			opcion = Integer.parseInt(br.readLine());
			opcionesMenu(opcion);

		} catch (Exception e) {

			System.out.println("Ha introducido un id incorrecto");
			eliminarCancion();
		}
	}

	private static VideoYoutubeArrayDao cargarCanciones() {
		// Solo se ejecuta una vez al iniciarlizar la ejecucion
		if (dao.getAll().size() == 0 && contador2 == false) {
			videoYoutube vInicial1 = new videoYoutube(1, "Agua de marzo", "rap1");
			videoYoutube vInicial2 = new videoYoutube(2, "Repartiendo arte", "rap2");
			videoYoutube vInicial3 = new videoYoutube(3, "Cancion3", "rap3");
			videoYoutube vInicial4 = new videoYoutube(4, "Cancion4", "rap4");
			videoYoutube vInicial5 = new videoYoutube(5, "Cancion5", "raps5");
			dao.insert(vInicial1);
			dao.insert(vInicial2);
			dao.insert(vInicial3);
			dao.insert(vInicial4);
			dao.insert(vInicial5);
		} else {
			System.out.println("No hay canciones que mostrar");
		}
		contador2 = true;
		return dao;
	}

	private static void salir() {

		System.out.println("Gracias por su consulta");
		System.exit(0);
	}

	private static boolean comprobarTitulo(String titulo) {

		if (titulo.length() > 3 && titulo.length() < 256) {
			return true;
		}
		return false;
	}

	private static boolean comprobarCodigo(String codigo) {
		if (codigo.length() == 11) {
			return true;
		}
		return false;
	}

	private static void opcionesMenu(int opcion) throws Exception {

		// constantes
		final int LISTAR = 1;
		final int AÑADIR = 2;
		final int ELIMINAR = 3;
		final int salir = 4;
		if (opcion == LISTAR) {
			listarCanciones();
		} else {
			if (opcion == AÑADIR) {
				Anadir();
			} else {
				if (opcion == ELIMINAR) {
					eliminarCancion();
				} else {
					if (opcion == salir) {
						salir();
					}
				}
			}
		}
	}

	private static VideoYoutubeArrayDao cargarInicialCanciones() {
		if (contador2 == false) {
			videoYoutube vInicial1 = new videoYoutube(1, "Agua de marzo", "rap1");
			videoYoutube vInicial2 = new videoYoutube(2, "Repartiendo arte", "rap2");
			videoYoutube vInicial3 = new videoYoutube(3, "Cancion3", "rap3");
			videoYoutube vInicial4 = new videoYoutube(4, "Cancion4", "rap4");
			videoYoutube vInicial5 = new videoYoutube(5, "Cancion5", "raps5");
			dao.insert(vInicial1);
			dao.insert(vInicial2);
			dao.insert(vInicial3);
			dao.insert(vInicial4);
			dao.insert(vInicial5);

		}
		contador2 = true;
		return dao;

	}
}
