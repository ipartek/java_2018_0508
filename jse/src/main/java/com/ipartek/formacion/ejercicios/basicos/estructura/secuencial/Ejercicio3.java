package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
* Escribe un programa Java que lee un número entero por teclado y obtiene y 
* muestra por pantalla el doble y el triple de ese número.
*/
public class Ejercicio3 {

	public static void main(String[] args) {
		
		
		//TODO controlar que solo se introduzcan números enteros
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un número");
		
		int numero;
		
		numero = sc.nextInt();
		
		System.out.println("El doble del número introducido es " + 2 * numero);
		System.out.println("El triple del número introducido es " + 3 * numero);
		
		sc.close();
		
	}

}
