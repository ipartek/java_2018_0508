package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Leer el nombre y sueldo de 20 empleados y 
 * mostrar el nombre y sueldo del empleado que más gana.
 *
 */
public class Ejercicio8 {
	
	public static String NOMBRE_MAYOR = "";
	public static int SUELDO_MAYOR = 0;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String nombre[] = new String[20];
		int sueldo[] = new int[20];
		
		for (int i = 0; i < sueldo.length; i++) {
			
			System.out.println("Introduce el nombre del empleado");
			nombre[i] = sc.next();
			
			System.out.println("Introduce el sueldo del empleado");
			sueldo[i] = sc.nextInt();
			
			if(sueldo[i] > SUELDO_MAYOR) {
				SUELDO_MAYOR = sueldo[i];
				NOMBRE_MAYOR = nombre[i];
			}
			
		}
		
		System.out.println("\nLa persona que más gana es " + NOMBRE_MAYOR + ", que cobra " + SUELDO_MAYOR + "€.");
		
		sc.close();
		
	}

}
