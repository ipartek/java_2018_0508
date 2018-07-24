package com.ipartek.ejercicios.arrays;

import java.util.Scanner;

/**
 * Programa Java que guarda en un array 10 números enteros que se leen por teclado. 
 * A continuación se recorre el array y calcula cuántos números son positivos, 
 * cuántos negativos y cuántos ceros
 * @author Curso
 *
 */

public class Ejercicio5 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		int numeros[]= new int[10];
		int positivos= 0;
		int negativos= 0;
		int ceros= 0;
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.print("numeros[" + i + "]= ");
            numeros[i] = sc.nextInt();
		}
		
		for (int i = 0; i < numeros.length; i++) {
			
			 if (numeros[i] > 0) {
	                positivos++;
	            } else if (numeros[i] < 0) {
	                negativos++;
	            } else {
	                ceros++;
	            }
			
		}
		
		System.out.println("Numeros Positivos: " + positivos);
        System.out.println("Numeros Negativos: " + negativos);
        System.out.println("Numeros Ceros: " + ceros);

}
	
}
