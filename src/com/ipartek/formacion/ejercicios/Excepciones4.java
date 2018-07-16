package com.ipartek.formacion.ejercicios;

/**
 * 
 * Ejercicio4 capturar excepciones para que se ejecuten todos los metodos
 * como si no huebiera excepciones
 * 
 */
public class Excepciones4 {

	public static void metodoA() {

		System.out.println("Comienzo metodo A");
		metodoB();
		System.out.println("Fin metodo A");
	}

	public static void metodoB() {

		System.out.println("Comienzo metodo B");
		metodoC();
		System.out.println("Fin metodo B");
	}

	public static void metodoC() {

		System.out.println("Comienzo metodo C");
		int[] test = new int[2];
		try {
			int num = test[4];
			System.out.println(num);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			System.out.println("Fin metodo C");

			
		}
		
	
	}

	public static void main(String[] args) {
		try {
			metodoA();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
