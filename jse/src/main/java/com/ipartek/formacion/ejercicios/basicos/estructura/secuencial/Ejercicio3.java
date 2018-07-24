package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/*
 *   Escribe un programa Java que lee un número entero por teclado y obtiene y 
 *   muestra por pantalla el doble y el triple de ese número.
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		// Variables
		int n;
		Scanner sc=new Scanner (System.in);
		
		System.out.println("Introduce un numero entero por teclado:");
		n=sc.nextInt();
		
		System.out.println("El doble del numero introducido es: "+(n*2));
		System.out.println("El triple del numero introducido es: "+(n*3));
		

	}

}
