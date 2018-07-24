package com.ipartek.formacion.uf2216;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


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
	static boolean formato;
	static String formatoPedir;
	static Revista revista;
	static long cont = 0;
	static String guardar;
	
	//Opciones
	static private final int OPCION_LISTAR =1;
	static private final int OPCION_CREAR =2;
	static private final int OPCION_GUARDAR_FICHERO =3;
	static private final int OPCION_SALIR =4;
	static private final boolean DIGITAL = true;
	static private final boolean PAPEL = false;
	
	static private final int TITULO_MIN_LENGTH=3;
	static private final int TITULO_MAX_LENGTH=150;
	static private final int ISBN_LENGTH=10;
	static private final int NUMPAG_MIN=1;
	
	public static void main(String[] args) {
		
		try {
			sc = new Scanner(System.in);
			dao = RevistaArrayDAO.getInstance();
			cargarRevista();
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
					crearFichero();
					break;
				case OPCION_SALIR:
					System.out.println("Saliendo de la aplicacion...Hasta la proxima");
					break;
				}
				
			//MIENTRAS
			} while (opcionSeleccionada != OPCION_SALIR);
			
			
		} catch (Exception e) {
			e.printStackTrace();
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
			System.out.println("Elige una opcion:");
			
			
		
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
	private static void cargarRevista() throws Exception {
		Revista nueva_revista = new Revista("Titulo de prueba","123456789",2,true);
		dao.insert(nueva_revista);
	}
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
			pintarMenu();
		}
	}
	
	private static void crearRevista() {
		System.out.println("-CREAR REVISTA-");
		
		//titulo
		do {
			System.out.println("Introduce el Titulo de la Revista: (3-150 caracteres)");
			titulo = sc.nextLine().trim();
			if(titulo.length() < TITULO_MIN_LENGTH || titulo.length() > TITULO_MAX_LENGTH) {
				System.out.println("ERROR. El titulo tiene que contener un minimo de 3 y un maximo de 150 caracteres.");
				System.out.println("");
			}
		}while(titulo.length() < TITULO_MIN_LENGTH || titulo.length() > TITULO_MAX_LENGTH);
		
		//isbn
		do {
			System.out.println("Introduce el ISBN de la revista: (10 caracteres) ");
			isbn = sc.next();
			if(isbn.length()!=ISBN_LENGTH) {
				System.out.println("Error.El Isbn tiene que tener 10 caracteres.");
				System.out.println("");
			}
		}while(isbn.length()!=ISBN_LENGTH);
		
		//numPaginas
		do {
			try {
				sc.nextLine();
				System.out.println("Introduce el numero de paginas de la revista: (minimo 1)");
				numPaginas=sc.nextInt();
				
				if(numPaginas<NUMPAG_MIN ) {
					System.out.println("ERROR.La revista debe contener almenos 1 página");
				}
			}catch (Exception e) {
				System.out.println("ERROR.Has introducido un valor incorrecto.");
				
			}
		}while(numPaginas<NUMPAG_MIN);
		
		//formato
		do {
			System.out.println("¿En que formato lo desea?  (D)Digital o (P)papel");
			formatoPedir=sc.next();
			
			if("D".equalsIgnoreCase(formatoPedir)) { //Si nos introducen una D
				formato=DIGITAL;
			}else if("P".equalsIgnoreCase(formatoPedir)) {
				formato=PAPEL;
			}else{
				System.out.println("ERROR.Has introducido un valor incorrecto.");	
			}
		}while(!"P".equalsIgnoreCase(formatoPedir) && !"D".equalsIgnoreCase(formatoPedir));
		
		//MOSTRAMOS LOS DATOS
		System.out.println("-Datos Introducidos-");
		System.out.println("Titulo:"+titulo);
		System.out.println("ISBN:"+isbn);
		System.out.println("Numero de paginas:"+numPaginas);
		System.out.println("Formato: "+formatoPedir);
		
		guardarRevista();
		
	}//fin crear revista	
	
	private static void guardarRevista() {
		//GUARDADO DEFINITIVO
				sc.nextLine();
				do {
					System.out.println("¿Desea crear definitavemente una revista con los datos anteriores?");
					System.out.println("Responda con un SI o NO");
					guardar=sc.nextLine();
					
					if("si".equalsIgnoreCase(guardar)) {
						
						Revista revista = new Revista();
						
						revista.setTitulo(titulo.trim());
						revista.setIsbn(isbn);
						revista.setNumPaginas(numPaginas);
						revista.setFormato(formato);

						dao.insert(revista);

						System.out.print("Revista Guardada con exito.");
						sc.nextLine();
						pintarMenu();
						
					}else if("no".equalsIgnoreCase(guardar)) {
						
						System.out.println("Tus deseos son ordenes,no se ha guardado nada.");
						pintarMenu();
						
					}else{
						System.out.println("ERROR.Has introducido un valor incorrecto.");
						//guardarRevista();
					}
				
				}while(!"Si".equalsIgnoreCase(guardar) && !"No".equalsIgnoreCase(guardar));
			
				
	}//fin guardado revista
	
	private static void crearFichero() {

		File fichero = new File("src/com/ipartek/formacion/uf2216/Revistas.txt");
		//System.out.println("path: " + fichero.getAbsolutePath());

		if (fichero.exists()) {//Si el fichero Existe
			System.out.println("El fichero ya existe.");
			escribirEnFichero(fichero);	
			
		}else{
			try{
				fichero.createNewFile();
				System.out.println("Fichero Creado.");
				escribirEnFichero(fichero);
			}catch (IOException e) {
				System.out.println("Ha habido un error al crear el fichero.");
				e.printStackTrace();
			}
		}

	}

	private static void escribirEnFichero(File fichero) {
		
		System.out.println("Disculpen las molestias.Estamos escribiendo en el fichero");
		
		ArrayList<Revista> listaDeRevista = (ArrayList<Revista>) dao.getAll();
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(fichero));
			
			for (int i = 0; i < listaDeRevista.size(); i++) {
				bw.write(listaDeRevista.get(i).toString());
				bw.newLine();
			}

			bw.close();
			System.out.println("Ya hemos escrito en el fichero.\n");

		} catch (Exception e) {
			System.out.println("Ha habido una excepcion escribiendo el fichero" + e.getMessage());
		}
		
	}
	
	
}
