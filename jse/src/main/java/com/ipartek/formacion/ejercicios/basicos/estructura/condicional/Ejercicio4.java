package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 1 4. Programa que lea dos caracteres por teclado y compruebe si
 *         son iguales.
 */
public class Ejercicio4 {
	public static void main(String[] args) throws Exception {
		char letra1;
		char letra2;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce la primera letra :");
		letra1 = br.readLine().charAt(0);
		System.out.println("Introduce la primera letra :");
		letra2 = br.readLine().charAt(0);
		System.out.println( letra1 == letra2 ? "Las letras "+letra1 +"-"+ letra2 +" son iguales " : "Las letras "+letra1 +"-"+ letra2 +" no son iguales ");
	}
}
