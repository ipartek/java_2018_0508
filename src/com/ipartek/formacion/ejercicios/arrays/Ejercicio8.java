package com.ipartek.formacion.ejercicios.arrays;

import java.util.Scanner;

/**
 * Programa Java que lea el nombre y el sueldo de 20 empleados y muestre el
 * nombre y el sueldo del empleado que más gana.
 * 
 * Para hacerlo utilizaremos dos arrays: Un array de String para los nombres de
 * los empleados Un array de tipo double para los sueldos de cada empleado.
 * 
 * Al mismo tiempo que leemos los datos de los empleados iremos comprobando cuál
 * es el que tiene el mayor sueldo. Para ello tomamos el sueldo del primer
 * empleado que se lee como mayor sueldo y después vamos comprobando el resto de
 * sueldos. Cuando encontramos alguno mayor que el mayor actual este sueldo se
 * convierte en el nuevo mayor.
 * 
 * @author Ainara
 *
 */
public class Ejercicio8 {
	public static void main(String[] args) {

		double[] sueldo = new double[20];
		String[] nombre = new String[20];
		int i = 0;
		double mayorsueldo = 0;
		String mayornombre;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introducción de datos: \n");
		System.out.println("-------------------------");
		System.out.print("Empleado " + (i + 1) + ": ");
		nombre[i] = sc.nextLine();
		System.out.print("Sueldo: ");
		sueldo[i] = sc.nextDouble();

		mayorsueldo = sueldo[i];
		mayornombre = nombre[i];

		for (i = 1; i < nombre.length; i++) {
			sc.nextLine();
			System.out.print("Empleado " + (i + 1) + ": ");
			nombre[i] = sc.nextLine();
			System.out.print("Sueldo: ");
			sueldo[i] = sc.nextDouble();

			if (sueldo[i] > mayorsueldo) {
				mayorsueldo = sueldo[i];
				mayornombre = nombre[i];
			}
		}

		System.out.println("El empleado con mayor sueldo es: " + mayornombre);
		System.out.println("Su sueldo es: " + mayorsueldo + " €");

		sc.close();
	}
}
