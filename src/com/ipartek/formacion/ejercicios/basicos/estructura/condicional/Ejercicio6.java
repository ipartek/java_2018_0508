package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa java que lea un carácter por teclado y 
 * compruebe si es un dígito numérico (cifra entre 0 y 9).
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		char caracter;
		
		System.out.println("Introduce un caracter para comprobar si es un dígito(0-9)");
		
		caracter = sc.next().charAt(0);
		
		if(Character.isDigit(caracter)) {
			System.out.println("El caracter '" + caracter + "' es un dígito");
		}
		else {
			System.out.println("El caracter '" + caracter + "' no es un dígito");
		}
		
		sc.close();

	}

}
