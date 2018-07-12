package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 9. Pasar de decimal a binario
 * 
 * @author Curso
 *
 */
public class Ejercicio9 {

	private static Scanner scan;

	public static void main(String[] args) {

		int num, exp, dig;
		double binario;
		scan = new Scanner(System.in);

		do {
			System.out.print("Introduce un numero positivo: ");
			num = scan.nextInt();
		} while (num < 0);

		exp = 0;
		binario = 0;
		
		while (num != 0) {
			dig = num % 2;
			binario = binario + dig * Math.pow(10, exp);
			exp++;
			num = num / 2;
		}
		System.out.printf("Binario: %.0f %n", binario);
	}

}
