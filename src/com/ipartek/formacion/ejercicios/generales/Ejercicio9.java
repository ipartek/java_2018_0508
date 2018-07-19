package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Pasar de decimal a binario
 * 
 * @author Curso
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {
		int num;
		String binario = "";
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero: ");
		num = sc.nextInt();

		while (num != 0) {
			binario = num % 2 + binario + " ";
			num /= 2;
		}

		System.out.println("Binario: " + binario);

		sc.close();
	}

}
