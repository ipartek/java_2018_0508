package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/***
 * Programa Java que lea dos números enteros por teclado y los muestre por
 * pantalla.
 * 
 * @author user
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1;
		int num2;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca un primer numero: ");
		num1 = sc.nextInt();
		System.out.println("El primero numero tecleado es el " + num1);

		System.out.println("Introduzca un segundo numero: ");
		num2 = sc.nextInt();
		System.out.println("El segundo numero tecleado es el " + num2);

		sc.close();
	}

}
