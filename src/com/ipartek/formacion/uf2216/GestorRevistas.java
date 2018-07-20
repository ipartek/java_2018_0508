package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.uf2216.RevistaDAO;

/**
 * Clase GestorRevistas para gestionar revistas utilizando el model
 * RevistaDAO
 * @see RevistaDAO
 * @author Curso
 */
public class GestorRevistas {
	
	static private RevistaDAO dao;
	static Scanner sc;
	
	//CONSTANTES
	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_AÑADIR = 2;
	static private final int OPCION_CREAR_FICHERO = 3;
	
	static private final int MIN_LONG_TITULO = 3;
	static private final int MAX_LONG_TITULO = 150;
	static private final int ISBN_LENGTH = 10;
	static private final int NUM_MIN_PAGINAS = 1;
	static private final boolean FORMATO_DIGITAL = true;
	static private final boolean FORMATO_PAPEL = false;

	public static void main(String[] args) {
		
		try {
			dao = RevistaDAO.getInstance();
			sc = new Scanner(System.in);
			cargarRevistas();
			pintarMenu();
		} catch (Exception e) {
			System.out.println("Lo sentimos, hemos tenido un error.");
		} finally {
			sc.close();
		}
		
	}

	/**
	 * Metodo que pinta el menu por pantalla y selecciona que accion realizar
	 */
	private static void pintarMenu() {
		System.out.println("------------------------------------------");
		System.out.println("--               REVISTAS               --");
		System.out.println("------------------------------------------");
		System.out.println("-   1. Listar revistas                   -");
		System.out.println("-   2. Añadir revista                    -");
		System.out.println("-   3. Guardar en TXT                    -");
		System.out.println("------------------------------------------");
		System.out.println("-   0. Salir                             -");
		
		try {
			int opcion = -1;

			do {
				try {
					System.out.println();
					System.out.println("Elige una opcion del menu:");
					opcion = sc.nextInt();

				} catch (Exception e) {
					System.out.println();
					System.out.println("Por favor, introduzca un valor correcto.");
					sc.nextLine();
				}
			} while (opcion < OPCION_SALIR || opcion > OPCION_CREAR_FICHERO);

			switch (opcion) {
			case OPCION_LISTAR:
				listarRevistas();
				break;
			case OPCION_AÑADIR:
				anadirRevista();
				break;
			case OPCION_CREAR_FICHERO:
				crearTxt();
				break;
			case OPCION_SALIR:
				System.out.println();
				System.out.println("¡Hasta la proxima!");
			}

		} catch (Exception e) {
			System.out.println("Algo ha salido mal, lo sentimos.");
			e.printStackTrace();
		}
		
	}

	/**
	 * Metodo para cargar una lista de revistas
	 */
	private static void cargarRevistas() {
		Revista revista1 = new Revista("Revista1", "1234567890", 15, false);
		dao.insert(revista1);
		Revista revista2 = new Revista("Revista2", "1029384756", 30, true);
		dao.insert(revista2);
		Revista revista3 = new Revista("Revista3", "1018273645", 25, true);
		dao.insert(revista3);
		Revista revista4 = new Revista("Revista4", "1342908765", 50, false);
		dao.insert(revista4);
		Revista revista5 = new Revista("Revista5", "1234567890", 100, true);
		dao.insert(revista5);
	}
	
	/**
	 * Metodo para listar todas las revistas
	 */
	private static void listarRevistas() {
		try {
			List<Revista> revistas = new ArrayList<Revista>();
			revistas = dao.getAll();
			String formatoTexto;
			boolean formato;
			
			if(revistas.isEmpty()) {
				System.out.println("No hay revistas.");
			}else {
				System.out.println("ISBN --- TITULO --- PAGINAS --- FORMATO");
				System.out.println("---------------------------------------");
				for (int i = 0; i < revistas.size(); i++) {
					formato = revistas.get(i).isFormato();
					if(formato == true) {
						formatoTexto = "Digital";
					}else {
						formatoTexto = "Papel";
					}
					
					System.out.print(revistas.get(i).getIsbn() + " - ");
					System.out.print(revistas.get(i).getTitulo() + " - ");
					System.out.print(revistas.get(i).getNumPaginas() + " - ");
					System.out.println(formatoTexto);
					
				}
			}
		} catch (Exception e) {
			System.out.println("No se han podido listar las revistas, lo sentimos.");
			e.printStackTrace();
		} finally {
			System.out.println();
			sc.nextLine();
			pintarMenu();
		}
	}
	
	/**
	 * Metodo para añadir nuevas revistas
	 */
	private static void anadirRevista() {
		String titulo = null;
		String isbn = null;
		int numPaginas = -1;
		String formatoTexto = null;
		boolean formato = false;
		
		try {
			sc.nextLine();
			do {//Pedir por teclado titulo de la revista
				try {
					System.out.println("Introduce el titulo de la revista, por favor: (Minimo 3 letras, Maximo 150)");
					titulo = sc.nextLine();
				} catch (Exception e) {
					System.out.println("Titulo incorrecto, repita por favor.");
					e.printStackTrace();
				}
			} while (titulo == null || titulo.length() < MIN_LONG_TITULO || titulo.length() > MAX_LONG_TITULO);

			do {//Pedir por teclado isbn de la revista
				try {
					System.out.println("Introduce el ISBN de la revista, por favor: (10 numeros)");
					isbn = sc.nextLine();
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("ISBN incorrecto, repita por favor.");
					e.printStackTrace();
				}
			} while (isbn.length() != ISBN_LENGTH );
			
			do {//Pedir por teclado numero de paginas de la revista
				try {
					System.out.println("Introduce el numero de paginas de la revista, por favor: (Minimo 1)");
					numPaginas = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Numero de paginas incorrecto, repita por favor.");
					e.printStackTrace();
				}
			} while (numPaginas < NUM_MIN_PAGINAS);
			sc.nextLine();
			do {//Pedir por teclado formato de la revista
				try {
					System.out.println("Introduce el formato de la revista, por favor: (Digital o Papel)");
					formatoTexto = sc.nextLine();
					formatoTexto = formatoTexto.toLowerCase();
				} catch (Exception e) {
					System.out.println("Formato incorrecto, repita por favor.");
					e.printStackTrace();
				}
			} while (formatoTexto.isEmpty());
			
			//Convertir la opcion de formato de String a boolean para luego introducirla
			if(formatoTexto.equals("digital")) {
				formato = FORMATO_DIGITAL;
			}else {
				formato = FORMATO_PAPEL;
			}
			
			Revista revistaNueva = new Revista(titulo, isbn, numPaginas, formato);
			dao.insert(revistaNueva);
			System.out.println("Revista nueva introducida correctamente.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println();
			pintarMenu();
		}
		
	}
	
	/**
	 * Metodo para crear un archivo TXT con todas las revistas
	 */
	private static void crearTxt() {
		// TODO Auto-generated method stub
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println();
			sc.nextLine();
			pintarMenu();
		}
		
	}
	
}
