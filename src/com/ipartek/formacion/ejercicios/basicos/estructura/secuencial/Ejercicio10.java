package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
* Programa Java que lea un número entero de 3 cifras y 
* muestre por separado las cifras del número.
*/
public class Ejercicio10 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int numero;
		int primerDigito;
		int segundoDigito;
		int tercerDigito;
		
		System.out.println("Introduce un número de 3 cifras");
		
		numero = sc.nextInt();
		
		tercerDigito = numero % 10;
		numero /= 10;
		
		segundoDigito = numero % 10;
		numero/=10;
		
		primerDigito = numero % 10;
		
		System.out.println("El primer dígito es " + primerDigito + "\n" +
						   "El segundo dígito es " + segundoDigito + "\n" +
						   "El tercer dígito es " + tercerDigito);	
		
		sc.close();

	}

}
