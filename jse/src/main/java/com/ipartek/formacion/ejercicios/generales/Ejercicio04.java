package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 4. Mostrar la tabla de multiplicar de un número.
 * 
 * @author Curso
 *
 */
public class Ejercicio04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.println("Dame un numero:");
		n = sc.nextInt();
		
		System.out.println("La tabla de multiplicar de "+n);
		for (int i = 0; i <= 20; i++) {
			System.out.println(i+" x "+n+" = "+(i*n));
		}
		
		sc.close();

	}

}
