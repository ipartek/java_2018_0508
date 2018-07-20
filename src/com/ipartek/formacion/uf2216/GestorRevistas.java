package com.ipartek.formacion.uf2216;

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
					//listar();
					break;

				case OPCION_A_TEXTO:
					//aTexto();
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
	
	private static void anadir() {
		
		String titulo = "";
		Revista temp = new Revista();
		boolean correcto = false;
		
		do {
			try {
				System.out.println("");
				System.out.print("Introduce el titulo [3/150 char]" );
				titulo = sc.nextLine();
				correcto = temp.setTitulo(titulo);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		} while (!(correcto));

		
	}

	private static void salir() {

		System.out.println("");
		System.out.println("AGUR BEN-HUR. Esperamos volver a verte!!! =)");

	}
	
	private static void pintarMenu() {

		System.out.println("------------------------------------");
		System.out.println("--           REVISTAS             --");
		System.out.println("------------------------------------");
		System.out.println("-    1. Listar                     -");
		System.out.println("-    2. Añadir Nuevo               -");
		System.out.println("-    3. Guardar .txt               -");
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