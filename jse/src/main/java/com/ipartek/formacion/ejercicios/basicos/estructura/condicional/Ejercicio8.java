package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Calcular el mayor de tres números enteros en Java.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n1;
		int n2;
		int n3;

		System.out.println("primer numero:");
		n1 = sc.nextInt();

		System.out.println("segundo numero:");
		n2 = sc.nextInt();

		System.out.println("tercer numero:");
		n3 = sc.nextInt();

		if (n1 > n2) {
			if (n1 > n3) {
				System.out.println("El " + n1 + "es el mayor");
			}
		} else if (n2 > n3) {
			if (n2 > n1) {
				System.out.println("El " + n2 + "es el mayor");
			}

		} else if (n3 > n1) {
			if (n3 > n2) {
				System.out.println("El " + n3 + "es el mayor");
			}
		}

		sc.close();
	}

}
