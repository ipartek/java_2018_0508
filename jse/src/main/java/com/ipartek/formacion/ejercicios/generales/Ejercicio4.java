package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa Java que lea un número entero N y muestre la tabla de multiplicar de
 * ese número. Por ejemplo, si se lee el valor 7 se mostrará por pantalla:
 * 
 * @author valen
 *
 */

public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numero;
		System.out.println("Ingrese el numero = ");
		numero = s.nextInt();
		for (int i = 0; i <= 10; i++) {
			System.out.println("La tabla de multiplar es : " + numero * i);
		}

	}

}
