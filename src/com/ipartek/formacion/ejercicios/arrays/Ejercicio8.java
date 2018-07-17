package com.ipartek.formacion.ejercicios.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author curso 8. Leer el nombre y sueldo de 20 empleados y mostrar el
 *         nombre<br>
 *         y sueldo del empleado que más gana.
 *
 */
public class Ejercicio8 {
	public static void main(String[] args) throws Exception {
		int[] sueldo = new int[20];
		String[] empleados = new String[20];
		int sueldoM = 0;
		int empleadoMayorSueldo = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int x = 0; x < sueldo.length; x++) {
			System.out.println("Introducse el nombre del trabajador:");
			empleados[x] = br.readLine();
			System.out.println("Introducse su sueldo:");
			sueldo[x] = Integer.parseInt(br.readLine());
			;
		}
		for (int x = 0; x < sueldo.length; x++) {
			if (sueldo[x] > sueldoM) {
				sueldoM = sueldo[x];
				empleadoMayorSueldo = x;
			}

		}
		System.out.println(
				"El empleado con mayor sueldo es:" + empleados[empleadoMayorSueldo] + ". Con un sueldo de:" + sueldo[empleadoMayorSueldo]);

	}
}
