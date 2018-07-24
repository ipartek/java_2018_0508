package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa lea la longitud de los catetos de un triángulo rectángulo y calcule
 * la longitud de la hipotenusa según el teorema de Pitágoras.
 */

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Longitud cateto 1:  ");
		float side1 = teclado.nextFloat();
		System.out.print("Longitud cateto 2:  ");
		float side2 = teclado.nextFloat();

		System.out.println("La hipotenusa es : " + Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2)));
		teclado.close();

	}

}
