package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Mostrar los N primeros términos de la serie de Fibonacci
 */

public class Ejercicio8 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un número: ");
		int num = teclado.nextInt();
		int sum=0;
		int prev=0;
		int act=1;
		if(num>0) {
			System.out.print(1 + " ");
			for (int i = 0; i < num-1; i++) {
				sum = (prev+act);
				System.out.print(sum +" ");
				prev=act;
				act=sum;
	
			}
		}
		teclado.close();

	}

}
