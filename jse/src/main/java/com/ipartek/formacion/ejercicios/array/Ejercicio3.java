package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * 
 * Leer por teclado la nota de los alumnos de una clase y calcular la nota media
 * del grupo. Mostar los alumnos con notas superiores a la media.
 */

public class Ejercicio3 {
	
	public static void main(String[] args) {

		int sum = 0;
		int[]marks =new int[10];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < marks.length; i++) {
			System.out.print("Introduce una nota: ");
			marks[i] = sc.nextInt();
			sum+=marks[i];
			
		}

		System.out.println("Las notas que han quedado por encima de la media son: ");
		float average  =(float) (sum / marks.length);
		for (int mark : marks) {
			if(mark > average ) {
				System.out.println(mark);
			}		
		}
		sc.close();
	}

}
