package com.ipartek.formacion.ejercicios;

/**
 * Ejercicio3 copiar 2 y que el b lance excepcion con throws hacia arriba.
 * 
 */

public class Excepciones3 {

	public static void main(String[] args) {
		System.out.println("main entro");

		metodoA();

		System.out.println("main salgo");
	}

	public static void metodoA() {
		System.out.println("metodoA entro");
		
		try {
			metodoB();	
		} catch (NullPointerException e) {
			
		}
		
		System.out.println("metodoA salgo");
	}

	public static void metodoB() throws NullPointerException {
		
		System.out.println("metodoB entro");

		Object o = null;
		System.out.println(o.toString());

		metodoC();

		System.out.println("metodoB salgo");

	}

	public static void metodoC() {
		main(null);
	}

}
