package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Programa Java que lea por teclado 10 números enteros y los guarde en un array.
 * A continuación calcula y muestra por separado la media de los valores positivos y la de los valores negativos.
 * @author Curso
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		int[] numeros = new int[10];
		int suma1 = 0;
		int suma2 = 0;
		int contPos = 0;
		int contNeg = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce un numero entero: ");
			numeros[i] = teclado.nextInt();
			
			if (numeros[i] > 0) {
				suma1 = suma1 + numeros[i];
				contPos++;
			}else {
				suma2 = suma2 + numeros[i];
				contNeg++;
			}
		}
		
		System.out.println();
		System.out.println("Numeros introducidos:");
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		
		System.out.println();
		System.out.println();
		
		if(contPos != 0) {
			System.out.println("La media de los valores positivos es: " + (suma1 / contPos));
		}else {
			System.out.println("No se han insertado numeros positivos.");
		}
		
		if(contNeg != 0) {
			System.out.println("La media de los valores negativos es: " + (suma2 / contNeg));
		}else {
			System.out.println("No se han insertado numeros negativos.");
		}
		
		teclado.close();
	}

}
