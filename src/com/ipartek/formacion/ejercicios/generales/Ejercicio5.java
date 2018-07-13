
package com.ipartek.formacion.ejercicios.generales;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author curso 5. Leer números y contar cuántos acaban en 2.
 */
public class Ejercicio5 {
	public static void main(String[] args) throws Exception {
		int numero = 0;
		int contador = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("Introduce un numero:");
			numero = Integer.parseInt(br.readLine());
			if (numero % 10 == 2) {
				contador += 1;
			}
			System.out.println("Numeros acabados en 2: " + contador);
		} while (numero > 0);
	}
}
