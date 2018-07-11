package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

/**
 * Programa Java que lea un número entero de 3 cifras y muestre por separado 
 * las cifras del número.
 */

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		int numero;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero entero de 3 cifras");
		numero = sc.nextInt();
		
		System.out.println("El primer digito es: " + numero/100);
		System.out.println("El segundo digito es: " + numero/10 % 10);
		System.out.println("El tercer digito es: " + numero%10);
		
		sc.close();
	}

}
