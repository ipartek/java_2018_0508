package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Pasar de binario a decimal
 * 
 * @author andreaperez
 *
 */
public class Ejercicio10 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = 0;
		int ultimaCifra = 0;
		int resultado = 0;
		int exp = 0;

		System.out.print("Escribe numero binario: ");
		n = sc.nextInt();

		int aux = n;

		do {

			ultimaCifra = n % 10;
			resultado = resultado + ultimaCifra * (int) Math.pow(2, exp);
			exp++;
			n = n / 10;

		} while (n > 0);

		System.out.println("El numero " + aux + " binario es el numero " + resultado + " en decimal");

		sc.close();

	}

}
