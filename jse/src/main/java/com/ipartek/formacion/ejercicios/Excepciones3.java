package com.ipartek.formacion.ejercicios;

import java.io.IOException;

/**
 * Excepciones3 pegar Excepciones2 y el metodoB puede lanzar una excepcion con el Throws. El Throws para arriba.
 * @author Curso
 *
 */
public class Excepciones3 {

	public static void main(String[] args) {
		System.out.println("Entro en Main");
		//Lo mas correcto es en el main hacer TRY/CATCH
		try {
			metodoA();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Salgo Main");

	}

	private static void metodoA() throws IOException {
		System.out.println("Entro en metodoA");
		metodoB();
		System.out.println("Salgo en metodoA");

	}

	private static void metodoB() throws IOException {
		
		System.out.println("Entro en metodoB");
		System.out.println("Introduce un caracter: ");
	//	char contest = (char) System.in.read();
		metodoC();
		System.out.println("Salgo en metodoB");
	}

	private static void metodoC() {
		System.out.println("Entro en metodoC");
		try {
	//		Object o = null;
	//		o.toString();

		} catch (NullPointerException e) {
			System.out.println("Catch--> Error con el Objeto");
		}

		/*
		 * } catch (Exception e) {
		 * System.out.println("Usuario=> Lo sentimos pero ha surgido un problema.");
		 * System.out.println("LOG=> " + e);
		 * 
		 * } finally { System.out.println("Terminamos ejecuci�n (Siempre se ejecute)");
		 * }
		 */

	}

}
