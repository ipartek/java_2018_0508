package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 6. Comprobar si un número es perfecto.
 * 
 * @author Curso
 *
 */
public class Ejercicio06 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n;
		int sumaDeN = 0;
		
		System.out.println("Dime un numero:");
		n = sc.nextInt();
		
		for (int i = 1; i < n; i++) {
			if(n%i == 0) {
				sumaDeN = sumaDeN + i;
			}
		}
		
		if (sumaDeN == n) {
			System.out.println("El numero "+n+" es Perfecto.");
		}else {
			System.out.println("El numero "+n+" no es Perfecto.");
		}
		
		sc.close();
	}

}
