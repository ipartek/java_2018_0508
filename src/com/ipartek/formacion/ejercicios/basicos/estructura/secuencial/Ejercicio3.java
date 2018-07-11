package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 3. Programa Java que lee un número entero por teclado y obtiene
 *         y muestra por pantalla el doble y el triple de ese número.
 */
public class Ejercicio3 {
	public static void main(String[] args) throws Exception {
		System.out.println("Introduzca un numero");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// convertimos la entrada a entero directamente
		int numero = Integer.parseInt(br.readLine());
		System.out.println("El numero introducido x 2 es: " + (numero * 2));
		System.out.println("El numero introducido x 3 es: " + (numero * 3));
	}
}
