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
		
		try {
			Object o = null;
			o.toString();
		}catch (Exception e) {
			System.out.println("******* Exception capturada");
		}	
		
		System.out.println("        metodoB salgo");
	}

}
