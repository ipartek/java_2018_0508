package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 8. Mostrar los N primeros términos de la serie de Fibonacci
 * @see 
 * @author Curso
 *
 */
public class Ejercicio08 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n1 = 0;
		int n2 = 1;
		int aux;
		int tamanoSerie;
		
		System.out.println("Introduce el tamano de la serie:");
		tamanoSerie = sc.nextInt();
		if(tamanoSerie > 0) {
			System.out.println("La serie Fibonacci: 0,");
			for (int i = 1; i < tamanoSerie; i++) {
				System.out.println(n2+",");
				aux=n2;
				n2=n1+n2;
				n1=aux;
			}
		}
		
		sc.close();
		

	}

}
