package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * 6. Leer 10 enteros y mostrar la media de los valores negativos y la de los
 * positivos.
 * 
 * @author apero
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {

		int n;
		int[] numeros = new int[10];
		int cPositivo = 0;
		int cNegativo = 0;
		int sumaPositiva = 0;
		int sumaNegativa = 0;
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce un numero :");
			n = sc.nextInt();
			numeros[i] = n;
			if (numeros[i] < 0) {
				cNegativo++;
				sumaNegativa += numeros[i];
			} else {
				cPositivo++;
				sumaPositiva += numeros[i];
			}

		}

		sumaPositiva = sumaPositiva / cPositivo;
		sumaNegativa = sumaNegativa / cNegativo;
		
		System.out.println("La medio de los valores positivos "+sumaPositiva);
		System.out.println("La medio de los valores negativos "+sumaNegativa);

		sc.close();

	}

}
