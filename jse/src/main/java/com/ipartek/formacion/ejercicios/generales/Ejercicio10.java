package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 
 * @author Curso
 *
 *         Pasar de binario a decimal
 */
public class Ejercicio10 {

	public static void main(String[] args) {
		int numero;
		int exp;
		int digito;
		double binario;
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce un numero entero mayor que 0: ");
		numero = sc.nextInt();

		exp = 0;
		binario = 0;
		while (numero != 0) {
			digito = numero % 2;
			binario = binario + digito * Math.pow(10, exp);
			exp++;
			numero = numero / 2;
		}
		System.out.printf("El numero introducido en binario es: %.0f", binario);
		sc.close();

	}

}
