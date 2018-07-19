package com.ipartek.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa que imprima los N primeros números de la serie de Fibonacci
 * @author Curso
 *
 */

public class Ejercicio8 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		int numero;
		int i;
		int fibo1;
		int fibo2;
		
		do {
			
			System.out.println("Introduce un numero mayor que uno");
			numero= sc.nextInt();
		}
		
		while(numero>=1);
			System.out.println("Los "+numero+" primeros numeros de la serie son: ");
			
			fibo1= 1;
			fibo2= 1;
			
			System.out.print(fibo1 + " ");
	        
			for(i=2;i<=numero;i++){
				
	             System.out.print(fibo2 + " ");
	             fibo2 = fibo1 + fibo2;
	             fibo1 = fibo2 - fibo1;
	        }
			
	        System.out.println();
		

}
	
}
