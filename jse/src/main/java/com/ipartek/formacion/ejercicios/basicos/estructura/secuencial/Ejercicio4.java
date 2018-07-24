package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/***
 * Programa que lea una cantidad de grados cent�grados y la pase a grados
 * Fahrenheit. La f�rmula correspondiente es: F = 32 + ( 9 * C / 5)
 * 
 * @author user
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {

		double centigrados;
		double fahrenheit;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca los grados a transformar: ");
		centigrados = sc.nextDouble();

		fahrenheit = 32 + (9 * centigrados / 5);

		System.out.println(centigrados + " �C son " + fahrenheit + " grados Fahrenheit.");

		sc.close();
	}

}
