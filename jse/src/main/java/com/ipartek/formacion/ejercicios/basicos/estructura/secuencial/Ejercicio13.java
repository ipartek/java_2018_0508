package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.*;

/**
 * Programa que pida por teclado la fecha de nacimiento de una persona (dia,
 * mes, año) y calcule su número de la suerte. El número de la suerte se calcula
 * sumando el día, mes y año de la fecha de nacimiento y a continuación sumando
 * las cifras obtenidas en la suma. Por ejemplo: Si la fecha de nacimiento es
 * 12/07/1980 Calculamos el número de la suerte así: 12+7+1980 = 1999 1+9+9+9 =
 * 28 Número de la suerte: 28
 * 
 * @author Curso
 *
 */

public class Ejercicio13 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int dia;
		int mes;
		int anyo;

		System.out.println("Introduce fecha nacimiento:");
		System.out.print("Dia: ");
		dia = sc.nextInt();
		System.out.print("Mes: ");
		mes = sc.nextInt();
		System.out.print("Año: ");
		anyo = sc.nextInt();

		int suma = dia + mes + anyo;
		int suerte = ((suma / 1000) % 10) + (suma / 100 % 10) + (suma / 10 % 10) + (suma % 10);

		System.out.print("Tu numero de la suerte es: " + suerte);

		sc.close();
	}

}
