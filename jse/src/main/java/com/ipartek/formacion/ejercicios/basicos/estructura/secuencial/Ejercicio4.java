package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
* Programa que lea una cantidad de grados centígrados y la pase a grados Fahrenheit. 
* La fórmula correspondiente es: F = 32 + ( 9 * C / 5)
*/
public class Ejercicio4 {

	public static void main(String[] args) {
		
		
		//TODO controlar que solo se introduzcan números enteros
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Cuántos grados marca el termómetro?");
		
		int gradosCelsius;
		int gradosFarenheit;
		
		gradosCelsius = sc.nextInt();
		
		gradosFarenheit = 32 + (9 * gradosCelsius / 5);
		
		System.out.println("El termómetro marca " + gradosFarenheit + " grados farenheit");
		
		sc.close();

	}

}
