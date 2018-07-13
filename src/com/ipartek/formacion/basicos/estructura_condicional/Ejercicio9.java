package com.ipartek.formacion.basicos.estructura_condicional;

import java.util.Scanner;

/**
 * Programa que lea una variable entera mes y compruebe si el valor corresponde
 * a un mes de 30, 31 o 28 días. Se mostrará además el nombre del mes. Se debe
 * comprobar que el valor introducido esté comprendido entre 1 y 12..
 * 
 * @author Curso
 *
 */
public class Ejercicio9 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int mes;
		
		System.out.println("Introduce un mes: ");
		mes = sc.nextInt();
		
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
			System.out.println("Septimbre");
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
		default:
			break;
		}
		
		if (mes == 2) {		// 28 días
			System.out.println("Tiene 28 días");
		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			System.out.println("Tiene 30 días");
		} else {
			System.out.println("Tiene 31 días");
		}

	}

}
