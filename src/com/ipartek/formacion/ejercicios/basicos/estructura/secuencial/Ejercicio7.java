package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
* Programa lea la longitud de los catetos de un triángulo 
* rectángulo y calcule la longitud de la hipotenusa según el teorema de Pitágoras. 
*/
public class Ejercicio7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cateto1;
		int cateto2;
		double hipotenusa;
		
		System.out.println("Introduce la longitud de los dos catetos de un triánculo rectángulo en cm");
		
		cateto1 = sc.nextInt();
		cateto2 = sc.nextInt();
		
		hipotenusa = Math.sqrt((Math.pow(cateto1, 2)) + (Math.pow(cateto2, 2)));
		
		System.out.println("La longitud de la hipotenusa de ese triángulo es " + hipotenusa + "cm");
		
		sc.close();
		
	}

}
