package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.*;

/**
 * Programa lea la longitud de los catetos de un triángulo rectángulo y calcule
 * la longitud de la hipotenusa según el teorema de Pitágoras
 * 
 * @author Curso
 *
 */

public class Ejercicio7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		float cateto1;
		float cateto2;

		System.out.print("Introduce cateto1: ");
		cateto1 = sc.nextFloat();
		System.out.print("Introduce cateto2: ");
		cateto2 = sc.nextFloat();
		System.out.println("La longitud de la hipotenusa es " + Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2)));

		sc.close();
	}

}
