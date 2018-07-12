package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 4. Mostrar la tabla de multiplicar de un número.
 * 
 * @author Curso
 *
 */
public class Ejercicio4 {

	private static Scanner scan;

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		int num;
		
		System.out.print("Introduce un numero: ");
		num = scan.nextInt();
		
		System.out.println("Tabla de multiplicar " + num);
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(num + " * " + i + " = " + num * i);
		}
	}

}
