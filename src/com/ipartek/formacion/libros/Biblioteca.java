package com.ipartek.formacion.libros;

import java.util.Scanner;

import com.ipartek.formacion.model.LibroArrayDAO;
import com.ipartek.formacion.pojo.Libro;

public class Biblioteca {

	static LibroArrayDAO dao;

	static private final int OPCION_MINIMA = 0;
	static private final int OPCION_MAXIMA = 4;
	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR_PRESTADOS = 1;
	static private final int OPCION_LISTAR_NO_PRESTADOS = 2;
	static private final int OPCION_LISTAR_TODOS = 3;
	static private final int OPCION_BUSCAR = 4;
	static private final int VALOR_CHIVATO = -1;
	static private int ULTIMO_ID = 0;

	private static Scanner sc = null;

	public static void main(String[] args) {

		try {

			sc = new Scanner(System.in);

			dao = LibroArrayDAO.getInstance();

			cargarLibros();

			ULTIMO_ID = dao.getAll().size() + 1;

			int opc = VALOR_CHIVATO;

			while (opc != OPCION_SALIR) {

				opc = opcion();
				switch (opc) {

				case OPCION_LISTAR_PRESTADOS:
//					eliminarVideo();
					break;

				case OPCION_LISTAR_NO_PRESTADOS:
//					modficarVideo();
					break;

				case OPCION_LISTAR_TODOS:
					listarLibros();
					break;

				case OPCION_BUSCAR:
//					altaVideo();
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



	private static void cargarLibros() throws Exception {

		dao.insert(new Libro(ULTIMO_ID, "Fariña", "123456789", "231456978"));
		ULTIMO_ID++;
		dao.insert(new Libro(ULTIMO_ID, "Fariña", "123456789", "231456978"));
		ULTIMO_ID++;
		dao.insert(new Libro(ULTIMO_ID, "Fariña", "123456789", "231456978"));
		ULTIMO_ID++;
		dao.insert(new Libro(ULTIMO_ID, "Fariña", "123456789", "231456978"));
		ULTIMO_ID++;
		dao.insert(new Libro(ULTIMO_ID, "Fariña", "123456789", "231456978"));
		ULTIMO_ID++;
	}
	
	private static void pintarMenu() {

		System.out.println("**************************************************");
		System.out.println("----------------Biblioteca Ipartek----------------");
		System.out.println("**************************************************");
		System.out.println("----------1. Listar Libros Prestados--------------");
		System.out.println("**************************************************");
		System.out.println("-------------2. Listar Libros Libres--------------");
		System.out.println("**************************************************");
		System.out.println("-------------3. Listar todos----------------------");
		System.out.println("**************************************************");
		System.out.println("-------------4. Buscador--------------------------");
		System.out.println("**************************************************");
		System.out.println("**************************************************");
		System.out.println("**************************************************");
		System.out.println("--------------0. Salir----------------------------");
		System.out.println("**************************************************");

	}
	
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
	

	private static void listarLibros() {

		if (dao.getAll().size() == 0) {
			System.out.println("No hay ningun libro :( \n Empieza a añadir.");
		} else {
			System.out.println(dao.getAll());
		}
		
	}
	
}
