package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

/**
 * Programa que pida por teclado la fecha de nacimiento de una persona (dia, mes, año) 
 * y calcule su número de la suerte.
 * El número de la suerte se calcula sumando el día, mes y año de la fecha de 
 * nacimiento y a continuación sumando las cifras obtenidas en la suma.
 * Por ejemplo:
 * Si la fecha de nacimiento es 12/07/1980 
 * Calculamos el número de la suerte así: 12+7+1980 = 1999  1+9+9+9 = 28
 * Número de la suerte: 28
 */

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		int dia, mes, anyo, suerte, suma, cifra1, cifra2, cifra3, cifra4;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escribe el dia de tu cumpleaños");
		dia = sc.nextInt();
		
		System.out.println("Escribe el mes de tu cumpleaños");
		mes = sc.nextInt();
		
		System.out.println("Escribe el año de tu cumpleaños");
		anyo = sc.nextInt();
		
		suma = dia + mes + anyo;
		
		cifra1 = suma/1000;
		cifra2 = suma/100 % 10;
		cifra3 = suma/10 % 10;
		cifra4 = suma %10;
		
		suerte = cifra1 + cifra2 + cifra3 + cifra4;
		
		System.out.println("Tu numero de la suerte es: " + suerte);
		
		sc.close();
	}

}
