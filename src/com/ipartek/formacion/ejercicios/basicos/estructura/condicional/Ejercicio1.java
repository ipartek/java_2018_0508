package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

/**
 * Programa Java que lea un número entero por teclado y calcule si es par o impar.
 */

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		int numero;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero");
		numero = sc.nextInt();
		
		if(numero%2 == 0) {
			System.out.println("Este numero es par");
		}
		else {
			System.out.println("Este numero es impar");
		}
		sc.close();
	}

}
