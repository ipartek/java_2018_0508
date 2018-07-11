package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Ejercicio 7. Programa lea la longitud de los catetos de un triángulo
 * rectángulo y calcule la longitud de la hipotenusa según el teorema de
 * Pitágoras.
 * 
 * @author Curso
 *
 */
public class Ejercicio07 {

	public static void main(String[] args) {
	
		double c1;
		double c2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el primer cateto:");
		c1 = sc.nextDouble();
		
		System.out.println("Introduce el segundo cateto:");
		c2 = sc.nextDouble();
		
		System.out.println("La hipotenusa es "+ Math.sqrt(((c1*c1)+(c2+c2))));
		
		sc.close();

	}

}
