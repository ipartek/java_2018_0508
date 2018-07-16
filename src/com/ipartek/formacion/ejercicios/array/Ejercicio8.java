package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * 
 * Leer el nombre y sueldo de 20 empleados y mostrar el nombre y sueldo del
 * empleado que más gana.
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {

		String[] names = new String[2];
		Scanner sc = new Scanner(System.in);
		float salary = 0;
		float max = 0;
		int pos = 0;

		for (int i = 0; i < names.length; i++) {
			System.out.print("Nombre del empleado: ");
			names[i] = sc.next();
			System.out.print("SAlario del empleado: ");
			salary = sc.nextFloat();
			if (salary > max) {
				max = salary;
				pos = i;
			}

		}

		System.out.println("Empleado: " + names[pos]);
		System.out.println("Salario: " + max + "€");
		sc.close();

	}

}
