package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/***
 * Programa que lea un n�mero entero N de 5 cifras y muestre sus cifras desde el
 * final igual que en el ejemplo. Por ejemplo para un n�mero N = 12345 La salida
 * debe ser: 5 45 345 2345 12345
 * 
 * @author Curso
 *
 */
public class Ejercicio12 {

	public static void main(String[] args) {
		int num;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero de 5 cifras: ");
		num = sc.nextInt();

		System.out.println(num % 10);
		System.out.println(num % 100);
		System.out.println(num % 1000);
		System.out.println(num % 10000);
		System.out.println(num);

		sc.close();
	}

}
