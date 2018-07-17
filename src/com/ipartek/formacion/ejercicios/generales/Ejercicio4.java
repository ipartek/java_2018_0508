package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/***
 * Mostrar la tabla de multiplicar de un número.
 * 
 * @author user
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;

		Scanner sc = new Scanner(System.in);

		System.out.println("Inserte un numero: ");
		num = sc.nextInt();

		System.out.println("Tabla del " + num);
		System.out.println("------------");

		for (int i = 1; i <= 10; i++) {
			System.out.println(num + " * " + i + " = " + num * i);
		}

		sc.close();
	}

}
