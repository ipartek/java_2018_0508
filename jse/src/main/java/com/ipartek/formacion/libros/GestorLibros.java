package com.ipartek.formacion.libros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.ipartek.formacion.model.LibroDAO;
import com.ipartek.formacion.pojo.Libro;

public class GestorLibros {

	static private LibroDAO dao;
	static private int opcionSeleccionada = -1;
	static Scanner sc = null;
	static BufferedReader br = null;
	
	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_LISTAR_PRESTADOS = 2;
	static private final int OPCION_LISTAR_NO_PRESTADOS = 3;
	static private final int OPCION_BUSCAR = 4;
	static private final int OPCION_ANADIR = 5;
	static private final int OPCION_ELIMINAR = 6;
	static private int CONTADOR = 0;

public static void main(String[] args) {

	
	try {
		sc = new Scanner(System.in);
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		dao = LibroDAO.getInstance();

		cargarVideos();
		
		pintarMenu();
		
	} catch (Exception e) {
		System.out.println("Lo sentimos, ha habido un error.");
	}
	
	finally {
		
		if (sc != null && br != null) {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Lo sentimos, ha habido un error.");
			}
			sc.close();
		}
		dao = null;
	}

}

private static void cargarVideos() throws Exception {
	
	dao.insert(new Libro(++CONTADOR, " 9788416001460", "FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA", "LIBROS DEL K.O", true));
			
	dao.insert(new Libro(++CONTADOR, " 9788467575057", "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA SAVIA ED 2015", "EDICIONES SM", false));
			
	dao.insert(new Libro(++CONTADOR, " 9788467575071", "MATEMÁTICAS TRIMESTRAL SAVIA-15", "EDICIONES SM", false));
			
	dao.insert(new Libro(++CONTADOR, " 9788461716098", "LA VOZ DE TU ALMA", "AUTOR-EDITOR", true));
			
	dao.insert(new Libro(++CONTADOR, " 9788467569957", "LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES SAVIA CASTELLA NO ED 2014", "EDICIONES SM", false));
			
	dao.insert(new Libro(++CONTADOR, " 9781380013835", "NEW HIGH FIVE 1 PUPILS BOOK PACK", "MACMILLAN CHILDRENS BOOKS", false));
			
	dao.insert(new Libro(++CONTADOR, " 9781380011718", "NEW HIGH FIVE 3 PUPILS BOOK ", "MACMILLAN CHILDRENS BOOKS", false));
			
}

private static void pintarMenu() {//throws Exception{
	
	System.out.println("----------------------------------------");
	System.out.println("---          Libros                  ---");
	System.out.println("----------------------------------------");
	System.out.println("---    1. Listar todos los libros    ---");
	System.out.println("---    2. Listar libros prestados    ---");
	System.out.println("---    3. Listar libros no prestados ---");
	System.out.println("---    4. Buscar por título          ---");
	System.out.println("---    5. Añadir libro               ---");
	System.out.println("---    6. Eliminar libro             ---");
	System.out.println("---                                  ---");
	System.out.println("---    0 - salir                     ---");
	System.out.println("----------------------------------------");
	System.out.println("");
	System.out.println("Dime una opcion por favor");
	
	try {
		opcionSeleccionada = sc.nextInt();
	}catch (Exception e) {
		//e.printStackTrace(); Pinta la fila de excepción
		
		sc.nextLine();
		System.out.println("\nOPCIÓN NO VÁLIDA, Por favor, introduzca un número del menú\n");
		
		pintarMenu();
		
	}

	opcionElegida();
	
}

private static void opcionElegida() {
	
	switch (opcionSeleccionada) {
	
	case OPCION_LISTAR:
		listar();
		break;
		
	case OPCION_LISTAR_PRESTADOS:
		listarPrestados();
		break;
		
	case OPCION_LISTAR_NO_PRESTADOS:
		listarNoPrestados();
		break;

	case OPCION_BUSCAR:
		buscarPorTitulo();
		break;

	case OPCION_ANADIR:
		anadirLibro();
		break;

	case OPCION_ELIMINAR:
		eliminarLibro();
		break;

	case OPCION_SALIR:
		salir();
		break;	
		
	default:
		noOption();
		break;
	}
	
}

private static void listar() {
	for ( Libro libro : dao.getAll() ) {
		System.out.println(libro);
	}

	pintarMenu();
	
}

private static void listarPrestados() {
		
	for ( Libro libro : dao.getAllPrestados(true) ) {
		
			System.out.println("   " + libro);
		
	}
	
	if(dao.getAll().isEmpty()) {
		System.out.println("\nEn estos momentos no hay ningún libro prestado\n");
	}	
	
	pintarMenu();
	
}

private static void listarNoPrestados() {
		
	for ( Libro libro : dao.getAllPrestados(false) ) {
		
			System.out.println("   " + libro);
		
	}
	
	if(dao.getAll().isEmpty()) {
		System.out.println("\nEn estos momentos todos los libros están prestados\n");
	}
	
	pintarMenu();
	
}

private static void buscarPorTitulo() {
	
	String titulo = "";
	
	System.out.println("Introduce el título del libro que deseas buscar");
	try {
		titulo = br.readLine();
	} catch (IOException e) {
		System.out.println("Lo sentimos, ha ocurrido un error inesperado");
	}
	
	for (Libro libro : dao.getByTitulo(titulo)) {
		
		System.out.println(libro);
	}
	
	if(dao.getByTitulo(titulo).isEmpty()) {
		System.out.println("\nNo hemos encontrado ninún libro con ese titulo\n");
		buscarPorTitulo();
	}
	
	pintarMenu();
	
}

private static void anadirLibro() {
	
	Libro libro =  new Libro();
	long id = ++CONTADOR;
	String isbn = "";
	String titulo = "";
	String editorial = "";
	char prestado = 'n';
	
	libro.setId(id);
	
	do {
		System.out.println("¿Cuál es el ISBN del libro?");
		isbn = sc.next();
		try {
			libro.setIsbn(isbn);
		} catch (Exception e1) {
			System.out.println("El ISBN debe contener 5 caracteres como mínimo");
		} 
	} while (isbn.trim().length() < 5);
	
	System.out.println("¿Cuál es el título del libro?");
	try {
		titulo = br.readLine();
	} catch (IOException e) {
		System.out.println("Lo sentimos, ha ocurrido un error inesperado");
	}
	libro.setTitulo(titulo);

	System.out.println("¿Cuál es la editorial del libro?");
	try {
		editorial = br.readLine();
	} catch (IOException e) {
		System.out.println("Lo sentimos, ha ocurrido un error inesperado");
	}
	libro.setEditorial(editorial);
	
	System.out.println("¿El libro está prestado(s/n)?");
	prestado = sc.next().charAt(0);
	Character.toLowerCase(prestado);
	
	if(prestado == 's') {
		libro.setPrestado(true);
	}else {
		libro.setPrestado(false);
	}
	
	dao.insert(libro);
	
	if(dao.getAll().size() == CONTADOR) {
		System.out.println("\nLibro insertado correctamente\n");
	}
	
	pintarMenu();
	
}

private static void eliminarLibro() {
	
	long id;

	System.out.println("Introduce la id del libro a eliminar");
	id = sc.nextLong();
	
	while(dao.getById(id) == null) {
		System.out.println("No puede eliminar algo que no existe");
		System.out.println("Introduzca otra id");
		id = sc.nextLong();
	}
	
	dao.delete(id);
	
	pintarMenu();
	
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
	
	System.out.println("Lo sentimos, no existe esa opcion");
	pintarMenu();
	
}

}