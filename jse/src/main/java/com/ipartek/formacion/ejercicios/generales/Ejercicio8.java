package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * La serie de fibonacci la forman una serie de números tales que:
 * 
 * El primer término de la serie es el número 1 El segundo término de la serie
 * es el número 1 Los siguientes términos de la serie de fibonacci se obtienen
 * de la suma de los dos anteriores:
 * 
 * 1, 1, 2, 3, 5, 8, 13, .....
 * 
 * Vamos a escribir el programa java que muestra los N primeros números de la
 * serie. El valor de N se lee por teclado.
 * 
 * @author Curso
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num;

		System.out.print("Introduce un numero: ");
		num = sc.nextInt();
		System.out.println("Los primeros " + num + " numeros de Fibonacci son:");
		
		int fib1 = 0;
		int fib2 = 1;
		int aux;
		System.out.print("=> 1");
		
		for (int i = 0 ; i <= num ; i++) {			
			System.out.print(" - " + (fib1+fib2));
			aux=fib1;
			fib1=fib2;
			fib2=fib2+aux;
			
		sc.close();
		
		}
	}

}
