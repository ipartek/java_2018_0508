package com.ipartek.formacion.ejercicios.recursividad;

import java.util.Scanner;

/**
 * Calcular el cociente de dos números enteros de forma recursiva.
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner sc =null;
		try {
			sc = new Scanner(System.in);
			System.out.print("Numero1: ");
			int a = sc.nextInt();
			System.out.print("Numero2: ");
			int b = sc.nextInt();
			cociente(a,b);
			
		} catch (Exception e) {
			System.out.println("ERROR al introducir los datos");
			main(args);
			
		} finally {
			sc.close();
		}
		

	}

	private static void cociente(int a, int b) {
		
		if(a>b) {
			System.out.println("El cociente es "+a/b);
		}else {
			cociente(b,a);
			
		}
		
	}

}
