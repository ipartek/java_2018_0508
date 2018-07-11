package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 13. Programa que calcula el número de la suerte de una persona a partir de
 * su<br>
 * fecha de nacimiento. Si la fecha de nacimiento es 12/07/1980 Calculamos
 * el<br>
 * número de la suerte así: 12+7+1980 = 1999 1+9+9+9 = 28 Número de la suerte:
 * 28<br>
 * 
 * 
 * @author Curso
 *
 */
public class Ejercicio13 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		int num, suma, dia, mes, anio, n1, n2, n3, n4;

		System.out.println("Introduce la fecha de tu nacimiento");
		System.out.println("Dia: ");
		dia = scan.nextInt();

		System.out.println("Mes: ");
		mes = scan.nextInt();

		System.out.println("Año: ");
		anio = scan.nextInt();

		suma = dia + mes + anio;

		n1 = suma / 1000;
		n2 = (suma / 100) % 10;
		n3 = (suma / 10) % 10;
		n4 = suma % 10;

		num = n1 + n2 + n3 + n4;

		System.out.println("Tu numero de la suerte es el " + num);

	}

}
