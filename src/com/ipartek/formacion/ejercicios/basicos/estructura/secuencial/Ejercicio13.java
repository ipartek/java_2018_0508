package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 
 * Programa que pida por teclado la fecha de nacimiento de una persona (dia,
 * mes, año) y calcule su número de la suerte. <br>
 * El número de la suerte se calcula sumando el día, mes y año de la fecha de
 * nacimiento y a continuación sumando las cifras obtenidas en la suma.
 */

public class Ejercicio13 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca la fecha de su nacimiento (dd/mm/year):  ");
		String[] date = teclado.next().split("/");
		teclado.close();
		int sum = 0;
		int result = 0;
		for (String value : date) {
			sum += Integer.parseInt(value);
		}
		while (sum > 0) {
			result += sum % 10;
			sum /= 10;
		}
		System.out.print("El resultado es: " + result);

	}

}
