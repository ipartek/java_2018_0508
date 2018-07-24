package com.ipartek.formacion.generales;

import java.util.Scanner;

/**
 * COMPROBAR SI UN NÚMERO ES CAPICÚA EN JAVA Un número es capicúa si se puede
 * leer igual de derecha a izquierda que de izquierda a derecha. Ejemplos de
 * números capicúas: 121, 3003, 1234321, 33, 445544, etc. Vamos a escribir un
 * programa Java que pida por teclado un número entero N de más de una cifra y
 * verifique si es capicúa.
 * 
 * @author Ainara
 *
 */
public class Ejercicio13 {

	public static void main(String[] args) {
		
		int num;
		int aux;
		int inverso = 0;
		int cifra;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("Introduce un número >= 10: ");
			num = sc.nextInt();
		} while (num < 10);

		aux = num;
		
		while (aux != 0) {
			cifra = aux % 10;
			inverso = inverso * 10 + cifra;
			aux = aux / 10;
		}

		if (num == inverso) {
			System.out.println("Es capicua");
		} else {
			System.out.println("No es capicua");
		}
		
		sc.close();

	}

}
