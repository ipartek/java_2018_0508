package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		/**
		 * Programa Java que lea dos números enteros por teclado y los muestre por pantalla.
		 */
		
		//TODO controlar que solo se introduzcan números enteros
		Scanner leer = new Scanner(System.in);
		
		int numero1;
		int numero2;
		
		System.out.println("Introduce dos números");
		
		numero1 = leer.nextInt();
		numero2 = leer.nextInt();
		
		System.out.println("El primer número introducido es " + numero1);
		System.out.println("El segundo número introducido es " + numero2);

		leer.close();

	}

}
