package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * 2. Programa que lea un número entero y muestre si el número es múltiplo de
 * 10.
 * 
 * Podemos comprobar si un número entero es múltiplo de 10 si al dividirlo por
 * 10 es resto de esta división es cero.
 * 
 * @author valen
 *
 */

public class Ejercicio2 {
	public static void main(String[] args) {
		Scanner m = new Scanner(System.in);
		int numero;
		System.out.println("Ingrese el numero entero = ");
		numero = m.nextInt();

		if (numero % 10 == 0) {
			System.out.println("Es multiplo de 10 = ");
		} else {
			System.out.println("No es multiplo de 10 = ");
		}
	}

}
