package com.ipartek.formacion.uf2216;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * Interfaz desde donde se cargaran y se haran consultas en el gestor de
 * revistas
 * 
 * @author Curso
 *
 */
public class GestorRevistas {
	// La declaracion se puede hacer aqui
	static Revistas revistas;
	static RevistasDao revistasDao;
	static final char SI = 's';
	static final char NO = 'n';
	static final int ISBN_MAX_LENGTH = 10;
	public static final int TITTLE_MIN_LENGTH = 3;
	public static final int TITTLE_MAX_LENGTH = 150;

	public static void main(String[] args) {
		// La inicializacion es mas correcta hacerla aqui
		revistasDao = RevistasDao.getInstance();
		cargarMenu();
	}

	private static void cargarMenu() {
		/**
		 * Cargamos menu y pedimos al usuario una opcion
		 */
		int opcionUsuario;

		System.out.println("-------------------------------------");
		System.out.println("-------Registro de Revistas----------");
		System.out.println("-------------Opciones----------------");
		System.out.println("-----1: Añadir-----------------------");
		System.out.println("-----2: Listar todas las revistas----");
		System.out.println("-----3: Guardar en txt---------------");
		System.out.println("-----0: Salir -----------------------");
		System.out.println("-----Seleccione una opcion-----------");

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			opcionUsuario = Integer.parseInt(br.readLine());

			// quito las opciones para ser llamadas desde una funcion
			opcionesMenu(opcionUsuario);

		} catch (Exception e) {
			System.out.println("Opcion incorrecta!! Pulse un numero del 1 al 3 para");
			cargarMenu();
		}

	}

	private static void opcionesMenu(int opcionUsuario) {
		/**
		 * Se encarga de enlazarnos con las funcionalidades de las opciones
		 */
		// Constantes
		final int ANADIR = 1;
		final int LISTAR_REVISTAS = 2;
		final int GUARDAR_TXT = 3;
		final int SALIR = 0;
		try {

			switch (opcionUsuario) {
			case (ANADIR):
				anadirRevista();
				break;
			case (LISTAR_REVISTAS):
				listarRevistas();
				break;
			case (GUARDAR_TXT):
				guardarTxt();
				break;
			case (SALIR):
				salir();
				break;

			default:
				break;
			}
		} catch (Exception e) {
			System.out.println("Hemos tenido un error al procesar su respuesta, introduzca una opcion valida");
			cargarMenu();
		}

	}

	private static void salir() {
		System.out.println("Gracias por su consulta");
		System.exit(0);

	}

	private static void guardarTxt() {
		/**
		 * input -> Recoge el nombre que le pondra al fichero txt donde se guardaran los
		 * datos output -> Archivo txt + ubicacion para que el usuario pueda acceder a
		 * el
		 */
		String usuarioArchivo;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {

			System.out.println("¿ Que nombre quiere darle al fichero donde almacenara los datos ?");
			usuarioArchivo = br.readLine();

			File archivo = new File(usuarioArchivo);
			System.out.println("Guardando registros en archivo txt en" + archivo.getAbsolutePath());
			FileWriter escribir = new FileWriter(archivo, true);
			for (Revistas rev : revistasDao.getAll()) {
				escribir.write(rev.toString());
			}
			escribir.close();
			cargarMenu();

		} catch (Exception e) {
			System.out.println("Error al guardar archivo");
		}
	}

	private static void listarRevistas() {
		revistasDao.listarRevistas();
		cargarMenu();

	}

	private static void anadirRevista() {
		/**
		 * input->Se pregunta al usuario por los detalles de la revista outpt-> Si tras
		 * introducir datos por parte del usuario y valida se pasan a un arrayList
		 */
		String titulo;
		String isbn;
		int paginas;
		boolean formato;
		boolean confirmacion = false;
		String formato2 = null;
		long id;

		try {
			try {

				titulo = preguntarTitulo();

			} catch (Exception e) {
				System.out.println("Se ha producido un error al procesar el titulo");
				titulo = preguntarTitulo();
			}
			try {
				isbn = preguntarIsbn();
			} catch (Exception e) {
				isbn = preguntarIsbn();
			}
			try {
				paginas = preguntarPaginas();
			} catch (Exception e) {
				paginas = preguntarPaginas();
			}
			try {
				formato = preguntarFormato();
				if (formato == false) {
					formato2 = "Papel";
				} else {
					formato2 = "Digital";
				}

			} catch (Exception e) {
				System.out.println(("Porfavor introduzca un codigo ISBN valido."));
				formato = preguntarFormato();
			}
			id = calculaId();
			confirmacion = resumenRegistro(id, isbn, titulo, formato2, paginas);
			if (confirmacion == true) {
				Revistas rev = new Revistas(id, isbn, titulo, formato2, paginas);
				revistasDao.insert(rev);
				System.out.println("Registro dado de alta correctamente");
				cargarMenu();
			} else {
				cargarMenu();
			}

		} catch (Exception e) {
			System.out.println("Se ha producido un error, lamentablemente tendre que comenzar de nuevo");
			anadirRevista();
		}

	}

	private static boolean resumenRegistro(long id, String isbn, String titulo, String formato2, int paginas) {
		/**
		 * Tras meter los datos de la revista , se le muestran por pantalla y se le
		 * preguntan si quiere guardarlos o no
		 */
		char confirmacionUsuario = 0;
		boolean confirmacion = true;
		// Resumen de los datos introducidos
		try {

			System.out.println("Los datos que quiere dar de alta son los siguientes:");
			System.out.println("Titulo: " + titulo);
			System.out.println("Codigo isbn: " + isbn);
			System.out.println("Formato del libro: " + formato2);
			System.out.println("Nº de paginas: " + paginas);
			// Solicitamos confirmacion al usuario
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Esta seguro que quiere dar de alta la revista ? s / n");
			confirmacionUsuario = br.readLine().charAt(0);

			if (confirmacionUsuario == SI) {
				confirmacion = true;
			} else {
				if (confirmacionUsuario == NO) {
					confirmacion = false;
				} else {

					System.out.println("No le hemos entendido, que desea hacer ?");
					resumenRegistro(id, isbn, titulo, formato2, paginas);
				}

			}

		} catch (Exception e) {
			System.out.println("Ups no le hemos entendido");
			resumenRegistro(id, isbn, titulo, formato2, paginas);
		}
		return confirmacion;
	}

	private static long calculaId() {
		/**
		 * Nos lleva a una funcion de revistasDao donde calculamos el tamaño del
		 * arraylist y en base a esto detrerminamos el siguiente numero de id
		 */
		long id;
		id = revistasDao.calculeId();
		return id;

	}

	private static int preguntarPaginas() throws Exception {
		/**
		 * Bloque que se encarga de pedir el numero de paginas y a su vez hacemos la
		 * validacion de que tenga que tener mas de 1 pagina
		 */
		int nPaginas = 0;
		boolean nPaginasFix = false;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce el numero de paginas, minimo ha de ser 1 pagina");
		nPaginas = Integer.parseInt(br.readLine());
		if (nPaginas > 0) {
			nPaginasFix = true;
			return nPaginas;
		} else {
			System.out.println(
					"Se ha producido un error al procesar el numero de paginas, recuerde que el nunero minimo de paginas es de 1");
			preguntarPaginas();
		}

		return nPaginas;
	}

	private static boolean preguntarFormato() throws Exception {
		/**
		 * se pregunta el formato de la revista y detrerminamos si es digital o papel
		 */
		int formato;
		boolean formatoFix = false;
		int papel = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("¿ Que tipo de formato es la revista ? 1- Papel 2- Digital ");
		System.out.println("");
		formato = Integer.parseInt(br.readLine());
		// formatoFix = revistasDao.resuelveFormato(formato);
		if (formato == papel) {
			formatoFix = false;

		} else {
			formatoFix = true;
		}
		return formatoFix;
	}

	private static String preguntarIsbn() throws Exception {
		/**
		 * Se le pregunta al usuario por el codigo isbn y se hace la validacion de la
		 * longitud del codigo que debe ser 10
		 */
		String isbn;
		boolean isbnFix = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce un codigo isb mayor a 10 caracteres");
		isbn = br.readLine();
		if (isbn.length() != ISBN_MAX_LENGTH) {
			isbnFix = false;
		} else {
			isbnFix = true;
		}
		if (isbnFix == true) {
			return isbn;
		} else {
			System.out.println("El codigo isb es incorrecto, por favor introduzca un codigo isbn de 10 caracteres");
			preguntarIsbn();
		}
		return isbn;

	}

	private static String preguntarTitulo() throws Exception {
		/**
		 * 
		 */
		String titulo;
		boolean tituloOk = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Introduce el titulo de la revista");
		titulo = br.readLine();
		// tituloOk = revistas.compruebaTitulo(titulo);
		if (titulo.length() >= TITTLE_MIN_LENGTH && titulo.length() <= TITTLE_MAX_LENGTH) {
			tituloOk = true;
		}
		if (tituloOk == true) {
			return titulo;
		} else {
			System.out.println("Se ha producido un error al procesar el titulo, vuelva a introducir un titulo");
			System.out.println("Introduzca un titulo que contenga mas de 3 caracteres y menos de 150");
			preguntarTitulo();
		}
		return titulo;
	}
}
