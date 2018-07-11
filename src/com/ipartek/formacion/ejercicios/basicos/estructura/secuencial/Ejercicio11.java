package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 11. Programa que lea un número entero N de 5 cifras y muestre
 *         sus cifras desde el principio como en el ejemplo.
 */
public class Ejercicio11 {
	public static void main(String[] args) throws Exception {
		int numero;
		int primero;
		int segundo;
		int tercero;
		int cuarto;
		int quinto;

		System.out.println("Introduce numero de 5 cifras :");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numero = Integer.parseInt(br.readLine());

		/*
		 * primero = numero/10000; segundo = numero/1000; tercero = numero/100; cuarto =
		 * numero/10; quinto = numero;
		 * 
		 * 
		 * System.out.println("Primera cifra de " + numero + " -> " + primero);
		 * System.out.println("Segunda central de " + numero + " -> " + segundo);
		 * System.out.println("Tercera cifra  de " + numero + " -> " + tercero);
		 * System.out.println("Cuarto cifra  de " + numero + " -> " + cuarto);
		 * System.out.println("Quinto cifra  de " + numero + " -> " + quinto);
		 */

		System.out.println(numero / 10000);
		System.out.println(numero / 1000 % 10);
		System.out.println(numero / 100);
		System.out.println(numero / 10);
		System.out.println(numero);
	}
}
