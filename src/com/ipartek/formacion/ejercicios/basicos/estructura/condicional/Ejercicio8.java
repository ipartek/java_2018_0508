package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/***
 * 
 * Calcular el mayor de tres números enteros en Java.
 * 
 * El programa lee por teclado tres números enteros y calcula y muestra el mayor
 * de los tres.
 * 
 * @author Curso
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1, num2, num3;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el primer numero: ");
		num1 = sc.nextInt();
		System.out.println("Introduce el segundo numero: ");
		num2 = sc.nextInt();
		System.out.println("Introduce el tercer numero: ");
		num3 = sc.nextInt();

		if (num1 < num2)
			if (num2 < num3)
				System.out.println("El mayor de los tres es " + num3);
			else
				System.out.println("El mayor de los tres es " + num2);
		else if (num1 < num3)
			System.out.println("El mayor de los tres es " + num3);
		else
			System.out.println("El mayor de los tres es " + num1);

		sc.close();
	}

}
