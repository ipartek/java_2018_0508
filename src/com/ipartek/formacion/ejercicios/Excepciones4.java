package com.ipartek.formacion.ejercicios;

/**
 * Capturar excepciones para que se ejecuten todos los metodos, como si no hubiera excepcion
 * @author ur00
 *
 */
public class Excepciones4 {

	public static void main(String[] args) {
		System.out.println("Main comenzamos");
		
		metodoA();
	
		System.out.println("Main Terminamos");
	}
	
	static void metodoA() {
		System.out.println("    metodoA entro");
		metodoB();
		System.out.println("    metodoA salgo");
	}
	
	static void metodoB() {
		System.out.println("        metodoB entro");
		
		Object o = null;
		o.toString();
		
		System.out.println("        metodoB salgo");
	}

}
