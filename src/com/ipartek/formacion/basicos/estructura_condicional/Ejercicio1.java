package com.ipartek.formacion.basicos.estructura_condicional;

import java.util.Scanner;

import com.ipartek.formacion.util.Utilidades;

/**
 * Programa Java que lea un número entero y calcule si es par o impar.
 * 
 * @author Curso
 *
 */
public class Ejercicio1 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int n;
			
			n = Utilidades.leerInt(sc);
			System.out.println(esPar(n) ? n + " es par" : n + " es impar");
		
	}

	private static boolean esPar(int n) {

		return (n % 2 == 0 ? true : false);
	}

}
