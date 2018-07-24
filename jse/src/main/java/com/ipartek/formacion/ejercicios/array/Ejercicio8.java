package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Leer el nombre y sueldo de 20 empleados y mostrar el nombre y sueldo del<br>
 * empleado que más gana.
 * 
 * 
 * @author Asier Cornejo
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] empleados = new String[20];
		double[] sueldos = new double[20];

		String nombreMayor;
		double mayorSueldo;

		int i = 0;

		System.out.println("Introduzca el nombre del empleado: ");
		empleados[i] = sc.nextLine();
		System.out.print("Introduzca el sueldo del empleado: ");
		sueldos[i] = sc.nextDouble();

		mayorSueldo = sueldos[i];
		nombreMayor = empleados[i];

		for (i = 1; i < empleados.length; i++) {
			sc.nextLine();
			System.out.print("Empleado " + (i + 1) + ": ");
			empleados[i] = sc.nextLine();
			System.out.print("Sueldo: ");
			sueldos[i] = sc.nextDouble();
			// se compara el sueldo leído con el mayor
			if (sueldos[i] > mayorSueldo) {
				mayorSueldo = sueldos[i];
				nombreMayor = empleados[i];
			}
		}

		System.out.println("Empleado con mayor sueldo: " + nombreMayor + ", Sueldo: " + mayorSueldo);
		sc.close();
	}

}
