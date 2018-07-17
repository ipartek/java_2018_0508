package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/***
 * Programa que lee un número de 3 cifras y muestra sus cifras por separado.
 * 
 * @author Curso
 *
 */
public class Ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero de 3 cifras: ");
		n = sc.nextInt();

		System.out.println("Centenas: " + n / 100);
		System.out.println("Decenas: " + (n / 10) % 10);
		System.out.println("Unidades: " + n % 10);

		sc.close();
	}

}
