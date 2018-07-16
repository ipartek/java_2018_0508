package com.ipartek.formacion.ejercicios.arrays;

import java.util.Scanner;

/**
 * 1. Calcular la media de una serie de números que se leen por teclado.<br>
 * 
 * Programa Java que lea por teclado 10 números enteros y los guarde en un<br>
 * array. A continuación calcula y muestra por separado la media de los valores<br>
 * positivos y la de los valores negativos.<br>
 * 
 * @author Ainara
 *
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		
		int[] numeros = new int[10]; 
		int positivos = 0;
		int negativos = 0;
		int i;
		float resulpos = 0;
		float resulneg = 0;
		
		Scanner sc = new Scanner(System.in);
		
		for(i=0;i<numeros.length;i++) {
			System.out.println("Introduce un numero: ");
			numeros[i]=sc.nextInt();
		}
		
		for (i = 0; i < 10; i++) {
            if (numeros[i] > 0){ 
                positivos += numeros[i];
                resulpos++;
            } else if (numeros[i] < 0){ 
                negativos += numeros[i];
                resulneg++;
            }
        }
 
        if (positivos != 0) {
            System.out.println("Media de los valores positivos: " + positivos / resulpos);
        } else {
            System.out.println("No ha introducido numeros positivos");
        }
        if (negativos != 0) {
            System.out.println("Media de los valores negativos: " + negativos / resulneg);
        } else {
            System.out.println("No ha introducido numeros negativos");
        }
	
        sc.close();

	}

}
