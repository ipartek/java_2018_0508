package com.ipartek.formacion.ejercicios.recursividad;

import java.util.Scanner;

/**
 * Calcular la suma desde 1 hasta un número entero N de forma recursiva.
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner sc = null;

		try {
			sc = new Scanner(System.in);
			System.out.print("Introduce un numero: ");
			int num = sc.nextInt();
			System.out.println(sum(num));

		} catch (Exception e) {
			System.out.println("ERROR al introducir los datos");
			sc.close();
			main(args);

		} finally {
			sc.close();
		}

	}

	private static int sum(int num) {
		
		int result = 0;
		if(num>0) {
			result = num +sum(--num);
		}
		
		return result;
	}

}
