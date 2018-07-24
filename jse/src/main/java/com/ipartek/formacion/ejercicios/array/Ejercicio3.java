package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Leer por teclado la nota de los alumnos de una clase y calcular la nota media del grupo. 
 * Mostar los alumnos con notas superiores a la media.
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double notas[] = new double[10];
		double suma = 0;
		int alumnos = 0;
		double media;
		
		for (int i = 0; i < notas.length; i++) {
			System.out.println("Introduce una nota");
			notas[i] = sc.nextInt();
			suma += notas[i];
			alumnos++;
		}
		
		media = suma / alumnos;
		
		alumnos = 0;
		
		for (int i = 0; i < notas.length; i++) {
			if(notas[i] > media) {
				alumnos++;
			}
		}
		
		System.out.println("La media de notas de la clase es " + media);
		System.out.println("Ha habido " + alumnos + " alumnos que han superado la media");
		
		sc.close();

	}

}
