package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.*;

/**
 * Programa Java que lea un número entero por teclado y calcule si es par o
 * impar.
 * 
 * Podemos saber si un número es par si el resto de dividir el número entre 2 es
 * igual a cero. En caso contrario el número es impar
 * 
 * El operador Java que calcula el resto de la división entre dos números
 * enteros o no es el operador %
 * 
 * @author Curso
 *
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("Introduce numero: ");
		num = sc.nextInt();
		if (num%2==0) 
			System.out.println("El numero" + num + " es par");
		else
			System.out.println("El numero" + num + " es impar");
		
		sc.close();
	}

}
