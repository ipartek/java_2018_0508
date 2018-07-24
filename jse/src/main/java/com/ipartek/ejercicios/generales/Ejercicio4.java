package com.ipartek.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa Java que lea un número entero N y muestre la tabla de multiplicar de ese número
 * @author Curso
 *
 */

public class Ejercicio4 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		int numero;
		
		System.out.println("Introduce un numero");
		numero= sc.nextInt();
		
		System.out.println("Tabla de multiplicar del numero "+numero+":");
		
		for (int i= 1; i<=10; i++) {
			
			System.out.println(numero+"*"+i+"="+numero*i);
			
			
		}

}

}