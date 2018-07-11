package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * 10. Programa que lee un número de 3 cifras y muestra sus cifras por separado.
 * 
 * @author Curso
 *
 */
public class Ejercicio10 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		int num, a, b, c;

		System.out.println("Introduce un numero de 3 cifras: ");
		num = scan.nextInt();

		a = num / 100;
		b = (num-(a*100)) / 10;
		c = num-(a*100)-(b*10);
		
		System.out.println("Primera cifra: "+ a+" Segunda cifra: "+b+" Tercera cifra: "+c);

	}

}
