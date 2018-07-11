package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que pida por teclado la fecha de nacimiento de una persona (dia,
 * mes, año) y calcule su número de la suerte. El número de la suerte se calcula
 * sumando el día, mes y año de la fecha de nacimiento y a continuación sumando
 * las cifras obtenidas en la suma. Por ejemplo: Si la fecha de nacimiento es
 * 12/07/1980 Calculamos el número de la suerte así: 12+7+1980 = 1999 1+9+9+9 =
 * 28 Número de la suerte: 28
 * 
 * @author valen
 *
 */

public class Ejercicio13 {
	public static void main(String[] args) {

		Scanner m = new Scanner(System.in);
		int dia;
		int mes;
		int ano;
		int suerte;
		int suma;
		int numero1, numero2, numero3, numero4;

		System.out.println("Ingrese el dia de  nacimiento : ");
		dia = m.nextInt();
		System.out.println("Ingrese el mes de nacimiento : ");
		mes = m.nextInt();
		System.out.println("Ingrese el año de nacimiento : ");
		ano = m.nextInt();
		suma = dia + mes + ano;
		System.out.println(" La suma = " + suma);

		numero1 = suma / 1000;
		numero2 = suma / 100 % 10;
		numero3 = suma / 10 % 10;
		numero4 = suma % 10;

		System.out.println(" El numero de la suerte es = " + (numero1 + numero2 + numero3 + numero4));

	}

}
