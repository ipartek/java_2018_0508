package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa Java que pide un número entero por teclado y calcula y muestra el número de cifras que tiene.
 * El proceso leer un número y contar sus cifras se repetirá hasta que se conteste ‘N’ a la pregunta Continuar? (S/N)
 * Si se responde 'S' se volverá a pedir otro número. 
 * @author Curso
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int n1;
		char car = 'S';
		
		do {
			System.out.println("Introduce un numero entero:");
			n1 = teclado.nextInt();
			int cifras= 0;
			
			while (n1 != 0) {
				n1 = n1/10;
				cifras++;
			}
			
			System.out.println();
			System.out.println("El numero tiene " + cifras + " cifras.");
			
			System.out.println();
			System.out.println("¿Continuar? S/N");
			car = teclado.next().charAt(0);
			System.out.println();
		} while (car!='n' && car != 'N');
		
		teclado.close();
	}

}
