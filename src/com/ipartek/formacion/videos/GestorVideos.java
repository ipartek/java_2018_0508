package com.ipartek.formacion.videos;

import java.util.Scanner;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorVideos {

	static private VideoYoutubeArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static String titulo;
	static long id;
	static String codigo;
	static VideoYoutube video = new VideoYoutube();

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_ELIMINAR = 3;


	public static void main(String[] args) {

		sc = new Scanner(System.in);

		dao = VideoYoutubeArrayDAO.getInstance();

		cargarVideos();

		pintarMenu();

		do {
			switch (opcionSeleccionada) {
			case OPCION_LISTAR:
				listar();
				break;

			case OPCION_ANADIR:
				anadir();
				break;

			case OPCION_ELIMINAR:
				eliminar();
				break;

			case OPCION_SALIR:
				salir();
				break;	

			default:
				noOption();
				break;
			}
		}while(opcionSeleccionada != OPCION_SALIR);
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

		for ( VideoYoutube video : dao.getAll() ) {
			System.out.println("    " + video);
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

		pintarMenu();
	}

	/*titulo mayor que 3 y menor que 254 caracteres
	 * codigo 11 caracteres*/
	private static void anadir() {
		//sc.nextLine();
		do {
			System.out.println("Introduce el titulo del video a añadir: ");
			titulo = sc.nextLine().trim();
			/*String[] tituloCompuesto = new String[10];
			tituloCompuesto =  sc.nextLine().split(" ");
			for(int i = 0; i<tituloCompuesto.length; i++) {
				if(!tituloCompuesto[i].isEmpty())
					if(titulo != null)
						titulo = titulo + tituloCompuesto[i] + " ";
					else
						titulo = tituloCompuesto[i] + " ";
			}*/

			if(titulo.length() < 3 || titulo.length() > 254) {
				System.out.println("ERROR. El titulo tiene que ser mayor de 3 caracteres y menor de 254.");
				System.out.println("");
			}else{
				System.out.println("Introduce el codigo del video a añadir: ");

				codigo = sc.next();

				if(codigo.length() != 11) {
					System.out.println("ERROR. El codigo tiene que ser de 11 caracteres");
					System.out.println("");
				}else {
					video.setId((long)dao.length()+1);
					video.setTitulo(titulo);
					video.setCodigo(codigo);

					dao.insert(video);

					System.out.println("Video añadido. "+ video.toString());

					pintarMenu();
				}
			}

		}while(titulo.length() < 3 || titulo.length() > 254 || codigo.length() != 11);
	}

	private static void eliminar() {
		do {
			System.out.println("Introduzca el ID del video que desea borrar: ");
			id = sc.nextLong();
			video = dao.getById(id);
			if(video == null) {
				System.out.println("ERROR. El video que quiere borrar no existe.");
				System.out.println("");
			}else {
				System.out.println("Video borrado: "+video.toString());
				System.out.println("");
				dao.delete(id);				
				pintarMenu();
			}
		}while(video == null);		
	}

	private static void cargarVideos() {
		VideoYoutube video = new VideoYoutube(12650, "Nightmares On Wax Boiler Room London DJ Set", "Q692lHFaLVM");
		dao.insert(video);

		video = new VideoYoutube(701, "The Skatalites - Rock Fort Rock", "6bLVdKbPHHY");
		dao.insert(video);
	}


	private static void pintarMenu() /*throws Exception*/{

		System.out.println("------------------------------------");
		System.out.println("--          youtube               --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar                     -");
		System.out.println("-    2. Añadir Nuevo               -");
		System.out.println("-    3. Eliminar                   -");
		System.out.println("-                                  -");
		System.out.println("-    0 - Salir                     -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.println("Dime una opcion por favor");

		try {

			opcionSeleccionada = sc.nextInt();

		}catch(Exception e) {
			//e.printStackTrace(); pinta la pila de excepcion
			System.out.println("OPCION NO VALIDA, por favor introduce un numero del menu");
			sc.nextLine();			
			//pintarMenu();
		}finally {
			sc.nextLine();	
		}

	}

}
