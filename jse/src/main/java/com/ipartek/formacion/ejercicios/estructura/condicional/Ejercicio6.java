package com.ipartek.formacion.ejercicios.estructura.condicional;

import java.util.Scanner;

/**
 * Programa java que lea un carácter por teclado y compruebe si es un dígito numérico (cifra entre 0 y 9).
 * @author Curso
 *
 */

public class Ejercicio6 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		char car1;
		
		System.out.println("Introduce un character:");
		car1 = teclado.next().charAt(0);
		
		System.out.println();
		if(Character.isDigit(car1)) {
			System.out.println(car1 + " es un dígito númerico.");
		}else {
			System.out.println(car1 + " no es un dígito númerico.");
		}

		teclado.close();
		
	}

}
