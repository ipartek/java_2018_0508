package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

/**
 * Programa java que lea un carácter por teclado y compruebe 
 * si es un dígito numérico (cifra entre 0 y 9).
 */

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		char c;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un caracter");
		c = sc.next().charAt(0);
		
		if(Character.isDigit(c)) {
			System.out.println("Este caracter es un numero");
		}
		else {
			System.out.println("Este caracter es una letra");
		}
		sc.close();
	}

}
