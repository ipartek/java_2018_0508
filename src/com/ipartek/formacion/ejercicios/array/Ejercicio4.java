package com.ipartek.formacion.ejercicios.array;

/**
 * 4. Guardar en un array los 20 primeros números pares
 * @author apero
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {

		int[] nPares = new int[20];
		int contador = 0;
		
		for (int i = 0; i < 100; i++) {
			if(i%2==0) {
				nPares[contador] = i;
				contador++;
			}
			if (contador >= nPares.length) {
				break;
			}
		}
		
		for (int i = 0; i < nPares.length; i++) {
			System.out.println(nPares[i]);
		}

	}

}
