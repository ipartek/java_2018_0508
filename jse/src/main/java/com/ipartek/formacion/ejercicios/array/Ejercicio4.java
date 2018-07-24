package com.ipartek.formacion.ejercicios.array;

/**
 * Programa que crea un array de 20 elementos llamado Pares y guarde los 20 primeros números pares.
 * @author Alain
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		
		int[] pares = new int[20];
		int cont = 2;
		
		for (int i = 0; i < pares.length; i++) {
				pares[i] = cont;
				cont += 2;
		}
		
		System.out.println("Los 20 primeros numeros pares son:");
		for (int i = 0; i < pares.length; i++) {
			if(i != 19){
				System.out.print(pares[i] + ", ");
			}else {
				System.out.print(pares[i] + ".");
			}
			
		}

	}

}
