package com.ipartek.formacion.ejercicios;

/**
 * Capturar excepciones para que se ejecuten todos los metodos como si no
 * hubiera excepciones
 * 
 * @author Curso
 *
 */
public class Excepciones4 {

  public static void main(String[] args) {
		System.out.println("Entro en Main");
		metodoA();
		System.out.println("Salgo Main");

	}

	private static void metodoA()  {
		System.out.println("Entro en metodoA");
		metodoB();
		System.out.println("Salgo en metodoA");

	}

	private static void metodoB()  {

		System.out.println("Entro en metodoB");
		metodoC();
		System.out.println("Salgo en metodoB");
	}

	private static void metodoC() {
		System.out.println("Entro en metodoC");
		try {
		//	Object o = null;
		//	o.toString();

		} catch (Exception e) {
			System.out.println("Excepcion capturada.");

		} 

	}

}
