package com.ipartek.formacion.uf2216;

import java.io.IOException;
import java.util.Scanner;

import com.ipartek.formacion.pojo.VideoYoutube;
import com.ipartek.formacion.uf2216.Revista;
import com.ipartek.formacion.uf2216.RevistaArrayDAO;

public class GestorRevistas {
	//Constantes
	static private RevistaArrayDAO dao;
	static private int opcionSeleccionada = 0;
	static Scanner sc = null;
	
	//Atributos
	static String titulo;
	static String isbn;
	static int numPaginas;
	static long id;
	static boolean formato;
	static boolean formato_pedir;
	static Revista revista;
	static long cont = 0;
	
	
	//Opciones
	static private final int OPCION_LISTAR =1;
	static private final int OPCION_CREAR =2;
	static private final int OPCION_GUARDAR_FICHERO =3;
	static private final int OPCION_SALIR =4;
	
	public static void main(String[] args) {
		
		try {
			sc = new Scanner(System.in);
			dao = RevistaArrayDAO.getInstance();

			do { //Hazme esto

				pintarMenu();
				
				//Opciones de menu
				switch (opcionSeleccionada) {
				case OPCION_LISTAR:
					listar();
					break;
				case OPCION_CREAR:
					crearRevista();
					break;
				case OPCION_GUARDAR_FICHERO:
					//buscarLibro();
					break;
				case OPCION_SALIR:
					System.out.println("Saliendo de la aplicacion...Hasta la proxima");
					break;
				}
				
			//MIENTRAS
			} while (opcionSeleccionada != OPCION_SALIR);
			
			
		} catch (Exception e) {//SI ME FALLARIA EL CARGAR LIBROS
			System.out.println("Lo sentimos la aplicacion esta fuera de servicio por problemas tecnicos");
		} finally {
			sc.close();
		}
	
	}
	
	private static void pintarMenu() { 
			
			System.out.println("------------------------------------");
			System.out.println("--          Revista               --");
			System.out.println("------------------------------------");
			System.out.println("-      1.- Listado                 -");
			System.out.println("-      2.- Crear revista           -");
			System.out.println("-      3.- Guardar en fichero      -");
			System.out.println("-      4.- salir                   -");
			System.out.println("------------------------------------");
			System.out.print("Elige una opcion:");
			
			
		
			try {
				opcionSeleccionada = sc.nextInt();
				sc.nextLine();
				if(opcionSeleccionada>=4) {
					System.out.println("Has introducido un numero fuera del rango.");
					System.out.println("Por favor,vuelve a introducir un numero valido entre 1-4.");
				}
			}catch (Exception e) {
				sc.nextLine();
				System.out.println("OPCION NO VALIDA, Por favor introduzca un numero del menu");
				pintarMenu();
			}
		
		}
	//METODOS
	/**
	 * Miramos si la lista esta vacia para informar al usuario, que si quiere ver alguna primero tendra que añadirla.
	 */
	private static void listar() {
		
		if(dao.getAll().isEmpty()) {
			System.out.println("El gestor de revistas esta vacio.");
			System.out.println("Tendrá que añadir una revista para poder visualizarla.");
			pintarMenu();
		}else {
			for ( Revista revista : dao.getAll() ) {
				System.out.println("    " + revista);
			}

			System.out.println("");
			System.out.println("");
			System.out.println("");

			pintarMenu();
		}
	}
	
	private static void crearRevista() {
		System.out.println("-CREAR REVISTA-");
		//titulo
		do {
			System.out.println("Introduce el Titulo de la Revista: (3-150 caracteres)");
			titulo = sc.nextLine().trim();
			if(titulo.length() < 3 || titulo.length() > 150) {
				System.out.println("ERROR. El titulo tiene que contener un minimo de 3 y un maximo de 150 caracteres.");
				System.out.println("");
			}
		}while(titulo.length() < 3 || titulo.length() > 150);
		
		//isbn
		do {
			System.out.println("Introduce el ISBN de la revista: (10 caracteres) ");
			isbn = sc.next();
			if(isbn.length()!=10) {
				System.out.println("Error.El Isbn tiene que tener 10 caracteres.");
				System.out.println("");
			}
		}while(isbn.length()!=10);
		
		//numPaginas
		do {
		System.out.println("Introduce el numero de paginas de la revista: (minimo 1)");
		numPaginas=sc.nextInt();
			if(numPaginas<1 ) {
				System.out.println("ERROR.La revista debe contener almenos 1 página");
			}	
		}while(numPaginas<1);
		
		
		do {
			System.out.println("¿En que formato lo desea?");
			System.out.println("Digital o papel");
			formato=sc.hasNext();
			if(formato) {
				
			}
		}while();
	}	
	
	
	
	
}
/*	private static void crearRevista() {
		char anadir=('s');
		System.out.println("-CREAR REVISTA-");
		do {
			//TITULO
			System.out.println("Introduce el Titulo de la Revista: (3-150 caracteres)");
			titulo = sc.nextLine().trim();
			
			if(titulo.length() < 3 || titulo.length() > 150) {
				System.out.println("ERROR. El titulo tiene que contener un minimo de 3 y un maximo de 150 caracteres.");
				System.out.println("");*/
			
			/*}else{
				//ISBN			}
				System.out.println("Introduce el ISBN de la revista: (10 caracteres) ");
				isbn = sc.next();
				if(isbn.length()!=10) {
					System.out.println("Error.El Isbn tiene que tener 11 caracteres.");
					System.out.println("");
				}else {
					//NumPaginas
					System.out.println("Introduce el numero de paginas de la revista: (minimo 1)");
					numPaginas=sc.nextInt();
					if(numPaginas<1 ) {
						System.out.println("ERROR.La revista debe contener almenos 1 página");
						
					}else {
						//QUIERES GUARDAR LIBRO
						System.out.println("-Datos Revista-");
						System.out.println("Titulo= "+titulo);
						System.out.println("Isbn= "+isbn);
						System.out.println("Numero de Paginas= "+numPaginas);
						System.out.println("Id= "+id);
						
						System.out.println("Desea añadir esta Revista?");
						try {
							anadir = (char) System.in.read();
						} catch (IOException e) {
							System.out.println("Introduce una n de NO o una s de Si");
							sc.nextLine();
						}
						if(anadir != NO) {
							pintarMenu();
						}else {
							//GUARDAMOS TODOS LOS VALORES
							revista = new Revista();
							revista.setTitulo(titulo);
							revista.setIsbn(isbn);
							revista.setNumPaginas(numPaginas);
							revista.setId(cont);
							
							
							//dao.insert(revista);
							//cont++;
						}
						
						
						
					}
				}
			}
		
	}while(titulo.length() < 3 || titulo.length() > 150 || isbn.length() != 10 || numPaginas<1 || anadir!=NO);
	
	*/
	
	//FIN CREAR REVISTA

