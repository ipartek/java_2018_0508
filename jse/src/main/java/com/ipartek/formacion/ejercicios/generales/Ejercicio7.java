package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa que calcula si dos números son amigos
 * @author Curso
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int n1;
		int n2;
		int suma1 = 0;
		int suma2 = 0;
		
		System.out.println("Introduce un numero:");
		n1 = teclado.nextInt();
		
		System.out.println();
		System.out.println("Introduce otro numero:");
		n2 = teclado.nextInt();
		
		for (int i = 1; i < n1; i++) { // sumar todos los divisores propios de n1
			if(n1 % i == 0) {
				suma1 = suma1 + i;
			}
		}
		
		if(suma1 == n2) { // comprobar que la suma de los divisores de n1 es igual a n2
			for (int i = 1; i < n2; i++) { // sumar todos los divisores propios de n2 
				if(n2 % i == 0) { 
					suma2 = suma2 + i;
				}
			}
		}
		
		System.out.println();
		if(suma2 == n1) { // compronar que la suma de los divisores de n2 es igual a n1, por lo cual son num amigos
			System.out.println(n1 + " y " + n2 + " son números amigos.");
		}else {
			System.out.println(n1 + " y " + n2 + " no son números amigos.");
		}
		
		teclado.close();
	}

}
