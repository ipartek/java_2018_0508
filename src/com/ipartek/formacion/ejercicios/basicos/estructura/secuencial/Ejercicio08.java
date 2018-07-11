package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Ejercicio 8: Programa que tome como dato de entrada un número que corresponde
 * a la longitud del radio una esfera y nos calcula y escribe el volumen de la
 * esfera que se corresponden con dicho radio.
 * 
 * La fórmula para calcular el volumen de la esfera es v = (4/3)*PI*r^3
 * 
 * @author Curso
 *
 */
public class Ejercicio08 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double longitud;
		
		System.out.println("Dame la longitud del radio de la esfera: ");
		longitud = sc.nextDouble();
		
		System.out.println("El volumen de la esfera es "+ ((4/3)*Math.PI*(Math.pow(longitud, 3))));
		
		sc.close();

	}

}
