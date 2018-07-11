package com.ipartek.formacion.ejercicios.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa lea la longitud de los catetos de un triángulo rectángulo y calcule la longitud de la hipotenusa según el teorema de Pitágoras.
 * @author Curso
 *
 */

public class Ejercicio7 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		float cateto1;
		float cateto2;
		
		System.out.println("Introduce la longitud de un cateto:");
		cateto1 = teclado.nextFloat();
		
		System.out.println("Introduce la longitud de otro cateto:");
		cateto2 = teclado.nextFloat();
		
		System.out.println("La hipotenusa es: " + Math.sqrt(Math.pow(cateto1,2)+ Math.pow(cateto2, 2)));

		teclado.close();
	}

}
