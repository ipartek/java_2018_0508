package com.ipartek.formacion.ejercicios.generales;

import java.io.IOException;
import java.util.Scanner;

/**
 * 2. Calcular el número de cifras de un número entero
 * 
 * @author Curso
 *
 */
public class Ejercicio2 {

	private static Scanner scan;

	public static void main(String[] args) throws IOException {
		scan = new Scanner(System.in);
		int num, cant;
		char c;
		do {
			System.out.print("Introduce un numero: ");
			num = scan.nextInt();
			cant = 0;
			while (num != 0) {
				num = num / 10;
				cant++;
			}
			System.out.println("El numero tiene " + cant + " cifras");
			System.out.print("Continuar? ");
			c = (char) System.in.read();
		} while (c != 'n' && c != 'N');
	}
}
