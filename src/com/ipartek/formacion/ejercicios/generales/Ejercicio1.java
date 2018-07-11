package com.ipartek.formacion.ejercicios.generales;

/**
 * Programa para intercambiar el valor de dos variables. Los valores iniciales se 
 * leen por teclado.
 * Por ejemplo, suponiendo que las variables se llaman A y B, si A contiene 3 y B 
 * contiene 5, después del intercambio A contendrá 5 y B 3. 
 * En este ejemplo, para intercambiar el valor entre dos variables utilizaremos 
 * una avariable auxiliar donde guardar el valor de una de ellas. 
 * Después veremos la forma de hacerlo sin usar una variable auxiliar para el 
 * intercambio. 
 * 
 * Las instrucciones a realizar son:
 * AUX = A;
 * A = B;
 * B = AUX;
 */

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		int variable1, variable2;
		int vacia = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero ");
		variable1 = sc.nextInt();
		System.out.println("Introudce otro numero");
		variable2 = sc.nextInt();
		
		vacia = variable1;
		variable1 = variable2;
		variable2 = vacia;
		System.out.println("Los valores han cambiado. Variable 1: " + variable1 + " variable 2: " + variable2);
		sc.close();
	}

}
