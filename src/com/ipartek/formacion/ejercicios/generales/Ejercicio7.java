package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 7. Comprobar si dos números son amigos.
 * 
 * @author Curso
 *
 */
public class Ejercicio7 {

	private static Scanner scan;

	public static void main(String[] args) {
		
		int suma = 0, num1, num2;
		scan = new Scanner(System.in);
		
		System.out.print("Introduce un numero: ");
		num1 = scan.nextInt();
		
		System.out.print("Introduce otro numero: ");
		num2 = scan.nextInt();
		
		for (int i = 1; i < num1; i++) {
			if (num1 % i == 0) {
				suma = suma + i;
			}
		}
		
		if (suma == num2) {
			suma = 0;
			for (int i = 1; i < num2; i++) {
				if (num2 % i == 0) {
					suma = suma + i;
				}
			}
			
			if (suma == num1) {
				System.out.println("Son Amigos");
			} else {
				System.out.println("NO son amigos");
			}
		} else {
			System.out.println("No son amigos");
		}
	}

}
