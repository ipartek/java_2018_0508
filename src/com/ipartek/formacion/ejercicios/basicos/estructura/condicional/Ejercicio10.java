package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * 10. Programa que lea una variable entera mes y compruebe si el valor<br>
 * corresponde a un mes de 30, 31 o 28 días. Se mostrará además el nombre del<br>
 * mes. Se debe comprobar que el valor introducido esté comprendido entre 1 y<br>
 * 12.
 * 
 * @author Curso
 *
 */
public class Ejercicio10 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		int mes;

		System.out.println("Introduce un mes(numero): ");
		mes = scan.nextInt();

		if (mes < 1 || mes > 12)
			System.out.println("Mes incorrecto");
		else {
			switch (mes) {
			case 1:
				System.out.print("Enero");
				break;
			case 2:
				System.out.print("Febrero");
				break;
			case 3:
				System.out.print("Marzo");
				break;
			case 4:
				System.out.print("Abril");
				break;
			case 5:
				System.out.print("Mayo");
				break;
			case 6:
				System.out.print("Junio");
				break;
			case 7:
				System.out.print("Julio");
				break;
			case 8:
				System.out.print("Agosto");
				break;
			case 9:
				System.out.print("Septiembre");
				break;
			case 10:
				System.out.print("Octubre");
				break;
			case 11:
				System.out.print("Noviembre");
				break;
			case 12:
				System.out.print("Diciembre");
				break;
			}
			if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
				System.out.println(" es un mes de 30 días");
			else if (mes == 2)
				System.out.println(" es un mes de 28 días");
			else
				System.out.println(" es un mes de 31 días");
		}
	}

}
