package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * 6: Programa java que lea un carácter por teclado y compruebe si es un dígito
 * numérico (cifra entre 0 y 9).
 * 
 * Vamos a escribir dos soluciones a este ejercicio.
 * 
 * La primera consiste en comprobar si el carácter es un dígito mediante el
 * método isDigit de la clase Character. Este método devuelve true si el
 * carácter que se le pasa como parámetro es una cifra entre 0 y 9
 * 
 * @author valen
 *
 */
public class Ejercicio6 {
	public static void main(String[] args) {
		Scanner p = new Scanner(System.in);
		char letra;
		System.out.println("Ingrese la letra ");
		letra = p.nextLine().charAt(0);

		if (Character.isDigit(letra)) {
			System.out.println("Es un numero");
		} else {
			System.out.println("No es un numero");
		}
	}

}
