package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa java para calcular si un número es perfecto
 * El programa pide por teclado un número y muestra si es perfecto o no. mediante un bucle for sumaremos los divisores del número. Al final si esta suma es igual al número mostraremos el mensaje correspondiente.
 * @author Curso
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int n1;
		int suma = 0;
		
		System.out.println("Introduce un numero:");
		n1 = teclado.nextInt();
		
		for (int i = 1; i < n1; i++) { // i son los divisores. Se divide desde 1 hasta n-1 
			if(n1 % i == 0) { // si es divisor se suma
				suma = suma + i;
			}
		}
		
		System.out.println();
		if(suma == n1) { // comprueba si es el numero es perfecto
			System.out.println("Este numero es perfecto");
		}else {
			System.out.println("Este numero no es perfecto");
		}
		
		teclado.close();
	}
}
