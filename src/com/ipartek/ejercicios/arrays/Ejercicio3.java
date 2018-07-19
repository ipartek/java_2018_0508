package com.ipartek.ejercicios.arrays;

import java.util.Scanner;

/**
 *  Programa que lee por teclado la nota de los alumnos de una clase y calcula la nota media 
 *  del grupo. También muestra los alumnos con notas superiores a la media. 
 *  El número de alumnos se lee por teclado
 * @author Curso
 *
 */

public class Ejercicio3 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		int numeroAlumnos;
		int i;
		double media;
		double suma= 0;
		
		do {
			System.out.println("Introduce el numero de alumnos: ");
			numeroAlumnos= sc.nextInt();
		}
		while(numeroAlumnos>0);
		
		double notas[]= new double[numeroAlumnos]; //creamos aqui el array porque si no
                                                   //nos obliga a inicializar numeroAlumnos
		
		for (i = 0; i < notas.length; i++) {
			System.out.print("Alumno " + (i + 1) + " Nota final: ");
            notas[i] = sc.nextDouble();	
		}
		
		for (i = 0; i < notas.length; i++) { //sumamos las notas
            suma = suma + notas[i];
        }
		
		media= suma/notas.length;
		
		System.out.printf("Nota media del curso: %.2f %n", media);
		
		System.out.println("Notas superiores a la media: ");
		for ( i = 0; i < notas.length; i++) {
			if(notas[i]>media) {
				System.out.println("Alumno " + (i + 1)+ " Nota final: " + notas[i]);
			}
			
		}


}
	
}
