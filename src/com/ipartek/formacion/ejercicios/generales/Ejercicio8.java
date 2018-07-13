package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Mostrar los N primeros términos de la serie de Fibonacci 
 * La serie de fibonacci la forman una serie de números tales que:
 * 
 * El primer término de la serie es el número 1
 * El segundo término de la serie es el número 1
 * Los siguientes términos de la serie de fibonacci se obtienen de la suma 
 * de los dos anteriores:
 * 
 * 1, 1, 2, 3, 5, 8, 13, .....  
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
		int numero;
		int anteriorTermino = 1;
		int siguienteTermino = 1;
		
		System.out.println("Introduce la cantidad de números que se mostrarán de la secuencia de fibonacci");
		numero = sc.nextInt();
		
		System.out.println("Los " + numero + " primeros números de la secuencia de fibonacci son:");
		System.out.print(anteriorTermino + " ");
		
		for (int i = 2; i <= numero; i++) {;
			System.out.print(siguienteTermino + " ");
			siguienteTermino += anteriorTermino;
			anteriorTermino = siguienteTermino - anteriorTermino;
		}
		
		sc.close();

	}

}
