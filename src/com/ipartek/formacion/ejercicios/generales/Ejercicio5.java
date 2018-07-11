package com.ipartek.formacion.ejercicios.generales;

import java.io.IOException;
import java.util.Scanner;

/**
 * Programa que lea una serie de números por teclado hasta que se lea un número 
 * negativo. El programa indicará cuántos números acabados en 2 se han leído.
 * Para saber si un número acaba en dos o en general para saber en qué dígito 
 * termina un número entero se divide el número entre 10 y se obtiene el resto de 
 * esta división.
 * En Java el operador que obtiene el resto de una división es el operador 
 * En este caso para saber si el número acaba en 2 escribiremos la instrucción:
 * if(n%10==2)
 *
 */

public class Ejercicio5 {

	public static void main(String[] args) throws IOException {
		
		int numero;
		int contador = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero ");
		numero = sc.nextInt();
		System.in.read();
		
		while(numero >= 0) {
			if(numero % 10 == 2) {
				contador++;
			}	
			System.out.println("Introduce un numero ");
			numero = sc.nextInt();
		}
		
		System.out.println("Acaban en 2: " + contador + " numeros");
		
		sc.close();
	}

}
