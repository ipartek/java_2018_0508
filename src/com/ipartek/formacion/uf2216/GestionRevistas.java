package com.ipartek.formacion.uf2216;

/**
 * Programa que imprime un menu con 3 opciones:/n
 * <ul>
 * <li>Lista las revistas introducidas</li>
 * <li>Añade nuevas revistas</li>
 * <li>Genera un txt con una lista de las revistas introducidas</li>
 * </ul>
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GestionRevistas {

	static private RevistasArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_GENERAR_TXT = 3;

	static private final int MAXLIM_TITULO = 150;
	static private final int MINLIM_TITULO = 3;
	static private final int LIM_PAGINAS = 1;
	static private final int LIM_ISBN = 10;

	static public boolean SALIR = false;

	static public int CONTADOR_REVISTAS;

	private static final char NO = 'n';
	private static final char SI = 's';

	public static void main(String[] args) throws Exception {

		sc = new Scanner(System.in);

		dao = RevistasArrayDAO.getInstance();

		cargarVideos();

		pintarMenu();

		do {
			switch (opcionSeleccionada) {
			case OPCION_LISTAR:
				listar();
				break;

			case OPCION_ANADIR:
				anadirRevista();
				break;

			case OPCION_GENERAR_TXT:
				generarTxt();
				break;

			case OPCION_SALIR:
				salir();
				break;

			default:
				noOption();
				break;
			}

		} while (SALIR == false);

	}

	/**
	 * Genera un archivo con el nombre que el usuario desee a no ser que exista /n
	 * un archivo con el mismo nombre./n Lo genera en la carpeta Revistas de este
	 * mismo proyecto.
	 * 
	 * @throws IOException por lo que pueda pasar
	 */
	private static void generarTxt() throws IOException {
		String nameTxt;
		char seguro;

		do {
			sc.nextLine();
			System.out.println("¿Como deseas llamar al fichero?");
			nameTxt = sc.nextLine();
			System.out.println("¿Estas seguro de que deseas llamarlo " + nameTxt + "?(s/n)");
			seguro = (char) System.in.read();
		} while (seguro != SI);

		File f = new File("Revistas\\" + nameTxt + ".txt");

		if (f.exists()) {
			System.out.println("Ya existe un fichero con ese nombre");
			generarTxt();
		} else {
			try {
				f.createNewFile();
				System.out.println("El fichero ha sido creado con exito.");
				System.out.println("");
				System.out.println("");
				System.out.println("");

				FileWriter fw = new FileWriter(f);
				PrintWriter pw = new PrintWriter(fw);

				try {

					for (Revistas pojo : dao.getAll()) {
						pw.println(pojo);
					}

				} finally {
					pw.close();
					fw.close();
				}

			} catch (IOException e) {
				System.out.println("Error al crear fichero");
				e.printStackTrace();
			}
		}

		pintarMenu();

	}

	/**
	 * Funcion que añade revistas al array con los datos introducidos por el
	 * usuario.
	 * 
	 * @throws Exception Controlamos que introduzca numeros enteros en el numero de
	 *                   paginas.
	 */
	private static void anadirRevista() throws Exception {
		char seguir;
		char esDigital;
		char seguro;

		do {

			String titulo = "";
			String isbn = "";
			int numPaginas = 0;
			boolean isDigital = false;

			do { // PEDIMOS TITULO
				System.out.println("Introduce el TITULO de la revista que deseas añadir(de 3 a 150 caracteres):");
				titulo = sc.nextLine();
			} while (titulo.getBytes().length > MAXLIM_TITULO || titulo.getBytes().length < MINLIM_TITULO);

			do { // PEDIMOS ISBN
				System.out.println("Introduce el ISBN de la revista que deseas añadir(10 caracteres):");
				isbn = sc.nextLine();
			} while (isbn.getBytes().length != LIM_ISBN);

			do { // PEDIMOS PAGINAS
				try {
					System.out.println("Introduce las PAGINAS de la revista que deseas añadir(Minimo 1):");
					numPaginas = sc.nextInt();
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("Introduce un numero entero porfavor");
					// e.printStackTrace();
				}
			} while (numPaginas <= LIM_PAGINAS);

			do { // PREGUNTAMOS SI ES DIGITAL O NO
				System.out.println("¿Es digital?(s/n)");
				sc.nextLine();
				esDigital = (char) System.in.read();
				sc.nextLine();
				System.out.println("¿Estas seguro?(s/n)");
				seguro = (char) System.in.read();
			} while (seguro != SI);

			if (esDigital == SI) {
				isDigital = true;
			} else {
				isDigital = false;
			}

			CONTADOR_REVISTAS = CONTADOR_REVISTAS + 1;

			Revistas pojo = new Revistas(CONTADOR_REVISTAS, titulo, isbn, numPaginas, isDigital);
			dao.insert(pojo);

			System.out.println("Tu revista ha sido añadida");
			mostrar();

			sc.nextLine();
			System.out.println("Deseas AÑADIR alguna revista mas(s/n)");
			seguir = (char) System.in.read();

		} while (seguir != NO);
		pintarMenu();

	}

	/**
	 * Funcion para finalizar la ejecucion del programa.
	 */
	private static void salir() {
		System.out.println(" ");
		System.out.println(" ");

		System.out.println("¡HASTA OTRA! GRACIAS POR CONTAR CON NOSOTROS ");
		SALIR = true;

	}

	/**
	 * Funcion utilizada en caso de que el usuario introduzca una opcion que no
	 * existe en el menu.
	 */
	private static void noOption() {
		System.out.println("Lo sentimos, no existe esa opcion");
		pintarMenu();

	}

	/**
	 * Funcion que lista todas las revistas.
	 */
	private static void listar() {

		for (Revistas pojo : dao.getAll()) {
			System.out.println("    " + pojo);
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

		pintarMenu();

	}

	/**
	 * Funcion que muestra las revistas por pantalla
	 */
	private static void mostrar() {

		for (Revistas pojo : dao.getAll()) {
			System.out.println("    " + pojo);
		}
	}

	/**
	 * Funcion que carga 2 revistas por defecto en el array.
	 * 
	 * @throws Exception
	 */
	private static void cargarVideos() throws Exception {
		Revistas pojo = new Revistas(1, "QUORE", "123456789a", 235, true);
		dao.insert(pojo);

		pojo = new Revistas(2, "Planeta de agostini", "123456789b", 245, false);
		dao.insert(pojo);

		CONTADOR_REVISTAS = CONTADOR_REVISTAS + 2;

	}

	/**
	 * Funcion que imprime el menu por pantalla.
	 */
	private static void pintarMenu() {

		System.out.println("------------------------------------");
		System.out.println("--          REVISTAS              --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar                     -");
		System.out.println("-    2. Añadir Nueva               -");
		System.out.println("-    3. Generar txt                -");
		System.out.println("-                                  -");
		System.out.println("-    0. Salir                      -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.println("Dime una opcion por favor: ");

		try {
			opcionSeleccionada = sc.nextInt();
		} catch (Exception e) {
			// e.printStackTrace();
			sc.nextLine();
			System.out.println("!OPCION NO VALIDA! Porfavor introduce un numero del menu");
			pintarMenu();
		}

	}

}
