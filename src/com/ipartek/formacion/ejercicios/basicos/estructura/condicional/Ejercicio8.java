package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * 8. Calcular el mayor de tres números enteros en Java.
 * 
 * @author Curso
 *
 */
public class Ejercicio8 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		int num1, num2, num3, aux;

		System.out.println("introduce un numero");
		num1 = scan.nextInt();

		System.out.println("introduce un segundo numero");
		num2 = scan.nextInt();

		System.out.println("introduce un tercer numero");
		num3 = scan.nextInt();

		aux = num1;

		if (aux < num2) {
			aux = num2;
		}
		if (aux < num3) {
			aux = num3;
		}

		System.out.println("El numero mas alto es " + aux);

	}

}
