package com.ipartek.formacion.ejercicios.recursividad;

import java.util.Scanner;

/**
 * Sumar y resta (ejercicio extra) dos números enteros de forma recursiva
 * 
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc = null;

		try {
			sc = new Scanner(System.in);
			System.out.print("Introduce un numero: ");
			int a = sc.nextInt();
			System.out.print("Introduce otro numero: ");
			int b = sc.nextInt();
			System.out.println("Suma: "+sum(a, b));
			
			System.out.println("Resta: "+resta(a, b));

		} catch (Exception e) {
			System.out.println("ERROR al introducir los datos");
			sc.close();
			main(args);

		} finally {
			sc.close();
		}
	}

	private static int sum(int a, int b) {
		
		int result = 0;
		
		if (b == 0) {
			result = a;

		} else if (a == 0) {
			result = b;

		} else {
			result = 1 + sum(a, b - 1);
		}
		
		return result;
	}
	
private static int resta(int a, int b) {
		
		int result = 0;
		
		if (b == 0) {
			result = a;

		} else if (a == 0) {
			result = b;

		} else {
			result = resta(a, b - 1) -1;
		}
		
		return result;
	}

}
