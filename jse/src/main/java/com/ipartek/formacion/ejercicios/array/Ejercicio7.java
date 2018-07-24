package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Programa Java para leer la altura de N personas y calcular la altura media.
 * Calcular cuántas personas tienen una altura superior a la media y cuántas tienen una altura inferior a la media.
 * El valor de N se pide por teclado y debe ser entero positivo.
 * @author Alain
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int nPersonas = 0;
		int mediaAltura = 0;
		
		System.out.println("¿Cuantas personas hay?");
		nPersonas = teclado.nextInt();
		
		int[] alturas = new int[nPersonas];
		
		System.out.println();
		for (int i = 0; i < alturas.length; i++) {
			System.out.println("Introduce la altura de la persona " + (i+1) + ":");
			alturas[i] = teclado.nextInt();
			mediaAltura = mediaAltura + alturas[i];
		}
		
		// Calcular la media
		mediaAltura = mediaAltura / nPersonas;
		
		//Mostrar notas introducidas
		System.out.println();
		System.out.println("Las alturas introducidas son:");
		for (int i = 0; i < alturas.length; i++) {
			System.out.print(alturas[i] + " | ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("La altura media es: " + mediaAltura);
		
		//Comprobar que alturas superan la media
		System.out.println();
		for (int i = 0; i < alturas.length; i++) {
			if(alturas[i] > mediaAltura) {
				System.out.println("La altura de la persona " + (i+1) + "("+ alturas[i] + ") es superior a la media");
			}else if(alturas[i] < mediaAltura){
				System.out.println("La altura de la persona " + (i+1) + "("+ alturas[i] + ") es inferior a la media");
			}else{
				System.out.println("La altura de la persona " + (i+1) + "("+ alturas[i] + ") es igual a la media");
			}
		}

	
		teclado.close();
	}

}
