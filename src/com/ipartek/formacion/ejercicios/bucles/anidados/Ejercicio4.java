package com.ipartek.formacion.ejercicios.bucles.anidados;

/**
 * 4. Programa que muestre en lineas separadas lo siguiente:
 * ZYWXVUTSRQPONMLKJIHGFEDCBA, YWXVUTSRQPONMLKJIHGFEDCBA,
 * WXVUTSRQPONMLKJIHGFEDCBA, ...., DCBA, CBA, BA, A.
 * 
 * @author Curso
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		for (char x = 'Z'; x >= 'A'; x--) {
			for (char y = x; y >= 'A'; y--) {
				System.out.print(y);
			}
			System.out.println();
		}
	}

}
