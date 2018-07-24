package com.ipartek.formacion.ejercicios.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea dos números por teclado y muestre el resultado de la división del primer número por el segundo. Se debe comprobar que el divisor no puede ser cero.
 * @author Curso
 *
 */

public class Ejercicio7 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		int n1;
		int n2;
		int res;
		
		System.out.println("Introduce un numero:");
		n1 = teclado.nextInt();
		
		System.out.println("Introduce otro numero:");
		n2 = teclado.nextInt();
		
		if(n2 != 0) {
			res = n1 / n2;
			System.out.println(n1 + " / " + n2 + " = " + res);
		}else {
			System.out.println();
			System.out.println("¡No puede dividir por cero!");
		}
		
		teclado.close();

	}

}
