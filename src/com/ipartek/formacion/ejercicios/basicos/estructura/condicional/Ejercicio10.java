package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea una variable entera mes y compruebe si el valor corresponde
 * a un mes de 30 días, de 31 o de 28. Supondremos que febrero tiene 28 días. Se
 * mostrará además el nombre del mes. Se debe comprobar que el valor introducido
 * esté comprendido entre 1 y 12.
 * 
 * @author valen
 *
 */

public class Ejercicio10 {
	public static void main(String[] args) {
		Scanner p = new Scanner(System.in);
		int mes;

		System.out.println("Ingrese el mes = ");
		mes = p.nextInt();

		switch (mes) {
		case 1:
			System.out.println("Enero es un mes de 31 dias");
			break;
		case 2:
			System.out.println("Febrero es un mes de 28 dias");
			break;
		case 3:
			System.out.println("Marzo es un mes de 31 dias");
			break;
		case 4:
			System.out.println("Abril es un mes de 30 dias");
			break;
		case 5:
			System.out.println("Mayo es un mes de 31 dias");
			break;
		case 6:
			System.out.println("Junio es un mes de 30 dias");
			break;
		case 7:
			System.out.println("Julio es un mes de 31 dias");
			break;
		case 8:
			System.out.println("Agosto es un mes de 31 dias");
			break;
		case 9:
			System.out.println("Septiembre es un mes de 30 dias");
			break;
		case 10:
			System.out.println("Octubre es un mes de 31 dias");
			break;
		case 11:
			System.out.println("Noviembre Es un mes de 30 dias");
			break;
		case 12:
			System.out.println("Diciembre Es un mes de 31 dias");
			break;
		default:
			System.out.println("No es un mes");

		}

	}

}
