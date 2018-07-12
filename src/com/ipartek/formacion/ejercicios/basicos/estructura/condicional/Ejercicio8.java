package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Calcular el mayor de tres números enteros en Java.
 *
 * El programa lee por teclado tres números enteros y calcula y muestra el mayor de los tres.
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int numero1;
		int numero2;
		int numero3;
		
		System.out.println("Introduce un primer número");
		numero1 = sc.nextInt();
		
		System.out.println("Introduce un segundo número");
		numero2 = sc.nextInt();
		
		System.out.println("Introduce un tercer número");
		numero3 = sc.nextInt();
		
		if (numero1 > numero2 && numero1 > numero3) {
			System.out.println(numero1 + " es el mayor");
		}
		else if(numero2 > numero1 && numero2 > numero3) {
			System.out.println(numero2 + " es el mayor");
		}
		else {
			System.out.println(numero3 + " es el mayor");
		}
		
		sc.close();

	}

}
