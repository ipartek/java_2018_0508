package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 
 * Programa Java que determina si dos números son amigos. Dos números son amigos
 * si la suma de los divisores propios del primero es igual al segundo y
 * viceversa.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int primerNum = 0;
		int segunNum = 0;
		int suma = 0;

		System.out.println("Escribe primer numero: ");
		primerNum = sc.nextInt();

		System.out.println("Escribe segundo numero: ");
		segunNum = sc.nextInt();

		for (int i = 1; i < primerNum; i++) { // for para sumar todos los divisores propios del primer numero

			if (primerNum % i == 0) {
				suma += i;
			}
		}

		if (suma == segunNum) {
			suma = 0;

			for (int i = 1; i < segunNum; i++) { // for para sumar todos los divisores propios del segundo numero

				if (segunNum % i == 0) {
					suma += i;
				}
			}

			if (suma == primerNum) {
				System.out.println("el " + primerNum + "y el " + segunNum + " son numeros amigos");

			} else {
				System.out.println("el " + primerNum + "y el " + segunNum + " no son numeros amigos");
			}

		} else {
			System.out.println("el " + primerNum + " y el " + segunNum + " no son numeros amigos");
		}

		sc.close();

	}

}
