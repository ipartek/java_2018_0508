package com.ipartek.formacion.ejercicios.recursividad;

import java.util.Scanner;

/**
 * Calcular el resto de la división de forma recursiva
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner sc = null;

		try {
			sc = new Scanner(System.in);
			System.out.print("Introduce un numero: ");
			int a = sc.nextInt();
			System.out.print("Introduce otro numero: ");
			int b = sc.nextInt();
			System.out.println(divisionRest(a, b));

		} catch (Exception e) {
			System.out.println("ERROR al introducir los datos");
			sc.close();
			main(args);

		} finally {
			sc.close();
		}

	}

	private static int divisionRest(int a, int b) {
		int rest = 0;
		if (a > b) {
			rest = divisionRest(a-b, b);

		}else {
			rest = a;
		}

		return rest;
	}

}
