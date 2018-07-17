package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/***
 * Programa lea la longitud de los catetos de un triángulo rectángulo y calcule
 * la longitud de la hipotenusa según el teorema de Pitágoras.
 * 
 * @author Curso
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double cateto1;
		double cateto2;

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el valor del primer cateto: ");
		cateto1 = sc.nextDouble();
		System.out.println("Introduce el valor del segundo cateto: ");
		cateto2 = sc.nextDouble();

		System.out.println("El valor de la hipotenusa es de " + Math.pow(cateto1, 2) + Math.pow(cateto2, 2));

		sc.close();
	}

}
