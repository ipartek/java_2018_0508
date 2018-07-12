package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa que lea una variable entera mes y compruebe si el valor corresponde
 * a un mes de 30, 31 o 28 días. Se mostrará además el nombre del mes. Se debe
 * comprobar que el valor introducido esté comprendido entre 1 y 12.
 * 
 * @author andreaperez
 *
 */
public class Ejercicio10 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int mes;

		System.out.println("mes:");
		mes = sc.nextInt();

		switch (mes) {
		case 1:
			System.out.println("Enero ");
			break;
		case 2:
			System.out.println("Febrero ");
			break;
		case 3:
			System.out.println("Marzo ");
			break;
		case 4:
			System.out.println("Abril ");
			break;
		case 5:
			System.out.println("Mayo ");
			break;
		case 6:
			System.out.println("Junio ");
			break;
		case 7:
			System.out.println("Julio ");
			break;
		case 8:
			System.out.println("Agosto ");
			break;
		case 9:
			System.out.println("Septiembre ");
			break;
		case 10:
			System.out.println("Octubre ");
			break;
		case 11:
			System.out.println("Noviembre ");
			break;
		case 12:
			System.out.println("Diciembre ");
			break;

		}

		// mostrar si es un mes de 30, 31 0 28 días
		if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			System.out.println(" es un mes de 30 días");
		} else if (mes == 2) {
			System.out.println(" es un mes de 28 días");
		} else {
			System.out.println(" es un mes de 31 días");
		}
		sc.close();
	}
}
