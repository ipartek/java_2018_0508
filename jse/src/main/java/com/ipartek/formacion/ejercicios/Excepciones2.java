package com.ipartek.formacion.ejercicios;

/**
 * Crear una nueva clase Excepciones2, con un metodo main, metodoA, metodoB y
 * metodoC. El C llama a NULLPOINTER
 * 
 * @author Curso
 *
 */

public class Excepciones2 {

	public static void main(String[] args) {
		System.out.println("Metodo Main");
		metodoA();

	}

	private static void metodoA() {
		System.out.println("Metodo A");
		metodoB();

	}

	private static void metodoB() {
		//TODO Excepciones3 pegar Excepciones2 y el metodoB puede lanzar una excepcion con el Throws. El Throws para arriba.
		System.out.println("Metodo B");
		metodoC();
	}

	private static void metodoC() {
		System.out.println("Metodo C");
		try {
			//Object o = null;
			//o.toString();

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
