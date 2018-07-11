package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

/**
 * Programa lea la longitud de los catetos de un triángulo rectángulo y 
 * calcule la longitud de la hipotenusa según el teorema de Pitágoras.
 */

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		double cateto1, cateto2;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el primer cateto ");
		cateto1 = sc.nextDouble();
		System.out.println("Introudce el segundo cateto");
		cateto2 = sc.nextDouble();
		
		System.out.println("Tienes un triangulo rectangular con un cateto de " + cateto1 + 
				" centimetros y otro cateto de " + cateto2 + " centimetros. Su hipotenusa seria de "
				+ Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2)) + " centimetros.");

		sc.close();
	}

}
