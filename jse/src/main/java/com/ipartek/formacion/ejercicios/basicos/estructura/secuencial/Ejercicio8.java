package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/***
 * Programa que calcula el volumen de una esfera.
 * 
 * @author Curso
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {
		double radio;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el valor del radio de la esfera: ");
		radio = sc.nextDouble();
		System.out.println("El volumen de la esfera es " + (4 / 3) * Math.PI * Math.pow(radio, 3));

		sc.close();
	}

}
