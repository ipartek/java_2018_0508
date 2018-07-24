package com.ipartek.formacion.ejercicios;

/**
 * Ejercicio3 de excepciones copiando el este dos y que el metodo b puede
 * lanzar una excepcion //EN el ejercicio3 mandan las excepcion para arriba
 */

public class Excepciones3 {

	public static void metodoA() throws Exception {

		System.out.println("Comienzo metodo A");
		metodoB();
		System.out.println("Fin metodo A");
	}

	public static void metodoB() throws Exception {

		System.out.println("Comienzo metodo B");
		metodoC();
		System.out.println("Fin metodo B");
	}

	public static void metodoC() throws Exception {

		System.out.println("Comienzo metodo C");
		int[] test = new int[2];
		int num = test[4];
		System.out.println(num);
		System.out.println("Fin metodo C");

	}

	public static void main(String[] args) {
		try {
			metodoA();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
