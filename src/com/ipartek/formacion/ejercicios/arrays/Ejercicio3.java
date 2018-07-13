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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Introduce el numero de alumnos: ");
		alumnos = Integer.parseInt(br.readLine());
	}
}
