package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/***
 * Programa que lea dos n�meros por teclado y muestre el resultado de la
 * divisi�n del primero por el segundo. Se debe comprobar que el divisor no
 * puede ser cero.
 * 
 * @author Curso
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		double num1, num2;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero: ");
		num1 = sc.nextDouble();
		System.out.println("Introduce otro numero: ");
		num2 = sc.nextDouble();

		if (num2 == 0)
			System.out.println("No se puede realizar la division porque el segundo numero es 0");
		else
			System.out.println("La division de " + num1 + "/" + num2 + " es " + num1 / num2);

		sc.close();
	}

}
