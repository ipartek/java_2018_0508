package com.ipartek.formacion.ejercicios;

public class Bubblesort {

	public static void main(String[] args) {
		
		int[] numeros = {0, 3, 1, 8, 7, 2, 5, 4, 6, 9};
		
		System.out.print("Los numeros del array desordenados son: ");
		for (int i = 0; i < numeros.length; i++) {
			if(i == numeros.length-1) {
				System.out.print(numeros[i] + ".");
			}else {
				System.out.print(numeros[i] + ", ");
			}
		}
		
		/* Ordenamos los numeros del array de menor a mayor */
		/*for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros.length-i-1; j++) {
				if(numeros[j] > numeros[j + 1]) {
					int n1 = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j+1] = n1;
				}
			}
		}*/
		
		/* Ordenamos los numeros del array de mayor a menor */
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros.length-i-1; j++) {
				if(numeros[j] < numeros[j + 1]) {
					int n1 = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j+1] = n1;
				}
			}
		}
		
		System.out.println();
		System.out.print("Los numeros del array ordenado son: ");
		for (int i = 0; i < numeros.length; i++) {
			if(i == numeros.length-1) {
				System.out.print(numeros[i] + ".");
			}else {
				System.out.print(numeros[i] + ", ");
			}
		}
		

	}

}
