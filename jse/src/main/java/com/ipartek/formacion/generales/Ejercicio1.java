package com.ipartek.formacion.generales;

import java.util.Scanner;

/**
 * 
 * Programa para intercambiar el valor de dos variables. Los valores iniciales<br>
 * se leen por teclado.<br>
 * Por ejemplo, suponiendo que las variables se llaman A y B, si A contiene 3 y<br>
 * B contiene 5, después <br>
 * del intercambio A contendrá 5 y B 3. <br>
 * En este ejemplo, para intercambiar el valor entre dos variables utilizaremos<br>
 * una avariable <br>
 * auxiliar donde guardar el valor de una de ellas. Después veremos la forma de<br>
 * hacerlo sin usar una <br>
 * variable auxiliar para el intercambio. <br>
 * Las instrucciones a realizar son:<br>
 * AUX = A;<br>
 * A = B;<br>
 * B = AUX;<br>
 * 
 * @author Ainara
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		int a;
		int b;
		int aux;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un número para A: ");
		a = sc.nextInt();

		System.out.println("Introduce un número para B: ");
		b = sc.nextInt();

		System.out.println("El valor de A era: " + a + " y el valor de B era: " + b);

		aux = a;
		a = b;
		b = aux;

		System.out.println("El valor de A ahora es: " + a + " y el valor de B ahora es: " + b);

		sc.close();

	}

}
