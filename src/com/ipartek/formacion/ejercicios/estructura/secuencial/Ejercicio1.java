package com.ipartek.formacion.ejercicios.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa Java que lea dos números enteros por teclado y los muestre por pantalla.
 * @author Curso
 *
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int n1;
		int n2;
		
		System.out.println("Escribe un numero:");
		n1 = teclado.nextInt();
		System.out.println("Escribe otro:");
		n2 = teclado.nextInt();
		
		System.out.println("Los numeros escritos son: " + n1 + " y " + n2);
		
		teclado.close();
	}

}
