package com.ipartek.formacion.ejercicios.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Calcular la altura media de los alumnos de una clase.
 * @author Adrian Garcia
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Double> alturas = new ArrayList<Double>();
		
		int cantidadAlumnos;
		double altura;
		double suma = 0;
		double media;
		
		do {
			System.out.println("¿Cuántos alumnos hay en la clase?");
			cantidadAlumnos = sc.nextInt();
		} while (cantidadAlumnos <= 0);
		
		for (int i = 1; i <= cantidadAlumnos; i++) {
			do {
				System.out.println("Altura del alumno " + i + ":");
				altura = sc.nextDouble();
			} while (altura <= 0);
			
			alturas.add(altura);
			
		}
		
		for (Double alto : alturas) {
			suma += alto;
		}
		
		media = suma / alturas.size();
		
		System.out.println("La media de la altura de los alumnos de esa clase es " + media + "m");
		
		sc.close();
		
	}

}
