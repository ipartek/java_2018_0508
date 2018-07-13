package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Comprobar si dos números son amigos Dos números enteros positivos A y B son
 * números amigos si la suma de los divisores propios de A es igual a B y la
 * suma de los divisores propios de B es igual a A.
 * 
 * @author Curso
 *
 */
public class Ejercicio07 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x;
		int y;
		int sumaDeX = 0;
		int sumaDeY = 0;

		System.out.println("Primer numero: ");
		x = sc.nextInt();

		System.out.println("Segundo numero: ");
		y = sc.nextInt();

		for (int i = 1; i < x; i++) {
			if (x % i == 0) {
				sumaDeX = sumaDeX + i;
			}
		}
		
		for (int i = 1; i < y; i++) {
			if (y % i == 0) {
				sumaDeY = sumaDeY + i;
			}
		}
		
		if((sumaDeX == y)&&(sumaDeY == x)) {
			System.out.println("Los numeros "+x+" y "+y+" son amigos.");
		}else {
			System.out.println("Los numeros "+x+" y "+y+" no son amigos.");
		}

		sc.close();
	}

}
