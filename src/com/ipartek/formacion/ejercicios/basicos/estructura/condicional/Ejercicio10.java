package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Ejercicio 10:
 * 
 * Programa que lea una variable entera mes y compruebe si el valor corresponde
 * a un mes de 30 días, de 31 o de 28. Supondremos que febrero tiene 28 días. Se
 * mostrará además el nombre del mes. Se debe comprobar que el valor introducido
 * esté comprendido entre 1 y 12.
 * 
 * @author Curso
 *
 */
public class Ejercicio10 {

	public static void main(String[] args) {

		int mesTeclado;
		int dias;
		boolean mesCorrecto = true;
		Scanner sc = new Scanner(System.in);
		String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };

		do {
			System.out.println("Introduce un numero del 1 al 12:");
			mesTeclado = sc.nextInt();
			if (mesTeclado >= 1 && mesTeclado <= 12) {
				mesCorrecto = false;
			}
		} while (mesCorrecto);

		switch (mesTeclado) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			dias = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dias = 30;
			break;
		default:
			dias = 28;
			break;
		}

		System.out.println("El mes de " + meses[mesTeclado - 1] + " tiene " + dias + " dias.");

		sc.close();
	}

}
