package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		/**
		 * Programa que lea una cantidad de grados centígrados y la pase a grados Fahrenheit. 
		 * La fórmula correspondiente es: F = 32 + ( 9 * C / 5)
		 */
		
		//TODO controlar que solo se introduzcan números enteros
		Scanner leer = new Scanner(System.in);
		
		System.out.println("¿Cuántos grados marca el termómetro?");
		
		int gradosCelsius;
		int gradosFarenheit;
		
		gradosCelsius = leer.nextInt();
		
		gradosFarenheit = 32 + (9 * gradosCelsius / 5);
		
		System.out.println("El termómetro marca " + gradosFarenheit + " grados farenheit");
		
		leer.close();

	}

}
