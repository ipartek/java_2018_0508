package com.ipartek.formacion.uf2216;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GestorRevista {

	private static Scanner sc = new Scanner(System.in);

	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_SALIR = 0;

	private static RevistasArrayDAO dao = RevistasArrayDAO.getIntance();

	public static void main(String[] args) {
		int opcion = 0;

		do {

			try {

				System.out.println("------------------------------------");
				System.out.println("--        BIENVENIDO/A            --");

				mostrarMenu();

				opcion = sc.nextInt();
				sc.nextLine();

				switch (opcion) {
				case OPCION_LISTAR:

					List<Revistas> revistas = dao.getAll();
					mostrarLista(revistas);
					break;

				case OPCION_ANADIR:

					Revistas nuevaRevista = crearNuevaRevista();
					// dao.insert(nuevaRevista);
					boolean respuestaCorrecta = false;
					do {
						System.out.println("Desea añadir la revista (S/N)");
						String respuesta = sc.nextLine();
						if (respuesta.toUpperCase().equals("S")) {
							dao.insert(nuevaRevista);
							respuestaCorrecta = true;
							System.out.println("Revista creada");
						} else if (respuesta.toUpperCase().equals("N")) {
							respuestaCorrecta = true;
							System.out.println("Revista No creada");
						}

					} while (respuestaCorrecta != true);

					break;

				case OPCION_SALIR:

					System.out.println("Gracias por tu visita a nuestra aplicacion ");
					break;

				default:
					System.out.println("Has ingresado un numero ERRONEO por favor vuelve a intentarlo");
				}
			} catch (InputMismatchException ex) {
				System.out.println("No has introducido un numero valido");
			}

		} while (opcion != OPCION_SALIR);

	}

	private static Revistas crearNuevaRevista() {

		String titulo = "";
		boolean tituloCorrecto = false;

		do {
			System.out.println("Ingresa un titulo:");
			titulo = sc.nextLine();

			if (titulo.length() > Revistas.TITULO_MIN_LENGTH && titulo.length() < Revistas.TITULO_MAX_LENGTH) {
				tituloCorrecto = true;
			} else {

				System.out.println("El titulo tiene que ser entre 3 y 150 caracteres por favor vuelve a intentarlo");
			}
		} while (tituloCorrecto != true);

		String isbn = "";
		boolean isbnCorrecto = false;

		do {
			System.out.println("Ingrese el ISBN por favor : ");
			isbn = sc.nextLine();

			if (isbn.length() == Revistas.ISBN_MIN_LENGTH) {
				isbnCorrecto = true;
			} else {
				System.out.println("El codigo tiene que ser de 10 caracters ");
			}
		} while (isbnCorrecto != true);

		int paginas = 0;
		boolean paginasCorrecta = false;

		do {
			System.out.println("Ingrese las paginas por favor : ");
			paginas = sc.nextInt();
			sc.nextLine();

			if (paginas >= Revistas.PAGINAS_MIN_LENGTH) {
				paginasCorrecta = true;
			} else {
				System.out.println("El numero de paginas debe tener mas de una pagina por favor vuelve a intentarlo");
			}
		} while (paginasCorrecta != true);

		boolean formato = true;
		boolean formatoCorrecto = false;

		do {
			System.out.println("Por favor ingrese el formato digital o papel ?  ");
			String frmt = sc.nextLine();

			if (frmt.equals("digital")) {
				formato = true;
				formatoCorrecto = true;
			} else if (frmt.equals("papel")) {
				formato = false;
				formatoCorrecto = true;
			} else {
				System.out.println(" El formato es incorrecto debe ser digital o papel,  por favor vuelve a insertalo");
			}
		} while (formatoCorrecto != true);

		Revistas nuevaRevista;

		try {
			nuevaRevista = new Revistas(titulo, isbn, paginas, formato);
			return nuevaRevista;

		} catch (Exception e) {
			System.out.println("Error al ingresar la lista ");
			e.printStackTrace();
		}

		return null;

	}

	private static void mostrarLista(List<Revistas> revistas) {
		if (revistas.size() == 0) {
			System.out.println("No hay revistas ");
		} else {
			for (int i = 0; i < revistas.size(); i++) {
				Revistas rev = revistas.get(i);
				System.out.println(rev.toString());
			}

		}

	}

	private static void mostrarMenu() {

		System.out.println("------------------------------------");
		System.out.println("--          REVISTAS              --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar                     -");
		System.out.println("-    2. Añadir Nuevo               -");
		System.out.println("-    0. Salir                      -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.print("Por favor, selecciona una opción: ");

	}

}
