package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
* Programa Java que lea dos números enteros por teclado y los muestre por pantalla.
*/
public class Ejercicio1 {

	public static void main(String[] args) {
		
		//TODO controlar que solo se introduzcan números enteros
		Scanner sc = new Scanner(System.in);
		
		int numero1;
		int numero2;
		
		System.out.println("Introduce dos números");
		
		numero1 = sc.nextInt();
		numero2 = sc.nextInt();
		
		System.out.println("El primer número introducido es " + numero1);
		System.out.println("El segundo número introducido es " + numero2);

		sc.close();

	}

}
