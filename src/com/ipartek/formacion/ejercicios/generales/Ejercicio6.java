package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa java para calcular si un número es perfecto
 * El programa pide por teclado un número y muestra si es perfecto o no. mediante un 
 * bucle for sumaremos los divisores del número. 
 * Al final si esta suma es igual al número mostraremos el mensaje correspondiente.
 */

public class Ejercicio6 {

	public static void main(String[] args) {
		int numero, divisor, suma = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero ");
		numero = sc.nextInt();
		
		for(divisor = 1; divisor < numero; divisor++) {
			if(numero % divisor == 0) {
				suma = suma + divisor;
			}
		}

		if(numero == suma) {
			System.out.println("Es un numero perfecto");
		}
		else {
			System.out.println("No es un numero perfecto");
		}
		
		sc.close();
	}

}
