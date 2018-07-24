package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 
 * 
 * @author Asier Cornejo
 * 
 *         Intercambiar el contenido de dos variables
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		int aux;

		System.out.print("Introduzca valor de a: ");
		a = sc.nextInt();
		System.out.print("Introduzca Valor de b: ");
		b = sc.nextInt();
		System.out.println("Valores iniciales: a = " + a + "   b = " + b);

		aux = a;
		a = b;
		b = aux;
		System.out.println("Valores intercambiados: a = " + a + "   b = " + b);
		sc.close();
	}

}
