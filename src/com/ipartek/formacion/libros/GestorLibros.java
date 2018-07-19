package com.ipartek.formacion.libros;

import java.util.Scanner;

import com.ipartek.formacion.model.LibroDAO;
import com.ipartek.formacion.pojo.Libro;

public class GestorLibros {

	private static LibroDAO dao = null;
	private static int COUNTER_ID = 0;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	public static void main(String[] args) {

		try {
			dao = LibroDAO.getInstance();
			sc = new Scanner(System.in);
			cargarLibros();

			do {
				menu();

			} while (opcionSeleccionada != 4);

		} catch (Exception e) {
			System.out.println("Estamos teniendo errores con el programa. Disculpe las molestias.");

		} finally {
			sc.close();
		}
	}

	private static void menu() {

		System.out.println("-------------MENU-------------");
		System.out.println("1.Listar libros prestados");
		System.out.println("2.Listar no libros prestados");
		System.out.println("3.Buscar libro por titulo");
		System.out.println("4.Salir");
		System.out.println("------------------------------");
		System.out.print("Opcion:");
		try {
			opcionSeleccionada = sc.nextInt();
			switch (opcionSeleccionada) {
			case 1:
				listarLibros(true);
				break;
			case 2:
				listarLibros(false);
				break;
			case 3:
				buscarPorTitulo();
				break;
			case 4:
				salir();
				break;

			default:
				throw new Exception("ERROR");
			}

		} catch (Exception e) {
			System.out.println("ERROR la opcion elegida no es correcta");
			sc.nextLine();
			System.out.println();
			menu();
		}

	}

	private static void salir() {
		System.out.println("FIN DEL PROGRAMA");

	}

	private static void buscarPorTitulo() {
		System.out.println();

		try {
			System.out.print("Introduce el titulo de un libro: ");
			String titulo = sc.next();
			if (dao.getAll().isEmpty()) {
				System.out.println("No hay libros.");

			} else {
				System.out.println("Libros con el titulo: " + titulo);
				boolean encontrado = false;
				for (Libro libro : dao.buscarPorTitulo(titulo)) {
					System.out.println(libro.toString());
					encontrado = true;

				}
				if (!encontrado) {
					System.out.println("No existen coincidencias");
					sc.nextLine();
				}

			}
			System.out.println();

		} catch (Exception e) {
			System.out.println("ERROR, el titulo no es correcto.");
			sc.nextLine();
			buscarPorTitulo();

		}

	}

	private static void listarLibros(boolean prestado) {
		System.out.println();
		System.out.println((prestado) ? "Libros prestados: " : "Libros no prestados: ");
		if (dao.getAll().isEmpty()) {
			System.out.print((prestado) ? "No es hay libros prestados " : "No hay libros o están todos prestados");

		}
		/*
		 * for (Libro libro : dao.getAllPrestados(prestado)) {
		 * System.out.println(libro.toString()); }
		 */
		dao.getAllPrestados(prestado).forEach((libro) -> System.out.println(libro));

		System.out.println();

	}

	private static void cargarLibros() {
		try {
			dao.insert(new Libro(++COUNTER_ID, "9788416001460",
					"FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA", "LIBROS DEL K.O", true));
			dao.insert(new Libro(++COUNTER_ID, "9788467575057", "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA SAVIA ED 2015",
					"EDICIONES SM", false));
			dao.insert(
					new Libro(++COUNTER_ID, "9788467575071", "MATEMÁTICAS TRIMESTRAL SAVIA-15", "EDICIONES SM", false));
			dao.insert(new Libro(++COUNTER_ID, "9788461716098", "LA VOZ DE TU ALMA", "AUTOR-EDITOR", true));
			dao.insert(new Libro(++COUNTER_ID, "9788467569957",
					"LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES SAVIA CASTELLA NO ED 2014", "EDICIONES SM",
					false));
			dao.insert(new Libro(++COUNTER_ID, "9781380013835", "NEW HIGH FIVE 1 PUPILS BOOK PACK",
					"MACMILLAN CHILDRENS BOOKS", false));
			dao.insert(new Libro(++COUNTER_ID, "9781380011718", "NEW HIGH FIVE 3 PUPILS BOOK",
					"MACMILLAN CHILDRENS BOOKS", false));

		} catch (Exception e) {
			System.out.println("Los parametros de los libros son incorrectos");
			System.out.println(e.getMessage());
		}
	}

}
