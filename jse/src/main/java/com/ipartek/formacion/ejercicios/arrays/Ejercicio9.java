package com.ipartek.formacion.ejercicios.arrays;

/**
 * 
 * @author Curso 9. Llenar un array con números aleatorios.
 */
public class Ejercicio9 {
	public static void main(String[] args) {
		int numAleatorio =0;
		
		int [] ArrayAleatorio = new int[10];
		for(int x =0; x<ArrayAleatorio.length;x++) {
			ArrayAleatorio[x] =  (int) (Math.random() * 1000) + 1;
			System.out.println(ArrayAleatorio[x]);
		}
	}
}
