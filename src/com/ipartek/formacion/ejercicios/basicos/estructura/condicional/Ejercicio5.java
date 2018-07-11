package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * 5: Programa java que lea dos caracteres por teclado y compruebe si los dos
 * son letras minúsculas
 * 
 * @author valen
 *
 */

public class Ejercicio5 {
	public static void main(String[] args) {
		Scanner p = new Scanner(System.in);
		char letra1;
		char letra2;

		System.out.println("Ingrese el primer caracter = ");
		letra1 = p.nextLine().charAt(0);
		System.out.println("Ingrese el segundo caracter = ");
		letra2 = p.nextLine().charAt(0);

		if (letra1 >= 'a' && letra1 <= 'z') {
			if (letra2 >= 'a' && letra2 <= 'z')
				System.out.println("Las dos son letras minusculas ");
		} else {
			if (letra2 >= 'a' && letra2 <= 'z') {
				System.out.println("el segundo caracter es minuscula pero el primero no  ");
			} else {
				if (letra1 >= 'a' && letra1 <= 'z') {
					System.out.println("El primero es minuscula pero el segundo no");
				} else {
					System.out.println("ninguno es minuscula");
				}
			}
		}

	}
}
