package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa para intercambiar el valor de dos variables. Los valores iniciales
 * se leen por teclado.
 * 
 * Por ejemplo, suponiendo que las variables se llaman A y B, si A contiene 3 y
 * B contiene 5, después del intercambio A contendrá 5 y B 3.
 * 
 * En este ejemplo, para intercambiar el valor entre dos variables utilizaremos
 * una avariable auxiliar donde guardar el valor de una de ellas. Después
 * veremos la forma de hacerlo sin usar una variable auxiliar para el
 * intercambio.
 * 
 * Las instrucciones a realizar son:
 * 
 * AUX = A; A = B; B = AUX;
 * 
 * @author Curso
 *
 */

public class Ejercicio1 {

	public static void main(String[] args) {

		Scanner p = new Scanner(System.in);

		int a;
		int b;
		int z;

		System.out.println("Ingrese el valor de A : ");
		a = p.nextInt();
		System.out.println("Ingrese el valor de B : ");
		b = p.nextInt();
		System.out.println("El valor de A es : " + a + " El valor de B es : " + b);

		z = a;
		a = b;
		b = z;
		System.out.println("Ahora el valor de A es : " + a + "  Ahora el valor de B es : " + b);

	}

}
