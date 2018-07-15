package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Comprobar si un número entero es capicúa. Vamos a escribir un programa Java
 * que pida por teclado un número entero N de más de una cifra y verifique si es
 * capicúa.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio13 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		do {
			System.out.print("Escribe un numero de mas de 1 cifra para saber si es capicuo o no: ");
			sb.append(sc.next());

		} while (sb.length() < 2);

		if (sb.toString().equals(sb.reverse().toString())) {
			System.out.println(sb + " es capicuo");
		} else {
			System.out.println(sb + " no es capicuo");
		}

		sc.close();

	}

}
