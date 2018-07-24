package com.ipartek.formacion.ejercicios.bucles.anidados;

/**
 * Programa que muestre en lineas separadas lo siguiente:
 * ZYWXVUTSRQPONMLKJIHGFEDCBA, YWXVUTSRQPONMLKJIHGFEDCBA,
 * WXVUTSRQPONMLKJIHGFEDCBA, ...., DCBA, CBA, BA, A. en este caso se trata de
 * mostrar las letras del abecedario (sin la Ñ) en mayúsculas y en orden
 * inverso. A continuación en cada fila mostrar una letra menos hasta llegar a
 * mostrar solamente la A
 * 
 * @author andreaperez
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