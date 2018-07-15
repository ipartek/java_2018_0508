package com.ipartek.formacion.generales;

import java.util.Scanner;

/**
 * Programa que lea una serie de números por teclado hasta que se lea un número
 * negativo. El programa indicará <br>
 * cuántos números acabados en 2 se han leído.<br>
 * Para saber si un número acaba en dos o en general para saber en qué dígito
 * termina un número entero se <br>
 * divide el número entre 10 y se obtiene el resto de esta división.<br>
 * En Java el operador que obtiene el resto de una división es el operador %<br>
 * En este caso para saber si el número acaba en 2 escribiremos la
 * instrucción:<br>
 * if(n%10==2)<br>
 * 
 * @author Ainara
 * 
 */

public class Ejercicio5 {

	public static void main(String[] args) {

		int num;
		int contador = 0;
		int contador1 = 1;

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce un número entero: ");
		num = sc.nextInt();
		do {
			contador1++;

			if (num % 10 == 2) {
				contador++;
			}

			System.out.print("Introduce un número entero: ");
			num = sc.nextInt();

		} while (num >= 0);

		System.out.println("Se han introducido " + contador1);
		System.out.println("Se han introducido " + contador + " números acabados en 2");

		sc.close();

	}

}
