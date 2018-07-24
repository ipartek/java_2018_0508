package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * 7: Programa que lea dos números por teclado y muestre el resultado de la
 * división del primer número por el segundo. Se debe comprobar que el divisor
 * no puede ser cero.
 * 
 * @author valen
 *
 */

public class Ejercicio7 {
	public static void main(String[] args) {
		Scanner p = new Scanner(System.in);
		int numero1;
		int numero2;
		System.out.println("Ingresa el primer numero ");
		numero1 = p.nextInt();
		System.out.println("Ingrese el segundo numero");
		numero2 = p.nextInt();
		if (numero2 == 0) {
			System.out.println("No se puede hacer la division");
		} else {
			System.out.println("El resultado de la division es " + numero1 / numero2);
		}

	}
}