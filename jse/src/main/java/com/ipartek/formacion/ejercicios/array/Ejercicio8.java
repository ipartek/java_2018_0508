package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * 8. Leer el nombre y sueldo de 20 empleados y mostrar el nombre y sueldo del
 * empleado que más gana.
 * 
 * @author Curso
 *
 */
public class Ejercicio8 {

	static final int N_EMPLEADOS = 20;

	public static void main(String[] args) {

		int[] sueldos = new int[N_EMPLEADOS];
		String[] empleados = new String[N_EMPLEADOS];
		int sueldoMaximo = 0;
		int posicionSMaximo = 0;
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < N_EMPLEADOS; i++) {

			System.out.println("Introduce el nombre del empleado:");
			empleados[i] = sc.nextLine();

			System.out.println("Introduce el sueldo:");
			sueldos[i] = sc.nextInt();

			if (sueldoMaximo < sueldos[i]) {
				sueldoMaximo = sueldos[i];
				posicionSMaximo = i;
			}
			sc.nextLine();
		}

		System.out.println("El empleado " + empleados[posicionSMaximo] + " es el que tiene mayor sueldo:"
				+ sueldos[posicionSMaximo]);
		
		sc.close();

	}

}
