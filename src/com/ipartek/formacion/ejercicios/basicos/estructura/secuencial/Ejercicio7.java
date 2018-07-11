package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Ejercicio 7. Programa lea la longitud de los catetos de un triángulo
 * rectángulo y calcule la longitud de la hipotenusa según el teorema de
 * Pitágoras.
 * 
 * @author valen
 *
 */

public class Ejercicio7 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double catetoa;
		double catetob;

		System.out.println("Ingrese el primer catetoa =  ");
		catetoa = s.nextDouble();
		System.out.println("Ingrese el segundo catetob = ");
		catetob = s.nextDouble();

		System.out.println(" la longitud de la hipotenusa segun el teorema de Pitagoras es = "
				+ Math.sqrt(Math.pow(catetoa, 2) + Math.pow(catetob, 2)));

	}

}
