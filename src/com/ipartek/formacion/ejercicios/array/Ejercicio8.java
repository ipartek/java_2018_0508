package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Programa Java que lea el nombre y el sueldo de 20 empleados y muestre el nombre y el sueldo del empleado que más gana.
 * @author Alain
 *
 */
public class Ejercicio8 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		String[] nombres = new String[20];
		double[] sueldos = new double[20];
		String nombreMayor;
		double sueldoMayor;
		
		//Tomar datos del primer empleado
		System.out.println("Introduce un nombre:");
		nombres[0] = teclado.nextLine();
		System.out.println("Introduce su salario:");
		sueldos[0] = teclado.nextDouble();
		
		//Guardamos su salario como el mas alto
		nombreMayor = nombres[0];
		sueldoMayor = sueldos[0];
		
		//Tomar datos del resto de empleados
		System.out.println();
		for (int i = 1; i < nombres.length; i++) {
			teclado.nextLine();
			System.out.println("Introduce un nombre:");
			nombres[i] = teclado.nextLine();
			System.out.println("Introduce su salario:");
			sueldos[i] = teclado.nextDouble();
			System.out.println();
			
			//Comprobar si supera el salario del anterior empleado
			if(sueldos[i] > sueldoMayor){
				nombreMayor = nombres[i];
				sueldoMayor = sueldos[i];
			}
		}
		
		//Mostrar que empleado tiene mayor sueldo
		System.out.println("El empleado " + nombreMayor + " es el que mayor sueldo tiene: " + sueldoMayor + "€.");
		
		teclado.close();
	}

}
