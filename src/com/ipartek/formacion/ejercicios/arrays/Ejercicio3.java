package com.ipartek.formacion.ejercicios.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 3. Leer por teclado la nota de los alumnos de una clase y<br>
 *         calcular la nota media del grupo. Mostar los alumnos con notas<br>
 *         superiores a la media.<br>
 *
 */
public class Ejercicio3 {
	
	public static void main(String[] args) throws Exception {

		int[] notas = new int[10];
		int alumnos ;
		int suma = 0;
		int media =0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Introduce el numero de alumnos: ");
		alumnos = Integer.parseInt(br.readLine());
		for (int i = 0; i < alumnos; i++) {
			System.out.print("Introduce una nota");
			notas[i] = Integer.parseInt(br.readLine());
		}
		for (int x = 0; x < notas.length;x++) {
			suma =suma + notas[x];
			
		}
		media = suma / alumnos;
		
		for (int j = 0; j < alumnos;j++) {
			if (notas[j] > suma) {
				System.out.println("Alumno nº: "+ j +" Con nota: "+ notas[j]);
			}
		}
		
	}
}
