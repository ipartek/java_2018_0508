package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		/**
		 * Programa Java que lea un número entero N de 5 cifras y 
		 * muestre sus cifras igual que en el ejemplo.
		 * Por ejemplo para un número N = 12345    La salida debe ser:
		 * 
		 * 5
		 * 45
		 * 345
		 * 2345
		 * 12345
		 */

		Scanner leer = new Scanner(System.in);
		
		int numero;
		
		System.out.println("Introduce un número de 5 cifras");
		
		numero = leer.nextInt();
		
		System.out.println(numero%10);
		
		leer.close();

	}

}
