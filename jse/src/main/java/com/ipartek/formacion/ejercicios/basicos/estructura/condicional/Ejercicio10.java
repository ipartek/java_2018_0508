package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.Scanner;

/***
 * Programa que lea una variable entera mes y compruebe si el valor corresponde
 * a un mes de 30, 31 o 28 d�as. Se mostrar� adem�s el nombre del mes. Se debe
 * comprobar que el valor introducido est� comprendido entre 1 y 12.
 * 
 * @author Curso
 *
 */
public class Ejercicio10 {

	public static void main(String[] args) {
		int mes;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el mes a comprobar: ");
		mes = sc.nextInt();

		if (mes < 1 || mes > 12)
			System.out.println("El mes introducido no existe.");
		else {
			switch (mes) {
			case 1:
				System.out.println("Enero");
				break;
			case 2:
				System.out.println("Febrero");
				break;
			case 3:
				System.out.println("Marzo");
				break;
			case 4:
				System.out.println("Abril");
				break;
			case 5:
				System.out.println("Mayo");
				break;
			case 6:
				System.out.println("Junio");
				break;
			case 7:
				System.out.println("Julio");
				break;
			case 8:
				System.out.println("Agosto");
				break;
			case 9:
				System.out.println("Septiembre");
				break;
			case 10:
				System.out.println("Octubre");
				break;
			case 11:
				System.out.println("Noviembre");
				break;
			case 12:
				System.out.println("Diciembre");
				break;
			}

			if (mes == 2)
				System.out.println("El mes introducido tiene 28 dias.");
			else if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
				System.out.println("El mes introducido tiene 30 dias.");
			else
				System.out.println("El mes introducido tiene 31 dias.");
		}

		sc.close();
	}

}
