package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		/**
		 * Programa que pida por teclado la fecha de nacimiento de una persona (dia, mes, año) 
		 * y calcule su número de la suerte.
		 * El número de la suerte se calcula sumando el día, mes y 
		 * año de la fecha de nacimiento y a continuación sumando las cifras obtenidas en la suma.
		 * Por ejemplo:
		 * Si la fecha de nacimiento es 12/07/1980 
		 * Calculamos el número de la suerte así: 12+7+1980 = 1999  1+9+9+9 = 28
		 * Número de la suerte: 28
		 */
		
		Scanner leer = new Scanner(System.in);
		
		int dia;
		int mes;
		int anio;
		
		System.out.println("Introduce tu fecha de nacimiento (día, mes, año)");
		
		dia = leer.nextInt();
		mes = leer.nextInt();
		anio = leer.nextInt();

	}

}
