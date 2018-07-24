package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Pasar de decimal a binario
 * 
 * @author andreaperez
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = 0;
		int digito = 0;
		int exp = 0;
		double binario = 0;

		do {

			System.out.print("Escribe un numero entero para pasar de decimal a binario: ");
			n = sc.nextInt();

		} while (n < 0);

		int aux = n;

		while (n != 0) {
			digito = n % 2;
			binario = binario + digito * Math.pow(10, exp);
			exp++;
			n = n / 2;

		}

		System.out.printf("el numero decimal " + aux + " en Binario es : " + binario);

		sc.close();

	}

}
