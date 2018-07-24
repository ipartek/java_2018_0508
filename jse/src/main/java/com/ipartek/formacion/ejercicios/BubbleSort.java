package com.ipartek.formacion.ejercicios;

public class BubbleSort {

	public static void main(String[] args) {
		
		int numeros[] = {0, 3, 1, 8, 7, 2, 5, 4, 6, 9};
		
		int nAuxiliar;
		
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 1; j < (numeros.length - i); j++) {
				if(numeros[j - 1] > numeros[j]) {
					nAuxiliar = numeros[j - 1];
					numeros[j - 1] = numeros[j];
					numeros[j] = nAuxiliar;
				}
				
			}
						
		}
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
		
	}

}
