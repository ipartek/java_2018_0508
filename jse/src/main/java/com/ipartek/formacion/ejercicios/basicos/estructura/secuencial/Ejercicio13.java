package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 13. Programa que calcula el número de la suerte de una persona
 *         a partir de su fecha de nacimiento. Por ejemplo: Si la fecha de
 *         nacimiento es 12/07/1980 Calculamos el número de la suerte así:
 *         12+7+1980 = 1999 1+9+9+9 = 28 Número de la suerte: 28
 */
public class Ejercicio13 {
	public static void main(String[] args) throws Exception {

		int dia;
		int mes;
		int anio;
		int suma;
		int numeroSuerte;
		int primerNumero;
		int segundoNumero;
		int terceroNumero;
		int cuartoNumero;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce el dia de tu cumple :");
		dia = Integer.parseInt(br.readLine());
		System.out.println("Introduce el mes de tu cumple :");
		mes = Integer.parseInt(br.readLine());
		System.out.println("Introduce el anio de tu cumple :");
		anio = Integer.parseInt(br.readLine());
		suma = (dia + mes + anio);

		primerNumero = suma / 1000;
		segundoNumero = suma / 100 % 10;
		terceroNumero = suma / 10 % 10;
		cuartoNumero = suma % 10;
		numeroSuerte = (primerNumero + segundoNumero + terceroNumero + cuartoNumero);

		System.out.println("Su numero de la suerte es :" + numeroSuerte);

	}
}
