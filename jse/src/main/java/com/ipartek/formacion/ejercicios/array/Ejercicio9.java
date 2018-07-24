package com.ipartek.formacion.ejercicios.array;

import java.util.Scanner;

/**
 * Llenar un array con números aleatorios.
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int cantidadAleatorios;
		
		System.out.println("¿Cuántos números aleatorios quieres que aparezcan?");
		cantidadAleatorios = sc.nextInt();
		
		int numerosAleatorios[] = new int[cantidadAleatorios];
		
		for (int i = 0; i < numerosAleatorios.length; i++) {
			numerosAleatorios[i] = (int) (Math.random() * numerosAleatorios.length);
			System.out.println(numerosAleatorios[i]);
		}
		
		sc.close();		

	}

}
