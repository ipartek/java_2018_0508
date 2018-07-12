package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 
 * @author Curso
 *
 */
public class Ejercicio13 {
	public static void main(String[] args) {
		
		int dia;
		int mes;
		int anio;
		int num;

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca día de nacimiento:");
		
		dia = sc.nextInt();
		System.out.print("Introduzca el mes de nacimiento: ");
		
		mes = sc.nextInt();
		System.out.print("Introduzca el año de nacimiento: ");
		
		anio = sc.nextInt();
		num = (anio / 1000) + (anio / 100 % 10) + (anio / 10 % 10) + (anio % 10);
		
		System.out.println("Su número de la suerte es: " + (num + dia + mes));

		sc.close();
	}

}
