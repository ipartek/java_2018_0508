package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Comprobar si un número entero es capicúa
 */
public class Ejercicio13 {

	public static void main(String[] args) {
		System.out.print("ntroduce un numero: ");
		Scanner teclado = new Scanner(System.in);
		String num = teclado.next();
		boolean correct = true;
		for (int i = 0; i < Math.floor(num.length()/2); i++) {
			if(num.charAt(i) != num.charAt((num.length()-1)-i)) {
				correct =false;
				break;
			}
		}
		System.out.println((correct)?"Es capicua":"No es capicua");
		teclado.close();

	}

}
