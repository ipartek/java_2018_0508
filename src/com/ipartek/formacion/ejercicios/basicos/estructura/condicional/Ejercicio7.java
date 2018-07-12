package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * 
 * @author Asier Cornejo
 * 
 *         Programa que lea dos números por teclado y muestre el resultado de
 *         la<br>
 *         división del primero por el segundo. Se debe comprobar que el
 *         divisor<br>
 *         no puede ser cero.
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {

		int num;
		int num2;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un número entero:");
		num = sc.nextInt();
		System.out.println("Introduce otro número entero:");
		num2 = sc.nextInt();
		if (num2 > 0) {
			System.out.println("El resultado de dividir " + num + "/" + num2 + " = " + num / num2);
		} else {
			System.out.println("Lo siento pero el divisor no puede ser 0");
		}
		sc.close();
	}

}
