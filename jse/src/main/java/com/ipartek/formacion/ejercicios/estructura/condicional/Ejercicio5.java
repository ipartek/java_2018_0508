package com.ipartek.formacion.ejercicios.estructura.condicional;

import java.util.Scanner;

/**
 * Programa java que lea dos caracteres por teclado y compruebe si los dos son letras minúsculas
 * @author Curso
 *
 */

public class Ejercicio5 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		char car1;
		char car2;
		
		System.out.println("Introduce un character:");
		car1 = teclado.next().charAt(0);
		
		System.out.println("Introduce otro character:");
		car2 = teclado.next().charAt(0);
		
		if(car1 == car2) {
			System.out.println(car1 + " es igual a " + car2);
		}else {
			System.out.println(car1 + " no es igual a " + car2);
		}
		
		teclado.close();
		
	}

}
