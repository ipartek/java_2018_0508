package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/***
 * Programa que calcula el número de la suerte de una persona a partir de su
 * fecha de nacimiento. Por ejemplo: Si la fecha de nacimiento es 12/07/1980
 * Calculamos el número de la suerte así: 12+7+1980 = 1999 1+9+9+9 = 28 Número
 * de la suerte: 28
 * 
 * @author Curso
 *
 */
public class Ejercicio13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dia;
		int mes;
		int anyo;
		int total;
		int uM, cent, dec, un;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce tu fecha de nacimiento");
		System.out.println("Día: ");
		dia = sc.nextInt();
		System.out.println("Mes: ");
		mes = sc.nextInt();
		System.out.println("Año: ");
		anyo = sc.nextInt();

		total = dia + mes + anyo;
		uM = total / 1000;
		cent = total / 100 % 10;
		dec = total / 10 % 10;
		un = total % 10;

		System.out.println("Tu numero de la suerte es: " + (uM + cent + dec + un));

		sc.close();
	}

}
