package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

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
public class Ejercicio13 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int dia;
		int mes;
		int anio;
		int total;
		int numeroSuerte;
		int cuartoDigito;
		int tercerDigito;
		int segundoDigito;
		int primerDigito;
		
		System.out.println("Introduce tu fecha de nacimiento (día, mes, año)");
		
		dia = sc.nextInt();
		mes = sc.nextInt();
		anio = sc.nextInt();
		
		total = dia + mes + anio;
		
		cuartoDigito = total % 10;
		total /= 10;

		tercerDigito = total % 10;
		total /= 10;
		
		segundoDigito = total % 10;
		total/=10;
		
		primerDigito = total % 10;
		
		numeroSuerte = primerDigito + segundoDigito + tercerDigito + cuartoDigito;
		
		System.out.println("Tu número de la suerte es " + numeroSuerte);
		
		sc.close();
		
	}

}
