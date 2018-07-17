package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/***
 * Intercambiar el contenido de dos variables
 * 
 * @author user
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1, num2, numAux;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca el primer numero: ");
		num1 = sc.nextInt();
		System.out.println("Introduzca el segundo numero: ");
		num2 = sc.nextInt();

		System.out.println("Valor de num1: " + num1 + " y num2: " + num2);

		numAux = num1;
		num1 = num2;
		num2 = numAux;

		System.out.println("Valor intercambiado de num1: " + num1 + " y num2: " + num2);

		sc.close();
	}

}
