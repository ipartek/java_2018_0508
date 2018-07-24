package com.ipartek.formacion.ejercicios.array;

/**
 * 5. Contar el número de elementos positivos, negativos y ceros en un array de
 * 10 enteros.
 * 
 * @author apero
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {

		int[] numeros = {15,-15,25,-25,30,58,0,98,0,0};
		int cPositivo = 0;
		int cNegativo = 0;
		int cCero = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			if(numeros[i] < 0) {
				cNegativo++;
			}else if(numeros[i] > 0){
				cPositivo++;
			}else {
				cCero++;
			}
		}
		
		System.out.println("Hay "+cPositivo+" numeros positivos.");
		System.out.println("Hay "+cNegativo+" numeros negativos.");
		System.out.println("Hay "+cCero+" ceros.");

	}

}
