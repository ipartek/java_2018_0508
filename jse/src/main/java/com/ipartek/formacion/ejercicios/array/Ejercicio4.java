package com.ipartek.formacion.ejercicios.array;

/**
 * Guardar en un array los 20 primeros números pares
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		
		int pares[] = new int[20];
		int contadorPares = 0;
		
		for (int i = 0; i < pares.length; i++) {
			pares[i] = contadorPares;
			contadorPares += 2;
		}
		
		System.out.println("Los 20 primeros números pares son:\n");
		
		for (int i = 0; i < pares.length; i++) {
			System.out.println(pares[i]);
		}

	}

}
