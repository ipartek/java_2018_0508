package com.ipartek.formacion.basicos.anidados;

/**
 * Mostrar los números perfectos entre 1 y 1000.
 * 
 * @author Curso
 * 
 */
public class Ejercicio1 {

	final static int TOP = 1000;
	final static int LOW = 1;

	public static void main(String[] args) {

		System.out.println("Números perfectos del 1 - 1000");
		System.out.println("------------------------------");

		for (int i = LOW; i <= TOP; i++) {
			System.out.print(esPerfecto(i) ? i + " " : "");
		}

	}

	public static boolean esPerfecto(int n) {

		int sum = 0;
		boolean es;

		for (int i = 1; i < n; i++) {
			sum += (n % i == 0 ? i : 0);
		}

		es = (sum == n ? true : false);
		return es;
	}

}
