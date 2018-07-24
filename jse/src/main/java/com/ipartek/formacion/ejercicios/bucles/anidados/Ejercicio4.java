package com.ipartek.formacion.ejercicios.bucles.anidados;

/**
 * 
 * Programa que muestre en lineas separadas lo siguiente:<br>
 * ZYWXVUTSRQPONMLKJIHGFEDCBA, YWXVUTSRQPONMLKJIHGFEDCBA,<br>
 * WXVUTSRQPONMLKJIHGFEDCBA, ...., DCBA, CBA, BA, A.
 * 
 * @author Asier Cornejo
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		for (char i = 'Z'; i >= 'A'; i--) {
			for (char j = i; j >= 'A'; j--) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

}
