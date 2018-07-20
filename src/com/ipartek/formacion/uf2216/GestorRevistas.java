package com.ipartek.formacion.uf2216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.ipartek.formacion.model.CocheDao;
import com.ipartek.formacion.pojo.Coche;
import com.ipartek.formacion.pojo.Libro;

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
		// constantes
		final int ANADIR = 1;
		final int LISTAR_REVISTAS = 2;
		final int GUARDAR_TXT = 3;
		final int SALIR = 0;
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

	}

	private static void salir() {
		System.out.println("Gracias por su consulta");
		System.exit(0);

	}

	private static void guardarTxt() {
		// TODO Auto-generated method stub

	}

	private static void listarRevistas() {
		List<Libro> resul = revistasDao.listarRevistas();


	}

	private static void anadirRevista() {
		String titulo;
		String isbn;
		int paginas;
		boolean formato;
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
			} catch (Exception e) {
				System.out.println(("Porfavor introduzca un codigo ISBN valido."));
				formato = preguntarFormato();
			}
			id = calculaId();
			Revistas rev = new Revistas( id,  isbn,  titulo,  formato ,  paginas);
			revistasDao.insert(rev);
			cargarMenu();

		} catch (Exception e) {
			System.out.println("Se ha producido un error, lamentablemente tendre que comenzar de nuevo");
			anadirRevista();
		}

	}



	private static long calculaId() {
		long id;
		id= revistasDao.calculeId();
		return id;
		
	}

	private static int preguntarPaginas() throws Exception {
		int nPaginas = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce el numero de paginas, minimo ha de ser 1 pagina");
		nPaginas = Integer.parseInt(br.readLine());

		return nPaginas;
	}

	private static boolean preguntarFormato() throws Exception {
		int formato;
		boolean formatoFix;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("¿ Que tipo de formato es la revista ? 1- Papel 2- Digital ");
		System.out.println("");
		formato = Integer.parseInt(br.readLine());
		formatoFix = revistasDao.resuelveFormato(formato);
		return formatoFix;
	}

	private static String preguntarIsbn() throws Exception {
		String isbn;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce un codigo isb mayor a 10 caracteres");
		isbn = br.readLine();
		return isbn;

	}

	private static String preguntarTitulo() throws Exception {
		String titulo;
		boolean tituloOk= false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Introduce el titulo de la revista");
		titulo = br.readLine();
		tituloOk = revistas.compruebaTitulo(titulo);
		if(tituloOk == true) {
			return titulo;
		}else {
			System.out.println("Se ha producido un error al procesar el titulo, vuelva a introducir un titulo");
			System.out.println("Introduzca un titulo que contenga mas de 3 caracteres y menos de 150");
			preguntarTitulo();
		}
		return titulo;
	}
}
