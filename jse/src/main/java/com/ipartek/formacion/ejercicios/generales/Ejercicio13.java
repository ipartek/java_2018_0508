package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Comprobar si un número entero es capicúa
 *
 */
public class Ejercicio13 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numero;
		int auxiliar;
		int capicua = 0;
		int cifra;
		
		System.out.println("Introduce un número entero para comprobar si es capicúa");
		numero = sc.nextInt();
		
		auxiliar = numero;
		
		while(auxiliar != 0) {
			cifra = auxiliar % 10;
			capicua = capicua * 10 + cifra;
			auxiliar /= 10;
		}
		
		if(capicua == numero) {
			System.out.println("El número " + numero + " es capicúa");
		}
		else {
			System.out.println("El número " + numero + " no es capicúa");
		}
		
		sc.close();

	}

}
