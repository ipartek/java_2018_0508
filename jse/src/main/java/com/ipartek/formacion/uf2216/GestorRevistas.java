package com.ipartek.formacion.uf2216;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class GestorRevistas {

	static private RevistaArrayDAO dao;
	
	static private int opcionSeleccionada = -1;
	static Scanner sc; 

	static private final int OPCION_SALIR = 0;
	static private final int OPCION_LISTAR = 1;
	static private final int OPCION_ANADIR = 2;
	static private final int OPCION_A_TEXTO = 3;
	
	public static void main(String[] args) {

		try {

			dao = RevistaArrayDAO.getInstance();
			sc = new Scanner(System.in);

			do {

				pintarMenu();

				switch (opcionSeleccionada) {

				case OPCION_ANADIR:
					anadir();
					break;

				case OPCION_LISTAR:
					listar();
					break;

				case OPCION_A_TEXTO:
					crearFichero();
					break;

				case OPCION_SALIR:
					salir();
					break;
					
				default:
					noOption();
					break;
				}
			} while (opcionSeleccionada != OPCION_SALIR);
		} catch (Exception e) {
			System.out.println("Sentimos las molestias, ha ocurrido un error inesperado.");
		} finally {
			if (sc != null) {
				sc.close();
			}
			dao = null;			
		}
	}

	private static void noOption() {
		System.out.println("Introduce una opcion valida [1/2/3/0]");
	}
	
	private static void listar() {

		if (dao.getAll().size() > 0) {
			System.out.println("Lista de revistas: \n");
			for (Revista revista : dao.getAll()) {
				System.out.println("    " + revista);
			}
			System.out.println("");
		} else {
			System.out.println();
			System.out.println("LO SENTIMOS. No hay revistas en la lista.");
		}

	}

	private static void anadir() {
		
		String titulo = "";
		String isbn = "";
		int paginas = 0;
		String opFormato = "";
		Revista temp = new Revista();
		boolean correcto = false;
		
		do {
			try {
				System.out.println("");
				System.out.print("Introduce el titulo [" + Revista.TITULO_MIN_LONG + "/" + Revista.TITULO_MAX_LONG + " char]" );
				titulo = sc.nextLine();
				correcto = temp.setTitulo(titulo);
				
			} catch (Exception e) {
				System.out.println();
				System.out.println(e.getMessage());
			}
		} while (!(correcto));

		correcto = false;
		do {
			try {
				System.out.println("");
				System.out.print("Introduce el ISBN [" + Revista.ISBN_LENGTH + " char]" );
				isbn = sc.nextLine();
				correcto = temp.setIsbn(isbn);
				
			} catch (Exception e) {
				System.out.println();
				System.out.println(e.getMessage());
			}
		} while (!(correcto));

		correcto = false;
		do {
			try {
				System.out.println("");
				System.out.print("Introduce numero de paginas [minimo " + Revista.PAGINAS_MIN + "]: " );
				paginas = sc.nextInt();
				correcto = temp.setPaginas(paginas);
				
			} catch (Exception e) {
				System.out.println();
				System.out.println(e.getMessage());
			}
		} while (!(correcto));

		correcto = false;
		do {
			try {
				System.out.println("");
				System.out.println("Formato de revista");
				System.out.println("   1. Digital");
				System.out.println("   2. Papel");
				System.out.print("Introduce opcion [1/2]");
				opFormato = sc.next();
				
			} catch (Exception e) {
				System.out.println();
				System.out.println(e.getMessage());
			}
			if (opFormato.contentEquals("1"))
				correcto = temp.setFormato(true);
			if (opFormato.contentEquals("2"))
				correcto = temp.setFormato(false);
			if (!correcto) {
				System.out.println();
				System.out.println("Opcion no valida");
			}
		} while (!correcto);
		
		System.out.println();
		System.out.println(temp.toString());
		
		dao.insert(temp);
		
	}
	
	private static void crearFichero() {

		File f = new File("C:\\Desarrollo\\eclipse-workspace\\java_2018_0508\\src\\com\\ipartek\\formacion\\uf2216\\Revistas.txt");
		System.out.println();
		System.out.println("Creando fichero en path: " + f.getAbsolutePath());
		System.out.println();

		try {
			f.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedWriter bw = null;
	
		try {
			bw = new BufferedWriter(new FileWriter(f));
			if (dao.getAll().size() > 0) {
				bw.write("Lista de revistas: "); 
				bw.newLine();
				bw.write("=================="); 
				bw.newLine();
				
				for (Revista revista : dao.getAll()) {
					bw.write("    " + revista);
					bw.newLine();
				}
			} else {
				System.out.println();
				System.out.println("LO SENTIMOS. No hay revistas en la lista.");
			}	
			bw.close();
		}catch (Exception e) {
			System.out.println("Exception escribiendo fichero: " + e.getMessage() ); 
		} 
	}


	private static void salir() {

		System.out.println("");
		System.out.println("AGUR BEN-HUR. Esperamos volver a verte!!! =)");

	}
	
	private static void pintarMenu() {

		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("--           REVISTAS             --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar                     -");
		System.out.println("-    2. Añadir Nuevo               -");
		System.out.println("-    3. Lista en .txt              -");
		System.out.println("-    0. Salir                      -");
		System.out.println("------------------------------------");
		System.out.println("");
		System.out.print("Por favor, selecciona una opción: ");

		try {
			opcionSeleccionada = sc.nextInt();

		} catch (Exception e) {
			//LOGGER
		} finally {
			sc.nextLine();
		}
	}
	
	
	
	
	
}