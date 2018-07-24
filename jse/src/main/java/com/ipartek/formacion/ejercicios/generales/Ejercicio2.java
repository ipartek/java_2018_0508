package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/***
 * Calcular el n�mero de cifras de un n�mero entero
 * 
 * @author user
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		int num;
		String numT;
		char opc;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Introduzca un numero: ");
			num = sc.nextInt();

			sc.nextLine();

			numT = Integer.toString(num);
			System.out.println("El numero " + num + " tiene " + numT.length() + " cifras.");
			System.out.println("Continuar? (S/N)");
			opc = sc.nextLine().charAt(0);
		} while (opc == 's' || opc == 'S');

		sc.close();
	}

}
