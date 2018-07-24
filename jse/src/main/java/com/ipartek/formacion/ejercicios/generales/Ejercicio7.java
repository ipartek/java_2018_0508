package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Comprobar si dos números son amigos. 
 * 
 * Los divisores propios de un número incluyen la unidad pero no el propio número.
 * 
 * Un ejemplo de números amigos son los números 220 y 284.
 * Los divisores propios de 220 son 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 y 110.
 * La suma de los divisores propios de 220 da como resultado 284
 * Los divisores propios de 284 son 1, 2, 4, 71 y 142.
 * La suma de los divisores propios de 284 da como resultado 220.
 * Por lo tanto 220 y 284 son amigos.
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numero1;
		int numero2;
		int sumaDivisores1 = 0;
		int sumaDivisores2 = 0;
		
		System.out.println("Introduce un primer número");
		numero1 = sc.nextInt();
		
		System.out.println("Introduce un segundo número");
		numero2 = sc.nextInt();
		
		for (int i = 1; i < numero1; i++) {
			if (numero1 % i == 0) {
				sumaDivisores1 += i;
			}
		}
		
		for (int i = 1; i < numero2; i++) {
			if (numero2 % i == 0) {
				sumaDivisores2 += i;
			}
		}
		
		if (sumaDivisores1 == numero2 && sumaDivisores2 == numero1) {
			System.out.println("Los números " + numero1 + " y " + numero2 + " son números amigos");
		}
		else {
			System.out.println("Los números " + numero1 + " y " + numero2 + " no son números amigos");
		}
		
		sc.close();
		
	}

}
