package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 
 * @author Asier Cornejo
 * 
 *         Programa lea la longitud de los catetos de un triángulo rectángulo y
 *         <br>
 *         calcule la longitud de la hipotenusa según el teorema de Pitágoras.
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		double cateto1 = 0.0;
		double cateto2 = 0.0;
		double hipotenusa = 0.0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el valor del primer cateto");
		cateto1 = sc.nextDouble();
		System.out.println("Introduzca el valor del segundo cateto");
		cateto2 = sc.nextDouble();
		hipotenusa = Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
		System.out.println("La hipotenusa del triangulo con lados " + cateto1 + ", y " + cateto2 + " es:" + hipotenusa);
		sc.close();
	}

}
