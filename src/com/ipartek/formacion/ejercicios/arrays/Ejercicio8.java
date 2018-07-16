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
 * @author andreaperez
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] nombres = new String[5];
		double[] sueldos = new double[5];

		String nombreMayor = "";
		double sueldoMayor = 0;

		for (int i = 0; i < nombres.length; i++) {
			System.out.println("Ingrese nombre: ");
			nombres[i] = sc.next();

		}
		for (int j = 0; j < sueldos.length; j++) {

			System.out.println("Ingrese sueldo : ");
			sueldos[j] = sc.nextDouble();
		}

		nombreMayor = nombres[0];
		sueldoMayor = sueldos[0];

		for (int i = 0; i < sueldos.length; i++) {
			if (sueldoMayor < sueldos[i]) {
				sueldoMayor = sueldos[i];
				nombreMayor = nombres[i];
			}
		}

		System.out.println("El sueldo mayor " + sueldoMayor + " corresponde al nombre " + nombreMayor);

		sc.close();

	}

}
