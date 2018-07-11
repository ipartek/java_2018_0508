package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * 4: Programa que lea dos caracteres y compruebe si son iguales.
 * 
 * @author valen
 *
 */

public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner m = new Scanner(System.in);
		char letra1;
		char letra2;
		System.out.println("Ingre el primer caracter = ");
		letra1 = m.nextLine().charAt(0);
		System.out.println("Ingre el segundo caracter = ");
		letra2 = m.nextLine().charAt(0);

		if (letra1 == letra2) {
			System.out.println("Son iguales");
		} else {
			System.out.println("No son iguales");
		}
	}

}
