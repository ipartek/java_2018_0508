package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea dos números por teclado y muestre el resultado de la
 * división del primer número por el segundo. Se debe comprobar que el divisor
 * no puede ser cero.
 * 
 * @author Curso
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		float num1;
		float num2;

		System.out.print("Introduce un número: ");
		num1 = sc.nextInt();
		do {
			System.out.print("Introduce otro número: ");
			num2 = sc.nextInt();
			if (num2 == 0)
				System.out.println("El número no puede ser 0 !!!");
		} while (num2 == 0);

		System.out.println(num1 + "/" + num2 + " = " + (num1 / num2) );
		sc.close();
	}

}
