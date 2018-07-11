package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 10. 10. Programa que lee un número de 3 cifras y muestra sus
 *         cifras por separado.
 */
public class Ejercicio10 {
	public static void main(String[] args) throws Exception {
		int numero;
		int tercero;
		int segundo;
		int primero;

		System.out.println("Introduce numero de 3 cifras :");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numero = Integer.parseInt(br.readLine());

		primero = numero / 100;
		segundo = (numero / 10) % 10;
		tercero = numero % 10;

		System.out.println("Primera cifra de " + numero + " -> " + primero);
		System.out.println("Segunda central de " + numero + " -> " + segundo);
		System.out.println("Tercera cifra  de " + numero + " -> " + tercero);

	}
}
