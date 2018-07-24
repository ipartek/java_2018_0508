package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Programa Java que llene un array con 10 números enteros que se leen por teclado.
 * A continuación calcula y muestra la media de los valores positivos y la de los valores negativos del array.
 * @author Alain
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		int[] arrayNums = new int[10];
		int mediaPos = 0;
		int mediaNeg = 0;
		int contPos = 0;
		int contNeg = 0;

		
		for (int i = 0; i < arrayNums.length; i++) {
			System.out.println("Introduce un numero:");
			arrayNums[i] = teclado.nextInt();
			
			if(arrayNums[i] > 0){
				mediaPos += arrayNums[i];
				contPos++;
			}else{
				mediaNeg += arrayNums[i];
				contNeg++;
			}
		}
		
		System.out.println();
		if(contPos != 0){
			System.out.println("La media de los numeros positivos de la lista es: " + (mediaPos / contPos));
		}else{
			System.out.println("No has introducido numeros positivos.");
		}

		System.out.println();
		if(contNeg != 0){
			System.out.println("La media de los numeros negativos de la lista es: " + (mediaNeg / contNeg));
		}else{
			System.out.println("No has introducido numeros negativos.");
		}
		
		
		teclado.close();
	}

}
