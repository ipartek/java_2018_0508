package com.ipartek.formacion.videos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.ipartek.formacion.model.VideoYoutubeArrayDao;
import com.ipartek.formacion.pojo.videoYoutube;

public class GestorVideos {
	static videoYoutube[] videos = new videoYoutube[5];
	static videoYoutube[] videoB = new videoYoutube[1];
	static VideoYoutubeArrayDao dao;
	int contador = 0;

	public static void main(String[] args) throws Exception {

		cargarMenu();
	}

	private static void pintarMenu() throws Exception {
		int opcion;
		int contador;
		System.out.println("-----------------------");
		System.out.println("-------Youtube---------");
		System.out.println("-------Opciones--------");
		System.out.println("------1: Listar--------");
		System.out.println("------2: Añadirr--------");
		System.out.println("------3: Eliminar------");
		System.out.println("------4: Salir------");
		System.out.println("------Seleccione una opcion------");
		try {
			
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		opcion = Integer.parseInt(br.readLine());
		dao = VideoYoutubeArrayDao.getInstance();
		if (opcion == 1) {
			listarCanciones();
		} else {
			if (opcion == 2) {
				Anadir();
			}else {
				if(opcion == 3) {
					eliminarCancion();
				}
			}
		}
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
		String codigo;
		char sobreEscribir;

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

			System.out.println("------Introduzca el codigo de la cancion------");
			codigo = br.readLine();
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
		VideoYoutubeArrayDao videoarray = cargarCanciones();
		System.out.println("------Listar Menu------");
		try {
			for (videoYoutube video : videoarray.getAll()) {
				System.out.println("Id: " + video.getId() + "-" + video.getCodigo() + "-" + video.getTitulo());
			}

			System.out.println(
					"Menu principal pulse 1.Para Añadir canciones: Pulsar 2. Para Eliminar canciones Pulsar 3. ");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			opcion = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("Por favor introduzca una opcion correcta");
			try {
				System.out.println(
						"Menu principal pulse 1.Para Añadir canciones ? (Pulsar 2).Para Eliminar canciones ? (Pulsar 3). ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				opcion = Integer.parseInt(br.readLine());
			} catch (Exception e2) {
				System.out.println(("Empezemos de nuevo...."));
				listarCanciones();
			}
		}
		if (opcion == 1) {
			pintarMenu();
		} else {
		}
		if (opcion == 2) {
			Anadir();
		} else {
			if (opcion == 3) {
				eliminarCancion();
			}

		}
	}

	private static void eliminarCancion() throws Exception {
		long userDelete;
		int opcion;
		VideoYoutubeArrayDao videoArrayBorrar;
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
			System.out.println("Que quieres hacer ahora ? 1-listar. 2-Añadir. 3- Eliminar. 4 Salir");
			opcion = Integer.parseInt(br.readLine());
			if (opcion == 1) {
				listarCanciones();
			} else {
				if (opcion == 2) {
					Anadir();
				} else {
					if (opcion == 3) {
						eliminarCancion();
					}
				}

			}
		} catch (Exception e) {

			System.out.println("Ha introducido un id incorrecto");
			eliminarCancion();
		}
	}

	private static VideoYoutubeArrayDao cargarCanciones() {
		if (dao.getAll().size() == 0) {
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

		return dao;
	}

	private static void Salir() {
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

}
