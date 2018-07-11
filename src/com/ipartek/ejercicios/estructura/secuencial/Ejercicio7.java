package com.ipartek.ejercicios.estructura.secuencial;
import java.util.Scanner;
/**
 * Programa lea la longitud de los catetos de un triángulo rectángulo y calcule la longitud de la hipotenusa según el teorema de Pitágoras.
 * @author Curso
 *
 */

public class Ejercicio7 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		 double cateto1;
		 double cateto2;
	     System.out.print("Introduce la longitud del primer cateto: ");
	     cateto1 = sc.nextDouble();
	     System.out.print("Introduce la longitud del segundo cateto: ");
	     cateto2 = sc.nextDouble();
	     System.out.println("Hipotenusa: " +  Math.sqrt(Math.pow(cateto1,2)+ Math.pow(cateto2, 2)));
	}

}
