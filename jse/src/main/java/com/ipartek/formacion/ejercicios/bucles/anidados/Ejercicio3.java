package com.ipartek.formacion.ejercicios.bucles.anidados;

import java.util.Scanner;

import com.ipartek.formacion.ejercicios.Utilities;

/**
 * Leer un número N y calcular la suma de los factoriales de los números desde 0
 * hasta N.
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		
		System.out.println("Introduce un numero: ");
		Scanner sc = new Scanner(System.in);
		int num= sc.nextInt();
		int total=0;
		for (int i = 0; i < num; i++) {
			total+=Utilities.factorial(i);
		}
		System.out.println("La suma total de los factoriales es: "+total);
		sc.close();

	}

}
