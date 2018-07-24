package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Ejercicio 13: Programa que pida por teclado la fecha de nacimiento de una
 * persona (dia, mes, año) y calcule su número de la suerte. El número de la
 * suerte se calcula sumando el día, mes y año de la fecha de nacimiento y a
 * continuación sumando las cifras obtenidas en la suma. Por ejemplo: Si la
 * fecha de nacimiento es 12/07/1980 Calculamos el número de la suerte así:
 * 12+7+1980 = 1999 1+9+9+9 = 28 Número de la suerte: 28
 * 
 * @author Curso
 *
 */
public class Ejercicio13 {

	public static void main(String[] args) {

		int dia;
		int mes;
		int anyo;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce tu fecha de nacimiento:");
		System.out.println("el dia:");
		dia = sc.nextInt();
		System.out.println("el mes:");
		mes = sc.nextInt();
		System.out.println("el anyo:");
		anyo = sc.nextInt();
		
		int nSuerte = mes+dia+anyo;
		
		int n1 = nSuerte/1000;
		nSuerte = nSuerte%1000;
		int n2 = nSuerte/100;
		nSuerte = nSuerte%100;
		int n3 = nSuerte/10;
		nSuerte = nSuerte%10;
		
		nSuerte = (n1)+(n2)+(n3)+(nSuerte);
		
		System.out.println("Tu fecha es "+dia+"/"+mes+"/"+anyo);
		System.out.println("Tu numero de la suerte es:"+nSuerte);
		
		sc.close();

	}

}
