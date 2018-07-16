package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Programa Java que guarda en un array 10 números enteros que se leen por teclado.
 * A continuación se recorre el array y calcula cuántos números son positivos, cuántos negativos y cuántos ceros.
 * @author Alain
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int[] arrayNums = new int[10];
		int contPos = 0;
		int contNeg = 0;
		int contCeros = 0;
		
		for (int i = 0; i < arrayNums.length; i++) {
			System.out.println("Introduce un numero:");
			arrayNums[i] = teclado.nextInt();
			
			if(arrayNums[i] > 0){
				contPos++;
			}else if(arrayNums[i] < 0){
				contNeg++;
			}else{
				contCeros++;
			}
		}
		
		System.out.println();
		System.out.println("Dentro de la lista, hay " + contPos + " numeros positivos.");
		System.out.println("Dentro de la lista, hay " + contNeg + " numeros negativos.");
		System.out.println("Dentro de la lista, hay " + contCeros + " ceros.");

		teclado.close();
	}

}
