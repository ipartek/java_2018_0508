package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa que lea una serie de números por teclado hasta que se lea un número
 * negativo. El programa indicará cuántos números acabados en 2 se han leído.
 * 
 * Para saber si un número acaba en dos o en general para saber en qué dígito
 * termina un número entero se divide el número entre 10 y se obtiene el resto
 * de esta división. En Java el operador que obtiene el resto de una división es
 * el operador % En este caso para saber si el número acaba en 2 escribiremos la
 * instrucción: if(n%10==2)
 * 
 * @author andreaperez
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = 0;
		int cont = 0;

		do {

			System.out.print("Escribe numero:");
			n = sc.nextInt();

			if (n % 10 == 2) { // Si el número acaba en dos
				cont++; // esta variable contendrá cuántos números acabados en 2 se han leído.
			}
		} while (n >= 0);

		System.out.println("Se han introducido " + cont + " números acabados en 2");

		sc.close();
	}

}
