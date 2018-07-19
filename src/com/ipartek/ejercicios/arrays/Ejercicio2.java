package com.ipartek.ejercicios.arrays;

import java.util.Scanner;

/**
 * Programa Java que lea 10 números enteros por teclado y los guarde en un array. 
 * Calcula y muestra la media de los números que estén en las posiciones pares del array
 * @author Curso
 *
 */

public class Ejercicio2 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		int i;
		int numeros[]= new int[10];
		double media= 0;
		
		for (i = 0; i < 10; i++) {
            System.out.print("numeros[" + i + "]: ");
            numeros[i]= sc.nextInt();
		
		}
		
		for (i = 0; i < 10; i++) {
			if(i%2==0) { //vemos si la posición actual es par
				media= media+numeros[i]; //sumamos el valor de esa posición
				
			}
			
		}
		
		System.out.println("Media de los numeros en posiciones pares: "+media/5);

}
	
}
