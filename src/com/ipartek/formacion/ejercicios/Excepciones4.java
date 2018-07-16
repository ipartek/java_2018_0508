package com.ipartek.formacion.ejercicios;

/**
 * Capturar excepciones para que se ejecuten todos los metos como si no hubiera
 * excepciones
 * 
 * @author Curso
 *
 */

public class Excepciones4 {

	public static void main(String[] args) {
		System.out.println("main entro");

		metodoA();

		System.out.println("main salgo");
	}

	public static void metodoA() {
		System.out.println("metodoA entro");
		metodoB();
		System.out.println("metodoA salgo");
	}

	public static void metodoB() {
		System.out.println("metodoB entro");

		Object o = null;
		o.toString();

		metodoC();

		System.out.println("metodoB salgo");

		// Ejercicio3 copiar 2 y que el b lance excepcion con throws hacia arriba.
	}

	public static void metodoC() {
		main();
	}

}
