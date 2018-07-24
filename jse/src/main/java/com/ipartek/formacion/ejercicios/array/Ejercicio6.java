package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Leer 10 enteros y mostrar la media de los valores negativos y la de los
 * positivos.
 * 
 * @author Asier Cornejo
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		int totPos = 0;
		int totNeg = 0;
		int contPos = 0;
		int contNeg = 0;
		int resp = 0;
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			System.out.println("Introduzca un numero positivo o negativo");
			resp = sc.nextInt();
			if (resp < 0) {
				totNeg += resp;
				contNeg++;
			} else {
				totPos += resp;
				contPos++;
			}
		}

		System.out.println("La media de los numeros positivos introducidos es: " + totPos / contPos);

		System.out.println("La media de los numeros negativos introducidos es: " + totNeg / contNeg);
		sc.close();
	}

}
