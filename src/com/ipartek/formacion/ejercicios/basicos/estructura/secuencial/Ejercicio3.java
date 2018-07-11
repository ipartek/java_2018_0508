package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 3. Programa Java que lee un número entero por teclado y obtiene y muestra<br>
 * por pantalla el doble y el triple de ese número.
 * 
 * @author Curso
 *
 */
public class Ejercicio3 {
	
	public static int num;
	private static Scanner scan;
	
	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		
		System.out.println("Introduce un numero: ");
		
		num = scan.nextInt();
		
		System.out.println("El doble es "+(num*2)+" y el triple "+(num*3));

	}

}
