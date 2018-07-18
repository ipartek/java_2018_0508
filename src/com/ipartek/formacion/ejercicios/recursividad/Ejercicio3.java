package com.ipartek.formacion.ejercicios.recursividad;

import java.util.Scanner;

/**
 * Calcular 2 elevado a n de forma recursiva
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = null;

		try {
			sc = new Scanner(System.in);
			System.out.print("Introduce un numero: ");
			int exp = sc.nextInt();
			nPow(exp);

		} catch (Exception e) {
			System.out.println("ERROR al introducir los datos");
			sc.close();
			main(args);

		} finally {
			sc.close();
		}
	}

	private static int nPow(int num) {
		//TODO terminar

		if (num > 0) {
			return (2 * nPow(--num));
		}
		else{
			return 1;
		}

	}

}
